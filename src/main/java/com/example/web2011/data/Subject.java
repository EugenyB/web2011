package com.example.web2011.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "subject")
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "length")
    private Integer length;

    public Subject(Integer id, String title, Integer length) {
        this.id = id;
        this.title = title;
        this.length = length;
    }

    @ManyToMany
    @JoinTable(name = "subject_teachers",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "teachers_id"))
    private Set<Teacher> teachers = new LinkedHashSet<>();

}