package com.scsxw.service;

import java.util.List;
import com.scsxw.dao.AuthorDao;
import com.scsxw.entity.Author;

public class AuthorService {
    AuthorDao dao = new AuthorDao();

    public boolean add(Author obj) {
        return dao.add(obj) > 0;
    }

    public boolean update(Author obj) {
        return dao.update(obj) > 0;
    }

    public boolean delete(long id) {
        return dao.delete(id) > 0;
    }

    public List<Author> selectAll() {
        return dao.selectAll();
    }

    public Author selectById(long id) {
        return dao.selectById(id);
    }
}
