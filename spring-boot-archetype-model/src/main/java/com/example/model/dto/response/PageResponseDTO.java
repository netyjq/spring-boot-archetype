package com.example.model.dto.response;

import com.example.model.dto.request.PageRequestDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * PageResponseDTO 封装
 * @date 2017/6/6.
 * @author netyjq@gmail.com
 */
@Data
public class PageResponseDTO<T> implements Serializable {

    /**
     * 数据集合
     */
    private List<T> content;

    /**
     * 数据库几记录总数
     */
    private Integer total = 0;

    /**
     * 页码
     */
    private Integer pageNo = 1;

    /**
     * 每页数据大小
     */
    private Integer pageSize = 1;

    /**
     * 总页数
     */
    private Integer totalPage = 1;

    public PageResponseDTO empty(PageRequestDTO baseDTO) {
        this.setPageSize(baseDTO.getPageSize());
        this.setPageNo(baseDTO.getPageNum());
        this.setTotal(0);
        this.setTotalPage(0);
        this.setContent(new ArrayList<T>());
        return this;
    }

    public PageResponseDTO(List content, Integer total, int pageNo, int pageSize) {
        this.content = content;
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = getTotalPage();
    }

    public PageResponseDTO(List content, Integer total, PageRequestDTO baseDTO) {
        this.content = content;
        this.total = total;
        this.pageNo = baseDTO.getPageNum();
        this.pageSize = baseDTO.getPageSize();
    }

    public List<T> getContent() {
        if(this.content == null){
            this.content = new ArrayList<T>();
        }
        return content;
    }

    public PageResponseDTO setContent(List<T> content) {
        this.content = content;
        return this;
    }


    public PageResponseDTO setTotal(Integer total) {
        this.total = total;
        return this;
    }


    public PageResponseDTO setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }


    public PageResponseDTO setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getTotalPage() {
        if (this.total == 0 || this.total < pageSize) {
            this.totalPage = 1;
        } else {
            this.totalPage = this.total % pageSize == 0 ? this.total / this.pageSize : (this.total / this.pageSize) + 1;
        }
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageResponseDTO{" +
                "content=" + content +
                ", total=" + total +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                '}';
    }
}
