package com.se.team19.server;

import com.se.team19.server.Entity.InternalActivity;
import com.se.team19.server.Repository.DaysOfTheWeekRepository;
import com.se.team19.server.Repository.StaffRepository;
import com.se.team19.server.Repository.TimeDurationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InternalActivityTest {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    DaysOfTheWeekRepository daysOfTheWeekRepository;
    @Autowired
    TimeDurationRepository timeDurationRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void inActTestIsWork() {
        InternalActivity inAct = new InternalActivity();
        inAct.setActName("วิ่งเพื่อสุขภาพ Run");
        inAct.setDescription("วิ่งตอนเช้าเพื่อสุขภาพที่ดี");
        inAct.setStaff(staffRepository.findById(1));
        inAct.setDay(daysOfTheWeekRepository.findById(5));
        inAct.setTime(timeDurationRepository.findById(1));
        try {
            entityManager.persist(inAct);
            entityManager.flush();
            System.out.println("\nInActTest001 is correct\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void inActTestActNameIsNull() {
        InternalActivity inAct = new InternalActivity();
        inAct.setActName(null);
        inAct.setDescription("วิ่งตอนเช้าเพื่อสุขภาพที่ดี");
        inAct.setStaff(staffRepository.findById(1));
        inAct.setDay(daysOfTheWeekRepository.findById(5));
        inAct.setTime(timeDurationRepository.findById(1));
        try {
            entityManager.persist(inAct);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nInActTest002 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void inActTestWithOutDescriptionIsWork() {
        InternalActivity inAct = new InternalActivity();
        inAct.setActName("วิ่งเพื่อสุขภาพ Run");
        inAct.setDescription(null);
        inAct.setStaff(staffRepository.findById(1));
        inAct.setDay(daysOfTheWeekRepository.findById(5));
        inAct.setTime(timeDurationRepository.findById(1));
        try {
            entityManager.persist(inAct);
            entityManager.flush();
            System.out.println("\nInActTest003 is correct\n");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

    @Test
    public void inActTestStaffIsNull() {
        InternalActivity inAct = new InternalActivity();
        inAct.setActName("วิ่งเพื่อสุขภาพ Run");
        inAct.setDescription("วิ่งตอนเช้าเพื่อสุขภาพที่ดี");
        inAct.setStaff(null);
        inAct.setDay(daysOfTheWeekRepository.findById(5));
        inAct.setTime(timeDurationRepository.findById(1));
        try {
            entityManager.persist(inAct);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nInActTest004 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void inActTestDayIsNull() {
        InternalActivity inAct = new InternalActivity();
        inAct.setActName("วิ่งเพื่อสุขภาพ Run");
        inAct.setDescription("วิ่งตอนเช้าเพื่อสุขภาพที่ดี");
        inAct.setStaff(staffRepository.findById(1));
        inAct.setDay(null);
        inAct.setTime(timeDurationRepository.findById(1));
        try {
            entityManager.persist(inAct);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nInActTest005 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void inActTestTimeIsNull() {
        InternalActivity inAct = new InternalActivity();
        inAct.setActName("วิ่งเพื่อสุขภาพ Run");
        inAct.setDescription("วิ่งตอนเช้าเพื่อสุขภาพที่ดี");
        inAct.setStaff(staffRepository.findById(1));
        inAct.setDay(daysOfTheWeekRepository.findById(5));
        inAct.setTime(null);
        try {
            entityManager.persist(inAct);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nInActTest006 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void inActTestActNameIsTooLittle() {
        InternalActivity inAct = new InternalActivity();
        inAct.setActName("Run");
        inAct.setDescription("วิ่งตอนเช้าเพื่อสุขภาพที่ดี");
        inAct.setStaff(staffRepository.findById(1));
        inAct.setDay(daysOfTheWeekRepository.findById(5));
        inAct.setTime(timeDurationRepository.findById(1));
        try {
            entityManager.persist(inAct);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nInActTest007 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void inActTestActNameIsTooMuch() {
        InternalActivity inAct = new InternalActivity();
        inAct.setActName("วิ่งเพื่อสุขภาพ Run Run Run Run");
        inAct.setDescription("วิ่งตอนเช้าเพื่อสุขภาพที่ดี");
        inAct.setStaff(staffRepository.findById(1));
        inAct.setDay(daysOfTheWeekRepository.findById(5));
        inAct.setTime(timeDurationRepository.findById(1));
        try {
            entityManager.persist(inAct);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nInActTest008 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void inActTestDescriptionIsTooMuch() {
        InternalActivity inAct = new InternalActivity();
        inAct.setActName("วิ่งเพื่อสุขภาพ Run");
        inAct.setDescription("วิ่งตอนเช้าเพื่อสุขภาพที่ดีเพื่ออนาคตข้างหน้าอันสดใส");
        inAct.setStaff(staffRepository.findById(1));
        inAct.setDay(daysOfTheWeekRepository.findById(5));
        inAct.setTime(timeDurationRepository.findById(1));
        try {
            entityManager.persist(inAct);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nInActTest009 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void inActActNameNotMatch() {
        InternalActivity inAct = new InternalActivity();
        inAct.setActName("วิ่งเพื่อสุขภาพ Run!!!");
        inAct.setDescription("วิ่งตอนเช้าเพื่อสุขภาพที่ดีเพื่ออนาคตข้างหน้า");
        inAct.setStaff(staffRepository.findById(1));
        inAct.setDay(daysOfTheWeekRepository.findById(5));
        inAct.setTime(timeDurationRepository.findById(1));
        try {
            entityManager.persist(inAct);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nInActTest010 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void inActTestIsNotUnique() {
        InternalActivity inAct1 = new InternalActivity();
        inAct1.setActName("วิ่งเพื่อสุขภาพ Run");
        inAct1.setDescription("วิ่งตอนเช้าเพื่อสุขภาพ");
        inAct1.setStaff(staffRepository.findById(1));
        inAct1.setDay(daysOfTheWeekRepository.findById(5));
        inAct1.setTime(timeDurationRepository.findById(1));
        entityManager.persist(inAct1);

        InternalActivity inAct2 = new InternalActivity();
        inAct2.setActName("วิ่งเพื่อสุขภาพ");
        inAct2.setDescription("วิ่งตอนเช้าเพื่อสุขภาพที่ดี");
        inAct2.setStaff(staffRepository.findById(2));
        inAct2.setDay(daysOfTheWeekRepository.findById(5));
        inAct2.setTime(timeDurationRepository.findById(1));
        try {
            entityManager.persist(inAct2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("\nInActTest011 is correct\n");
            e.printStackTrace();
            System.out.println();
        }
    }
}



