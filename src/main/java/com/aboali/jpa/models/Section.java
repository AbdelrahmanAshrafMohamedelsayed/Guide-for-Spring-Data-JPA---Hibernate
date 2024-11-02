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
public class Section extends BaseEntity {

    private String sectionName;
    private int sectionOrder;
    //    the many to one relationship between section and course
    //    this is the owning side
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    //        the one to many relationship between section and lecture
    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;
}
