package com.example.productservice.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class CosmeticsTable extends ProductBaseTable{
    @Id
    int Pid;
    String BodyPart;
    int TargetAge;
    String Gender;
    String Brand;
}
