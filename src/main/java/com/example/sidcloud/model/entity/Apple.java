package com.example.sidcloud.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

//@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Apple implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long appleId;

    private String appleName;

    public Apple(String appleName){
        this.appleName= appleName;
    }
    public String getAppleName(){
        return this.appleName;
    }
    public void setAppleName(String appleName){
        this.appleName= appleName;
    }
}
