package com.springjdbc.dao;

import com.springjdbc.Pojos.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public int update(Student student);
    public int remove(Student student);
    public Student search(int id);
    public List<Student> getAllStudents();
}
