package com.zzj.blog.service;

import com.zzj.blog.dao.FriendRepositry;
import com.zzj.blog.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepositry friendRepositry;

    @Override
    public Friend saveFriend(Friend friend) {
        return friendRepositry.save(friend);
    }

    @Override
    public void deleteFriend(Long id) {
        friendRepositry.deleteById(id);
    }

    @Override
    public Friend updateFriend(Long id, Friend friend) {
        return friendRepositry.save(friend);
    }

    @Override
    public Friend getFriend(Long id) {
        return friendRepositry.getOne(id);
    }

    @Override
    public List<Friend> listFriends() {
        return friendRepositry.findAll();
    }
}
