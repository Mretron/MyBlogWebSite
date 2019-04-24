package com.zzj.blog.web.admin;

import com.zzj.blog.pojo.Friend;
import com.zzj.blog.service.BlogService;
import com.zzj.blog.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class FriendsController {



    @Autowired
    private FriendService friendService;

    @GetMapping("/friends")
    public String friends(Model model){

        model.addAttribute("friends",friendService.listFriends());
        return "admin/friends";

    }


    @PostMapping("/friends/{id}/input")
    public String friend(@PathVariable Long id, Friend friend, RedirectAttributes attributes){

        friend.setId(id);
        Friend friend1 = friendService.updateFriend(id,friend);

        if(friend1!=null){
            attributes.addFlashAttribute("message","修改成功");
        }else{
            attributes.addFlashAttribute("message","修改失败");
        }

        return "redirect:/admin/friends";

    }

    @PostMapping("/friends/input")
    public String input(Friend friend,RedirectAttributes attributes){

        Friend friend1 = friendService.saveFriend(friend);

        if(friend1!=null){

            attributes.addFlashAttribute("message","增加成功");
        }else{
            attributes.addFlashAttribute("message","增加失败");
        }
        return "redirect:/admin/friends";

    }

    @GetMapping("/friends/input/{flag}")
    public String input(@PathVariable String flag, Model model){
        Friend friend = new Friend();
        if(flag.equals("朋友")){
            friend.setFlag("朋友");
            friend.setAvatar("请添加");
            friend.setOccupation("请添加");
        }else{
            friend.setFlag(flag);
        }
        model.addAttribute("friend",friend);
        return "admin/friends-input";
    }

    @GetMapping("/friends/{id}/input")
    public String editBulletin(@PathVariable Long id, Model model){

        model.addAttribute("friend",friendService.getFriend(id));

        return "admin/friends-input";


    }

    @GetMapping("/friends/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        friendService.deleteFriend(id);

        attributes.addFlashAttribute("message","删除成功");

        return "redirect:/admin/friends";

    }



}
