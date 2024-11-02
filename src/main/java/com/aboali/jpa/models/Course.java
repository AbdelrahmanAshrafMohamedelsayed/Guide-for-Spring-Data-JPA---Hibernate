package com.aboali.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Course extends BaseEntity {

    private String courseName;
    private String courseDescription;

//    the many to many relationship between course and author
//    this is the owning side
    @ManyToMany
    @JoinTable(
            name = "courses_authors",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors;

//    the one to many relationship between course and section
    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
