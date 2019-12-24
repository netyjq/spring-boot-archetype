package com.github.netyjq.archetype.model.domain;

import com.github.netyjq.archetype.model.AbstractModel;
import lombok.Data;

/**
 * entity 示例
 * @author yejq@gmail.com
 * @date 2019-06-05
 */
@Data
public class AppInfo extends AbstractModel<Integer> {

    private Integer id;

    /**
     * 应用名称
     */
    private String name;

}
