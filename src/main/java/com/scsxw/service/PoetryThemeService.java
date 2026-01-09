package com.scsxw.service;

import java.util.List;

import com.scsxw.dao.PoetryThemeDao;
import com.scsxw.entity.PoetryTheme;

/**
 * 业务逻辑层-业务逻辑类（一般一个表对应有一个业务逻辑类 poetry_theme表->PoetryThemeService）
 */
public class PoetryThemeService {

    // 初始化数据访问对象
    PoetryThemeDao dao = new PoetryThemeDao();
    
    /**
     * 增加方法
     *
     * @param obj 实体对象（相当于poetry_theme表的一行数据）
     * @return 受影响的行数是否大于0
     */
    public boolean add(PoetryTheme obj) {
        return dao.add(obj) > 0;
    }

    /**
     * 修改方法
     *
     * @param obj 实体对象（相当于poetry_theme表的一行数据）
     * @return 受影响的行数是否大于0
     */
    public boolean update(PoetryTheme obj) {
        return dao.update(obj) > 0;
    }

    /**
     * 删除方法(根据id删除)
     *
     * @param id 主键id
     * @return 受影响的行数是否大于0
     */
    public boolean delete(int id) {
        return dao.delete(id) > 0;
    }

    /**
     * 查询方法(查询所有)
     *
     * @return 返回查询的实体对象列表（表格所有数据）
     */
    public List<PoetryTheme> selectAll() {
        return dao.selectAll();
    }

    /**
     * 根据id查询单个实体对象
     *
     * @param id 主键id
     * @return id对应的单个实体对象（单条记录）
     */
    public PoetryTheme selectById(int id) {
        return dao.selectById(id);
    }
}
