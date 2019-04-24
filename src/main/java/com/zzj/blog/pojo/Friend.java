package com.zzj.blog.pojo;

import javax.persistence.*;

@Entity
@Table(name="t_friend")
public class Friend {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    private String occupation;

    private String description;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String avatar;

    private String flag;//大佬，朋友，网站

    private String website;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Friend(String nickname, String occupation, String description, String avatar, String flag) {
        this.nickname = nickname;
        this.occupation = occupation;
        this.description = description;
        this.avatar = avatar;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", occupation='" + occupation + '\'' +
                ", description='" + description + '\'' +
                ", avatar='" + avatar + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }

    public Friend() {
    }
}
