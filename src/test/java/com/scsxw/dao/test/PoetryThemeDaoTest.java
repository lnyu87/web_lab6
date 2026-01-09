package com.scsxw.dao.test;


import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import com.scsxw.dao.PoetryThemeDao;
import com.scsxw.entity.PoetryTheme;

public class PoetryThemeDaoTest {

    PoetryThemeDao dao;
    
    @Before // 在所有测试方法执行之前执行
    public void setup() throws Exception {
        dao = new PoetryThemeDao(); // 初始化数据访问对象
    }

    @Test
    public void testAdd() { // 测试数据访问类的添加方法
        PoetryTheme obj = new PoetryTheme();
        obj.setName("今天天气很好");
        obj.setDescription("4444");
        obj.setCreateTime(LocalDateTime.now());
        obj.setUpdateTime(LocalDateTime.now()); // 需要添加updateTime字段
        dao.add(obj);
    }

    @Test
    public void testUpdate() { // 测试数据访问类的修改方法
        PoetryTheme obj = new PoetryTheme(); // 创建修改实体对象
        obj.setName("今天天气很好2222");
        obj.setDescription("44442255");
        obj.setId((long) 9); // 指定修改id为9的这条数据
        obj.setUpdateTime(LocalDateTime.now());
        dao.update(obj);
    }

    @Test
    public void testDelete() { // 测试数据访问类的删除方法
        dao.delete(9);
    }
}
