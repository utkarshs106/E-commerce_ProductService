package com.example.productservice.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass

public class ProductBaseTable {
    @Id
    int Pid;
    Date CreatedAt;
    Date UpdatedAt;
    int Price;
    String ImageURL;
}