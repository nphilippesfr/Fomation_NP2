package fr.uni.institute.library.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



public class CategoryDaoTestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Initialisation des ressource - Avant tous les tests");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Initialisation des ressource - Après tous les tests");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisation des ressource - Avant chaque test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Initialisation des ressource - après chaque test");
	}

	@Test
	public void testResearchAllCategories() {
		System.out.println("testResearchAllCategories");
		//fail("Not yet implemented");
		assertTrue(true);
	}

	@Test
	public void testResearchCategoryById() {
		System.out.println("testResearchCategoryById");
		//fail("Not yet implemented");
	}

}
