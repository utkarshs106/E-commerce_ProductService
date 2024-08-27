package com.example.productservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Stationary extends ProductBaseTable{
    @Id
    int Pid;
    String Title;
    String Author;
    String Genre;
    int NoOfPages;
}
