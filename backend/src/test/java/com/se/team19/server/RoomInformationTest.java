package com.se.team19.server;

import com.se.team19.server.Entity.RoomInformation;
import com.se.team19.server.Repository.RoomStatusRepository;
import com.se.team19.server.Repository.TypeRoomRepository;
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
public class RoomInformationTest {
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Autowired
    private RoomStatusRepository roomStatusRepository;
    @Autowired
    private TypeRoomRepository typeRoomRepository;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    //--------------------------  RoomInformationTest  --------------//
    //Sprint1
    @Test
    public void testRoomNumcannotBeNull() {
        RoomInformation room1 = new RoomInformation();
        room1.setRoomnumber(null);
        room1.setRoomstatus(roomStatusRepository.findById(1));
        room1.setTyperoom(typeRoomRepository.findById(1));
        try {
            entityManager.persist(room1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testStatusNull() {
        RoomInformation room1 = new RoomInformation();
        room1.setRoomnumber("A101");
        room1.setRoomstatus(null);
        room1.setTyperoom(typeRoomRepository.findById(1));
        try {
            entityManager.persist(room1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }@Test
    public void testtypeNull() {
        RoomInformation room1 = new RoomInformation();
        room1.setRoomnumber("A101");
        room1.setRoomstatus(roomStatusRepository.findById(1));
        room1.setTyperoom(null);
        try {
            entityManager.persist(room1);
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
        RoomInformation room1 = new RoomInformation();
        room1.setRoomnumber("A1023")
        ;room1.setRoomstatus(roomStatusRepository.findById(1));
        room1.setTyperoom(typeRoomRepository.findById(1));
        try {
            entityManager.persist(room1);
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
        RoomInformation room1 = new RoomInformation();
        room1.setRoomnumber("1023");
        room1.setRoomstatus(roomStatusRepository.findById(1));
        room1.setTyperoom(typeRoomRepository.findById(1));
        try {
            entityManager.persist(room1);
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
        RoomInformation room1 = new RoomInformation();
        room1.setRoomnumber("A101");
        room1.setRoomstatus(roomStatusRepository.findById(1));
        room1.setTyperoom(typeRoomRepository.findById(1));

        RoomInformation room2 = new RoomInformation();
        room2.setRoomnumber("A101");
        room2.setRoomstatus(roomStatusRepository.findById(2));
        room2.setTyperoom(typeRoomRepository.findById(2));
        try {
            entityManager.persist(room2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {

            System.out.println("========================================================= testCardIdUniqe Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");
            }
    }
    @Test
    public void testRoomTrue() {
        RoomInformation room1 = new RoomInformation();
        room1.setRoomnumber("A120");
        room1.setRoomstatus(roomStatusRepository.findById(1));
        room1.setTyperoom(typeRoomRepository.findById(1));
        try {
            entityManager.persist(room1);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //--------------------------  RoomInformationTest-END  --------------//


}
