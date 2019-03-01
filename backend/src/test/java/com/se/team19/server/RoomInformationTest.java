package com.se.team19.server;

import com.se.team19.server.Entity.RoomInformation;
import com.se.team19.server.Repository.DataOlderRepository;
import com.se.team19.server.Repository.RoomStatusRepository;
import com.se.team19.server.Repository.TypeRoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.Date;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoomInformationTest {
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Autowired
    private RoomStatusRepository roomStatusRepository;
    @Autowired
    private TypeRoomRepository typeRoomRepository;
    @Autowired
    private DataOlderRepository dataOlderRepository;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    //--------------------------  RoomInformationTest  --------------//
    //Sprint1
    @Test
    public void testBuildIsNull() {
        RoomInformation roomImformation = new RoomInformation();

        roomImformation.setBuilding(null);
        roomImformation.setFloor(1);
        roomImformation.setRoomnumber("A101");
        roomImformation.setRoomphone("011112");
        roomImformation.setDayCheckin(new Date());
        roomImformation.setTyperoom(typeRoomRepository.findById(2));
        roomImformation.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation.setOlder(dataOlderRepository.findById(2));
        try {
            entityManager.persist(roomImformation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testFloorIsMin() {
        RoomInformation roomImformation = new RoomInformation();

        roomImformation.setBuilding("1");
        roomImformation.setFloor(0);
        roomImformation.setRoomnumber("A101");
        roomImformation.setRoomphone("011112");
        roomImformation.setDayCheckin(new Date());
        roomImformation.setTyperoom(typeRoomRepository.findById(2));
        roomImformation.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation.setOlder(dataOlderRepository.findById(2));
        try {
            entityManager.persist(roomImformation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testRoomNumisLonger() {
        RoomInformation roomImformation = new RoomInformation();

        roomImformation.setBuilding("1");
        roomImformation.setFloor(1);
        roomImformation.setRoomnumber("A1011");
        roomImformation.setRoomphone("011112");
        roomImformation.setDayCheckin(new Date());
        roomImformation.setTyperoom(typeRoomRepository.findById(2));
        roomImformation.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation.setOlder(dataOlderRepository.findById(2));
        try {
            entityManager.persist(roomImformation);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testRoomNumisNotfirstString() {
        RoomInformation roomImformation = new RoomInformation();

        roomImformation.setBuilding("1");
        roomImformation.setFloor(1);
        roomImformation.setRoomnumber("1101");
        roomImformation.setRoomphone("011112");
        roomImformation.setDayCheckin(new Date());
        roomImformation.setTyperoom(typeRoomRepository.findById(2));
        roomImformation.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation.setOlder(dataOlderRepository.findById(2));
        try {
            entityManager.persist(roomImformation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomphoneIsNull() {
        RoomInformation roomImformation = new RoomInformation();

        roomImformation.setBuilding("1");
        roomImformation.setFloor(1);
        roomImformation.setRoomnumber("A101");
        roomImformation.setRoomphone(null);
        roomImformation.setDayCheckin(new Date());
        roomImformation.setTyperoom(typeRoomRepository.findById(2));
        roomImformation.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation.setOlder(dataOlderRepository.findById(2));
        try {
            entityManager.persist(roomImformation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomphoneIsLonger() {
        RoomInformation roomImformation = new RoomInformation();

        roomImformation.setBuilding("1");
        roomImformation.setFloor(1);
        roomImformation.setRoomnumber("A101");
        roomImformation.setRoomphone("011111111");
        roomImformation.setDayCheckin(new Date());
        roomImformation.setTyperoom(typeRoomRepository.findById(2));
        roomImformation.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation.setOlder(dataOlderRepository.findById(2));
        try {
            entityManager.persist(roomImformation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomphoneNotfirst0() {
        RoomInformation roomImformation = new RoomInformation();

        roomImformation.setBuilding("1");
        roomImformation.setFloor(1);
        roomImformation.setRoomnumber("A101");
        roomImformation.setRoomphone("111111");
        roomImformation.setDayCheckin(new Date());
        roomImformation.setTyperoom(typeRoomRepository.findById(2));
        roomImformation.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation.setOlder(dataOlderRepository.findById(2));
        try {
            entityManager.persist(roomImformation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testTypeIsNull() {
        RoomInformation roomImformation = new RoomInformation();

        roomImformation.setBuilding("1");
        roomImformation.setFloor(1);
        roomImformation.setRoomnumber("A101");
        roomImformation.setRoomphone("011112");
        roomImformation.setDayCheckin(new Date());
        roomImformation.setTyperoom(null);
        roomImformation.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation.setOlder(dataOlderRepository.findById(2));
        try {
            entityManager.persist(roomImformation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testStatusIsNull() {
        RoomInformation roomImformation = new RoomInformation();

        roomImformation.setBuilding("1");
        roomImformation.setFloor(1);
        roomImformation.setRoomnumber("A101");
        roomImformation.setRoomphone("011112");
        roomImformation.setDayCheckin(new Date());
        roomImformation.setTyperoom(typeRoomRepository.findById(2));
        roomImformation.setRoomstatus(null);
        roomImformation.setOlder(dataOlderRepository.findById(2));
        try {
            entityManager.persist(roomImformation);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testRoomUniqe() {
        RoomInformation roomImformation1 = new RoomInformation();
        roomImformation1.setBuilding("1");
        roomImformation1.setFloor(1);
        roomImformation1.setRoomnumber("A101");
        roomImformation1.setRoomphone("011111");
        roomImformation1.setDayCheckin(new Date());
        roomImformation1.setTyperoom(typeRoomRepository.findById(2));
        roomImformation1.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation1.setOlder(dataOlderRepository.findById(2));

        RoomInformation roomImformation2 = new RoomInformation();
        roomImformation2.setBuilding("1");
        roomImformation2.setFloor(1);
        roomImformation2.setRoomnumber("A101");
        roomImformation2.setRoomphone("011112");
        roomImformation2.setDayCheckin(new Date());
        roomImformation2.setTyperoom(typeRoomRepository.findById(1));
        roomImformation2.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation2.setOlder(dataOlderRepository.findById(1));
        try {
            entityManager.persist(roomImformation2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
    public void testphoneUniqe() {
        RoomInformation roomImformation1 = new RoomInformation();
        roomImformation1.setBuilding("1");
        roomImformation1.setFloor(1);
        roomImformation1.setRoomnumber("A101");
        roomImformation1.setRoomphone("011111");
        roomImformation1.setDayCheckin(new Date());
        roomImformation1.setTyperoom(typeRoomRepository.findById(2));
        roomImformation1.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation1.setOlder(dataOlderRepository.findById(2));

        RoomInformation roomImformation2 = new RoomInformation();
        roomImformation2.setBuilding("1");
        roomImformation2.setFloor(1);
        roomImformation2.setRoomnumber("A102");
        roomImformation2.setRoomphone("011111");
        roomImformation2.setDayCheckin(new Date());
        roomImformation2.setTyperoom(typeRoomRepository.findById(1));
        roomImformation2.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation2.setOlder(dataOlderRepository.findById(1));
        try {
            entityManager.persist(roomImformation2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
    public void testRoomTrue() {
        RoomInformation roomImformation2 = new RoomInformation();
        roomImformation2.setBuilding("1");
        roomImformation2.setFloor(1);
        roomImformation2.setRoomnumber("A102");
        roomImformation2.setRoomphone("011111");
        roomImformation2.setDayCheckin(new Date());
        roomImformation2.setTyperoom(typeRoomRepository.findById(1));
        roomImformation2.setRoomstatus(roomStatusRepository.findById(2));
        roomImformation2.setOlder(dataOlderRepository.findById(1));
        try {
            entityManager.persist(roomImformation2);
            entityManager.flush();
        } catch(javax.persistence.PersistenceException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
//    --------------------------  RoomInformationTest-END  --------------//


}
