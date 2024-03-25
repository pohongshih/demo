package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Map<String,Object> create(Product p){
        productRepository.save(p);
        Map<String,Object> map = new HashMap<>();
        map.put("product",p);
        map.put("status",true);
        map.put("message","新增成功!");
        return map;
    }

    public Map<String,Object> delete(Long pid){
        productRepository.deleteById(pid);
        Map<String,Object> map = new HashMap<>();
        map.put("status",true);
        map.put("message","刪除成功!");
        return map;
    }

    public Map<String,Object> myProduct(Long id){
        List<Product> lst = productRepository.findByMemberId(id);
        Map<String,Object> map = new HashMap<>();
        map.put("product",lst);
        map.put("status",true);
        map.put("message","查詢成功!");
        return map;
    }

    public Map<String,Object> AllProduct(){
        List<Product> lst = productRepository.findAll();
        Map<String,Object> map = new HashMap<>();
        map.put("product",lst);
        map.put("status",true);
        map.put("message","查詢成功!");
        return map;
    }

}
