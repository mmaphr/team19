package com.se.team19.server;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.CategoryRepository;
import com.se.team19.server.Repository.DepartmentRepository;
import com.se.team19.server.Repository.StaffRepository;
import com.se.team19.server.Repository.StockRepository;
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
public class WithdrawTest {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;
	private Stock stock1;
	private Category category;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	private Staff staff;
	private Department department;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		Category categorysave = new Category();
		categorysave.setCategoryName("TestCategory");
		entityManager.persist(categorysave);
		entityManager.flush();

		Department departmentsave = new Department();
		departmentsave.setDepartmentName("TestDepartment");
		entityManager.persist(departmentsave);
		entityManager.flush();

		Stock stock = new Stock();
		stock.setProductName("Drug");
		stock.setAmountTotal(1000);
		stock.setCategoryName(categoryRepository.findBycategoryName("TestCategory"));
		entityManager.persist(stock);
		entityManager.flush();
		category = categoryRepository.findBycategoryName("TestCategory");
		stock1 = stockRepository.findByCategoryNameAndProductName(category,"Drug");
		staff = staffRepository.findByUsernameAndPassword("S0001","123456");
		department = departmentRepository.findByDepartmentName("TestDepartment");
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	//=========================================================================================//
	//====+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++====//
	//=========================================================================================//
	//====#################################### Sprint2 ####################################====//
	//=========================================================================================//
	//====+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++====//
	//=========================================================================================//
	/////////////////////////////////////////////////////////////////////////////////////////////

	//Run = mvnw -Dtest=WithdrawTest test
	//<!!========== Success ==========!!>//
	@Test
	public void testWithdrawDataSuccess() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("Test Case Sprint2");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
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
	//<!!========== WithdrawName ==========!!>//
	@Test
	public void testWithdrawNameCannotBeNull() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName(null);
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("Test Case Sprint2");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		}catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("=================================================");
			System.out.println("<!!=========== WithdrawNameNotnull ===========!!>");
			System.out.println(e);
			System.out.println("=================================================");
			System.out.println("=================================================");
		}
	}

	//<!!========== WithdrawAmount ==========!!>//
	@Test
	public void testWithdrawAmountCannotBeNull() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(0);
		withdraw.setWithdrawDescrition("Test Case Sprint2");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		}catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("=================================================");
			System.out.println("<!!========== WithdrawAmountNotnull ==========!!>");
			System.out.println(e);
			System.out.println("=================================================");
			System.out.println("=================================================");
		}
	}

	//<!!========== WithdrawDescrition ==========!!>//
	@Test
	public void testWithdrawDescritionCannotBeNull() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition(null);
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		}catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("=====================================================");
			System.out.println("<!!========== WithdrawDescritionNotnull ==========!!>");
			System.out.println(e);
			System.out.println("=====================================================");
			System.out.println("=====================================================");
		}
	}

	//<!!========== WithdrawDepartmentName ==========!!>//
	@Test
	public void testWithdrawDepartmentNameCannotBeNull() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("Test Case Sprint2");
		withdraw.setDepartmentName(null);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		}catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("=========================================================");
			System.out.println("<!!========== WithdrawDepartmentNameNotnull ==========!!>");
			System.out.println(e);
			System.out.println("=========================================================");
			System.out.println("=========================================================");
		}
	}

	//<!!========== WithdrawCategoryName ==========!!>//
	@Test
	public void testWithdrawCategoryNameCannotBeNull() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("Test Case Sprint2");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(null);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		}catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("=======================================================");
			System.out.println("<!!========== WithdrawCategoryNameNotnull ==========!!>");
			System.out.println(e);
			System.out.println("======================================================");
			System.out.println("======================================================");
		}
	}

	//<!!========== WithdrawStaffName ==========!!>//
	@Test
	public void testWithdrawStaffNameCannotBeNull() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("Test Case Sprint2");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(null);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		}catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("====================================================");
			System.out.println("<!!========== WithdrawStaffNameNotnull ==========!!>");
			System.out.println(e);
			System.out.println("====================================================");
			System.out.println("====================================================");
		}
	}

	//<!!========== WithdrawStockName ==========!!>//
	@Test
	public void testWithdrawStockNameCannotBeNull() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("Test Case Sprint2");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(null);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		}catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("====================================================");
			System.out.println("<!!========== WithdrawStockNameNotnull ==========!!>");
			System.out.println(e);
			System.out.println("====================================================");
			System.out.println("====================================================");
		}
	}

	//<!!========== WithdrawDate ==========!!>//
	@Test
	public void testWithdrawDateCannotBeNull() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("Test Case Sprint2");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(null);
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("===============================================");
			System.out.println("<!!========== WithdrawDateNotnull ==========!!>");
			System.out.println(e);
			System.out.println("===============================================");
			System.out.println("===============================================");
		}
	}

	//<!!========== WithdrawPattern ==========!!>//
	@Test
	public void testWithdrawPattern() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("test Case Sprint2");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		}catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("===========================================");
			System.out.println("<!!========== WithdrawPattern ==========!!>");
			System.out.println(e);
			System.out.println("===========================================");
			System.out.println("===========================================");
		}
	}

	//<!!========== WithdrawMinSize ==========!!>//
	@Test
	public void testWithdrawDescritionMinSize() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("Test");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		}catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("===========================================");
			System.out.println("<!!========== WithdrawMinSize ==========!!>");
			System.out.println(e);
			System.out.println("===========================================");
			System.out.println("===========================================");
		}
	}

	//<!!========== WithdrawMaxSize ==========!!>//
	@Test
	public void testWithdrawDescritionMaXSize() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("Test Case Sprint2 Test Case Sprint2 Test Case Sprint2 Test Case Sprint2 Test Case Sprint2");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw);
			entityManager.flush();

			fail("Should not pass to this line");
		}catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("===========================================");
			System.out.println("<!!========== WithdrawMaxSize ==========!!>");
			System.out.println(e);
			System.out.println("===========================================");
			System.out.println("===========================================");
		}
	}

	//<!!========== Unique ==========!!>//
	@Test
	public void testWithdrawDataUnique() {
		Withdraw withdraw = new Withdraw();
		withdraw.setWithdrawName("Drug");
		withdraw.setWithdrawAmount(10);
		withdraw.setWithdrawDescrition("Test Case Sprint2");
		withdraw.setDepartmentName(department);
		withdraw.setCategoryName(category);
		withdraw.setStaffName(staff);
		withdraw.setStockName(stock1);
		entityManager.persist(withdraw);

		Withdraw withdraw1 = new Withdraw();
		withdraw1.setWithdrawName("Drug");
		withdraw1.setWithdrawAmount(10);
		withdraw1.setWithdrawDescrition("Test Case Sprint2");
		withdraw1.setDepartmentName(department);
		withdraw1.setCategoryName(category);
		withdraw1.setStaffName(staff);
		withdraw1.setStockName(stock1);

		try {
			withdraw.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			withdraw1.setWithdrawDate(formatter.parse("19.11.2019 00:00:00"));
			entityManager.persist(withdraw1);
			entityManager.flush();

		} catch (ParseException e) {
			//Exception date
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("==============================================");
			System.out.println("<!!========== WithdrawDataUnique ==========!!>");
			System.out.println(e);
			System.out.println("==============================================");
			System.out.println("==============================================");
		} catch (javax.persistence.PersistenceException e){
			System.out.println("==============================================");
			System.out.println("<!!========== WithdrawDataUnique ==========!!>");
			System.out.println("<!!============= Unique Column ============!!>");
			System.out.println(e);
			System.out.println("==============================================");
			System.out.println("==============================================");
		}
	}
}

