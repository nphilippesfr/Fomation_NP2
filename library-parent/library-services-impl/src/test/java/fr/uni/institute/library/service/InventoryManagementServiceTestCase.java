package fr.uni.institute.library.service;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.uni.institute.library.business.inventory.Category;
import fr.uni.institute.library.dao.jdbc.CategoryDaoJdbc;
import fr.uni.institute.library.service.impl.InventoryManagementServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryManagementServiceTestCase {

	private static InventoryManagementService service;
	private static int nombreCategories;
	private static Category categorieAttendue; 
	private static Logger logger = Logger.getLogger(InventoryManagementServiceTestCase.class) ;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		logger.debug("-- Initialisation setUpClass de jeu de tests");
		logger.info("Initialisation de jeu de tests");
		logger.debug("Chargement de Driver");
		Class.forName("com.mysql.jdbc.Driver");
		logger.debug("Creationn d'une connexion");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uni_library_db?autoReconnect=true", "root", "admin");
		service = new InventoryManagementServiceImpl();		
		service.setCategoryDao(new CategoryDaoJdbc(connection));
		nombreCategories = 9;
		//
		categorieAttendue = new Category(1, "Music");
	}
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("liberation de jeu de tests");
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		System.out.println("-- liberation  tearDownClass de jeu de tests");
	}

	@Test
	public final void test1GetCategoryById() {
		System.out.println("testGetCategoryById");
		
		try{
			Category resultat = service.getCategoryById(categorieAttendue.getId());
			assertNotNull(resultat);
			assertEquals(resultat.getName(), categorieAttendue.getName());	
		}catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public final void test2GetCategoryAll() {
		System.out.println("testGetCategoryAll");
		try{
			Collection categories = service.getAllCategories() ;
			assertNotNull(categories);
			assertEquals(nombreCategories, categories.size());	
		}catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	
	@Test(expected=ServiceException.class)
	public final void test3GetCategoryAllWithException() throws ServiceException {
		System.out.println("test3GetCategoryAllWithException");
		throw new ServiceException();
		
	}

}
