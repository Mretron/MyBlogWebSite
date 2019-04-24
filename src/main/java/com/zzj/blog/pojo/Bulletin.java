package com.zzj.blog.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_bulletin")
public class Bulletin {

    @Id
    @GeneratedValue
    private Long id;

    private String harvest ;

    private String uncompleted;


    public String getHarvest() {
        return harvest;
    }

    public void setHarvest(String harvest) {
        this.harvest = harvest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUncompleted() {
        return uncompleted;
    }

    public void setUncompleted(String uncompleted) {
        this.uncompleted = uncompleted;
    }


    public Bulletin(String harvest, String uncompleted) {
        this.harvest = harvest;
        this.uncompleted = uncompleted;
    }

    @Override
    public String toString() {
        return "Bulletin{" +
                "id=" + id +
                ", harvest='" + harvest + '\'' +
                ", uncompleted='" + uncompleted + '\'' +
                '}';
    }

    public Bulletin() {
    }
}
