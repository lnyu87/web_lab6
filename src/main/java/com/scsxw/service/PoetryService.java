package com.scsxw.service;

import java.util.List;
import com.scsxw.dao.PoetryDao;
import com.scsxw.entity.Poetry;

public class PoetryService {
    PoetryDao dao = new PoetryDao();

    public boolean add(Poetry obj) {
        return dao.add(obj) > 0;
    }

    public boolean update(Poetry obj) {
        return dao.update(obj) > 0;
    }

    public boolean delete(long id) {
        return dao.delete(id) > 0;
    }

    public List<Poetry> selectAll() {
        return dao.selectAll();
    }

    public Poetry selectById(long id) {
        return dao.selectById(id);
    }
}
