package com.weiwu.blog.mapper;

import com.weiwu.blog.domain.BlogTag;
import com.weiwu.blog.domain.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogTagMapper {

    /**
     * 保存博客和tag的关系
     * @param blogId
     * @param tagIds
     * @return
     */
    int saveBlogTag(@Param("blogId") Long blogId, @Param("tagIds") String[] tagIds);

    /**
     * 删除标签的关系
     * @param id
     * @return
     */
    int deleteTagsByBlogId(Long id);
}
