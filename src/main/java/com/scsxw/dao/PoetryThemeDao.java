package com.scsxw.dao;

import java.util.ArrayList;
import java.util.List;
import com.scsxw.entity.PoetryTheme;
import com.scsxw.util.DBHelper;

/**
 * 数据访问层 - 数据访问对象（一般一个表对应一个数据访问对象 poetry_theme表->PoetryThemeDao）
 */
public class PoetryThemeDao {

    /**
     * 增加的数据访问方法
     *
     * @param obj 实体对象（相当于poetry_theme表的一行数据）
     * @return 受影响的行数
     */
    public int add(PoetryTheme obj) {
        int ret = DBHelper.executeUpdate("insert into poetry_theme values (0,?,?,?,?)",
                obj.getName(), obj.getDescription(), obj.getCreateTime(), obj.getCreateTime());
        return ret;
    }

    /**
     * 修改的数据访问方法
     *
     * @param obj 实体对象（相当于poetry_theme表的一行数据）
     * @return 受影响的行数
     */
    public int update(PoetryTheme obj) {
        // 调用DBHelper类执行更新，返回受影响的行数
        int ret = DBHelper.executeUpdate("update poetry_theme set name=?,description=?,update_time=? where id=?",
                obj.getName(), obj.getDescription(), obj.getCreateTime(), obj.getId());
        return ret;
    }

    /**
     * 删除的数据访问方法(根据id删除)
     *
     * @param id 主键id
     * @return 受影响的行数
     */
    public int delete(int id) {
        // 调用DBHelper类执行删除，返回受影响的行数
        int ret = DBHelper.executeUpdate("delete from poetry_theme where id=?", id);
        return ret;
    }

    /**
     * 查询的数据访问方法(查询所有)
     *
     * @return 返回查询的实体对象列表（表格所有数据）
     */
    public List<PoetryTheme> selectAll() {
        // 调用DBHelper类执行查询，返回查询结果
        String querySql = "SELECT * FROM poetry_theme";
        List<PoetryTheme> result = DBHelper.executeQuery(querySql, rs -> {
            List<PoetryTheme> dataList = new ArrayList<>(); // 存放查询结果的列表
            while (rs.next()) { // 判断查询结果是否有下一行数据
                PoetryTheme poetryThemeObj = new PoetryTheme(); // 一个对象对应表格中的一行
                poetryThemeObj.setId(rs.getLong("id"));
                poetryThemeObj.setName(rs.getString("name"));
                poetryThemeObj.setDescription(rs.getString("description"));
                if (rs.getTimestamp("create_time") != null) {
                    poetryThemeObj.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                }
                if (rs.getTimestamp("update_time") != null) {
                    poetryThemeObj.setUpdateTime(rs.getTimestamp("update_time").toLocalDateTime());
                }
                dataList.add(poetryThemeObj); // 将对象添加到列表dataList
            }
            return dataList; // 返回列表
        });
        return result;
    }

    /**
     * 根据id查询单个实体对象
     *
     * @param id 主键id
     * @return id对应的单个实体对象（单条记录）
     */
    public PoetryTheme selectById(int id) {
        String querySql = "SELECT * FROM poetry_theme WHERE id=?";
        PoetryTheme result = DBHelper.executeQuery(querySql, rs -> {
            PoetryTheme obj = null; // 先初始化为null
            if (rs.next()) { // 判断是否有数据
                obj = new PoetryTheme(); // 创建实体对象
                obj.setId(rs.getLong("id"));
                obj.setName(rs.getString("name"));
                obj.setDescription(rs.getString("description"));
                if (rs.getTimestamp("create_time") != null) {
                    obj.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                }
                if (rs.getTimestamp("update_time") != null) {
                    obj.setUpdateTime(rs.getTimestamp("update_time").toLocalDateTime());
                }
            }
            return obj; // 返回对象（一行）
        }, id);
        return result;
    }
}
