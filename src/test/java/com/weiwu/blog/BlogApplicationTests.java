package com.weiwu.blog;

import com.weiwu.blog.mapper.BlogTagMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BlogApplicationTests.class})
@MapperScan("com.weiwu.blog.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class BlogApplicationTests {


    @Resource
    private BlogTagMapper blogTagMapper;

    @Test
    public void testmapper() {
        blogTagMapper.saveBlogTag(1L, new String[]{"2","3","4"});
    }
}