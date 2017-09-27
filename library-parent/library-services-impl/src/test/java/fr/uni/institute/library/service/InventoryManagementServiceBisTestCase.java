package fr.uni.institute.library.service;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;
import java.util.Properties;

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
public class InventoryManagementServiceBisTestCase {

	private static InventoryManagementService service;
	private static int nombreCategories;
	private static Category categorieAttendue; 
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		System.out.println("-- Initialisation setUpClass de jeu de tests");
		System.out.println("Initialisation de jeu de tests");
		
		Properties prop = new Properties();
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		InputStream properties = new FileInputStream(rootPath+"/"+"db.properties");

		// load a properties file
		prop.load(properties);

		// get the property value and print it out
		System.out.println(prop.getProperty("db.driver"));
		System.out.println(prop.getProperty("db.username"));
		System.out.println(prop.getProperty("db.password"));
		Class.forName(prop.getProperty("db.driver"));
		Connection connection = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.username"),prop.getProperty("db.password"));
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
