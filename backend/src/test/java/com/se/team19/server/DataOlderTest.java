package com.se.team19.server;
import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataOlderTest {

    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    // TestTrue
    @Test
    public void testDataOlderTrue() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("2/4");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** True ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    // End TestTrue

    // TestNotNull
    @Test
    public void testDataOlderOldernameNotNull() {
        DataOlder d = new DataOlder();
        d.setOldername(null);
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("2/4");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** OldernameNotNull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderOlderbirthNotNull() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(null);
        d.setParentname("แดง");
        d.setParentaddress("2/4");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** lderbirthNotNull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderParentnameNotNull() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname(null);
        d.setParentaddress("2/4");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** ParentnameNotNull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderParentaddressNotNull() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress(null);
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** ParentaddressNotNull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderParentphoneNotNull() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("2/4");
        d.setParentphone(null);
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** ParentphoneNotNull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderDataOlderGenderNotNull() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("2/4");
        d.setParentphone("0123456789");
        d.setDataOlderGender(null);
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** DataOlderGenderNotNull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderDataOlderProvinceNotNull() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("2/4");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(null);
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** DataOlderGenderNotNull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    // End TestNotNull

    // TestSize
    @Test
    public void testDataOlderOldernameSize() {
        DataOlder d = new DataOlder();
        d.setOldername("ก");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("2/4");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** OldernameSize ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderParentnameSize() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("ด");
        d.setParentaddress("2/4");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** ParentnameSize ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderParentaddressSize() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("0000/0000");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** ParentaddressSize ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderParentphoneSize() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("2/4");
        d.setParentphone("01234567890");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** ParentphoneSize ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    // End TestSize

    // TestPattern
    @Test
    public void testDataOlderOldernamePattern() {
        DataOlder d = new DataOlder();
        d.setOldername("aa");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("2/4");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** OldernamePattern ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderParentnamePattern() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("bb");
        d.setParentaddress("2/4");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** ParentnamePattern ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderParentaddressPattern() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("/1/");
        d.setParentphone("0123456789");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** ParentaddressPattern ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testDataOlderParentphonePattern() {
        DataOlder d = new DataOlder();
        d.setOldername("ดำ");
        d.setOlderbirth(new Date(100,1,1));
        d.setParentname("แดง");
        d.setParentaddress("2/4");
        d.setParentphone("a12345678b");
        d.setDataOlderGender(genderRepository.findById(1));
        d.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** ParentphonePattern ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    // End TestPattern

    // TestUnique
    @Test
    public void testDataOlderAllUnique() {
        DataOlder d1 = new DataOlder();
        d1.setOldername("ดำ");
        d1.setOlderbirth(new Date(100,1,1));
        d1.setParentname("แดง");
        d1.setParentaddress("2/4");
        d1.setParentphone("0123456789");
        d1.setDataOlderGender(genderRepository.findById(1));
        d1.setDataOlderProvince(provinceRepository.findById(1));
        entityManager.persist(d1);
        DataOlder d2 = new DataOlder();
        d2.setOldername("ดำ");
        d2.setOlderbirth(new Date(100,1,1));
        d2.setParentname("แดง");
        d2.setParentaddress("2/4");
        d2.setParentphone("0123456789");
        d2.setDataOlderGender(genderRepository.findById(1));
        d2.setDataOlderProvince(provinceRepository.findById(1));
        try {
            entityManager.persist(d2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.persistence.PersistenceException e){
            System.out.println("******************** AllUnique ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    // End TestUnipue
}
