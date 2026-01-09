package com.scsxw.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.scsxw.dao.UserDao;
import com.scsxw.entity.User;
import com.scsxw.util.DBHelper;

/**
 * 业务逻辑层-业务逻辑类（一般一个表对应有一个业务逻辑类 user表->PoetryThemeService）
 */
public class UserService {

    //初始数据访问类对象
    UserDao dao = new UserDao();

    /**
     * 增加方法
     * @param obj 实体对象（相当于user表的一行数据）
     * @return 受影响的行数
     */
    public boolean add(User obj) {
        return dao.add(obj) > 0;
    }

    /**
     * 修改方法
     * @param obj 实体对象（相当于user表的一行数据）
     * @return 受影响的行数
     */
    public boolean update(User obj) {
        return dao.update(obj) > 0;
    }

    /**
     * 删除方法（根据id删除）
     * @param id 主键id
     * @return
     */
    public boolean delete(int id) {
        return dao.delete((long) id) > 0;
    }

    /**
     * 查询方法（查询所有）
     * @return 返回查询的实体对象列表（表格）
     */
    public List<User> selectAll() {
        return dao.query(null); // 不传递调节查询所有
    }

    /**
     * 通用条件查询（不分页）
     * @param conditions 查询条件
     * @return 返回查询的实体对象列表（表格）
     */
    public List<User> select(Map<String, Object> conditions) {
        return dao.query(conditions); // 不传递调节查询所有
    }

    /**
     * 通用条件查询（支持分页）
     * @param conditions 查询条件
     * @param pageNum 页码（从1开始）
     * @param pageSize 每页条数
     * @return 分页后的列表
     */
    public List<User> select(Map<String, Object> conditions, int pageNum, int pageSize) {
        return dao.query(conditions, pageNum, pageSize); // 不传递调节查询所有
    }

    /**
     * 查询符合条件的总记录数（用于分页计算总页数）
     * @param conditions 查询条件
     * @return 总记录数
     */
    public long count(Map<String, Object> conditions) {
        return dao.count(conditions);
    }

    /**
     * 根据id查询单个实体对象
     * @param id 主键id
     * @return id对应的单个实体对象（单条记录）
     */
    public User selectById(int id) {
        return dao.selectById(id);
    }

    /**
     * 登录处理方法
     * @param obj 实体对象（相当于user表的一行数据）
     * @return id对应的单个实体对象（单条记录）
     */
    public User login(String username, String pswd) {
        // 构建查询条件
        Map<String, Object> conditions = Map.of("username", username, "password", pswd);
        List<User> obj = this.dao.query(conditions); // 调用数据访问类的查询方法
        if (obj != null && !obj.isEmpty()) { // 如果查询结果不为空
            return obj.get(0); // 获取第一个用户
        }
        return null; // 返回空表示登录失败
    }
}
