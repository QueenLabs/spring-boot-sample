package com.sample.api.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor // generate construct null
@AllArgsConstructor
public class Product {

    @Id
    @Transient
    private UUID id = UUID.randomUUID();

    @NotEmpty(message = "Product Empty")
    @Column(nullable = false,unique = false,length = 200)
    private String name;

    @NotEmpty(message = "Price Not null")
    @DecimalMin(value = "0.0",inclusive = false)
    private Float price;
}
