package com.springjdbc;

import com.springjdbc.Pojos.Student;
import com.springjdbc.config.JavaConfig;
import com.springjdbc.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentDao studentDao = applicationContext.getBean("studentDaoImpl", StudentDao.class);
        Student student = new Student();
        student.setId(101);
        student.setName("Mit");
        student.setCity("California");

        //System.out.println(studentDao.insert(student));

        Student student1 = new Student();
        student1.setId(111);
        student1.setName("Raj");
        student1.setCity("California");

        //System.out.println(studentDao.update(student1));

        Student student2 = new Student();
        student2.setId(1);
        student2.setName("Raj");
        student2.setCity("California");

        //System.out.println(studentDao.remove(student2));

        //System.out.println(studentDao.search(10000));

        System.out.println(studentDao.getAllStudents());
    }

}
