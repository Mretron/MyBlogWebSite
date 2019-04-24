package com.zzj.blog.service;

import com.zzj.blog.NotFoundException;
import com.zzj.blog.dao.TagRepository;
import com.zzj.blog.pojo.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {


    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {

        Tag t = tagRepository.getOne(id);
        if(t==null){
            throw new NotFoundException("该标签不存在");
        }

        BeanUtils.copyProperties(tag,t);
        return tagRepository.save(t);

    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.getOne(id);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag getTagByName(String name) {
        return tagRepository.getTagByName(name);
    }

    @Transactional
    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Transactional
    @Override
    public List<Tag> listTag(String ids) {

        List<Tag> list = new ArrayList<>();

        if(!"".equals(ids)&&ids!=null){
            String[] idarray = ids.split(",");
            for(int i=0;i<idarray.length;i++){
                Long tempId = Long.parseLong(idarray[i]);
                list.add(tagRepository.getOne(tempId));
            }
        }

        return list;
    }

    @Transactional
    @Override
    public List<Tag> listTagTop(Integer size) {

        Sort sort = new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = new PageRequest(0,size,sort);


        return tagRepository.findTop(pageable);
    }
}
