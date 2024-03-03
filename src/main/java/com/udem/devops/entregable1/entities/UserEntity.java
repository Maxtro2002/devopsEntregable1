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
@Document(collection = "users")
public class UserEntity {
    @Id
    private Long id;
    private String email;
    private String password;
    private String name;
    private String phone;
}
