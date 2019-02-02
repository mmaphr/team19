package com.se.team19.server;

import org.junit.runner.RunWith;
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
import com.se.team19.server.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.se.team19.server.Repository.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServerApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Autowired
	private RoomInformationRepository roomInformationRepository;
	@Autowired
	private RoomStatusRepository roomStatusRepository;
	@Autowired
	private TypeRoomRepository typeRoomRepository;
	@Autowired
	private GenderRepository genderRepository;
	@Autowired
	private RelativesStatusRepository relativesStatusRepository;
	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private VisitorRepository visitorRepository;
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
	public void testRoomNumcannotBeNull() {
		RoomInformation	room1 = new RoomInformation();
		room1.setRoomnumber(null);room1.setRoomstatus(roomStatusRepository.findById(1));room1.setTyperoom(typeRoomRepository.findById(1));
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
		RoomInformation	room1 = new RoomInformation();
		room1.setRoomnumber("A1023");room1.setRoomstatus(roomStatusRepository.findById(1));room1.setTyperoom(typeRoomRepository.findById(1));
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
		RoomInformation	room1 = new RoomInformation();
		room1.setRoomnumber("1023");room1.setRoomstatus(roomStatusRepository.findById(1));room1.setTyperoom(typeRoomRepository.findById(1));
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
	public void testRoomTrue() {
		RoomInformation	room1 = new RoomInformation();
		room1.setRoomnumber("A120");room1.setRoomstatus(roomStatusRepository.findById(1));room1.setTyperoom(typeRoomRepository.findById(1));
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
	//--------------------------  VisitorTest  --------------//
	//sprint2
	@Test
	public void testVisitorNumIdisLonger() {
		Visitor	visitor = new Visitor();
		visitor.setNameVisitor("นายสมใจ มีหม้อ");
		visitor.setNumIdVisitor("11281927312343");//ใส่เลขเกิน
		visitor.setAgeVisitor(34);visitor.setPhoneVisitor("0891234579");visitor.setDayVisitor(new Date());visitor.setTimeVisitor(new Date());
		visitor.setAddressVisitor("901 บ้านใหญ่");visitor.setGenders(genderRepository.findById(1));visitor.setProvince(provinceRepository.findById(65));visitor.setRelativesStatus(relativesStatusRepository.findById(1));visitor.setOlders(dataOlderRepository.findById(3));
		try {
			entityManager.persist(visitor);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
	@Test
	public void testVisitorphoneFirstisnot0() {
		Visitor	visitor = new Visitor();
		visitor.setNameVisitor("นายสมใจ มีหม้อ");visitor.setNumIdVisitor("1128192731243");visitor.setAgeVisitor(34);
		visitor.setPhoneVisitor("9891234579");//ไม่ขึ้นต้นด้วย0
		visitor.setDayVisitor(new Date());visitor.setTimeVisitor(new Date());visitor.setAddressVisitor("901 บ้านใหญ่");
		visitor.setGenders(genderRepository.findById(1));visitor.setProvince(provinceRepository.findById(65));visitor.setRelativesStatus(relativesStatusRepository.findById(1));visitor.setOlders(dataOlderRepository.findById(3));
		try {
			entityManager.persist(visitor);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
	@Test
	public void testVisitorphoneisLonger() {
		Visitor	visitor = new Visitor();
		visitor.setNameVisitor("นายสมใจ มีหม้อ");visitor.setNumIdVisitor("1128192731243");visitor.setAgeVisitor(34);
		visitor.setPhoneVisitor("08912345790");//ยาวเกิน
		visitor.setDayVisitor(new Date());visitor.setTimeVisitor(new Date());visitor.setAddressVisitor("901 บ้านใหญ่");visitor.setGenders(genderRepository.findById(1));
		visitor.setProvince(provinceRepository.findById(65));visitor.setRelativesStatus(relativesStatusRepository.findById(1));visitor.setOlders(dataOlderRepository.findById(3));
		try {
			entityManager.persist(visitor);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
	@Test
	public void testVisitortrue() {
		Visitor	visitor = new Visitor();visitor.setNameVisitor("นายสมใจ มีหม้อ");visitor.setNumIdVisitor("1128192731243");visitor.setAgeVisitor(34);
		visitor.setPhoneVisitor("0891234570");//ยาวเกิน
		visitor.setDayVisitor(new Date());visitor.setTimeVisitor(new Date());visitor.setAddressVisitor("901 บ้านใหญ่");visitor.setGenders(genderRepository.findById(1));
		visitor.setProvince(provinceRepository.findById(65));visitor.setRelativesStatus(relativesStatusRepository.findById(1));visitor.setOlders(dataOlderRepository.findById(3));
		try {
			entityManager.persist(visitor);
			entityManager.flush();
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
	//--------------------------  VisitorTest - END  --------------//
}

