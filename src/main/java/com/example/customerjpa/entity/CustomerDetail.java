package com.example.customerjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_detail")
public class CustomerDetail {

    @Id
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_age")
    private int age;

    @Column(name = "customer_address")
    private String address;

    public CustomerDetail(int age, String address) {
        this.age = age;
        this.address = address;
    }
}
