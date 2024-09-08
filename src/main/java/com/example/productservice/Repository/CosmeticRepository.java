package com.example.productservice.Repository;


import com.example.productservice.Model.Cosmetics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CosmeticRepository extends JpaRepository<Cosmetics, Integer>{

    @Override
    Optional<Cosmetics> findById(Integer id);

    @Override
    List<Cosmetics> findAll();

    Cosmetics save(Cosmetics cosmetics);

    Cosmetics deleteById(int id);


}
