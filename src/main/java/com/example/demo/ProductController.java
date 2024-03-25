package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Map<String,Object> create(@RequestBody Product p){
        return productService.create(p);
    }

    @PostMapping("/product/{pid}")
    public Map<String,Object> delete(@PathVariable Long pid){
        return productService.delete(pid);
    }


    @GetMapping("/product")
    public Map<String,Object> myproduct(@RequestParam("mid") Long mid){
        return productService.myProduct(mid);
    }

    @GetMapping("/product/all")
    public Map<String,Object> AllProduct(){
        return  productService.AllProduct();
    }
}
