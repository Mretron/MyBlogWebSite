package com.zzj.blog.service;

import com.zzj.blog.pojo.Friend;

import java.util.List;

public interface FriendService {

    Friend saveFriend(Friend friend);
    void deleteFriend(Long id);
    Friend updateFriend(Long id,Friend friend);
    Friend getFriend(Long id);

    List<Friend> listFriends();

}
