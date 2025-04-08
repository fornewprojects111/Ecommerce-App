package com.Developer.ecomapp.Controller;

import com.Developer.ecomapp.Model.Product;

import com.Developer.ecomapp.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String greet(){
        return "Hello";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getALLProducts(){

      return  new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<Product> getProduct(@PathVariable int prodId){

        Product product = productService.getProductById(prodId);

        if(product!=null){
        return new ResponseEntity<>(productService.getProductById(prodId),HttpStatus.OK);}
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/products")
//    public ResponseEntity<?>  addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
//
//
//        try {
//            Product product1 = productService.addProduct(product, imageFile);
//
//            return new ResponseEntity<>(product1,HttpStatus.CREATED);
//        }
//        catch (Exception e){
//
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product){

        Product product1 = productService.addProduct(product);
      if(product1 != null) {
          return new ResponseEntity<>(product1, HttpStatus.CREATED);
      }
      else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

    }

//    @GetMapping("/product/{productId}/image")
//    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
//
//        Product product = productService.getProductById(productId);
//        byte[] imageFile = product.getImgData();
//
//        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImgType())).body(imageFile);
//    }

//    @PutMapping("/products/{id}")
//    public ResponseEntity<String> updateProduct(@PathVariable int id ,@RequestPart Product product, @RequestPart MultipartFile imageFile){
//
//
//        Product product1 = null;
//        try {
//            product1 = productService.updateProduct(id,product,imageFile);
//        } catch (IOException e) {
//            return new ResponseEntity<>("Failed to Update",HttpStatus.BAD_REQUEST);
//        }
//
//        if (product1 !=null){
//            return new ResponseEntity<>("updated",HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Failed to Update",HttpStatus.BAD_REQUEST);
//        }
//    }


    @PutMapping("products/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable int id,@RequestBody Product product){

        Product product1 = productService.updateProductById(id,product);

        if (product1 != null){
            return new ResponseEntity<>("Updated SuccesFully",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Updation Failed",HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){

        Product product =  productService.getProductById(id);

        if(product != null){

            productService.deleteProductById(id);

            return new ResponseEntity<>("Deleted",HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>("Product not Found",HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){

        List<Product> products = productService.searchProducts(keyword);

        return new ResponseEntity<>(products,HttpStatus.OK);

    }
}
