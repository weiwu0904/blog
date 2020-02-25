package com.weiwu.blog.mapper;

import com.weiwu.blog.domain.Tag;
import com.weiwu.blog.domain.Type;

import java.util.List;

public interface TagMapper {

    /**
     * 保存标签
     * @param type
     */
    int saveTag(Tag type);

    /**
     * 查询标签
     * @param id
     * @return
     */
    Tag getTagById(Long id);

    /**
     * 查询标签列表
     * @return
     */
    List<Tag> list();

    /**
     * 更新标签信息
     * @param tag
     */
    int updateTag(Tag tag);

    /**
     * 删除标签信息
     * @param id
     */
    int deleteTag(Long id);

    /**
     * 根据名称查询标签
     * @param name
     * @return
     */
    Tag getTagByName(String name);

    /**
     * 根据博客ID查询 标签
     * @param id
     * @return
     */
    List<Tag> getTagByBlogId(Long id);

    /**
     * 首页根据 博客标签的数量排序查询
     * @return
     */
    List<Tag> indexTagTopList();
}
