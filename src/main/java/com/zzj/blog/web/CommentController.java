package com.zzj.blog.web;

import com.zzj.blog.pojo.Comment;
import com.zzj.blog.pojo.User;
import com.zzj.blog.service.BlogService;
import com.zzj.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @GetMapping("/comments/commentsPage")
    public String commentToPage(@RequestParam(defaultValue = "0",value = "page") String commentsPage, Model model){
        int page =  Integer.parseInt(commentsPage);
        Pageable pageable = new PageRequest(page,4,Sort.Direction.DESC,"createTime");
        Page<Comment> pages = commentService.listCommentsPage(pageable);
        model.addAttribute("commentsPage",pages);
        return "index :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));

        User user = (User)session.getAttribute("user");
        if(user !=null){
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        }else{
            comment.setAvatar(avatar);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/"+blogId;
    }

}
