package com.se.team19.server;


import com.se.team19.server.Entity.BookAPlace;
import com.se.team19.server.Entity.Category;
import com.se.team19.server.Entity.Stock;

import com.se.team19.server.Repository.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookAPlaceTest {
    @Autowired
    private BookAPlaceRopository bookAPlaceRopository;
    @Autowired
    private OutActivityRepository outActivityRepository;
    @Autowired
    private  PlaceTyRepository placeTyRepository;
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
        BookAPlace p = new BookAPlace();
        p.setCardid("1199900643611");
        p.setNameCaretaker("นายสมพร สีทา");
        p.setPhonCaretaker("0234569871");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานกีฬาผ่อนคาย");
        p.setOutActivity(outActivityRepository.findById(3));
        p.setPlaceTy(placeTyRepository.findById(1));
        try {
            entityManager.persist(p);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCardNull() {
        BookAPlace p = new BookAPlace();
        p.setCardid(null);
        p.setNameCaretaker("นายสมพร");
        p.setPhonCaretaker("0123789456");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานกีฬาผ่อนคาย");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testCardNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
    @Test
    public void testCardPattenHChat() {
        BookAPlace p = new BookAPlace();
        p.setCardid("119990064361A");
        p.setNameCaretaker("นายสมพร สีทา");
        p.setPhonCaretaker("0123789456");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานกีฬาผ่อนคาย");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testCardPattenHChat Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
    @Test
    public void testNameCareNotNull() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1199900643611");
        p.setNameCaretaker(null);
        p.setPhonCaretaker("0123789456");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานกีฬาผ่อนคาย");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testNameCareNotNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }

    @Test
    public void testNameCarePat() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1199900643611");
        p.setNameCaretaker("นายสมพร อิน+จัน*ทร์");
        p.setPhonCaretaker("0123789456");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานกีฬาผ่อนคาย");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testNameCarePat Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }

    @Test
    public void testPhonNull() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1133226655447");
        p.setNameCaretaker("นายสมพร อินจันทร์");
        p.setPhonCaretaker(null);
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานกีฬาผ่อนคาย");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testPhonNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
    @Test
    public void testPhonSize() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1199900643611");
        p.setNameCaretaker("นายสมพร อินจันทร์");
        p.setPhonCaretaker("A12345678");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานกีฬาผ่อนคาย");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testPhonSize Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
    @Test
    public void testNamePlaceNull() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1199900643611");
        p.setNameCaretaker("นายสมพร อินจันทร์");
        p.setPhonCaretaker("0123456789");
        p.setNamePlace(null);
        p.setDescriptionPlace("งานกีฬาผ่อนคาย");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testNamePlaceNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
    @Test
    public void testNamePlacePat() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1133226655447");
        p.setNameCaretaker("นายสมพร อินจันทร์");
        p.setPhonCaretaker("0123456789");
        p.setNamePlace("สนาม+หญ้า");
        p.setDescriptionPlace("งานกีฬาผ่อนคาย");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testPhonNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }

    @Test
    public void testSizeDesMin() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1133226655447");
        p.setNameCaretaker("นายสมพร อินจันทร์");
        p.setPhonCaretaker("0123456789");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งาน");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testSizeDesMin Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
    @Test
    public void testSizeDesMax() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1133226655447");
        p.setNameCaretaker("นายสมพร อินจันทร์");
        p.setPhonCaretaker("0123456789");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานดนตรีกลางแจ้งจัดเพื่อให้ผู้สูงอายุได้ฟังเพลงผ่อนคลายมากที่สุดและยังเป็นการทำกิจกรรมที่เเรียกส่าการทำประฝดยขน์ให้แก่สังคมการทำอย่างนี้เป็นสิ่งที่ดีทั้งสำหรับคนที่ให้และก็สำหรับคนที่ได้รับด้วยเช่นกัน");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testSizeDesMax Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
    @Test
    public void testDesPat() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1133226655447");
        p.setNameCaretaker("นายสมพร อินจันทร์");
        p.setPhonCaretaker("0123456789");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานดน++**ตรีกลางแจ้งจัดเพื่อให้ผู้สูงอายุได้ฟังเพลงผ่อนคลายมากที่สุดและยังเป็นการทำกิจ");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testDesPat Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
    @Test
    public void testDesNull() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1133226655447");
        p.setNameCaretaker("นายสมพร อินจันทร์");
        p.setPhonCaretaker("0123456789");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace(null);
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testDesNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
    @Test
    public void testCardIdUniqe() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1133226655447");
        p.setNameCaretaker("นายสมพร อิน");
        p.setPhonCaretaker("0123456689");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานดนตรีกลางแจ้งจัดเพื่อให้ผู้สูงอายุได้ฟังเพลงผ่อนคลายมากที่สุดและยังเป็นการทำกิจ");
        p.setOutActivity(outActivityRepository.findById(2));
        p.setPlaceTy(placeTyRepository.findById(2));

        BookAPlace p1 = new BookAPlace();
        p1.setCardid("1133226655447");
        p1.setNameCaretaker("นายสมพร อินจันทร์");
        p1.setPhonCaretaker("0123456789");
        p1.setNamePlace("สนามหญ้า");
        p1.setDescriptionPlace("งานดน++**ตรีกลางแจ้งจัดเพื่อให้ผู้สูงอายุได้ฟังเพลงผ่อนคลายมากที่สุดและยังเป็นการทำกิจ");
        p1.setOutActivity(outActivityRepository.findById(1));
        p1.setPlaceTy(placeTyRepository.findById(1));
        try {
            entityManager.persist(p1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testCardIdUniqe Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
      @Test
    public void testActivityNull() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1133226655447");
        p.setNameCaretaker("นายสมพร อินจันทร์");
        p.setPhonCaretaker("0123456789");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานดนตรีกลางแจ้งจัดเพื่อให้ผู้สูงอายุได้ฟังเพลงผ่อนคลายมากที่สุดและยังเป็นการทำกิจ");
        p.setOutActivity(null);
        p.setPlaceTy(placeTyRepository.findById(1));

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= testActivityNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }
    @Test
    public void tesPlaceTyNull() {
        BookAPlace p = new BookAPlace();
        p.setCardid("1133226655447");
        p.setNameCaretaker("นายสมพร อินจันทร์");
        p.setPhonCaretaker("0123456789");
        p.setNamePlace("สนามหญ้า");
        p.setDescriptionPlace("งานดนตรีกลางแจ้งจัดเพื่อให้ผู้สูงอายุได้ฟังเพลงผ่อนคลายมากที่สุดและยังเป็นการทำกิจ");
        p.setOutActivity(outActivityRepository.findById(1));
        p.setPlaceTy(null);

        try {
            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================================= tesPlaceTyNull Test =========================================================");
            System.out.println(e);
            System.out.println("===========================================================================================================================================");
            e.printStackTrace();
            System.out.println("===========================================================================================================================================");        }
    }

}
