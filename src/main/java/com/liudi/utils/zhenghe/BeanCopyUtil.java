package com.liudi.utils.zhenghe;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BeanCopyUtil<T> {
    private static final Logger log = LoggerFactory.getLogger(BeanCopyUtil.class);

    public static <T> T convertBean(Object sourceObj, Class<T> clazz) {
        DozerBeanMapper dozer = new DozerBeanMapper();
        if (sourceObj == null) {
            return null;
        } else if (sourceObj instanceof Optional) {
            Optional optional = (Optional)sourceObj;

            try {
                Object obj = optional.get();
                return dozer.map(obj, clazz);
            } catch (Exception var5) {
                return null;
            }
        } else {
            return dozer.map(sourceObj, clazz);
        }
    }


    public static <T> List<T> convertList(Collection sourceList, Class<T> destinationClass) {
        DozerBeanMapper dozer = new DozerBeanMapper();
        List destinationList = new ArrayList();
        Iterator i$ = sourceList.iterator();

        while(i$.hasNext()) {
            Object sourceObject = i$.next();
            Object destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }

        return destinationList;
    }

}
