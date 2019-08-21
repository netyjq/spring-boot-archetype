package com.example.mapper;

import com.example.model.AbstractModel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * BaseMapper
 * @date 2017/6/6.
 * @author netyjq@gmail.com
 */
public interface IBaseMapper<M extends AbstractModel, ID extends Serializable> {

    /**
     * 新增数据
     * @param model model实体
     * @return id 数据库自增主键
     */
    int insertOne(M model);

    /**
     * 删除
     * @param id 主键id
     * @return rows
     */
    int deleteOne(ID id);

    /**
     * 更新
     * @param model model实体
     * @return rows
     */
    int updateOne(M model);

    /**
     * 根据主键获取实体
     * @param id 主键id
     * @return model实体
     */
    M selectOne(ID id);

    /**
     * 根据参统计数量
     * @param params 参数
     * @return int
     */
    int count(Map<String, Object> params);

    /**
     * 根据参数或者多个对象
     * @param params 参数
     * @return List<M>
     */
    List<M> selectList(Map<String, Object> params);

    /**
     * 无参数获取全表对象
     * @return List<M>
     */
    List<M> selectAll();

}
