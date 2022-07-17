package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("turbo");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("ganesh");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("murugan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("gan");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("muru");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ganram213@gmail.com");
		WebElement dropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));

		Select select = new Select(dropdown);
		select.selectByVisibleText("Texas");

		driver.findElement(By.className("smallSubmit")).click();

		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("View Lead | opentaps CRM"))
			System.out.println("success");

		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("turbo1");

		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("ganesh");
		driver.findElement(By.className("smallSubmit")).click();

		title = driver.getTitle();

		if(title.equals("View Lead | opentaps CRM"))
			System.out.println("changes made successfully");

		// TODO Auto-generated method stub

	}

}
