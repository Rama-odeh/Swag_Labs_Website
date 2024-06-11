import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTheSystem {
	
	WebDriver driver = new ChromeDriver();
	
	@Test(priority=1)
	public void verifyTheLogin() {
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	
 }
	@Test(priority=2, enabled=false)
	public void verifyTheWordProductIsPresent() {
		
		WebElement WordProduct = driver.findElement(By.xpath("//span[@data-test='title']"));
		boolean ExpectedWord = true;
		boolean ActualWord = WordProduct.isDisplayed();
		Assert.assertEquals(ActualWord, ExpectedWord);
		
	}
	
	@Test(priority=3, enabled=false)
	public void verifycTheLatestItemFromLow_High() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement element=driver.findElement(By.className("product_sort_container"));
		Select myselect = new Select(element);
		myselect.selectByVisibleText("Price (low to high)");
		
		List<WebElement> Prices = driver.findElements(By.className("inventory_item_price"));
		String HighestPriceAsText = Prices.get(Prices.size()-1).getText().replace("$", "");
		String LowestPriceAsTesxt = Prices.get(0).getText().replace("$", "");
		double HighestPrice = Double.parseDouble(HighestPriceAsText);
		double LowestPrice = Double.parseDouble(LowestPriceAsTesxt);
		boolean Expected = true;
		Assert.assertEquals(HighestPrice> LowestPrice, true);
		
		
		
		
	}
	
	@Test(priority=4, enabled=false)
	public void checkTheLatestItemFromA_Z() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement element=driver.findElement(By.className("product_sort_container"));
		Select myselect = new Select(element);
		myselect.selectByVisibleText("Name (A to Z)");
		
		String ExpectedA_Z = "Test.allTheThings() T-Shirt (Red)";
		List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
		String ActualA_Z = items.get(items.size()-1).getText();
		Assert.assertEquals(ActualA_Z, ExpectedA_Z);
		
		
	}
	
	@Test(priority=5, enabled=false)
	public void checkTheLatestItemFromZ_A() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement element=driver.findElement(By.className("product_sort_container"));
		Select myselect = new Select(element);
		myselect.selectByVisibleText("Name (Z to A)");
		
		String ExpectedZ_A = "Sauce Labs Backpack";
		List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
		String ActualZ_A = items.get(items.size()-1).getText();
		Assert.assertEquals(ActualZ_A, ExpectedZ_A);
	}
	
	@Test(priority=6, enabled=false)
	public void checkTheLatestItemFromHigh_Low() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement element=driver.findElement(By.className("product_sort_container"));
		Select myselect = new Select(element);
		myselect.selectByVisibleText("Price (high to low)");
		
		String ExpectedH_L = "Sauce Labs Onesie";
		List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
		String ActualH_L = items.get(items.size()-1).getText();
		Assert.assertEquals(ActualH_L, ExpectedH_L);
		
		
	}
	
	@Test(priority=7,enabled=false)
	public void findAllElemenThatHasPriceIsHigherThan15() {
		
		List<WebElement> thePrices = driver.findElements(By.className("inventory_item_price"));
		List<WebElement> addToTheCart = driver.findElements(By.className("btn"));
		
		for(int i=0; i<thePrices.size(); i++) {
			String priceAsTest = thePrices.get(i).getText().replace("$", "");
			double Price = Double.parseDouble(priceAsTest);
			if(Price >15.0) {
				addToTheCart.get(i).click();
			}
		}
		
		
		
	}
	@Test(priority=8)
	public void findAllElementThatHasContainWordLabs() {
		
		List<WebElement> wordLabs = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> addToTheCart = driver.findElements(By.className("btn"));
		
		for(int i=0;i<wordLabs.size();i++) {
		String names=wordLabs.get(i).getText();
		if(names.contains("Labs")) 
			addToTheCart.get(i).click();
		
		}
	}
	
	
	
	
}