package com.zzj.blog.service;

import com.zzj.blog.NotFoundException;
import com.zzj.blog.dao.TypeRepository;
import com.zzj.blog.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {

        Type t = typeRepository.getOne(id);  //这里其实可以拿到这个id
        if(t==null){
            throw new NotFoundException("不存在该类型");
        }

        BeanUtils.copyProperties(type,t);  //将type的不为null的信息复制给t


        return typeRepository.save(t);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.getOne(id);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {

        return typeRepository.findAll(pageable);

    }
    @Transactional
    @Override
    public Type getTypeByName(String name) {
        return typeRepository.getTypeByName(name);
    }

    @Transactional
    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }


    @Transactional
    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC,"blogs.size");//排序规则
        Pageable pageable = new PageRequest(0,size,sort);
        return typeRepository.findTop(pageable);
    }
}
