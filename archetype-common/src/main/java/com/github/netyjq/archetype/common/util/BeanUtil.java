package com.github.netyjq.archetype.common.util;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.springframework.util.CollectionUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.IntStream;

/**
 * 对象转换工具
 * @date 2017/6/6.
 * @author netyjq@gmail.com
 */
public class BeanUtil {

    /**
     * 将bean转成 Map<String,Object>
     * @param object 传入对象
     * @return Map<String, Object>
     */
    public static Map<String, Object> transBeanToMap(Object object) {
        if (object == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>(16);
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!"class".equals(key)) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(object);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 将bean转成 Map<String,Object>
     * @param source 传入对象
     * @param properties 属性
     * @return
     */
    public static Map<String, Object> transBeanToMap(Object source, String properties) {
        if (source == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>(16);
        try {
            List<String> propsList = Arrays.asList(properties.replace(" ", "").split(","));
            // 如果数据非常敏感的话，可以先把 T 转成 vo,再反射vo
            Class<?> c = Class.forName(source.getClass().getName());
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                // 取出属性名称
                String propName = field.toString().substring(field.toString().lastIndexOf(".")+1);
                if (propsList.indexOf(propName) != -1) {
                    map.put(propName,field.get(source));
                }
                if (map.size() == propsList.size()) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, Object> transBeanToMap(Object source, Class<?> clazz) {
        return transBeanToMap(source, getProperty(clazz));
    }


    /**
     * 批量获取对象中指定属性的值
     * @param sourceList Bean集合
     * @param properties Bean属性
     * @return  List<Map<String, Object>>
     * @throws ClassNotFoundException
     */
    public static List<Map<String, Object>> transBeansToListMap(List sourceList, String properties) throws ClassNotFoundException {
        if (CollectionUtils.isEmpty(sourceList) || Strings.isNullOrEmpty(properties)) {
            return null;
        }
        List<Map<String, Object>> objectList = new ArrayList<>();
        sourceList.forEach(source -> {
            objectList.add(transBeanToMap(source, properties));
        });
        return objectList;
    }

    public static List<Map<String, Object>> transBeansToListMap(List sourceList, Class<?> clazz) throws ClassNotFoundException {
        return transBeansToListMap(sourceList, getProperty(clazz));
    }

    /**
     * 获取Object属性 举个栗子 对象有a,b,c 3个属性，执行此方法后返回字符串 "a,b,c"
     * @param clazz 对象的class
     * @return String
     */
    public static String getProperty(Class<?> clazz) {
        StringBuffer sb = new StringBuffer();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!"class".equals(key)) {
                    sb.append(key);
                    sb.append(",");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 根据key-value构造Map 举个栗子： keys="a,b,c", values:{A, B, C}
     * @param keys key值，多个用逗号隔开
     * @param values key 对应的value, 必须与 key 保证顺序
     * @return Map<String,Object>
     */
    public static Map<String, Object> getPropertyMap(String keys, Object... values) {
        if (Strings.isNullOrEmpty(keys) || values == null) {
            return null;
        }
        List<Object> valueList = new ArrayList<>();
        for (Object o : values) {
            valueList.add(o);
        }
        if (valueList.isEmpty()) {
            return null;
        }
        Map<String, Object> params = new HashMap<>(16);
        List<String> keyList = Splitter.on(",").trimResults().splitToList(keys);
        IntStream.range(0, keyList.size()).forEach(index -> {
            params.put(keyList.get(index), valueList.get(index));
        });
        return params;
    }

}
