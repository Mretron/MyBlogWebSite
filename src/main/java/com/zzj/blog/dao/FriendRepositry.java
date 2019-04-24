package com.zzj.blog.dao;

import com.zzj.blog.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepositry extends JpaRepository<Friend,Long> {
}
