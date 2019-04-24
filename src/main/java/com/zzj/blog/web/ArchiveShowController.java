package com.zzj.blog.web;

import com.zzj.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;


    @GetMapping("/archives")
    public String archives(Pageable pageable, Model model){


        model.addAttribute("archiveMap",blogService.archiveBlog());
        model.addAttribute("recommends",blogService.listRecommendBlogTop(3));
        model.addAttribute("page",blogService.listBlog(pageable));
        return "archives";

    }

}
