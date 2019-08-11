package TESTING_TESTS;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import BASE_CLASSES.Databases;
import BASE_CLASSES.HomePage;
import UTILITIES.Product;

public class testRunner {

	WebDriver dr;
	HomePage homepage;
	
	Databases dbpage;
	
	Logger log;

	
	String databaseLinkXp= "/html/body/table[5]/tbody/tr/td[1]/table[2]/tbody/tr[1]/td/a";
	
	@BeforeClass
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		dr= new ChromeDriver();
		
		dr.get("http://examples.codecharge.com/Store/Default.php");
	}
	
	
	public void create_log(String meth_name, String exp_res, String act_res, String test_res)
	{
		log=Logger.getLogger("devpinoyLogger");
		
		log.info("Method "+ meth_name+" is invoked \n"+"TC_TD: TESTING_TESTS.testRunner#"+meth_name+"\n Expected Result: "+exp_res+"\n Actual Result: "+act_res+"\n Test Result: "+test_res+"\n");

	}
	
	
	
	@Test(priority=1)
	public void verifySearchProds()
	{
		homepage= new HomePage(dr);
		
		String er= "Search Products";
		String ar=homepage.testSearchProducts();
		
		Assert.assertEquals(ar, er);
		
		this.create_log("verifySearchProds", er, ar, "PASS");
		
	}
	
	@Test(priority=2)
	public void verifyCategories()
	{
		String er= "Categories";
		String ar= homepage.testCategories();
		
		Assert.assertEquals(ar, er);
		
		this.create_log("verifyCategories", er, ar, "PASS");
		 
		WebDriverWait wt = new WebDriverWait(dr,10);                             
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(databaseLinkXp)));
		
		homepage.clickButton(databaseLinkXp);
		
		
	}
	
	
	@Test(priority=3)
	public void verifyNoOfProds()
	{
		dbpage= new Databases(dr);
		String er="5";
		
		String ar=dbpage.testNumberOfProds();
		
		Assert.assertEquals(ar, er);
		
		this.create_log("verifyNoOfProds", er, ar, "PASS");

	}
	
	
	@Test(priority=4)
	public void verifyProdsList()
	{
		ArrayList<Product> expResult= dbpage.getExpResList();
		ArrayList<Product> actualResult= dbpage.testProductsList();

		boolean flag=true;
		
		for(int i=0;i<actualResult.size();i++)
		{

			String a1=expResult.get(i).name;
			String a2=expResult.get(i).price;
			
			String b1= actualResult.get(i).name;
			String b2= actualResult.get(i).price;
			
			//String er=a1+a2;
			//String ar=b1+b2;
			
			//System.out.println(a1+","+b1);
			//System.out.println(a2+","+b2);
			
			
			if(a1.compareTo(b1)!=0 || a2.compareTo(b2)!=0)
			{
				flag=false;
			}
			
		}
		
		Assert.assertTrue(flag);
		
		for(int i=0;i<actualResult.size();i++)
		{

			String ename=expResult.get(i).name;
			String eprice=expResult.get(i).price;
			
			String aname= actualResult.get(i).name;
			String aprice= actualResult.get(i).price;
			
			this.create_log("verifyProdsList", ename+","+eprice, aname+","+aprice, "PASS");			
			
		}
		
		
		
		

		

	}
	

	
	
	
	
}
