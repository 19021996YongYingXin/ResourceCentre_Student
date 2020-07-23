import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void addChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		//WinnieYong
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
			
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addChromebook(chromebookList, cb1);		
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
				
		//The item just added is as same as the first item of the list
		assertSame("Test that Chromebook is added", cb1, chromebookList.get(0));
				
		//Add another item. test The size of the list is 2?
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
		assertSame("Test that Chromebook is added", cb2, chromebookList.get(1));
	}
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {
		//fail("Not yet implemented");
		// write your code here | done
		
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		
		String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = "";
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
		
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
		
		allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CB0011", "ASUS Chromebook", "Yes", "", "MacOS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CB0012", "HP Chromebook", "Yes", "", "Win 10");
	
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
	}

	@Test
	public void doLoanCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		
		//Test if camcorder 1 is available to loan
		boolean cam1Available = cc1.getIsAvailable();
		boolean available1 = true;
		assertEquals("Camcorder 1 is available to loan", available1, cam1Available);
		
		//Test if camcorder 1 is available to loan
		boolean cam2Available = cc2.getIsAvailable();
		boolean available2 = true;
		assertEquals("Camcorder 2 is available to loan", available2, cam2Available);
		
		//Given that camcorder 1 is available
		cc1.setIsAvailable(false);
		boolean cam1Loaned = cc1.getIsAvailable();
		boolean loaned1 = false;
		assertEquals("Camcorder 1 is now loaned", loaned1, cam1Loaned);
		
		//Given that camcorder 2 is available
		cc2.setIsAvailable(false);
		boolean cam2Loaned = cc2.getIsAvailable();
		boolean loaned2 = false;
		assertEquals("Camcorder 2 is now loaned", loaned2, cam2Loaned);
		
	}
	
	@Test
	public void doLoanChromebookTest() {
		//fail("Not yet implemented");
		// write your code here test 1
		
		//Test if chromebook 1 is available to loann
		boolean chrome1Available = cb1.getIsAvailable();
		boolean available1 = true;
		assertEquals("Camcorder 1 is available to loan", available1, chrome1Available);
		
		//Test if chromebook 1 is available to loan
		boolean chrome2Available = cb2.getIsAvailable();
		boolean available2 = true;
		assertEquals("Camcorder 2 is available to loan", available2, chrome2Available);
		
		//Given that chromebook 1 is availablee
		cb1.setIsAvailable(false);
		boolean chrome1Loaned = cb1.getIsAvailable();
		boolean loaned1 = false;
		assertEquals("Camcorder 1 is now loaned", loaned1, chrome1Loaned);
		
		//Given that chromebook 2 is available
		cb2.setIsAvailable(false);
		boolean chrome2Loaned = cb2.getIsAvailable();
		boolean loaned2 = false;
		assertEquals("Camcorder 2 is now loaned", loaned2, chrome2Loaned);
		
	}
	
	@Test
	public void doReturnCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		
	}
	@Test
	public void doReturnChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
