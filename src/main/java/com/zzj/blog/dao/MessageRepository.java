package com.zzj.blog.dao;

import com.zzj.blog.pojo.Message;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message,Long> {




}
