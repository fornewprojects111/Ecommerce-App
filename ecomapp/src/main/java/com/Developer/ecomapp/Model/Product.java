package com.Developer.ecomapp.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.math.BigDecimal;
import java.util.Date;
@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
public class Product {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private Boolean available;
   private String brand;
   private String category;
   private String desc;
   private String name;
   private BigDecimal price;
   private Integer quantity;
    private Date releaseDate;

//    private String imgName;
//    private String imgType;
//
//    @Lob
//    private byte[] imgData;

    public Product() {
    }

//    public Product(int id, String name, String desc, String brand, BigDecimal price, String category, Date releaseDate, int quantity, Boolean available, String imgName, String imgType, byte[] imgData) {
//        this.id = id;
//        this.name = name;
//        this.desc = desc;
//        this.brand = brand;
//        this.price = price;
//        this.category = category;
//        this.releaseDate = releaseDate;
//        this.quantity = quantity;
//        this.available = available;
//        this.imgName = imgName;
//        this.imgType = imgType;
//        this.imgData = imgData;
//    }

//    public Product(int id, Boolean available, String brand, String category, String desc, String name, BigDecimal price, Integer quantity, Date releaseDate) {
//        this.id = id;
//        this.available = available;
//        this.brand = brand;
//        this.category = category;
//        this.desc = desc;
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//        this.releaseDate = releaseDate;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
//    public String getImgName() {
//        return imgName;
//    }
//
//    public void setImgName(String imgName) {
//        this.imgName = imgName;
//    }
//
//    public String getImgType() {
//        return imgType;
//    }
//
//    public void setImgType(String imgType) {
//        this.imgType = imgType;
//    }
//
//    public byte[] getImgData() {
//        return imgData;
//    }
//
//    public void setImgData(byte[] imgData) {
//        this.imgData = imgData;
//    }
}
