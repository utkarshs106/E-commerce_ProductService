package com.example.productservice.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Cosmetics extends ProductBaseTable{
    @Id
    int Pid;
    String BodyPart;
    int TargetAge;
    String Gender;
    String Brand;

  /* public Cosmetics(int Pid, String BodyPart, int TargetAge, String Gender, String Brand){
        this.Pid = Pid;
        this.BodyPart = BodyPart;
        this.TargetAge = TargetAge;
        this.Gender = Gender;
        this.Brand = Brand;
    }
    */
}
