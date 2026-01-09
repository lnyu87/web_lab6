package com.scsxw.dao;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.scsxw.entity.User;
import com.scsxw.util.DBHelper;
 
/**
 * 基于DBHelper实现具体的数据操作的数据访问类=》一个表对应一个数据访问类
 */
public class UserDao {
 
	/**
	 * 新增用户
	 */
	public int add(User obj) {
		String sql = "INSERT INTO user(username, password, nickname, email, avatar, role, status, register_time, update_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return DBHelper.executeUpdate(sql, obj.getUsername(), obj.getPassword(), obj.getNickname(), obj.getEmail(),
				obj.getAvatar(), obj.getRole(), obj.getStatus(), LocalDateTime.now(), LocalDateTime.now());
	}
 
	/**
	 * 更新用户
	 */
	public int update(User obj) {
		String sql = "UPDATE user SET username=?, password=?, nickname=?, email=?, avatar=?, role=?, status=?, update_time=? WHERE id=?";
		return DBHelper.executeUpdate(sql, obj.getUsername(), obj.getPassword(), obj.getNickname(), obj.getEmail(),
				obj.getAvatar(), obj.getRole(), obj.getStatus(), LocalDateTime.now(), obj.getId());
	}
 
	/**
	 * 删除用户
	 */
	public int delete(Long id) {
		String sql = "DELETE FROM user WHERE id=?";
		return DBHelper.executeUpdate(sql, id);
	}
 
	/**
	 * 通用条件查询（支持分页）
	 * 
	 * @param conditions 查询条件
	 * @param pageNum    页码（从1开始）
	 * @param pageSize   每页条数
	 * @return 分页后的列表
	 */
	public List<User> query(Map<String, Object> conditions, int pageNum, int pageSize) {
		// 1. 构建基础SQL和WHERE条件
		String baseSql = "SELECT * FROM user";
		String whereSql = conditions == null || conditions.isEmpty() ? ""
				: " WHERE " + conditions.keySet().stream().map(key -> key + " = ?")
				.collect(Collectors.joining(" AND "));
 
		// 2. 拼接分页SQL（MySQL的LIMIT语法）
		String finalSql = baseSql + whereSql;
		if (pageNum > 0 && pageSize > 0) {
			int offset = (pageNum - 1) * pageSize; // 计算偏移量（从0开始）
			finalSql += " LIMIT " + pageSize + " OFFSET " + offset;
		}
 
		// 3. 执行查询并转换结果
		return DBHelper.executeQuery(finalSql, rs -> convertResultSetToList(rs),
				conditions == null ? new Object[0] : conditions.values().toArray());
	}
 
	/**
	 * 查询符合条件的总记录数（用于分页计算总页数）
	 * 
	 * @param conditions 查询条件
	 * @return 总记录数
	 */
	public long count(Map<String, Object> conditions) {
		// 1. 构建统计SQL
		String countSql = "SELECT COUNT(*) FROM user";
		String whereSql = conditions == null || conditions.isEmpty() ? ""
				: " WHERE "
						+ conditions.keySet().stream().map(key -> key + " = ?").collect(Collectors.joining(" AND "));
 
		// 2. 执行统计查询
		return DBHelper.executeQuery(countSql + whereSql, rs -> {
			if (rs.next()) {
				return rs.getLong(1);
			}
			return 0L;
		}, conditions == null ? new Object[0] : conditions.values().toArray());
	}
 
	/**
	 * 通用条件查询(不分页)
	 */
	public List<User> query(Map<String, Object> conditions) {
		return query(conditions, -1, -1);
	}
 
	/**
	 * 根据id查询单个实体对象
	 * 
	 * @param id 主键id
	 * @return id对应的单个实体对象（单条记录）
	 */
	public User selectById(int id) {
		String querySql = "select * FROM user WHERE id=?";
		// 处理空结果集，避免索引越界异常
		List<User> objs = DBHelper.executeQuery(querySql, rs -> convertResultSetToList(rs), id);
		return objs.isEmpty() ? null : objs.get(0);
	}
 
	/**
	 * 结果集转换工具方法（抽离重复逻辑）
	 */
	// 修复 UserDao.java 中的 convertResultSetToList 方法
	private List<User> convertResultSetToList(ResultSet rs) {
	    List<User> userList = new ArrayList<>();
	    try {
	        while (rs.next()) {
	            User user = new User();
	            user.setId(rs.getLong("id"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setNickname(rs.getString("nickname"));  // 修复
	            user.setEmail(rs.getString("email"));
	            user.setAvatar(rs.getString("avatar"));
	            user.setRole(rs.getString("role"));
	            user.setStatus(rs.getInt("status"));         // 修复
	            user.setRegisterTime(rs.getObject("register_time", LocalDateTime.class));
	            user.setLastLoginTime(rs.getObject("last_login_time", LocalDateTime.class));
	            user.setUpdateTime(rs.getObject("update_time", LocalDateTime.class));
	            userList.add(user);
	        }
	    } catch (Exception e) {
	        throw new RuntimeException("结果集转换失败", e);
	    }
	    return userList;
	}
 
	/**
	 * 测试main方法：验证条件查询、根据ID查询等功能
	 */
	public static void main(String[] args) {
		// 1. 创建UserDao实例
		UserDao userDao = new UserDao();
		
		
		User obj = new User();
		obj.setUsername("user1234");
		obj.setPassword("1234");
		obj.setRole("admin");
		obj.setStatus(1);
		//添加执行
		userDao.add(obj);
		
		System.out.println("======= 测试1：查询所有用户（无条件）=======");
		// 2. 测试无条件查询（查询所有用户）
		List<User> allUsers = userDao.query(null);
		System.out.println("总用户数：" + allUsers.size());
		// 打印前3条用户信息（避免数据过多）
		allUsers.stream().limit(3).forEach(user -> {
			System.out.println("用户ID：" + user.getId() + "，用户名：" + user.getUsername() + "，角色：" + user.getRole());
		});
 
		System.out.println("\n======= 测试2：单条件查询（状态为1的用户）=======");
		// 3. 测试单条件查询
		Map<String, Object> singleCondition = Map.of("status", 1);
		List<User> activeUsers = userDao.query(singleCondition);
		System.out.println("状态为1的用户数：" + activeUsers.size());
 
		System.out.println("\n======= 测试3：多条件查询（管理员+状态正常）=======");
		// 4. 测试多条件查询
		Map<String, Object> multiConditions = Map.of("role", "admin", "status", 1);
		List<User> adminUsers = userDao.query(multiConditions);
		System.out.println("管理员且状态正常的用户数：" + adminUsers.size());
		adminUsers.forEach(user -> {
			System.out.println("管理员信息：" + user);
		});
 
		System.out.println("\n======= 测试4：根据ID查询单个用户 =======");
		// 5. 测试根据ID查询（请替换为你数据库中实际存在的ID）
		int testId = 1; // 假设数据库中有ID为1的用户
		User singleUser = userDao.selectById(testId);
		if (singleUser != null) {
			System.out.println("ID为" + testId + "的用户信息：");
			System.out.println("用户名：" + singleUser.getUsername());
			System.out.println("昵称：" + singleUser.getNickname());
			System.out.println("邮箱：" + singleUser.getEmail());
		} else {
			System.out.println("未找到ID为" + testId + "的用户");
		}
		
		System.out.println("======= 测试6：无条件分页查询（第1页，每页5条）=======");
		// 6. 无条件分页查询
		int pageNum1 = 1;
		int pageSize1 = 5;
		List<User> page1Users = userDao.query(null, pageNum1, pageSize1);
		System.out.println("第" + pageNum1 + "页数据（每页" + pageSize1 + "条）：");
		page1Users.forEach(user -> {
			System.out.println("ID：" + user.getId() + "，用户名：" + user.getUsername());
		});
 
		System.out.println("\n======= 测试7：带条件分页查询（第1页，每页3条）=======");
		// 7. 带条件分页查询（状态为1的用户）
		Map<String, Object> condition = Map.of("status", 1);
		int pageNum2 = 1;
		int pageSize2 = 3;
		List<User> page2Users = userDao.query(condition, pageNum2, pageSize2);
		System.out.println("状态为1的用户 - 第" + pageNum2 + "页数据：");
		page2Users.forEach(user -> {
			System.out.println(user);
		});
 
		System.out.println("\n======= 测试8：查询总记录数和总页数 =======");
		// 8. 查询总记录数和计算总页数
		long totalCount = userDao.count(condition);
		long totalPages = (totalCount + pageSize2 - 1) / pageSize2; // 向上取整计算总页数
		System.out.println("状态为1的用户总记录数：" + totalCount);
		System.out.println("每页" + pageSize2 + "条，总页数：" + totalPages);
 
		System.out.println("\n======= 测试9：查询第2页数据 =======");
		// 9. 查询第2页数据
		if (totalPages >= 2) {
			List<User> page3Users = userDao.query(condition, 2, pageSize2);
			System.out.println("状态为1的用户 - 第2页数据：");
			page3Users.forEach(user -> {
				System.out.println("ID：" + user.getId() + "，昵称：" + user.getNickname());
			});
		} else {
			System.out.println("无第2页数据");
		}
 
	}
}