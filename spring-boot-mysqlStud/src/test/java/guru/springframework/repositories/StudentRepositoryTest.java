package guru.springframework.repositories;

import guru.springframework.domain.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

//    private static final int ROLL_NO  = "whats the rollno";
//    private static final String STUDENT_NAME = "a smart student";
//    private static final String EMAIL = "looks good";
//    private static final String PASSWORD  = "keep it secret";
//    private static final Date CREATED_DATE = ;
//    private static final Date LAST_LOGIN_DATE = ;

    @Autowired
    private StudentRepository studentRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPersistence() {
        //given
    	Student student = new Student();
//    	student.setrollNo(ROLL_NO);
//    	student.setname(STUDENT_NAME);
//    	student.setemail(EMAIL);
//    	student.setpassword(PASSWORD);
//    	student.setcreatedDate(CREATED_DATE);
//    	student.setlastLoginDate(LAST_LOGIN_DATE);
//
//        //when
//    	studentRepository.save(student);
//
//        //then
//        Assert.assertNotNull(student.getId());
//        Student newStudent = studentRepository.findById(student.getId()).orElse(null);
//        Assert.assertEquals((Long) 1L, newStudent.getId());
//        Assert.assertEquals(ROLL_NO, newStudent.getrollNo());
//        Assert.assertEquals(STUDENT_NAME, newStudent.getname());
//        Assert.assertEquals(EMAIL.compareTo(newStudent.getemail()), 0);
//        Assert.assertEquals(PASSWORD, newStudent.getpassword());
//        Assert.assertEquals(CREATED_DATE, newStudent.getcreatedDate());
//        Assert.assertEquals(LAST_LOGIN_DATE, newStudent.getlastLoginDate());
    }
}