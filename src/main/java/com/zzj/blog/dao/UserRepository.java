package com.zzj.blog.dao;

import com.zzj.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    User findUserByUsernameAndPassword(String username,String password);

}
