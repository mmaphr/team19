package com.example.demo.entity;

import javax.persistence.*;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class CategoryActivity {
    @Id
    @SequenceGenerator(name="categoryActivity_seq",sequenceName="categoryActivity_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="categoryActivity_seq")
    @Column(name="category_id",unique = true)

    private @NonNull Long category_id;
    private @NonNull String namecategory;

    public CategoryActivity(){}

    public CategoryActivity(String namecategory) {
        this.namecategory = namecategory;
    }
//    public void setNamecategory (String namecategiry){this.namecategory=namecategory;}
//    public  String getNamecategory(){return namecategory;}
}
