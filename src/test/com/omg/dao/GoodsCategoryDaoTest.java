package com.omg.dao;

import com.omg.entity.Goods;
import com.omg.entity.GoodsCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by admin on 2016/10/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mvc.xml"})
public class GoodsCategoryDaoTest {

    @Autowired
    private GoodsCategoryDao goodsCategoryDao;
    @Test
    public void queryList() throws Exception {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setGoodsCategoryName("手机");
        List<GoodsCategory> goodsCategoryList = goodsCategoryDao.queryList(goodsCategory);
        System.out.println(goodsCategoryList);
    }

    @Test
    public void deleteCategory() throws Exception {

    }

    @Test
    public void deleteBatch() throws Exception {

    }

    @Test
    public void addGoodsCategory() throws Exception {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setGoodsCategoryName("手机5");
        goodsCategory.setCreatePerson("leijun");
        goodsCategoryDao.addGoodsCategory(goodsCategory);
    }

    @Test
    public void updateGoodsCategory() throws Exception {
        GoodsCategory goodsCategory = goodsCategoryDao.queryById(154);
        goodsCategory.setCreatePerson("uu");
        goodsCategoryDao.updateGoodsCategory(goodsCategory);
    }
}