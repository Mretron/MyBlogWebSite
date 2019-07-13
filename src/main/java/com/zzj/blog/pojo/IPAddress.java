package com.zzj.blog.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_IP")
public class IPAddress {

    @Id
    @GeneratedValue
    private Long id;

    private String thisIP;

    private String address;

    private int views;

    @Temporal(TemporalType.TIMESTAMP)
    private Date viewTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThisIP() {
        return thisIP;
    }

    public void setThisIP(String thisIP) {
        this.thisIP = thisIP;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Date getViewTime() {
        return viewTime;
    }

    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }


    public IPAddress(String thisIP, String address, int views, Date viewTime) {
        this.thisIP = thisIP;
        this.address = address;
        this.views = views;
        this.viewTime = viewTime;
    }

    public IPAddress() {
    }
}
