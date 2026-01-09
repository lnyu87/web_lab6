package com.scsxw.dao;

import java.util.ArrayList;
import java.util.List;
import com.scsxw.entity.Poetry;
import com.scsxw.util.DBHelper;

public class PoetryDao {

    public int add(Poetry obj) {
        return DBHelper.executeUpdate(
            "insert into poetry values (0,?,?,?,?,?,?,?,?,?,0,0,0,0,?,?)",
            obj.getTitle(), obj.getContent(), obj.getDynasty(), obj.getPic(),
            obj.getAuthorId(), obj.getAuthorName(), obj.getTypeId(), obj.getThemeId(),
            obj.getNotes(), obj.getCreateTime(), obj.getCreateTime()
        );
    }

    public int update(Poetry obj) {
        return DBHelper.executeUpdate(
            "update poetry set title=?, content=?, dynasty=?, pic=?, author_id=?, author_name=?, type_id=?, theme_id=?, notes=?, update_time=? where id=?",
            obj.getTitle(), obj.getContent(), obj.getDynasty(), obj.getPic(),
            obj.getAuthorId(), obj.getAuthorName(), obj.getTypeId(), obj.getThemeId(),
            obj.getNotes(), obj.getUpdateTime(), obj.getId()
        );
    }

    public int delete(long id) {
        return DBHelper.executeUpdate("delete from poetry where id=?", id);
    }

    public List<Poetry> selectAll() {
        String sql = "SELECT p.*, pt.name as type_name_str, pth.name as theme_name_str " +
                     "FROM poetry p " +
                     "LEFT JOIN poetry_type pt ON p.type_id = pt.id " +
                     "LEFT JOIN poetry_theme pth ON p.theme_id = pth.id";
        
        return DBHelper.executeQuery(sql, rs -> {
            List<Poetry> list = new ArrayList<>();
            while (rs.next()) {
                Poetry obj = new Poetry();
                obj.setId(rs.getLong("id"));
                obj.setTitle(rs.getString("title"));
                obj.setContent(rs.getString("content"));
                obj.setDynasty(rs.getString("dynasty"));
                obj.setPic(rs.getString("pic"));
                obj.setAuthorId(rs.getLong("author_id"));
                obj.setAuthorName(rs.getString("author_name"));
                obj.setTypeId(rs.getLong("type_id"));
                obj.setThemeId(rs.getLong("theme_id"));
                obj.setNotes(rs.getString("notes"));
                obj.setLikeCount(rs.getInt("like_count"));
                obj.setViewCount(rs.getInt("view_count"));
                obj.setCollectCount(rs.getInt("collect_count"));
                obj.setCommentCount(rs.getInt("comment_count"));
                if (rs.getTimestamp("create_time") != null)
                    obj.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                if (rs.getTimestamp("update_time") != null)
                    obj.setUpdateTime(rs.getTimestamp("update_time").toLocalDateTime());
                
                // Set non-db fields
                obj.setTypeName(rs.getString("type_name_str"));
                obj.setThemeName(rs.getString("theme_name_str"));
                
                list.add(obj);
            }
            return list;
        });
    }

    public Poetry selectById(long id) {
        return DBHelper.executeQuery("SELECT * FROM poetry WHERE id=?", rs -> {
            Poetry obj = null;
            if (rs.next()) {
                obj = new Poetry();
                obj.setId(rs.getLong("id"));
                obj.setTitle(rs.getString("title"));
                obj.setContent(rs.getString("content"));
                obj.setDynasty(rs.getString("dynasty"));
                obj.setPic(rs.getString("pic"));
                obj.setAuthorId(rs.getLong("author_id"));
                obj.setAuthorName(rs.getString("author_name"));
                obj.setTypeId(rs.getLong("type_id"));
                obj.setThemeId(rs.getLong("theme_id"));
                obj.setNotes(rs.getString("notes"));
                obj.setLikeCount(rs.getInt("like_count"));
                obj.setViewCount(rs.getInt("view_count"));
                obj.setCollectCount(rs.getInt("collect_count"));
                obj.setCommentCount(rs.getInt("comment_count"));
                if (rs.getTimestamp("create_time") != null)
                    obj.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                if (rs.getTimestamp("update_time") != null)
                    obj.setUpdateTime(rs.getTimestamp("update_time").toLocalDateTime());
            }
            return obj;
        }, id);
    }
}
