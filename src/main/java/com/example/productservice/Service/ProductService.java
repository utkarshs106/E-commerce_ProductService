package com.example.productservice.Service;

import com.example.productservice.DTO.AddProductDTO;
import com.example.productservice.DTO.FindProductDto;
import com.example.productservice.Exception.ProductNotFound;
import com.example.productservice.Model.Cosmetics;
import com.example.productservice.Model.Electronics;
import com.example.productservice.Model.ProductBaseTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.productservice.Repository.*;
import com.example.productservice.Exception.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    CosmeticRepository cosmeticRepository;
    @Autowired
    ElectronicsRepository electronicsRepository;


    public List<?> listAllProductsByCategory(String category) {
        List<?> products = new ArrayList<>();

        switch (category.toLowerCase()) {
            case "cosmetics":
                products =  cosmeticRepository.findAll();
                break;

            case "electronics":
                products =  electronicsRepository.findAll();
                break;


            default:
                throw new IllegalArgumentException("Unknown product category: " + category);
        }

        return products;
    }

    public Object updateProduct(AddProductDTO productDTO) throws ProductNotFound{
        Object ProductData = null;
        switch (productDTO.getProducType()){
            case "Cosmetics":
                Cosmetics cosmetics = (Cosmetics) productDTO.getProductData();
                Optional<Cosmetics> fromDb = cosmeticRepository.findById(cosmetics.getPid());
                if(fromDb.isEmpty()){
                    throw new ProductNotFound("The object is not present");
                }
                cosmeticRepository.deleteById(cosmetics.getPid());
                ProductData = cosmeticRepository.save(cosmetics);

            case "Electronics":
                Electronics electronics = (Electronics) productDTO.getProductData();
                Optional<Electronics> fromDB = electronicsRepository.findById(electronics.getPid());
                if(fromDB.isEmpty()){
                    throw new ProductNotFound("The object is not present");
                }
                electronics.setPid(fromDB.get().getPid());
                ProductData = electronicsRepository.save(electronics);
        }
        return ProductData;
    }
   public Object findById(FindProductDto findProductDto){
        Object ProductData = null;
        switch (findProductDto.getProductCategory()){
            case "Cosmetics":
                ProductData = cosmeticRepository.findById(findProductDto.getId());
            case "Electronics":
                ProductData = electronicsRepository.findById(findProductDto.getId());
        }
        return ProductData;
    }

    //void deleteProduct(){}

   public Object AddProduct(AddProductDTO productDTO){
        Object ProductData = null;
        switch (productDTO.getProducType()){
            case "Cosmetics":
                Cosmetics cosmetics = (Cosmetics) productDTO.getProductData();
                ProductData = cosmeticRepository.save(cosmetics);
            case "Electronics":
                Electronics electronics = (Electronics) productDTO.getProductData();
                ProductData = electronicsRepository.save(electronics);
        }
        return ProductData;
    }

}
