package com.zzj.blog.web;

import com.zzj.blog.pojo.Message;
import com.zzj.blog.pojo.TransWord;
import com.zzj.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;


@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private BulletinService bulletinService;

    @Autowired
    private MessageService messageService;



    @GetMapping("/")
    public String index(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC)
                        Pageable pageable, Model model){

        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("typesCount",typeService.listType().size());
        model.addAttribute("tagsCount",tagService.listTag().size());
         //这里是评论总数model.addAttribute("commentsCount",commentService.listComment().size());
        model.addAttribute("bulletins",bulletinService.listBulletin());
        model.addAttribute("messages",messageService.listMessages());
        model.addAttribute("recommends",blogService.listRecommendBlogTop(3));
        return "index";
    }

    @PostMapping("/messages")
    public String message(Message message, RedirectAttributes attributes){
        System.out.println("sdasda");
        message.setCreateTime(new Date());
        Message message1 = messageService.saveMessage(message);
        if(message1!=null){
            attributes.addFlashAttribute("message","谢谢你的声音，已成功提交，等待博主听到。");
        }else{
            attributes.addFlashAttribute("message","发生错误，博主未能听到，请稍后重试.");
        }
        return "redirect:/";

    }

    @GetMapping("/blog")
    public String blog(){

        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){

        model.addAttribute("blog",blogService.getAndConvert(id));
        TransWord transWord = new TransWord();
        transWord.setWord("");
        transWord.setResult("");
        model.addAttribute("transWord",transWord);
        return "blog";
    }



}
