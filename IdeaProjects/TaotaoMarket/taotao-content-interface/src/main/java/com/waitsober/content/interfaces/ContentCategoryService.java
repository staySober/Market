package com.waitsober.content.interfaces;

import com.waitsober.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * Created by Renhai on 2016/12/5.
 */
public interface ContentCategoryService {

    public List<EasyUITreeNode> getContentCategoryList(long parentId);
}
