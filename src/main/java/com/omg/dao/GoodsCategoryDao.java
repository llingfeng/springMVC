package com.omg.dao;

import com.omg.entity.GoodsCategory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/10/24.
 */
public interface GoodsCategoryDao {

    /**
     * 查询商品类别
     * @param goodsCategory
     * @return
     */
    List<GoodsCategory> queryList(GoodsCategory goodsCategory);

    /**
     * 删除单条商品
     * @param categoryId
     * @return
     */
    int deleteCategory(Integer categoryId);

    /**
     * 批量删除
     * @param list
     * @return
     */
    int deleteBatch(List<Integer> list);

    /**
     * 增加
     * @return
     */
    int addGoodsCategory(GoodsCategory goodsCategory);

    /**
     * 根据id查询
     * @param goodsCategoryId
     * @return
     */
    GoodsCategory queryById(Integer goodsCategoryId);

    /**
     * 更新
     * @param goodsCategory
     * @return
     */
    int updateGoodsCategory(GoodsCategory goodsCategory);

}
