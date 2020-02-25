package com.weiwu.blog.mapper;

import com.weiwu.blog.domain.Type;
import com.weiwu.blog.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeMapper {

    /**
     * 保存分类
     * @param type
     */
    int saveType(Type type);

    /**
     * 查询分类
     * @param id
     * @return
     */
    Type getById(Long id);

    /**
     * 查询分类列表
     * @return
     */
    List<Type> list();

    /**
     * 更新分类信息
     * @param type
     */
    int updateType(Type type);

    /**
     * 删除分类信息
     * @param id
     */
    int deleteType(Long id);

    /**
     * 根据名称查询分类
     * @param name
     * @return
     */
    Type getTypeByName(String name);


    /**
     * 首页展示的分类排行（根据博客属于这个分类的数量）
     * @return
     */
    List<Type> indexTypeTopList();
}
