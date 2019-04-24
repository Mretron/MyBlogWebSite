package com.zzj.blog.service;

import com.zzj.blog.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    Type  saveType(Type type);

    void deleteType(Long id);

    Type updateType(Long id,Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> listType(Pageable pageable); //这个就是分页查询

    List<Type> listType();

    List<Type> listTypeTop(Integer size);//这个是首页显示的那几条

}
