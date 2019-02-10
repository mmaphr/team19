package com.se.team19.server;

import com.se.team19.server.Entity.Maintenance;
import com.se.team19.server.Repository.MaintenanceStatusRepository;
import com.se.team19.server.Repository.PlaceRepository;
import com.se.team19.server.Repository.StaffRepository;
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
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MaintenanceTest {

    @Autowired
    private MaintenanceStatusRepository maintenanceStatusRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void maintenanceTestAllDataIsWork() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง II");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            System.out.println("\nMaintenanceTest001 is correct\n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

    @Test
    public void maintenanceTestMaintenanceNameIsNull() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName(null);
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest002 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestDescriptionIsNull() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง");
        maintenance.setDescription(null);
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest003 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestDateStartIsNull() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(null);
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest004 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestTimeStartIsNull() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(null);
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest005 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestDateFinishIsNull() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(null);
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            System.out.println("\nMaintenanceTest006 is correct\n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

    @Test
    public void maintenanceTestTimeFinishIsNull() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(null);
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            System.out.println("\nMaintenanceTest007 is correct\n");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            fail("Should not pass to this line");
        }
    }

    @Test
    public void maintenanceTestStatusIsNull() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(null);
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest008 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestStaffIsNull() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(null);
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest009 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestPlaceIsNull() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(null);
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest010 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestMaintenanceNameNotMatch() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง!!!");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest011 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestMaintenanceNameTooLitle() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("เสีย");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest012 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestMaintenanceNameTooMuch() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียงที่ติดๆดับๆห้องโถง");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest013 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestDescriptionTooMuch() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceName("ซ่อมเครื่องเสียง");
        maintenance.setDescription("เครื่องเสียงติดๆดับๆติดๆดับๆติดๆดับๆติดๆดับๆติดๆดับๆติดๆดับๆติดๆดับๆ");
        maintenance.setDateStart(new Date());
        maintenance.setTimeStart(new Date());
        maintenance.setDateFinish(new Date());
        maintenance.setTimeFinish(new Date());
        maintenance.setStatus(maintenanceStatusRepository.findById(1));
        maintenance.setStaff(staffRepository.findById(1));
        maintenance.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\nMaintenanceTest014 is correct\n" + e.getConstraintViolations());
            System.out.println();
        }
    }

    @Test
    public void maintenanceTestIsNotUnique() {
        Date newDate = new Date();
        Maintenance maintenance1 = new Maintenance();
        maintenance1.setMaintenanceName("ซ่อมเครื่องเสียง");
        maintenance1.setDescription("เครื่องเสียงติดๆดับๆ");
        maintenance1.setDateStart(newDate);
        maintenance1.setTimeStart(new Date());
        maintenance1.setDateFinish(new Date());
        maintenance1.setTimeFinish(new Date());
        maintenance1.setStatus(maintenanceStatusRepository.findById(1));
        maintenance1.setStaff(staffRepository.findById(1));
        maintenance1.setPlace(placeRepository.findById(1));
        entityManager.persist(maintenance1);

        Maintenance maintenance2 = new Maintenance();
        maintenance2.setMaintenanceName("ซ่อมเพดานห้อง");
        maintenance2.setDescription("เพดานรั่ว");
        maintenance2.setDateStart(newDate);
        maintenance2.setTimeStart(new Date());
        maintenance2.setDateFinish(new Date());
        maintenance2.setTimeFinish(new Date());
        maintenance2.setStatus(maintenanceStatusRepository.findById(2));
        maintenance2.setStaff(staffRepository.findById(2));
        maintenance2.setPlace(placeRepository.findById(1));
        try {
            entityManager.persist(maintenance2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("\nMaintenanceTest015 is correct\n");
            e.printStackTrace();
            System.out.println();
        }
    }
}
