package com.zzj.blog.service;

import com.zzj.blog.dao.UserRepository;
import com.zzj.blog.pojo.User;
import com.zzj.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User checkUser(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username,MD5Utils.code(password));
    }
}
