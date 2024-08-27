package com.luv2code.crudDemo;

import com.luv2code.crudDemo.dao.StudentDAo;
import com.luv2code.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAo studentDAo) {
        return runner -> {
            //createStudent(studentDAo);
            //createMultipleStudents(studentDAo);
            //readStudent(studentDAo);
            //queryForStudnents(studentDAo);
            //queryForLastName(studentDAo);
            //updateDetailsOfTheStudent(studentDAo);
            deleteData(studentDAo);

            System.out.println("hlo world");
        };
    }

    private void deleteData(StudentDAo studentDAo) {
        int theId = 3;
        System.out.println("fetching details of the id = " + theId);
        Student myStudent = studentDAo.findById(theId);
        System.out.println(myStudent);
        System.out.println("deleting the data");
        studentDAo.deleteStudent(theId);


    }

    private void updateDetailsOfTheStudent(StudentDAo studentDAo) {
        //retrieve based on the id :primary Key
        int theId = 1;
        System.out.println("fetching details of the id = " + theId);

        Student myStudent = studentDAo.findById(theId);

        System.out.println(myStudent);


        //change the first name
        System.out.println("Changing the first name ");
        myStudent.setFirstName("MaruthiKiran");

        //update
        System.out.println("updating it to the data base");
        studentDAo.updateStudent(myStudent);
        //display
        System.out.println(myStudent);

    }

    private void queryForLastName(StudentDAo studentDAo) {
        System.out.println(studentDAo.findByLastName("b"));

    }

    private void queryForStudnents(StudentDAo studentDAo) {
        System.out.println("finding all the students details  ");
        List<Student> theStudent = studentDAo.findAll();
        System.out.println("printing the detials");

        for (Student temp : theStudent) {

            System.out.println(temp);
        }

    }

    private void readStudent(StudentDAo studentDAo) {
        System.out.println("creating the student ");
        Student student = new Student("m", "kiran", "r");
        System.out.println("Saving the objects .........");
        studentDAo.save(student);

        System.out.println("find the student ");
        int theId = student.getId();
        System.out.println(studentDAo.findById(student.getId()));
        System.out.println("retrieving the student details");
        Student find = studentDAo.findById(theId);
        System.out.println(find.toString());

    }

    private void createMultipleStudents(StudentDAo studentDAo) {
        System.out.println("creating new student object....");
        Student tempStudent1 = new Student("c", "d", "cd@gmail.com");
        Student tempStudent2 = new Student("e", "f", "ef@gmail.com");
        Student tempStudent3 = new Student("g", "h", "gh@gmail.com");


        System.out.println("Saving the objects .........");
        studentDAo.save(tempStudent1);
        studentDAo.save(tempStudent2);
        studentDAo.save(tempStudent3);

    }

    private void createStudent(StudentDAo studentDAo) {

        //create
        System.out.println("creating new student object....");
        Student tempStudent = new Student("a", "b", "ab@gmail.com");


        //save the student object
        System.out.println("Saving the object ");
        studentDAo.save(tempStudent);


        //display id of the  saved object

        System.out.println("Saved object info id:" + tempStudent.getId());
        tempStudent.toString();


    }
}
