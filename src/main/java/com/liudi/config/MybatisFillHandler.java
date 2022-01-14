package com.liudi.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * desc：Mybatis自定义填充类
 *
 */
@Component
public class MybatisFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"baseCreateTime",Date.class, new Date());
        this.strictInsertFill(metaObject,"isDelete", Boolean.class,false);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"baseUpdateTime",Date.class, new Date());
    }
}
