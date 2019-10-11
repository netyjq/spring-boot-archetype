package com.example.model.dto.request;

import com.example.model.dto.AbstractDTO;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 分页请求dto
 * @date 2017/2/20
 * @author netyjq@gmail.com
 */
@Data
public class PageRequestDTO extends AbstractDTO {

    private Integer pageNum = 1;

    @Range(min = 0, max = 100)
    private Integer pageSize = 5;

    public PageRequestDTO() {
    }

    public PageRequestDTO setPageSize(Integer pageSize) {
        if (pageSize < 1) {
            pageSize = 1;
        }
        this.pageSize = pageSize;
        return this;
    }

    public PageRequestDTO setPageNum(Integer pageNum) {
        if (pageNum < 0) {
            pageNum = 1;
        }
        this.pageNum = pageNum;
        return this;
    }

    public PageRequestDTO(Integer pageNum, Integer pageSize) {
        setPageNum(pageNum);
        setPageSize(pageSize);
    }

    @Override
    public boolean validate() {
        return false;
    }
}
