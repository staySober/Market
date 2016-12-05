package com.waitsober.interfaces;

import com.waitsober.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by Renhai on 2016/12/4.
 */
public interface ItemCatService {
    public List<EasyUITreeNode> getItemCatList(long parentId);
}
