package com.liudi.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class BaseSerivceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
    public BaseSerivceImpl() {
    }
}