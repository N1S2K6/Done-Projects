package com.wms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wms.entity.Goodstype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.entity.Storage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nty
 * @since 2024-01-12
 */
public interface GoodstypeService extends IService<Goodstype> {
    IPage pageCC(IPage<Goodstype> page, Wrapper wrapper);

}