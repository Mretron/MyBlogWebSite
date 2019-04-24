package com.zzj.blog.web;

import com.zzj.blog.service.BlogService;
import com.zzj.blog.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FriendsShowController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private FriendService friendService;

    @GetMapping("/friends")
    public String friends(Model model){

        model.addAttribute("friends",friendService.listFriends());
        model.addAttribute("recommends",blogService.listRecommendBlogTop(3));
        return "friends";

    }

}
