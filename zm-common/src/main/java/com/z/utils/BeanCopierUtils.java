package com.z.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanCopierUtils {
    private static final Map<String, BeanCopier> CACHE = new ConcurrentHashMap<>();

    public static <F>F copyObject(Object source, Class<F> target) {
        F f= getInstance(target);
        BeanCopier copier = getBeanCopier(source.getClass(), target);
        copier.copy(source, f, null);
        return f;
    }

    public static <T, F>List<F> copyList(Class<T> source, Class<F> target,List<T> sourceList) {

        List<F> res = new ArrayList<>();

        BeanCopier copier = getBeanCopier(source, target);
        for(T t:sourceList){
            F f= getInstance(target);
            copier.copy(t, f, null);
            res.add(f);
        }

        return res;
    }

    private static BeanCopier getBeanCopier(Class<?> sourceClazz, Class<?> targetClazz) {
        String key = generatorKey(sourceClazz, targetClazz);
        BeanCopier copier;
        if(CACHE.containsKey(key)) {
            copier = CACHE.get(key);
        } else {
            copier = BeanCopier.create(sourceClazz, targetClazz, false);
            CACHE.put(key, copier);
        }
        return copier;
    }

    private static String generatorKey(Class<?> sourceClazz, Class<?> targetClazz) {
        return sourceClazz + "_" + targetClazz;
    }

    private static <F> F getInstance(Class<F> obj){
        F f= null;
        try {
            f = obj.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return f;
    }

    private BeanCopierUtils(){}
}
