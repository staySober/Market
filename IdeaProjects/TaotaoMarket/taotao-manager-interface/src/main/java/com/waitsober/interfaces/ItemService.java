package com.waitsober.interfaces;

import com.waitsober.common.pojo.EasyUIResult;

/**
 * Created by Renhai on 2016/12/2.
 */

public interface ItemService {

    public EasyUIResult getItemList(Integer page, Integer rows);
}
