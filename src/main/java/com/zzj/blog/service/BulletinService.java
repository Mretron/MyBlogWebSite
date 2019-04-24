package com.zzj.blog.service;

import com.zzj.blog.pojo.Bulletin;

import java.util.List;

public interface BulletinService {


    List<Bulletin> listBulletin();

    Bulletin getBulletinById(Long id);


    Bulletin updateBulletin(Bulletin bulletin);

    Bulletin addBulletin(Bulletin bulletin);

    void deleteBulletin(Long id);
}
