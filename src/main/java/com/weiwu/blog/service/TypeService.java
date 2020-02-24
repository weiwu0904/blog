package com.weiwu.blog.service;

import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Type;
import com.weiwu.blog.exception.ServiceException;

public interface TypeService {

    /**
     * 新增分类
     * @param type
     * @return
     */
    Type saveType(Type type) throws ServiceException;

    /**
     *
     * @param id
     * @return
     */
    Type getById(Long id);

    /**
     * 分页查询
     * @return
     */
    PageInfo<Type> list(int page, int pageNum);


    /**
     * 更新分类信息
     * @param type
     * @return
     */
    Type updateType(Type type);

    /**
     * 删除分类
     */
    void deleteType(Long id);
}
