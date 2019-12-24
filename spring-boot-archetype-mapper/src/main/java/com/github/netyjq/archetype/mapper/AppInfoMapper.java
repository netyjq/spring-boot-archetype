package com.github.netyjq.archetype.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.netyjq.archetype.model.domain.AppInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * a mapper class example, others mapper should extends BaseMapper like this
 *
 * @date 2019/9/25 16:16
 * @author netyjq@gmail.com
 **/
@Mapper
public interface AppInfoMapper extends BaseMapper<AppInfo> {

}
