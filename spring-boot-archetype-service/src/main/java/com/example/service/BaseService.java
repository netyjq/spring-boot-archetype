package com.example.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * common-used service, other service class should extends this class to make CURD easily
 * @date 2019/12/13
 * @author netyjq@gmail.com
 */
public class BaseService<T> {

    @Resource
    private BaseMapper<T> baseMapper;

    public void insert(T t) {
        baseMapper.insert(t);
    }

    public T selectOne(Wrapper<T> wrapper) {
        return baseMapper.selectOne(wrapper);
    }

    public List<T> selectList(Wrapper<T> wrapper) {
        return baseMapper.selectList(wrapper);
    }

    public IPage<T> selectPage(long current, long size, Wrapper<T> wrapper) {
        return baseMapper.selectPage(new Page<>(current, size), wrapper);
    }

    public int update(T t, Wrapper<T> wrapper) {
        return baseMapper.update(t, wrapper);
    }

    public int delete(Wrapper<T> wrapper) {
        return baseMapper.delete(wrapper);
    }

    public int deleteById(Serializable id) {
        return baseMapper.deleteById(id);
    }

    public T selectById(Serializable id) {
        return baseMapper.selectById(id);
    }

}
