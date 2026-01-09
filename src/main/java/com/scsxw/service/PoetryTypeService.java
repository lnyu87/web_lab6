package com.scsxw.service;

import java.util.List;
import com.scsxw.dao.PoetryTypeDao;
import com.scsxw.entity.PoetryType;

/**
 * 业务逻辑层 - PoetryTypeService
 */
public class PoetryTypeService {

    PoetryTypeDao dao = new PoetryTypeDao();

    public boolean add(PoetryType obj) {
        return dao.add(obj) > 0;
    }

    public boolean update(PoetryType obj) {
        return dao.update(obj) > 0;
    }

    public boolean delete(long id) {
        return dao.delete(id) > 0;
    }

    public List<PoetryType> selectAll() {
        return dao.selectAll();
    }

    public PoetryType selectById(long id) {
        return dao.selectById(id);
    }
}
