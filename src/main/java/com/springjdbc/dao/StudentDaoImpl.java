package com.springjdbc.dao;

import com.springjdbc.Pojos.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?)";
        int res = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return res;
    }

    @Override
    public int update(Student student) {
        String query = "update student set name=? , city=? where id=?;";
        int res = jdbcTemplate.update(query,student.getName(), student.getCity(), student.getId());
        return res;
    }

    @Override
    public int remove(Student student) {
        String query = "delete from student where id=?;";
        int res = jdbcTemplate.update(query, student.getId());
        return res;
    }

    @Override
    public Student search(int id) {
        String query = "select * from student where id=?;";
        Student student = jdbcTemplate.queryForObject(query, new StudentRowMapperImpl() , id);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from student;";
        List<Student> students = jdbcTemplate.query(query, new StudentRowMapperImpl());
        return students;
    }
}
