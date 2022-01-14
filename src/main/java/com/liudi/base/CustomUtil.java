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

public class CustomUtil {
    public CustomUtil() {
    }

    public static List<CustomVo> voConcert(Class clazz) {
        List<CustomVo> list = new ArrayList();
        List<Field> tempFields = new ArrayList();
        tempFields.addAll(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        tempFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Iterator var3 = tempFields.iterator();

        while(var3.hasNext()) {
            Field field = (Field)var3.next();
            if (field.isAnnotationPresent(ShowProperty.class)) {
                CustomVo customVo = new CustomVo();
                customVo = putToField(field, (ShowProperty)field.getAnnotation(ShowProperty.class), customVo);
                list.add(customVo);
            }
        }

        return list;
    }

    private static CustomVo putToField(Field field, ShowProperty attr, CustomVo customVo) {
        if (attr != null) {
            String value = attr.name();
            boolean isShow = attr.isShow();
            String key = field.getName();
            customVo.setKey(key);
            customVo.setValue(value);
            customVo.setShow(isShow);
        }

        return customVo;
    }
}
