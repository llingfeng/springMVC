package com.omg.web;

import com.omg.entity.GoodsCategory;
import com.omg.entity.User;
import com.omg.service.GoodsCategoryService;
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/10/24.
 */
@Controller
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 查询（get）
     * @param map
     * @param request
     * @return
     */
    @RequestMapping(value = "/categoryList", method = RequestMethod.GET)
    public String getGoodsCategoryGet(Map<String, Object> map, HttpServletRequest request) {
        return getGoodsCategory(map,request);
    }

    /**
     * 查询（post）
     * @param map
     * @param request
     * @return
     */
    @RequestMapping(value = "/categoryList", method = RequestMethod.POST)
    public String getGoodsCategory(Map<String, Object> map, HttpServletRequest request) {
        String createPerson = request.getParameter("createPerson");
        String goodsCategoryName = request.getParameter("goodsCategoryName");
        List<GoodsCategory> goodsCategoryList = goodsCategoryService.queryGoodsCategoryList(goodsCategoryName, createPerson);
        map.put("goodsCategoryList", goodsCategoryList);
        map.put("createPerson", createPerson);
        map.put("goodsCategoryName", goodsCategoryName);
        return "goods_category";
    }

    /**
     * 删除单条记录
     *
     */
    @ResponseBody
    @RequestMapping(value = "/categoryList", method = RequestMethod.DELETE)
    public Integer deleteOne(@RequestBody GoodsCategory goodsCategory) {
        return goodsCategoryService.deleteBatch(goodsCategory.getGoodsCategoryId());
    }

    /**
     * 批量删除
     * @param request
     * @return
     */
    @RequestMapping(value = "deleteBatch",method = RequestMethod.DELETE)
    public ModelAndView deleteBatch(HttpServletRequest request){
        String[] categoryIds = request.getParameterValues("categoryIds");
        int flag = goodsCategoryService.deleteBatch(categoryIds);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("goodsCategoryName", request.getParameter("goodsCategoryName"));
        modelMap.addAttribute("createPerson", request.getParameter("createPerson"));
        return new ModelAndView("redirect:/categoryList", modelMap);
    }

    /**
     * 新增
     * @param goodsCategory
     * @return
     */
    @RequestMapping(value = "/goodsCategory", method = RequestMethod.PUT)
    public String addGoodsCategory(GoodsCategory goodsCategory){
        goodsCategoryService.saveGoodsCategory(goodsCategory);
        return "redirect:/categoryList";
    }

    /**
     * 跳转到新增页面
     * @param map
     * @return
     */
    @RequestMapping("/goodsCategory")
    public String inputGoodsCategory(Map<String ,Object> map){
        map.put("goodsCategory",new GoodsCategory());
        return "addGoodsCategory";
    }

    /**
     * 修改
     * @param goodsCategory
     * @return
     */
    @RequestMapping(value = "/goodsCategory",method = RequestMethod.POST)
    public String modifyGoodsCategory(GoodsCategory goodsCategory){
        goodsCategoryService.updateGoodsCategory(goodsCategory);
        return "redirect:/categoryList";
    }

    /**
     * 跳转到修改页面
     * @param map
     * @param id
     * @return
     */
    @RequestMapping("/goodsCategory/{id}")
    public String modifyGoodsCategory(Map<String ,Object> map, @PathVariable("id") Integer id){
        map.put("goodsCategory",goodsCategoryService.getGoodsCategory(id));
        return "addGoodsCategory";
    }

    @RequestMapping("/test")
    @ResponseBody
    public User testJson(@RequestBody User user){
        return user;
    }
}
