package com.aboali.jpa.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Lecture extends BaseEntity {

    private String lectureName;

    //    the many to one relationship between lecture and section
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    // one to one relationship between lecture and resource
    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
