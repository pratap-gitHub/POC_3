package BASE_CLASSES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	
WebDriver dr;
	
	//By profile_xp= By.xpath("//*[@id=\"u_0_a\"]/div[1]/div/a/span/span");
	By searchProduct= By.xpath("/html/body/table[5]/tbody/tr/td[1]/form/table[1]/tbody/tr/th");
	By cat=By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[1]/tbody/tr/th");
	
	By databaseLink= By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[2]/tbody/tr[1]/td/a");
	By htmlLink= By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[2]/tbody/tr[2]/td/a");
	By prog= By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[2]/tbody/tr[3]/td/a");
	
	
	
	
	public HomePage(WebDriver dr)
	{
		this.dr= dr;
		
		
		
	}
	
	public String testSearchProducts()
	{
		String ar= dr.findElement(searchProduct).getText();
		
		return ar;
	}
	
	public String testCategories()
	{
		
		String ar= dr.findElement(cat).getText();
		
		return ar;
		
		
	}
	
	public void clickButton(String xp)
	{
		
		dr.findElement(By.xpath(xp)).click();
		
		
	}


}
