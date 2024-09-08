package com.example.productservice.Repository;



import com.example.productservice.Model.Cosmetics;
import com.example.productservice.Model.Electronics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectronicsRepository extends JpaRepository<Electronics, Integer>{

    @Override
    Optional<Electronics> findById(Integer id);

    @Override
    List<Electronics> findAll();

    Electronics save(Electronics cosmetics);


}
