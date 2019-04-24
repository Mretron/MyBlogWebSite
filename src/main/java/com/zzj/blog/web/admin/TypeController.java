package com.zzj.blog.web.admin;

import com.zzj.blog.pojo.Type;
import com.zzj.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 3,sort = {"id"},direction = Sort.Direction.DESC)
                        Pageable pageable, Model model){

        model.addAttribute("page",typeService.listType(pageable));

        return "admin/types";

    }

    @GetMapping("/types/input")
    public String input(Model model){

        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String post(Type type, RedirectAttributes attributes){

        Type type1 = typeService.getTypeByName(type.getName());

        if(type1!=null){
            attributes.addFlashAttribute("message","错误:已存在同名的分类");
        }else{

            typeService.saveType(type);
            attributes.addFlashAttribute("message","添加成功.");
        }

        return "redirect:/admin/types";
    }

    //编辑
    @GetMapping("/types/{id}/input")
    public String input(@PathVariable Long id,Model model){

        model.addAttribute("type",typeService.getType(id));

        return "admin/types-input";
    }

    @PostMapping("/types/{id}")
    public String editPost(Type type, RedirectAttributes attributes){

        Type type1 = typeService.getTypeByName(type.getName());

        if(type1!=null){
            attributes.addFlashAttribute("message","错误:已存在同名的分类");
        }else {
            typeService.updateType(type.getId(),type);
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";


    }

    //删除分类
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }

}
