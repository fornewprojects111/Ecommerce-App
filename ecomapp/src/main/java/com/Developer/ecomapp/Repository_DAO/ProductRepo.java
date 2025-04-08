package com.Developer.ecomapp.Repository_DAO;

import com.Developer.ecomapp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>
{


    @Query("SELECT p FROM Product p \n" +
            "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) \n" +
            "   OR LOWER(p.desc) LIKE LOWER(CONCAT('%', :keyword, '%')) \n" +
            "   OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) \n" +
            "   OR LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))\n")
    List<Product> searchProducts(@Param("keyword") String keyword);


}
