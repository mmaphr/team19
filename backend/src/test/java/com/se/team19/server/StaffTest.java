package com.se.team19.server;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StaffTest {

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private StaffRepository staffRepository;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //Running => mvnw -Dtest=StaffTest test
    //<!!========== Success ==========!!>//
    @Test
    public void testStaff() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(20);
        S1.setAddress("123/2");
        S1.setPhone("0812345678");
        S1.setUsername("S1234");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();
            System.out.println("=======================================================================");
            System.out.println("======================= Test Staff SuccessTest ========================");
            System.out.println("=======================================================================");
            //            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //<!!==================== NotNullTest ====================!!>//
    //<!!========== StaffName ==========!!>//
    @Test
    public void testStaffNamecannotBeNull() {
        Staff S1 = new Staff();
        S1.setStaffName(null);
        S1.setAge(20);
        S1.setAddress("123/2");
        S1.setPhone("0812345678");
        S1.setUsername("S1234");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("===================== Test StaffNamecannotBeNull ======================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== StaffAge ==========!!>//
    @Test
    public void testStaffAgecannotBeNull() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(0);
        S1.setAddress("123/2");
        S1.setPhone("0812345678");
        S1.setUsername("S1234");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("==================== Test testStaffAgecannotBeNull =====================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== StaffAddress ==========!!>//
    @Test
    public void testStaffAddresscannotBeNull() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(22);
        S1.setAddress(null);
        S1.setPhone("0812345678");
        S1.setUsername("S1234");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("================== Test testStaffAddresscannotBeNull ===================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== StaffPhone ==========!!>//
    @Test
    public void testStaffPhonecannotBeNull() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(22);
        S1.setAddress("123/4");
        S1.setPhone(null);
        S1.setUsername("S1234");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("=================== Test testStaffPhonecannotBeNull ====================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== StaffUsername ==========!!>//
    @Test
    public void testStaffUsernamecannotBeNull() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(22);
        S1.setAddress("123/4");
        S1.setPhone("0831234567");
        S1.setUsername(null);
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("================= Test testStaffUsernamecannotBeNull ==================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== StaffPassword ==========!!>//
    @Test
    public void testStaffPasswordcannotBeNull() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(22);
        S1.setAddress("123/4");
        S1.setPhone("0831234567");
        S1.setUsername("S1234");
        S1.setPassword(null);
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("================= Test testStaffPasswordcannotBeNull ==================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!==================== SizeTest ====================!!>//
    //<!!========== StaffPhone ==========!!>//
    @Test
    public void testStaffPhoneMustBe10() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(20);
        S1.setAddress("123/2");
        S1.setPhone("08123456789");
        S1.setUsername("S1234");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("===================== Test testStaffPhoneMustBe10 =====================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== StaffUsername ==========!!>//
    @Test
    public void testStaffUsernameMustBe5() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(20);
        S1.setAddress("123/2");
        S1.setPhone("0812345678");
        S1.setUsername("S12");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("==================== Test testStaffUsernameMustBe5 ====================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }


    //<!!========== StaffPassword ==========!!>//
    @Test
    public void testStaffPasswordMustLongerThan3() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(20);
        S1.setAddress("123/2");
        S1.setPhone("0812345678");
        S1.setUsername("S1234");
        S1.setPassword("12");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("================ Test testStaffPasswordMustLongerThan3 ================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!==================== PatternTest ====================!!>//
    //<!!========== StaffName ==========!!>//
    @Test
    public void testStaffNamePattern() {
        Staff S1 = new Staff();
        S1.setStaffName("☺☻♥♦♣♠§◘○");
        S1.setAge(20);
        S1.setAddress("123/2");
        S1.setPhone("0812345678");
        S1.setUsername("S1234");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("====================== Test testStaffNamePattern ======================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== StaffAddress ==========!!>//
    @Test
    public void testStaffAddressPattern() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(20);
        S1.setAddress("☺☻♥♦♣♠§◘○");
        S1.setPhone("0812345678");
        S1.setUsername("S1234");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("==================== Test testStaffAddressPattern =====================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== StaffPhone ==========!!>//
    @Test
    public void testStaffPhonePattern() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(20);
        S1.setAddress("123/4");
        S1.setPhone("081234asdf");
        S1.setUsername("S1234");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("===================== Test testStaffPhonePattern ======================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== StaffUsername ==========!!>//
    @Test
    public void testStaffUsernamePattern() {
        Staff S1 = new Staff();
        S1.setStaffName("SomSom");
        S1.setAge(20);
        S1.setAddress("123/4");
        S1.setPhone("0812345678");
        S1.setUsername("A1234");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("==================== Test testStaffUsernamePattern =====================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!==================== UniqueTest ====================!!>//
    //<!!========== StaffUsername ==========!!>//
    @Test
    public void testStaffUsernameMustBeUnique() {
        Staff S1 = new Staff();
        S1.setStaffName("SomX");
        S1.setAge(20);
        S1.setAddress("123/2");
        S1.setPhone("0812345678");
        S1.setUsername("S4321");
        S1.setPassword("123456");
        S1.setStaffGender(genderRepository.findById(2));
        S1.setStaffProvince(provinceRepository.findById(13));
        S1.setStaffPosition(positionRepository.findById(2));
        entityManager.persist(S1);

        Staff S2 = new Staff();
        S2.setStaffName("SomY");
        S2.setAge(20);
        S2.setAddress("232/1");
        S2.setPhone("0887654321");
        S2.setUsername("S4321");
        S2.setPassword("654321");
        S2.setStaffGender(genderRepository.findById(2));
        S2.setStaffProvince(provinceRepository.findById(13));
        S2.setStaffPosition(positionRepository.findById(2));

        try {
            entityManager.persist(S2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("=======================================================================");
            System.out.println("================== Test testStaffUsernameMustBeUnique ==================");
            System.out.println("=======================================================================");
            System.out.println(e);
            e.printStackTrace();
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }
}
