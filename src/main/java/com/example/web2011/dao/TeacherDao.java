package com.example.web2011.dao;

import com.example.web2011.data.Teacher;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class TeacherDao {
    @PersistenceContext
    EntityManager em;

    public List<Teacher> findAll() {
        return em.createNamedQuery("Teacher.findAll", Teacher.class).getResultList();
    }

    public void add(Teacher teacher) {
        em.persist(teacher);
    }

    public void delete(Integer id) {
        Teacher t = em.find(Teacher.class, id);
        em.remove(t);
    }

    public void update(Teacher teacher) {
        em.merge(teacher);
    }
}
