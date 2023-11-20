package com.example.web2011.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "teacher")
@NamedQueries({
        @NamedQuery(name = "Teacher.findAll", query = "select t from Teacher t"),
        @NamedQuery(name = "Teacher.findByExperienceGreaterThanEqual", query = "select t from Teacher t where t.experience >= :experience")
})
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "experience")
    private Integer experience;

    @ManyToMany(mappedBy = "teachers")
    private Set<Subject> subjects = new LinkedHashSet<>();


    public Teacher(Integer id, String name, Integer experience) {
        this.id = id;
        this.name = name;
        this.experience = experience;
    }
}