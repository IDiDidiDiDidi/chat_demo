//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CustomSearchUtil {
    public CustomSearchUtil() {
    }

    public static List<CustomSearchVo> voConcert(Class clazz) {
        List<CustomSearchVo> list = new ArrayList();
        List<Field> tempFields = new ArrayList();
        tempFields.addAll(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        tempFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Iterator var3 = tempFields.iterator();

        while(var3.hasNext()) {
            Field field = (Field)var3.next();
            if (field.isAnnotationPresent(CustomSearch.class)) {
                CustomSearchVo customVo = new CustomSearchVo();
                customVo = putToField(field, (CustomSearch)field.getAnnotation(CustomSearch.class), customVo);
                list.add(customVo);
            }
        }

        return list;
    }

    private static CustomSearchVo putToField(Field field, CustomSearch attr, CustomSearchVo customVo) {
        if (attr != null) {
            String value = attr.name();
            boolean isShow = attr.isShow();
            String rule = attr.rule();
            String key = field.getName();
            String columnName = attr.columnName();
            boolean isDateStr = attr.dateShow();
            customVo.setKey(key);
            customVo.setValue(value);
            customVo.setShow(isShow);
            customVo.setRule(rule);
            customVo.setColumnName(columnName);
            customVo.setDateShow(isDateStr);
        }

        return customVo;
    }
}
