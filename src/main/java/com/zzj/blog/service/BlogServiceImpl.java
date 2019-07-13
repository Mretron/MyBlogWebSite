package com.zzj.blog.service;

import com.zzj.blog.NotFoundException;
import com.zzj.blog.dao.BlogRepository;
import com.zzj.blog.pojo.Blog;
import com.zzj.blog.pojo.BlogQuery;
import com.zzj.blog.pojo.Type;
import com.zzj.blog.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        if(blog.getId()==null){
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        }else{
            blog.setUpdateTime(new Date());
            blog.setViews(blogRepository.getOne(blog.getId()).getViews());
            blog.setCreateTime(blogRepository.getOne(blog.getId()).getCreateTime());
        }

        return blogRepository.save(blog);
    }
    @Transactional
    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
    @Transactional
    @Override
    public Blog updateBlog(Long id, Blog blog) {

        Blog b = blogRepository.getOne(id);

        if(b==null){
            throw new NotFoundException("这篇博客不存在!");
        }

        BeanUtils.copyProperties(blog,b);

        return blogRepository.save(b);
    }
    @Transactional
    @Override
    public Blog getBlog(Long id) {
        return blogRepository.getOne(id);
    }

    @Transactional
    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();

                if(!"".equals(blog.getTitle())&&blog.getTitle()!=null){

                    predicates.add(criteriaBuilder.like(root.<String>get("title"),"%"+blog.getTitle()+"%"));
                }
                if(blog.getTypeId()!=null){

                    predicates.add(criteriaBuilder.equal(root.<Type>get("type").get("id"),blog.getTypeId()));

                }

                if(blog.isRecommend()){

                    predicates.add(criteriaBuilder.equal(root.<Boolean>get("recommend"),blog.isRecommend()));

                }

                query.where(predicates.toArray(new Predicate[predicates.size()]));

                return null;
            }
        },pageable);

    }

    @Transactional
    @Override
    public Page<Blog> listBlog(Pageable pageable) {

        return blogRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogRepository.getOne(id);
        blog.setViews(blog.getViews()+1);
        blog.setCreateTime(blog.getCreateTime());
        blogRepository.save(blog);
        if(blog==null){
            throw new NotFoundException("该博客不存在");
        }
        Blog b = new Blog();
        BeanUtils.copyProperties(blog,b);
        String content = b.getContent();
        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return b;
    }

    @Transactional
    @Override
    public Page<Blog> listBlog(Long tagId, Pageable pageable) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Join join = root.join("tags");
                return cb.equal(join.get("id"),tagId);
            }
        },pageable);
    }

    @Transactional
    @Override
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogRepository.findGroupYear();
        Map<String,List<Blog>> map = new HashMap<>();
        for(String year : years){
            map.put(year,blogRepository.findByYear(year));
        }
        return map;
    }

    public Map<String,List<Blog>> archiveBlogByYear(Integer year){

        List<Blog> blogs = archiveBlog().get(year);//根据年得到的所有博客
        Map<String,List<Blog>> map = new HashMap<>();

        for(int i=1;i<=12;i++){

            map.put(i+"",blogRepository.findByYearAndMonth(year,i));
        }
        return map;
    }


    @Transactional
    @Override
    public List<Blog> listRecommendBlogTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC,"updateTime");
        Pageable pageable = new PageRequest(0, size, sort);
        return blogRepository.findTop(pageable);
    }

}
