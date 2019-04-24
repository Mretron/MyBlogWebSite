package com.zzj.blog.web.admin;

import com.zzj.blog.pojo.Blog;
import com.zzj.blog.pojo.Bulletin;
import com.zzj.blog.service.BulletinService;
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
public class BulletinController {

    @Autowired
    private BulletinService bulletinService;


    @GetMapping("/bulletin")
    public String bulletin(Model model){
        model.addAttribute("bulletins" , bulletinService.listBulletin());
        return "admin/bulletin";
    }

    @PostMapping("/bulletin/{id}/input")
    public String bulletin(@PathVariable Long id, Bulletin bulletin, RedirectAttributes attributes){

        bulletin.setId(id);
        Bulletin bulletin1 = bulletinService.updateBulletin(bulletin);

        if(bulletin1!=null){
            attributes.addFlashAttribute("message","修改成功");
        }else{
            attributes.addFlashAttribute("message","修改失败");
        }

        return "redirect:/admin/bulletin";

    }

    @PostMapping("/bulletin/input")
    public String input(Bulletin bulletin,RedirectAttributes attributes){

        Bulletin bulletin1 = bulletinService.addBulletin(bulletin);
        if(bulletin1!=null){

            attributes.addFlashAttribute("message","增加成功");
        }else{
            attributes.addFlashAttribute("message","增加失败");
        }
        return "redirect:/admin/bulletin";

    }

    @GetMapping("/bulletin/input")
    public String input(Model model){

        model.addAttribute("bulletin",new Bulletin());
        return "admin/bulletin-input";
    }

    @GetMapping("/bulletin/{id}/input")
    public String editBulletin(@PathVariable Long id, Model model){

        model.addAttribute("bulletin",bulletinService.getBulletinById(id));

        return "admin/bulletin-input";


    }

    @GetMapping("/bulletin/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        bulletinService.deleteBulletin(id);

        attributes.addFlashAttribute("message","删除成功");

        return "redirect:/admin/bulletin";

    }


}
