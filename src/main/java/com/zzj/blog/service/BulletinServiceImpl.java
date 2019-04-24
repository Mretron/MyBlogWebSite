package com.zzj.blog.service;

import com.zzj.blog.dao.BulletinRepository;
import com.zzj.blog.pojo.Bulletin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BulletinServiceImpl implements BulletinService {

    @Autowired
    private BulletinRepository bulletinRepository;

    @Transactional
    @Override
    public List<Bulletin> listBulletin() {
        return bulletinRepository.findAll();
    }

    @Transactional
    @Override
    public Bulletin getBulletinById(Long id) {
        return bulletinRepository.getOne(id);
    }

    @Transactional
    @Override
    public Bulletin updateBulletin(Bulletin bulletin) {
        return bulletinRepository.save(bulletin);
    }

    @Transactional
    @Override
    public Bulletin addBulletin(Bulletin bulletin) {
        return bulletinRepository.save(bulletin);
    }
    @Transactional
    @Override
    public void deleteBulletin(Long id) {
        bulletinRepository.deleteById(id);
    }
}
