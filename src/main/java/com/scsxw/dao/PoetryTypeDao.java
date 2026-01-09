package com.scsxw.dao;

import java.util.ArrayList;
import java.util.List;
import com.scsxw.entity.PoetryType;
import com.scsxw.util.DBHelper;

/**
 * 数据访问层 - PoetryTypeDao
 */
public class PoetryTypeDao {

    public int add(PoetryType obj) {
        int ret = DBHelper.executeUpdate("insert into poetry_type values (0,?,?,?,?)",
                obj.getName(), obj.getDescription(), obj.getCreateTime(), obj.getCreateTime());
        return ret;
    }

    public int update(PoetryType obj) {
        int ret = DBHelper.executeUpdate("update poetry_type set name=?,description=?,update_time=? where id=?",
                obj.getName(), obj.getDescription(), obj.getUpdateTime(), obj.getId());
        return ret;
    }

    public int delete(long id) {
        int ret = DBHelper.executeUpdate("delete from poetry_type where id=?", id);
        return ret;
    }

    public List<PoetryType> selectAll() {
        String querySql = "SELECT * FROM poetry_type";
        List<PoetryType> result = DBHelper.executeQuery(querySql, rs -> {
            List<PoetryType> dataList = new ArrayList<>();
            while (rs.next()) {
                PoetryType obj = new PoetryType();
                obj.setId(rs.getLong("id"));
                obj.setName(rs.getString("name"));
                obj.setDescription(rs.getString("description"));
                if (rs.getTimestamp("create_time") != null) {
                    obj.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                }
                if (rs.getTimestamp("update_time") != null) {
                    obj.setUpdateTime(rs.getTimestamp("update_time").toLocalDateTime());
                }
                dataList.add(obj);
            }
            return dataList;
        });
        return result;
    }

    public PoetryType selectById(long id) {
        String querySql = "SELECT * FROM poetry_type WHERE id=?";
        PoetryType result = DBHelper.executeQuery(querySql, rs -> {
            PoetryType obj = null;
            if (rs.next()) {
                obj = new PoetryType();
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
            return obj;
        }, id);
        return result;
    }
}
