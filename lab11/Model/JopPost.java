package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JopPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@NotEmpty(message = "title should not be null")
    //@Size(min = 4,message = "title must be more than 4 character")
    //@Column(columnDefinition = "varchar(10) not null ")
    private String title;
    //@NotEmpty(message = "description should not be null")
    //@Column(columnDefinition = "varchar(50) not null ")
    private String description;
    //@NotEmpty(message = "title should not be null")
    //@Column(columnDefinition = "varchar(10) not null ")
    private String location;
    //@NotNull(message = "salary should not be null")
    //@Positive
    //@Column(columnDefinition = "int not null ")
    private Integer salary;
    //@Column(columnDefinition = " date ")
    private LocalDate postingdate;
}
