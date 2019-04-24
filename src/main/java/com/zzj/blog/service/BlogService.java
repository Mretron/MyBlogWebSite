package com.zzj.blog.service;

import com.zzj.blog.pojo.Blog;
import com.zzj.blog.pojo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {


    Blog saveBlog(Blog blog);

    void deleteBlog(Long id);

    Blog updateBlog(Long id,Blog blog);

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Blog getAndConvert(Long id);//根据id得到这个博客并且转换成html格式

    Page<Blog> listBlog(Long tagId, Pageable pageable);

    Map<String,List<Blog>> archiveBlog();



    List<Blog> listRecommendBlogTop(Integer size);

}
