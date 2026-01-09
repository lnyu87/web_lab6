package com.scsxw.dao;

import java.util.ArrayList;
import java.util.List;
import com.scsxw.entity.Author;
import com.scsxw.util.DBHelper;

public class AuthorDao {

    public int add(Author obj) {
        return DBHelper.executeUpdate(
            "insert into author values (0,?,?,?,?,?,?,?,?,?,?)",
            obj.getName(), obj.getDynasty(), obj.getPic(), 
            obj.getBirthYear(), obj.getDeathYear(), obj.getAlias(),
            obj.getBiography(), obj.getRepresentativeWorks(),
            obj.getCreateTime(), obj.getCreateTime()
        );
    }

    public int update(Author obj) {
        return DBHelper.executeUpdate(
            "update author set name=?, dynasty=?, pic=?, birth_year=?, death_year=?, alias=?, biography=?, representative_works=?, update_time=? where id=?",
            obj.getName(), obj.getDynasty(), obj.getPic(),
            obj.getBirthYear(), obj.getDeathYear(), obj.getAlias(),
            obj.getBiography(), obj.getRepresentativeWorks(),
            obj.getUpdateTime(), obj.getId()
        );
    }

    public int delete(long id) {
        return DBHelper.executeUpdate("delete from author where id=?", id);
    }

    public List<Author> selectAll() {
        return DBHelper.executeQuery("SELECT * FROM author", rs -> {
            List<Author> list = new ArrayList<>();
            while (rs.next()) {
                Author obj = new Author();
                obj.setId(rs.getLong("id"));
                obj.setName(rs.getString("name"));
                obj.setDynasty(rs.getString("dynasty"));
                obj.setPic(rs.getString("pic"));
                obj.setBirthYear(rs.getString("birth_year"));
                obj.setDeathYear(rs.getString("death_year"));
                obj.setAlias(rs.getString("alias"));
                obj.setBiography(rs.getString("biography"));
                obj.setRepresentativeWorks(rs.getString("representative_works"));
                if (rs.getTimestamp("create_time") != null)
                    obj.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                if (rs.getTimestamp("update_time") != null)
                    obj.setUpdateTime(rs.getTimestamp("update_time").toLocalDateTime());
                list.add(obj);
            }
            return list;
        });
    }

    public Author selectById(long id) {
        return DBHelper.executeQuery("SELECT * FROM author WHERE id=?", rs -> {
            Author obj = null;
            if (rs.next()) {
                obj = new Author();
                obj.setId(rs.getLong("id"));
                obj.setName(rs.getString("name"));
                obj.setDynasty(rs.getString("dynasty"));
                obj.setPic(rs.getString("pic"));
                obj.setBirthYear(rs.getString("birth_year"));
                obj.setDeathYear(rs.getString("death_year"));
                obj.setAlias(rs.getString("alias"));
                obj.setBiography(rs.getString("biography"));
                obj.setRepresentativeWorks(rs.getString("representative_works"));
                if (rs.getTimestamp("create_time") != null)
                    obj.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
                if (rs.getTimestamp("update_time") != null)
                    obj.setUpdateTime(rs.getTimestamp("update_time").toLocalDateTime());
            }
            return obj;
        }, id);
    }
}
