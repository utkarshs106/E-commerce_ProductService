package com.example.productservice.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProductBaseTable {
    @Id
    int Pid;
    Date CreatedAt;
    Date UpdatedAt;
    int Price;
}