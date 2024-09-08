package com.example.productservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Electronics extends ProductBaseTable{
    @Id
    int Pid;
    String ModelNo;
    String Memory;
    String Brand;
}

