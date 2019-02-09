package com.se.team19.server;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class AddProductTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    private Stock stock1;
    private Category category;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private Staff staff;
    private Note note;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        Category categorysave = new Category();
        categorysave.setCategoryName("TestCategory");
        entityManager.persist(categorysave);
        entityManager.flush();

        Note notesave = new Note();
        notesave.setNoteName("TestNote");
        entityManager.persist(notesave);
        entityManager.flush();

        Stock stock = new Stock();
        stock.setProductName("Drug");
        stock.setAmountTotal(1000l);
        stock.setCategoryName(categoryRepository.findBycategoryName("TestCategory"));
        entityManager.persist(stock);
        entityManager.flush();
        category = categoryRepository.findBycategoryName("TestCategory");
        stock1 = stockRepository.findByCategoryNameAndProductName(category,"Drug");
        staff = staffRepository.findByUsernameAndPassword("SomA","123456");
        note = noteRepository.findBynoteName("TestNote");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    //=========================================================================================//
    //====+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++====//
    //=========================================================================================//
    //====#################################### Sprint1 ####################################====//
    //=========================================================================================//
    //====+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++====//
    //=========================================================================================//
    /////////////////////////////////////////////////////////////////////////////////////////////

    //Run = mvnw -Dtest=AddProductTest test
    //<!!========== Success ==========!!>//
    @Test
    public void testAddProductsDataSuccess() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName("Drug");
        addProducts.setAddAmount(10l);
        addProducts.setNoteName(note);
        addProducts.setCategoryName(category);
        addProducts.setStaffName(staff);
        addProducts.setStockName(stock1);
        try {
            addProducts.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            entityManager.persist(addProducts);
            entityManager.flush();

        } catch (ParseException e) {
            //Exception date
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }

    //<!!========== Notnull ==========!!>//
    //<!!========== AddProductName ==========!!>//
    @Test
    public void testAddProductNameCannotBeNull() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName(null);
        addProducts.setAddAmount(10l);
        addProducts.setNoteName(note);
        addProducts.setCategoryName(category);
        addProducts.setStaffName(staff);
        addProducts.setStockName(stock1);
        try {
            addProducts.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            entityManager.persist(addProducts);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (ParseException e) {
            //Exception date
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("===================================================");
            System.out.println("<!!=========== AddProductNameNotnull ===========!!>");
            System.out.println(e);
            System.out.println("===================================================");
            System.out.println("===================================================");
        }
    }

    //<!!========== AddAmount ==========!!>//
    @Test
    public void testAddAmountCannotBeNull() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName("Drug");
        addProducts.setAddAmount(null);
        addProducts.setNoteName(note);
        addProducts.setCategoryName(category);
        addProducts.setStaffName(staff);
        addProducts.setStockName(stock1);
        try {
            addProducts.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            entityManager.persist(addProducts);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (ParseException e) {
            //Exception date
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==============================================");
            System.out.println("<!!=========== AddAmountNotnull ===========!!>");
            System.out.println(e);
            System.out.println("==============================================");
            System.out.println("==============================================");
        }
    }

    //<!!========== NoteName ==========!!>//
    @Test
    public void testNoteNameCannotBeNull() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName("Drug");
        addProducts.setAddAmount(10l);
        addProducts.setNoteName(null);
        addProducts.setCategoryName(category);
        addProducts.setStaffName(staff);
        addProducts.setStockName(stock1);
        try {
            addProducts.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            entityManager.persist(addProducts);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (ParseException e) {
            //Exception date
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=============================================");
            System.out.println("<!!=========== NoteNameNotnull ===========!!>");
            System.out.println(e);
            System.out.println("=============================================");
            System.out.println("=============================================");
        }
    }

    //<!!========== CategoryName ==========!!>//
    @Test
    public void testCategoryNameCannotBeNull() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName("Drug");
        addProducts.setAddAmount(10l);
        addProducts.setNoteName(note);
        addProducts.setCategoryName(null);
        addProducts.setStaffName(staff);
        addProducts.setStockName(stock1);
        try {
            addProducts.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            entityManager.persist(addProducts);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (ParseException e) {
            //Exception date
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("=================================================");
            System.out.println("<!!=========== CategoryNameNotnull ===========!!>");
            System.out.println(e);
            System.out.println("=================================================");
            System.out.println("=================================================");
        }
    }

    //<!!========== StockName ==========!!>//
    @Test
    public void testStockNameCannotBeNull() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName("Drug");
        addProducts.setAddAmount(10l);
        addProducts.setNoteName(note);
        addProducts.setCategoryName(category);
        addProducts.setStaffName(staff);
        addProducts.setStockName(null);
        try {
            addProducts.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            entityManager.persist(addProducts);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (ParseException e) {
            //Exception date
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==============================================");
            System.out.println("<!!=========== StockNameNotnull ===========!!>");
            System.out.println(e);
            System.out.println("==============================================");
            System.out.println("==============================================");
        }
    }

    //<!!========== AddDate ==========!!>//
    @Test
    public void testAddDateCannotBeNull() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName("Drug");
        addProducts.setAddAmount(10l);
        addProducts.setNoteName(note);
        addProducts.setCategoryName(category);
        addProducts.setStaffName(staff);
        addProducts.setStockName(stock1);
        try {
            addProducts.setAddDate(null);
            entityManager.persist(addProducts);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("============================================");
            System.out.println("<!!=========== AddDateNotnull ===========!!>");
            System.out.println(e);
            System.out.println("============================================");
            System.out.println("============================================");
        }
    }

    //<!!========== AddProductPattern ==========!!>//
    @Test
    public void testAddProductPattern() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName("drug");
        addProducts.setAddAmount(10l);
        addProducts.setNoteName(note);
        addProducts.setCategoryName(category);
        addProducts.setStaffName(staff);
        addProducts.setStockName(stock1);
        try {
            addProducts.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            entityManager.persist(addProducts);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (ParseException e) {
            //Exception date
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("===============================================");
            System.out.println("<!!=========== AddProductPattern ===========!!>");
            System.out.println(e);
            System.out.println("===============================================");
            System.out.println("===============================================");
        }
    }

    //<!!========== AddProductMinSize ==========!!>//
    @Test
    public void testAddProductMinSize() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName("Dr");
        addProducts.setAddAmount(10l);
        addProducts.setNoteName(note);
        addProducts.setCategoryName(category);
        addProducts.setStaffName(staff);
        addProducts.setStockName(stock1);
        try {
            addProducts.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            entityManager.persist(addProducts);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (ParseException e) {
            //Exception date
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("===============================================");
            System.out.println("<!!=========== AddProductMinSize ===========!!>");
            System.out.println(e);
            System.out.println("===============================================");
            System.out.println("===============================================");
        }
    }

    //<!!========== AddProductMaxSize ==========!!>//
    @Test
    public void testAddProductMaxSize() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName("Drug Drug Drug Drug Drug Drug Drug Drug Drug");
        addProducts.setAddAmount(10l);
        addProducts.setNoteName(note);
        addProducts.setCategoryName(category);
        addProducts.setStaffName(staff);
        addProducts.setStockName(stock1);
        try {
            addProducts.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            entityManager.persist(addProducts);
            entityManager.flush();

            fail("Should not pass to this line");
        }catch (ParseException e) {
            //Exception date
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("===============================================");
            System.out.println("<!!=========== AddProductMaxSize ===========!!>");
            System.out.println(e);
            System.out.println("===============================================");
            System.out.println("===============================================");
        }
    }
    //<!!========== Unique ==========!!>//
    @Test
    public void testAddProductDataUnique() {
        AddProducts addProducts = new AddProducts();
        addProducts.setAddProductName("Drug");
        addProducts.setAddAmount(10l);
        addProducts.setNoteName(note);
        addProducts.setCategoryName(category);
        addProducts.setStaffName(staff);
        addProducts.setStockName(stock1);
        entityManager.persist(addProducts);

        AddProducts addProducts1 = new AddProducts();
        addProducts1.setAddProductName("Drug");
        addProducts1.setAddAmount(10l);
        addProducts1.setNoteName(note);
        addProducts1.setCategoryName(category);
        addProducts1.setStaffName(staff);
        addProducts1.setStockName(stock1);
        try {
            addProducts.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            addProducts1.setAddDate(formatter.parse("19.11.2019 00:00:00"));
            entityManager.persist(addProducts1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (ParseException e) {
            //Exception date
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("================================================");
            System.out.println("<!!=========== WithdrawDataUnique ===========!!>");
            System.out.println(e);
            System.out.println("================================================");
            System.out.println("================================================");
        } catch (javax.persistence.PersistenceException e){
            System.out.println("================================================");
            System.out.println("<!!========== AddProductDataUnique ==========!!>");
            System.out.println("<!!============== Unique Column =============!!>");
            System.out.println(e);
            System.out.println("================================================");
            System.out.println("================================================");
        }
    }
}

