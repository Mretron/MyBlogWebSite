package com.zzj.blog.web;

import com.zzj.blog.pojo.Blog;
import com.zzj.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;



    @GetMapping("/archives")
    public String archivesByYearAndMonth(Model model){
        Calendar calendar = Calendar.getInstance();
        Integer year = calendar.get(Calendar.YEAR);
        Map<String,List<Blog>> map_value = blogService.archiveBlogByYear(year);
        Map<String,List<Blog>> map = new HashMap<>();
        for(int i=1;i<=12;i++){
            List<Blog> blogs = map_value.get(i+"");
            map.put(i+"月",blogs);
            if(i==6){
                model.addAttribute("archiveMap1",map);
                map = new HashMap<>();
            }else if(i==12){
                model.addAttribute("archiveMap2",map);
            }
        }
        model.addAttribute("recommends",blogService.listRecommendBlogTop(3));
        return "archives";

    }


}
