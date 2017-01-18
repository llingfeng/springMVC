package com.omg.service;

import com.omg.entity.GoodsCategory;

import java.util.List;

/**
 * Created by admin on 2016/10/24.
 */
public interface GoodsCategoryService {

    /**
     * 查询所有产品类型
     * @return
     */
    public List<GoodsCategory> queryGoodsCategoryList();

    /**
     * 根据类型名称和创建人查询
     * @param goodsCategoryName
     * @param createPerson
     * @return
     */
    public List<GoodsCategory> queryGoodsCategoryList(String goodsCategoryName,String createPerson);

    /**
     * 删除商品类别
     * @param categoryId
     * @return
     */
    public int deleteBatch(Integer categoryId);

    /**
     * 批量删除
     * @param categoryIds
     * @return
     */
    public int deleteBatch(String[] categoryIds);

    /**
     * 保存
     * @param goodsCategory
     * @return
     */
    public int saveGoodsCategory(GoodsCategory goodsCategory);

    public GoodsCategory getGoodsCategory(Integer goodsCategoryId);

    public int updateGoodsCategory(GoodsCategory goodsCategory);
}
