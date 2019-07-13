package com.zzj.blog.dao;

import com.zzj.blog.pojo.IPAddress;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IPAddressRepository extends JpaRepository<IPAddress,Long> {

    IPAddress getIPAddressByThisIP(String thisIP);


}
