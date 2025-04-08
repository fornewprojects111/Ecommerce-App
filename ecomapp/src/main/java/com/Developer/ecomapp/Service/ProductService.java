package com.Developer.ecomapp.Service;

import com.Developer.ecomapp.Model.Product;
import com.Developer.ecomapp.Repository_DAO.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts(){

        return repo.findAll();
    }


    public Product getProductById(int prodId) {

        return repo.findById(prodId).orElse(null);
    }

    public Product addProduct(Product product) {

        return repo.save(product);
    }

    public Product updateProductById(int id, Product product) {

        return repo.save(product);
    }

    public void deleteProductById(int id) {

        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {

        return  repo.searchProducts(keyword);
    }
}
