package com.se.team19.server;

import com.se.team19.server.Entity.Category;
import com.se.team19.server.Entity.Stock;
import com.se.team19.server.Repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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
public class StockTests {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;
	private Category category;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		Category categorysave = new Category();
		categorysave.setCategoryName("TestCategory");
		entityManager.persist(categorysave);
		entityManager.flush();

		category = categoryRepository.findBycategoryName("TestCategory");
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

	//<!!========== Success ==========!!>//
	@Test
	public void testStockDataSuccess() {
		Stock stock = new Stock();
		stock.setAmountTotal(1000l);
		stock.setProductName("Drug");
		stock.setCategoryName(category);
		try {
			entityManager.persist(stock);
			entityManager.flush();

		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 0);
		}
	}
	//<!!========== Notnull ==========!!>//
	//<!!========== StockAmount ==========!!>//
	@Test
	public void testStockAmountTotalCannotBeNull() {
		Stock stock = new Stock();
		stock.setAmountTotal(null);
		stock.setProductName("Drug");
		stock.setCategoryName(category);
		try {
			entityManager.persist(stock);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("================================================");
			System.out.println("<!!=========== StockAmountNotnull ===========!!>");
			System.out.println(e);
			System.out.println("================================================");
			System.out.println("================================================");
		}
	}

	//<!!========== ProductName ==========!!>//
	@Test
	public void testProductNameCannotBeNull() {
		Stock stock = new Stock();
		stock.setAmountTotal(1000l);
		stock.setProductName(null);
		stock.setCategoryName(category);
		try {
			entityManager.persist(stock);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("================================================");
			System.out.println("<!!=========== ProductNameNotnull ===========!!>");
			System.out.println(e);
			System.out.println("===============================================");
			System.out.println("===============================================");
		}
	}

	//<!!========== StockCategoryName ==========!!>//
	@Test
	public void testStockCategoryNameCannotBeNull() {
		Stock stock = new Stock();
		stock.setAmountTotal(1000l);
		stock.setProductName("Drug");
		stock.setCategoryName(null);
		try {
			entityManager.persist(stock);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("======================================================");
			System.out.println("<!!=========== StockCategoryNameNotnull ===========!!>");
			System.out.println(e);
			System.out.println("=====================================================");
			System.out.println("=====================================================");
		}
	}

	//<!!========== StockPattern ==========!!>//
	@Test
	public void testStockPattern() {
		Stock stock = new Stock();
		stock.setAmountTotal(1000l);
		stock.setProductName("drug");
		stock.setCategoryName(category);
		try {
			entityManager.persist(stock);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("==========================================");
			System.out.println("<!!=========== StockPattern ===========!!>");
			System.out.println(e);
			System.out.println("==========================================");
			System.out.println("==========================================");
		}
	}

	//<!!========== StockMinSize ==========!!>//
	@Test
	public void testStockMinSize() {
		Stock stock = new Stock();
		stock.setAmountTotal(1000l);
		stock.setProductName("Dru");
		stock.setCategoryName(category);
		try {
			entityManager.persist(stock);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("==========================================");
			System.out.println("<!!=========== StockMinSize ===========!!>");
			System.out.println(e);
			System.out.println("==========================================");
			System.out.println("==========================================");
		}
	}

	//<!!========== StockMaxSize ==========!!>//
	@Test
	public void testStockMaxSize() {
		Stock stock = new Stock();
		stock.setAmountTotal(1000l);
		stock.setProductName("Drug drug drug drug drug drug drug drug");
		stock.setCategoryName(category);
		try {
			entityManager.persist(stock);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("==========================================");
			System.out.println("<!!=========== StockMaxSize ===========!!>");
			System.out.println(e);
			System.out.println("==========================================");
			System.out.println("==========================================");
		}
	}

	//<!!========== Unique ==========!!>//
	@Test
	public void testStockDataUnique() {
		Stock stock = new Stock();
		stock.setAmountTotal(1000l);
		stock.setProductName("Drug");
		stock.setCategoryName(category);
		entityManager.persist(stock);

		Stock stock1 = new Stock();
		stock1.setAmountTotal(1000l);
		stock1.setProductName("Drug");
		stock1.setCategoryName(category);
		try {
			entityManager.persist(stock1);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("===========================================");
			System.out.println("<!!========== StockDataUnique ==========!!>");
			System.out.println(e);
			System.out.println("===========================================");
			System.out.println("===========================================");
		} catch (javax.persistence.PersistenceException e){
			System.out.println("===========================================");
			System.out.println("<!!========== StockDataUnique ==========!!>");
			System.out.println("<!!============= Unique Column =========!!>");
			System.out.println(e);
			System.out.println("===========================================");
			System.out.println("===========================================");
		}
	}
}

