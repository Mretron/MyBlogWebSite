package com.zzj.blog.dao;

import com.zzj.blog.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long>,JpaSpecificationExecutor<Blog> {


    @Query("select  function('date_format',b.createTime,'%Y') as year from Blog b group by function('date_format',b.createTime,'%Y') order by year desc ")
    List<String> findGroupYear();

    @Query("select b from Blog b where function('date_format',b.createTime,'%Y') = ?1")
    List<Blog> findByYear(String year);

    @Query("select b from Blog b where ( (function('year',b.createTime) = ?1) and (function('month',b.createTime) = ?2)) order by b.createTime desc")
    List<Blog> findByYearAndMonth(Integer year,Integer month);

    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);



}
