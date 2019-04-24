package com.zzj.blog.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_message")
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


    public Message() {
    }

    public Message(String nickname, String content, Date createTime, boolean isPublished) {
        this.nickname = nickname;
        this.content = content;
        this.createTime = createTime;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }





    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
