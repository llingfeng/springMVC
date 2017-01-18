package com.omg.service.impl;

import com.omg.dao.GoodsCategoryDao;
import com.omg.entity.GoodsCategory;
import com.omg.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.core.InteractionCallback;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/10/24.
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryDao goodsCategoryDao;

    public List<GoodsCategory> queryGoodsCategoryList() {
        return goodsCategoryDao.queryList(null);
    }

    public List<GoodsCategory> queryGoodsCategoryList(String goodsCategoryName, String createPerson) {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setGoodsCategoryName(goodsCategoryName);
        goodsCategory.setCreatePerson(createPerson);
        return goodsCategoryDao.queryList(goodsCategory);
    }

    @Override
    public int deleteBatch(Integer categoryId) {
        if (categoryId != null) {
            return goodsCategoryDao.deleteCategory(categoryId);
        }
        return 0;
    }

    @Override
    public int deleteBatch(String[] categoryIds) {
        if (categoryIds != null && categoryIds.length > 0) {
            List<Integer> list = new ArrayList<>();
            for (String s : categoryIds) {
                list.add(Integer.parseInt(s));
            }
            return goodsCategoryDao.deleteBatch(list);
        }
        return 0;
    }

    @Override
    public int saveGoodsCategory(GoodsCategory goodsCategory) {
        if(goodsCategory.getGoodsCategoryId() == null){
            return goodsCategoryDao.addGoodsCategory(goodsCategory);
        }
        return goodsCategoryDao.updateGoodsCategory(goodsCategory);
    }

    @Override
    public GoodsCategory getGoodsCategory(Integer goodsCategoryId) {
        if (goodsCategoryId == null)
            return null;
        return goodsCategoryDao.queryById(goodsCategoryId);
    }

    @Override
    public int updateGoodsCategory(GoodsCategory goodsCategory) {
        return goodsCategoryDao.updateGoodsCategory(goodsCategory);
    }

}

