package com.se.team19.server;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import static org.junit.Assert.fail;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OutActivityTest {
    @Autowired
    private OutActivityRepository outActivityRepository;
    @Autowired
    private CategoryActivityRepository categoryActivityRepository ;
    @Autowired
    private PeriodTimeRepository periodTimeRepository ;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private OrganizedRepository organizedRepository;
    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testTureData() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("0922818151");
        o.setDate(new Date(1,1,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNameActivityNull() {
        OutActivity o = new OutActivity();
        o.setNameActivity(null);
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("0922818151");
        o.setDate(new Date(1,1,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

          fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testNameActivityNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
    @Test
    public void testNameRequestorNull() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor(null);
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("0922818151");
        o.setDate(new Date(1,1,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testNameRequestorNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }

    @Test
    public void testDescriptionActivityNull() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity(null);
        o.setPhonenum("0922818151");
        o.setDate(new Date(1,1,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testDescriptionActivityNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
    @Test
    public void testPhonenumNull() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum(null);
        o.setDate(new Date(1,1,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testPhonenumNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
    @Test
    public void testPhonenumTozerotonine() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("B123456789");
        o.setDate(new Date(1,1,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testPhonenumTozerotonine Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
    @Test
    public void testUnique() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("B123456789");
        o.setDate(new Date(1,1,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));

        OutActivity o1 = new OutActivity();
        o1.setNameActivity("งานกีฬา");
        o1.setNameRequestor("นายสมพร");
        o1.setDescriptionActivity("งายกีฬานอกสถานที่");
        o1.setPhonenum("0123456789");
        o1.setDate(new Date(1,1,2));
        o1.setCategoryActivity(categoryActivityRepository.findById(2));
        o1.setPeriodTimeS(periodTimeRepository.findById(2));
        o1.setPeriodTimeE(periodTimeRepository.findById(1));
        o1.setStaff(staffRepository.findById(2));
        o1.setOrganized(organizedRepository.findById(2));
        try{
            entityManager.persist(o1);
            entityManager.flush();
          //  fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e){
            System.out.println("========================================================= Unique Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
    @Test
    public void testDateNull() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("0123456789");
        o.setDate(null);
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testDateNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
    @Test
    public void testCategoryActivityNull() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("0123456789");
        o.setDate(new Date(1,2,2));
        o.setCategoryActivity(null);
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testCategoryActivityNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
    @Test
    public void testPeriodTimeSNull() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("0123456789");
        o.setDate(new Date(1,2,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(null);
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testPeriodTimeSNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
    @Test
    public void testPeriodTimeENull() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("0123456789");
        o.setDate(new Date(1,2,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(null);
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testPeriodTimeSNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
    @Test
    public void testStaffNull() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("0123456789");
        o.setDate(new Date(1,2,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(null);
        o.setOrganized(organizedRepository.findById(1));
        try {
            entityManager.persist(o);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testStaffNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
    @Test
    public void testOrganizedNull() {
        OutActivity o = new OutActivity();
        o.setNameActivity("งานดนตรี");
        o.setNameRequestor("นายสมชาย");
        o.setDescriptionActivity("งายดนตรีกลางแจ้ง");
        o.setPhonenum("0123456789");
        o.setDate(new Date(1,2,2));
        o.setCategoryActivity(categoryActivityRepository.findById(1));
        o.setPeriodTimeS(periodTimeRepository.findById(1));
        o.setPeriodTimeE(periodTimeRepository.findById(3));
        o.setStaff(staffRepository.findById(1));
        o.setOrganized(null);
        try {
            entityManager.persist(o);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testOrganizedNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
        }
    }
}
