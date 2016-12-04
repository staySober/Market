package com.waitsober.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.waitsober.common.pojo.EasyUIResult;
import com.waitsober.interfaces.ItemService;
import com.waitsober.mapper.TbItemMapper;
import com.waitsober.pojo.TbItem;
import com.waitsober.pojo.TbItemExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Renhai on 2016/12/2.
 */

@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private TbItemMapper itemMapper;
    //分页查询对象
    public EasyUIResult getItemList(Integer page,Integer rows){
        //使用PageHelper 实现分页
        //设置分页信息
        PageHelper.startPage(page,rows);
        //调用Dao层进行查询
        TbItemExample tbItemExample=new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(tbItemExample);
        PageInfo<TbItem> itemPageInfo=new PageInfo<TbItem>(list);
        //创建返回的结果对象
        EasyUIResult result=new EasyUIResult();
        result.setRows(itemPageInfo.getList());
        result.setTotal((int) itemPageInfo.getTotal());
        return result;
    }

}
