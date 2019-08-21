package com.example.service;

import com.example.common.util.BeanUtil;
import com.example.mapper.IBaseMapper;
import com.example.model.AbstractModel;
import com.example.model.dto.request.PageRequestDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 泛型 AbstractBaseService
 * @date 2017/6/7.
 * @author netyjq@gmail.com
 */
public abstract class AbstractBaseService<M extends AbstractModel, ID extends Serializable> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected IBaseMapper<M, ID> baseMapper;

    /**
     * 增
     * @param model Model
     * @return int
     */
    protected int insert(M model) {
        return baseMapper.insertOne(model);
    }

    /**
     * 删
     * @param id ID
     * @return int
     */
    protected int delete(ID id) {
        return baseMapper.deleteOne(id);
    }

    /**
     * 改
     * @param model Model
     * @return int
     */
    protected int update(M model) {
        return baseMapper.updateOne(model);
    }

    /**
     * 主键查询
     * @param id ID
     * @return Model
     */
    protected M get(ID id) {
        return (M) baseMapper.selectOne(id);
    }

    /**
     * 查询所有
     * @return List<M>
     */
    public List<M> listAll() {
        return baseMapper.selectAll();
    }

    /**
     * 分页条件查询
     * @param requestDTO 分页查询条件
     * @return PageInfo<M>
     */
    public PageInfo<M> listPage(PageRequestDTO requestDTO) {
        Map<String, Object> params = BeanUtil.transBeanToMap(requestDTO);
        return PageHelper.startPage(requestDTO.getPageNum(), requestDTO.getPageSize()).doSelectPageInfo(() -> {
            baseMapper.selectList(params);
        });
    }

    /**
     * 条件不分页查询
     * @param params Map<String, Object>
     * @return List<M>
     */
    public List<M> list(Map<String, Object> params) {
        return baseMapper.selectList(params);
    }

}
