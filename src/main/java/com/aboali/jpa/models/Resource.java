package com.aboali.jpa.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Resource {
    @Id
    @GeneratedValue
    private Integer id;
    private String resourceName;
    private String resourceSize;
    private String resourceUrl;

    // one to one relationship between lecture and resource
//    @OneToOne
//   // @JoinColumn(name = "lecture_id")
//    private Lecture lecture;
}
