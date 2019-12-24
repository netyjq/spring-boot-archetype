package com.github.netyjq.archetype.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.netyjq.archetype.mapper.AppInfoMapper;
import com.github.netyjq.archetype.model.domain.AppInfo;
import org.springframework.stereotype.Service;

/**
 * a service class example, other services class should extends ServiceImpl like this
 *
 * @date 2019/12/13
 * @author netyjq@gmail.com
 */
@Service
public class AppInfoService extends ServiceImpl<AppInfoMapper, AppInfo> {


}
