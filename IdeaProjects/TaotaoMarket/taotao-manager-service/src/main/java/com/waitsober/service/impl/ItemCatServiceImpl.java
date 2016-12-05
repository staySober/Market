package com.waitsober.service.impl;

import com.waitsober.common.pojo.EasyUITreeNode;
import com.waitsober.interfaces.ItemCatService;
import com.waitsober.mapper.TbItemCatMapper;
import com.waitsober.pojo.TbItemCat;
import com.waitsober.pojo.TbItemCatExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Renhai on 2016/12/4.
 * 分类节点的查询
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Resource
    private TbItemCatMapper  itemCatMapper;
    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {

        List<EasyUITreeNode> list=new ArrayList<>();
        //根据商品的父节点id查询子节点列表
        TbItemCatExample example=new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> itemCatList = itemCatMapper.selectByExample(example);
        //对获取的数据进行转换
        for (TbItemCat tbItemCat:itemCatList) {
            EasyUITreeNode node =new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            node.setText(tbItemCat.getName());
            list.add(node);
        }
        return list;
    }
}
