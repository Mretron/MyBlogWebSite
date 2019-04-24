package com.zzj.blog.web;

import com.zzj.blog.pojo.BlogQuery;
import com.zzj.blog.pojo.Tag;
import com.zzj.blog.service.BlogService;
import com.zzj.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;


    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 8,sort={"updateTime"},direction = Sort.Direction.DESC)
                               Pageable pageable, @PathVariable Long id, Model model){

        List<Tag> tags = tagService.listTagTop(1000);
        if(id==-1){
            id = tags.get(0).getId();
        }

        model.addAttribute("tags",tags);
        model.addAttribute("page",blogService.listBlog(id,pageable));
        model.addAttribute("activeTagId",id);
        model.addAttribute("recommends",blogService.listRecommendBlogTop(3));
        return "tags";
    }


}
