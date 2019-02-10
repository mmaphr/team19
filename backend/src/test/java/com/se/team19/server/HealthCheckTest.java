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
public class HealthCheckTest {

    @Autowired
    private TypeHealthCheckRepository typeHealthCheckRepository;
    @Autowired
    private DataOlderRepository dataOlderRepository;

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
    public void testHealthCheckTrue() {
        HealthCheck h = new HealthCheck();
        h.setHospital("โรงพยาบาล");
        h.setDatecheck(new Date(100,1,1));
        h.setExpenses(1200);
        h.setDescription("ปวดท้องน้อย");
        h.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h);
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
    public void testHealthCheckHospitalNotnull() {
        HealthCheck h = new HealthCheck();
        h.setHospital(null);
        h.setDatecheck(new Date(100,1,1));
        h.setExpenses(1200);
        h.setDescription("ปวดท้องน้อย");
        h.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** HospitalNotnull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testHealthCheckDatecheckNotnull() {
        HealthCheck h = new HealthCheck();
        h.setHospital("โรงพยาบาล");
        h.setDatecheck(null);
        h.setExpenses(1200);
        h.setDescription("ปวดท้องน้อย");
        h.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** DatecheckNotnull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testHealthCheckDescriptionNotnull() {
        HealthCheck h = new HealthCheck();
        h.setHospital("โรงพยาบาล");
        h.setDatecheck(new Date(100,1,1));
        h.setExpenses(1200);
        h.setDescription(null);
        h.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** DescriptionNotnull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testHealthCheckHealthCheckTypeNotnull() {
        HealthCheck h = new HealthCheck();
        h.setHospital("โรงพยาบาล");
        h.setDatecheck(new Date(100,1,1));
        h.setExpenses(1200);
        h.setDescription("ปวดท้องน้อย");
        h.setHealthCheckType(null);
        h.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** HealthCheckTypeNotnull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testHealthCheckHealthCheckDataNotnull() {
        HealthCheck h = new HealthCheck();
        h.setHospital("โรงพยาบาล");
        h.setDatecheck(new Date(100,1,1));
        h.setExpenses(1200);
        h.setDescription("ปวดท้องน้อย");
        h.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h.setHealthCheckData(null);
        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** HealthCheckDataNotnull ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    // End TestNotNull

    // TestSize
    @Test
    public void testHealthCheckHospitalSize() {
        HealthCheck h = new HealthCheck();
        h.setHospital("โ");
        h.setDatecheck(new Date(100,1,1));
        h.setExpenses(1200);
        h.setDescription("ปวดท้องน้อย");
        h.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** HospitalSize ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testHealthCheckDescriptionSize() {
        HealthCheck h = new HealthCheck();
        h.setHospital("โรงพยาบาล");
        h.setDatecheck(new Date(100,1,1));
        h.setExpenses(1200);
        h.setDescription("ปวดท้องน้อยปวดท้องน้อยปวดท้องน้อยปวดท้องน้อยปวดท้องน้อยปวดท้องน้อยปวดท้องน้อยปวดท้องน้อยปวดท้องน้อยปวดท้องน้อยปวดท้องน้อยปวดท้องน้อย");
        h.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** HospitalSize ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    // End TestSize
    // TestPattern
    @Test
    public void testHealthCheckHospitalPattern() {
        HealthCheck h = new HealthCheck();
        h.setHospital("ABCDEF");
        h.setDatecheck(new Date(100,1,1));
        h.setExpenses(1200);
        h.setDescription("ปวดท้องน้อย");
        h.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** HospitalPattern ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    @Test
    public void testHealthCheckDescriptionPattern() {
        HealthCheck h = new HealthCheck();
        h.setHospital("โรงพยาบาล");
        h.setDatecheck(new Date(100,1,1));
        h.setExpenses(1200);
        h.setDescription("/*-*+/asdddกฟหก");
        h.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** DescriptionPattern ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    // End TestPattern

    // TestDecimalMin
    @Test
    public void testHealthCheckExpensesDecimalMin() {
        HealthCheck h = new HealthCheck();
        h.setHospital("โรงพยาบาล");
        h.setDatecheck(new Date(100,1,1));
        h.setExpenses(-10);
        h.setDescription("ปวดท้องน้อย");
        h.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("******************** ExpensesDecimalMin ********************");
            System.out.println(e.getMessage());
            System.out.println("******************** ******************* ********************");
            e.printStackTrace();
            System.out.println("******************** ******************* ********************");
        }
    }
    // End TestDecimalMin

    // TestUnique
    @Test
    public void testHealthCheckUnique() {
        HealthCheck h1 = new HealthCheck();
        h1.setHospital("โรงพยาบาล");
        h1.setDatecheck(new Date(100,1,1));
        h1.setExpenses(1200);
        h1.setDescription("ปวดท้องน้อย");
        h1.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h1.setHealthCheckData(dataOlderRepository.findById(1));
        entityManager.persist(h1);
        HealthCheck h2 = new HealthCheck();
        h2.setHospital("โรงพยาบาลน้ำ");
        h2.setDatecheck(new Date(100,1,1));
        h2.setExpenses(1300);
        h2.setDescription("ปวดท้องน้อยหมู");
        h2.setHealthCheckType(typeHealthCheckRepository.findById(1));
        h2.setHealthCheckData(dataOlderRepository.findById(1));
        try {
            entityManager.persist(h2);
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
