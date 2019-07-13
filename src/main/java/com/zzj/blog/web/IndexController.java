package com.zzj.blog.web;

import com.zzj.blog.pojo.IPAddress;
import com.zzj.blog.pojo.Message;
import com.zzj.blog.pojo.TransWord;
import com.zzj.blog.service.*;
import com.zzj.blog.util.LogIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;


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

    @Autowired
    private IPAddressService ipAddressService;



    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "0" , value = "page") Integer page, Model model, HttpServletRequest request){
        Pageable pageable1 = new PageRequest(page,8,Sort.Direction.DESC,"createTime");
        Pageable pageable2 = new PageRequest(0,4,Sort.Direction.DESC,"createTime");
        String IP = LogIP.getIpAddress(request);
        IPAddress ipAddress = LogIP.logIPtoDatabase(IP);
        if(ipAddressService.getOne(IP) ==null){
            ipAddress = ipAddressService.addOne(ipAddress);
        }else{
            ipAddress = ipAddressService.getOne(IP);
            ipAddress.setViewTime(new Date());
            ipAddress.setViews(ipAddress.getViews()+1);
            ipAddress = ipAddressService.updateOne(ipAddress);
        }
        List<IPAddress> ipAddresses = ipAddressService.getAll();
        int views = LogIP.viewsCount(ipAddresses);
        model.addAttribute("page",blogService.listBlog(pageable1));
        model.addAttribute("commentsPage",commentService.listCommentsPage(pageable2));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("typesCount",typeService.listType().size());
        model.addAttribute("tagsCount",tagService.listTag().size());
        model.addAttribute("commentsCount",commentService.listComment().size());
        model.addAttribute("bulletins",bulletinService.listBulletin());
        model.addAttribute("messages",messageService.listMessages());
        model.addAttribute("recommends",blogService.listRecommendBlogTop(3));
        model.addAttribute("visitorsCount",ipAddresses.size());
        model.addAttribute("numOfYou",ipAddresses.indexOf(ipAddress)+1);
        model.addAttribute("views",views);
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
