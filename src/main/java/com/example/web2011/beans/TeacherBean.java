package com.example.web2011.beans;

import com.example.web2011.dao.TeacherDao;
import com.example.web2011.data.Teacher;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.ActionListener;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TeacherBean implements Serializable {
    @EJB
    private TeacherDao teacherDao;

    @Getter
    @Setter
    private Teacher teacher = new Teacher();

    public List<Teacher> getTeachers() {
        return teacherDao.findAll();
    }

    public void add() {
        teacherDao.add(teacher);
        teacher = new Teacher();
    }

    public void delete() {
        teacherDao.delete(teacher.getId());
        teacher = new Teacher();
    }

    public void update() {
        teacherDao.update(teacher);
        teacher = new Teacher();
    }
}
