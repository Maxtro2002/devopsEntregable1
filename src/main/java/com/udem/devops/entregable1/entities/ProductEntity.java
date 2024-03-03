package com.udem.devops.entregable1.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "products")
public class ProductEntity {
    @Id
    private Long id;
    private String size;
    private String color;
    private String material;
    private String warranty;
    private String origin;
}
