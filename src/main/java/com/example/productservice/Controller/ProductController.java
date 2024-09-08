package com.example.productservice.Controller;

import com.example.productservice.DTO.AddProductDTO;
import com.example.productservice.DTO.FindProductDto;
import com.example.productservice.DTO.ProductResponseDTO;
import com.example.productservice.Exception.ProductNotFound;
import com.example.productservice.Repository.ElectronicsRepository;
import com.example.productservice.Service.ProductService;
import com.example.productservice.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ProductController")
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/AddProduct")
    public void AddProduct(@RequestBody AddProductDTO productDTO) {
        productService.AddProduct(productDTO);
    }

    @PostMapping("/ListAll")
    public List<?> findAllProducts(String category) {
      return  productService.listAllProductsByCategory(category);
    }

    @PostMapping("/findByProductIDandCategory")
    public Object findProductById(@RequestBody int id,@RequestBody String category) {
        FindProductDto productDto = new FindProductDto();
        productDto.setId(id);
        productDto.setProductCategory(category);
       return productService.findById(productDto);
    }

    @PostMapping("/updateProduct")
    public Object updateProduct(@RequestBody AddProductDTO productDTO) throws ProductNotFound {
        return productService.updateProduct(productDTO);
    }
}
