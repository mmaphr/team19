package com.se.team19.server;

import com.se.team19.server.Entity.Visitor;
import com.se.team19.server.Repository.DataOlderRepository;
import com.se.team19.server.Repository.GenderRepository;
import com.se.team19.server.Repository.ProvinceRepository;
import com.se.team19.server.Repository.RelativesStatusRepository;
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
public class VisitorTest {
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private RelativesStatusRepository relativesStatusRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DataOlderRepository dataOlderRepository;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }



    //--------------------------  VisitorTest  --------------//
    //sprint2
    @Test
    public void testNameNull() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor(null);
        visitor.setNumIdVisitor("1128192731233");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
    public void testNumIdNull() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor(null);
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
    public void testAgelower() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(0);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
    public void testPhoneNull() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor(null);
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
    public void testDayNull() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(null);
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
    public void testTimeNull() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(null);
        visitor.setAddressVisitor("901/12 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
    public void testAddNull() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor(null);
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
    public void testGenderNull() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(null);
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
    public void testProvinceNull() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(null);
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
    public void testStatusNull() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(null);
        visitor.setOlders(dataOlderRepository.findById(3));
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
    public void testOlderNull() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(null);
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
    public void testVisitorNumIdisLonger() {
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("11281927312343");//ใส่เลขเกิน
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234579");
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("9891234579");//ไม่ขึ้นต้นด้วย0
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("08912345790");//ยาวเกิน
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
        Visitor visitor = new Visitor();
        visitor.setNameVisitor("นายสมใจ มีหม้อ");
        visitor.setNumIdVisitor("1128192731243");
        visitor.setAgeVisitor(34);
        visitor.setPhoneVisitor("0891234570");//ยาวเกิน
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setAddressVisitor("901 บ้านใหญ่");
        visitor.setGenders(genderRepository.findById(1));
        visitor.setProvince(provinceRepository.findById(65));
        visitor.setRelativesStatus(relativesStatusRepository.findById(1));
        visitor.setOlders(dataOlderRepository.findById(3));
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
