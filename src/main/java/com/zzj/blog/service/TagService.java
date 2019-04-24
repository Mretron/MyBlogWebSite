package com.zzj.blog.service;

import com.zzj.blog.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    Tag saveTag(Tag tag);

    void deleteTag(Long id);

    Tag updateTag(Long id,Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    //返回所有的tags
    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);

}
