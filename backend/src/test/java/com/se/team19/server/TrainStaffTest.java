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
import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrainStaffTest {
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Autowired
    private TrainTypeRepository trainTypeRepository;
    @Autowired
    private TrainStaffRepository trainStaffRepository;
    @Autowired
    private TrainAndStaffRepository trainAndStaffRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private TimeDurationRepository timeDurationRepository;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //Running => mvnw -Dtest=TrainStaffTest test
    //<!!========== Success ==========!!>//
    @Test
    public void testTrainStaff() {
        TrainStaff T1 = new TrainStaff();
        T1.setTrainName("อมรมฝึกสอนกายภาพ");
        T1.setTrainDescription("การอบรมฝึกสอนวิธีการทำกายภาพบำบัดผู้สูงอายุ");
        T1.setTrainDate(new Date(118,2,14));
        T1.setTrainTime(timeDurationRepository.findById(8));
        T1.setTrainType(trainTypeRepository.findById(1));
        T1.setTrainStaff(staffRepository.findById(1));

        try {
            entityManager.persist(T1);
            entityManager.flush();
            System.out.println("=======================================================================");
            System.out.println("======================= testTrainStaff Success ========================");
            System.out.println("=======================================================================");
            //            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //<!!==================== NotNullTest ====================!!>//
    //<!!========== TrainName ==========!!>//
    @Test
    public void testTrainNamecannotBeNull() {
        TrainStaff T1 = new TrainStaff();
        T1.setTrainName(null);
        T1.setTrainDescription("การอบรมฝึกสอนวิธีการทำกายภาพบำบัดผู้สูงอายุ");
        T1.setTrainDate(new Date(118,2,14));
        T1.setTrainTime(timeDurationRepository.findById(8));
        T1.setTrainType(trainTypeRepository.findById(1));
        T1.setTrainStaff(staffRepository.findById(1));

        try {
            entityManager.persist(T1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("=================== Test testTrainNamecannotBeNull ====================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== TrainDescription ==========!!>//
    @Test
    public void testTrainDescriptioncannotBeNull() {
        TrainStaff T1 = new TrainStaff();
        T1.setTrainName("อมรมฝึกสอนกายภาพ");
        T1.setTrainDescription(null);
        T1.setTrainDate(new Date(118,2,14));
        T1.setTrainTime(timeDurationRepository.findById(8));
        T1.setTrainType(trainTypeRepository.findById(1));
        T1.setTrainStaff(staffRepository.findById(1));

        try {
            entityManager.persist(T1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("=============== Test testTrainDescriptioncannotBeNull =================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== TrainDate ==========!!>//
    @Test
    public void testTrainDatecannotBeNull() {
        TrainStaff T1 = new TrainStaff();
        T1.setTrainName("อมรมฝึกสอนกายภาพ");
        T1.setTrainDescription("การอบรมฝึกสอนวิธีการทำกายภาพบำบัดผู้สูงอายุ");
        T1.setTrainDate(null);
        T1.setTrainTime(timeDurationRepository.findById(8));
        T1.setTrainType(trainTypeRepository.findById(1));
        T1.setTrainStaff(staffRepository.findById(1));

        try {
            entityManager.persist(T1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("================== Test testTrainDatecannotBeNull =====================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!==================== SizeTest ====================!!>//
    //<!!========== TrainName ==========!!>//
    @Test
    public void testTrainNameMustLongerThan3() {
        TrainStaff T1 = new TrainStaff();
        T1.setTrainName("อบ");
        T1.setTrainDescription("การอบรมฝึกสอนวิธีการทำกายภาพบำบัดผู้สูงอายุ");
        T1.setTrainDate(new Date(118,2,14));
        T1.setTrainTime(timeDurationRepository.findById(8));
        T1.setTrainType(trainTypeRepository.findById(1));
        T1.setTrainStaff(staffRepository.findById(1));

        try {
            entityManager.persist(T1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("================= Test testTrainNameMustLongerThan3 ===================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== TrainDescription ==========!!>//
    @Test
    public void testTrainDescriptionMustLongerThan5() {
        TrainStaff T1 = new TrainStaff();
        T1.setTrainName("อบรมฝึกสอนกายภาพ");
        T1.setTrainDescription("การ");
        T1.setTrainDate(new Date(118,2,14));
        T1.setTrainTime(timeDurationRepository.findById(8));
        T1.setTrainType(trainTypeRepository.findById(1));
        T1.setTrainStaff(staffRepository.findById(1));

        try {
            entityManager.persist(T1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("============== Test testTrainDescriptionMustLongerThan5 ================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!==================== PatternTest ====================!!>//
    //<!!========== TrainName ==========!!>//
    @Test
    public void testTrainNamePattern() {
        TrainStaff T1 = new TrainStaff();
        T1.setTrainName("อมรมฝึกสอนกายภาพ☺☻♥♦♣♠§◘○");
        T1.setTrainDescription("การอบรมฝึกสอนวิธีการทำกายภาพบำบัดผู้สูงอายุ");
        T1.setTrainDate(new Date(118,2,14));
        T1.setTrainTime(timeDurationRepository.findById(8));
        T1.setTrainType(trainTypeRepository.findById(1));
        T1.setTrainStaff(staffRepository.findById(1));

        try {
            entityManager.persist(T1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("================= Test testTrainNameMustLongerThan3 ===================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!========== TrainDescription ==========!!>//
    @Test
    public void testTrainDescriptionPattern() {
        TrainStaff T1 = new TrainStaff();
        T1.setTrainName("อมรมฝึกสอนกายภาพ");
        T1.setTrainDescription("☺☻♥♦♣♠§◘○การอบรมฝึกสอนวิธีการทำกายภาพบำบัดผู้สูงอายุ");
        T1.setTrainDate(new Date(118,2,14));
        T1.setTrainTime(timeDurationRepository.findById(8));
        T1.setTrainType(trainTypeRepository.findById(1));
        T1.setTrainStaff(staffRepository.findById(1));

        try {
            entityManager.persist(T1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=======================================================================");
            System.out.println("================== Test testTrainDescriptionPattern ====================");
            System.out.println("=======================================================================");
            System.out.println(e);
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }

    //<!!==================== UniqueTest ====================!!>//
    //<!!========== TrainDate ==========!!>//
    @Test
    public void testTrainDateMustBeUnique() {
        TrainStaff T1 = new TrainStaff();
        Date TrainDate = new Date(118,2,14);
        T1.setTrainName("อมรมฝึกสอนกายภาพ");
        T1.setTrainDescription("การอบรมฝึกสอนวิธีการทำกายภาพบำบัดผู้สูงอายุ");
        T1.setTrainDate(TrainDate);
        T1.setTrainTime(timeDurationRepository.findById(8));
        T1.setTrainType(trainTypeRepository.findById(1));
        T1.setTrainStaff(staffRepository.findById(1));
        entityManager.persist(T1);

        TrainStaff T2 = new TrainStaff();
        T2.setTrainName("อมรมฝึกสอนออกกำลัง");
        T2.setTrainDescription("การอบรมฝึกสอนวิธีการออกกำลังกายกับผู้สูงอายุ");
        T2.setTrainDate(TrainDate);
        T2.setTrainTime(timeDurationRepository.findById(8));
        T2.setTrainType(trainTypeRepository.findById(1));
        T2.setTrainStaff(staffRepository.findById(1));

        try {
            entityManager.persist(T2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("=======================================================================");
            System.out.println("================== Test testTrainDateMustBeUnique =====================");
            System.out.println("=======================================================================");
            System.out.println(e);
            e.printStackTrace();
            System.out.println("=======================================================================");
            System.out.println("=======================================================================");
        }
    }
}
