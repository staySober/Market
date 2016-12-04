package com.waitsober.controller;

import com.waitsober.common.pojo.EasyUIResult;
import com.waitsober.interfaces.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * Created by Renhai on 2016/12/2.
 */
@Controller
public class PageController {

    @Resource
    private ItemService itemService;

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    //返回要展示的页面视图
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIResult getItemList(Integer page, Integer rows){
        EasyUIResult result = itemService.getItemList(page, rows);
        return result;
    }
}
