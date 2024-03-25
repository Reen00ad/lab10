package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Userr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be null")
    @Size(min = 4,message = "name must be more than 4 character")
    @Pattern(regexp = "^[A-Za-z]+$",message = "name must only character")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String name;
    @Email
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
    @NotEmpty(message = "password cannot be empty")
    @Column(columnDefinition = "varchar(10) not null ")
    private String password;
    @NotNull(message = "age should not be null")
    //@Pattern(regexp = "^[0-9]+$",message = "age must be a number")
    @Min(value = 21,message = "age must be greater than 21")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty(message = "role should not be null")
    @Pattern(regexp ="^(JopSeeker|Admin)$", message = "role must be Admin or jopseeker only")
    @Column(columnDefinition = "varchar(10) not null check ( role='JopSeeker' or role='Admin')")
    private String role;
}
