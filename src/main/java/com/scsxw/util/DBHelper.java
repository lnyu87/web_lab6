package com.scsxw.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC数据库操作工具类 封装连接获取、资源关闭、通用CRUD方法
 */
public class DBHelper {
	// 数据库连接配置
	
	//jdbc:mysql://localhost:3306/scsxw?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
	
	private static final String URL = "jdbc:mysql://localhost:3306/scsxw";
	private static final String USER = "root";
	private static final String PASSWORD = "00000000";

	// 静态代码块：加载驱动（只执行一次）
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL驱动加载成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("MySQL驱动加载失败，请检查依赖包！");
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return Connection对象
	 * @throws SQLException 连接异常
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	/**
	 * 关闭资源（通用方法，适配查询/更新操作）
	 * 
	 * @param conn 连接对象
	 * @param stmt 语句对象（PreparedStatement/Statement）
	 * @param rs   结果集对象（查询时使用）
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		// 关闭结果集
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 关闭语句对象
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 关闭连接
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 简化关闭（无结果集时使用，如新增/修改/删除）
	 */
	public static void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}

	/**
	 * 通用新增/修改/删除方法（支持占位符参数）
	 * 
	 * @param sql    SQL语句（使用?作为占位符）
	 * @param params 参数列表（顺序与占位符一致）
	 * @return 受影响的行数
	 */
	public static int executeUpdate(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// 1. 获取连接
			conn = getConnection();
			// 2. 预编译SQL
			ps = conn.prepareStatement(sql);
			// 3. 设置参数（处理不同类型的参数）
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]); // JDBC参数索引从1开始
				}
			}
			// 4. 执行SQL
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL执行失败：" + sql, e);
		} finally {
			// 5. 关闭资源
			close(conn, ps);
		}
	}

	/**
	 * 通用查询方法（需要自定义结果集处理）
	 * 
	 * @param sql     SQL查询语句
	 * @param handler 结果集处理器（将ResultSet转换为目标对象）
	 * @param params  查询参数
	 * @param <T>     结果类型
	 * @return 查询结果（单个对象或集合）
	 */
	public static <T> T executeQuery(String sql, ResultSetHandler<T> handler, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1. 获取连接
			conn = getConnection();
			// 2. 预编译SQL
			ps = conn.prepareStatement(sql);
			// 3. 设置参数
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// 4. 执行查询
			rs = ps.executeQuery();
			// 5. 处理结果集（通过自定义处理器）
			return handler.handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询执行失败：" + sql, e);
		} finally {
			// 6. 关闭资源
			close(conn, ps, rs);
		}
	}

	/**
	 * 通用查询方法（需要手段关闭）
	 * 
	 * @param sql    SQL查询语句
	 * @param params 查询参数
	 * @param <T>    结果类型
	 * @return 查询结果（单个对象或集合）
	 */
	public static ResultSet executeQuery(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 1. 获取连接
			conn = getConnection();
			// 2. 预编译SQL
			ps = conn.prepareStatement(sql);
			// 3. 设置参数
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// 4. 执行查询
			rs = ps.executeQuery();			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询执行失败：" + sql, e);
		} 
	}

	/**
	 * 结果集处理器接口（用于自定义查询结果转换）
	 * 
	 * @param <T> 目标结果类型
	 */
	public interface ResultSetHandler<T> {
		T handle(ResultSet rs) throws SQLException;
	}

	// ------------------------------ 示例用法（可删除，仅参考）------------------------------
	public static void main(String[] args) throws SQLException {
		// 1. 测试新增（对应你原有的插入逻辑）
		String insertSql = "INSERT INTO test (title, content) VALUES (?, ?)";
		String title = "直接SQL新增的标题";
		String content = "这条数据是通过JSP直接执行SQL语句插入的，无需表单提交";

		int rows = DBHelper.executeUpdate(insertSql, title, content);
		System.out.println("新增成功，受影响行数：" + rows);

		// 2. 测试查询（查询所有test表数据）
		// 2. 测试查询（查询所有test表数据）
		String querySql = "SELECT id, title, content FROM test";
		List<String> result = DBHelper.executeQuery(querySql, rs -> {
			List<String> dataList = new ArrayList<>();
			while (rs.next()) {
				dataList.add(String.format("id: %d, title: %s, content: %s", rs.getInt("id"), rs.getString("title"),
						rs.getString("content")));
			}
			return dataList; // 返回集合
		});

		System.out.println("查询结果：");
		result.forEach(System.out::println);

		// 3. 测试查询（查询所有test表数据）
		 ResultSet ret = DBHelper.executeQuery(querySql);
		 while (ret.next()) {
			 System.out.println(ret.getString("id")+","+ret.getString("title"));
			
		}

	}
}