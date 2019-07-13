package com.zzj.blog.service;

import com.zzj.blog.dao.IPAddressRepository;
import com.zzj.blog.pojo.IPAddress;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IPAddressServiceImpl implements IPAddressService {

    @Autowired
    private IPAddressRepository ipAddressRepository;

    @Transactional
    @Override
    public IPAddress getOne(String thisIP) {
        return ipAddressRepository.getIPAddressByThisIP(thisIP);
    }

    @Transactional
    @Override
    public IPAddress addOne(IPAddress ipAddress) {
        return ipAddressRepository.save(ipAddress);
    }

    @Transactional
    @Override
    public List<IPAddress> getAll() {
        return ipAddressRepository.findAll();
    }

    @Transactional
    @Override
    public IPAddress updateOne(IPAddress ipAddress) {
        IPAddress ipAddress1 = ipAddressRepository.getIPAddressByThisIP(ipAddress.getThisIP());
        BeanUtils.copyProperties(ipAddress,ipAddress1);
        System.out.println("ipAddress:"+ipAddress);
        System.out.println("ipAddress1"+ipAddress1);
        return ipAddressRepository.save(ipAddress1);

    }
}
