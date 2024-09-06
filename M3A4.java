package intellipet.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class M3A4 {

	public static void main(String[] args) throws Exception {
		
		/*
		1. TC-1 launch Firefox browser
		2. TC-2 go to test URL - https://netbanking.hdfcbank.com/netbanking/
		3. TC-3 maximize the browser window
		4. TC-4 get the title of page
		5. TC-5 click on know more link text
		6. TC-6 switch from 0th window to 1st window
		7. TC-7 after switching get the title of page
		8. TC-8 close 1st window
		9. TC-8 switch from 1st window to 0th window
		10. TC-9 after switching get the title of page
		11.TC-10 close 0th window
		*/
		
		// 1. TC-1 launch Firefox browser
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// 2. TC-2 go to test URL - https://netbanking.hdfcbank.com/netbanking/
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		// 3. TC-3 maximize the browser window
		driver.manage().window().maximize();
		
		// 4. TC-4 get the title of page
		System.out.println(driver.getTitle());
		
		// 5. TC-5 click on know more link text
		driver.switchTo().frame("login_page");
		WebElement linkText= driver.findElement(By.xpath("//div[@id='nortonimg1']//a[contains(text(),'Know')]"));
		linkText.click();
		
		// 6. TC-6 switch from 0th window to 1st window
		Set<String> setWindowIds = driver.getWindowHandles();
		List<String> listWindowIds = new ArrayList<String>(setWindowIds);
		
		String zeroWindow = listWindowIds.get(0);
		String firstWindow = listWindowIds.get(1);
		
		driver.switchTo().window(firstWindow);
		Thread.sleep(5000);
		
		// 7. TC-7 after switching get the title of page
		System.out.println("First Window Title: " + driver.getTitle());
		Thread.sleep(5000);
		
		// 8. TC-8 close 1st window
		driver.close();
		
		// 9. TC-8 switch from 1st window to 0th window
		driver.switchTo().window(zeroWindow);
		Thread.sleep(5000);
		
		// 10. TC-9 after switching get the title of page
		System.out.println("0th Window Title: " + driver.getTitle());
		
		// 11.TC-10 close 0th window
		driver.close();
		
		

	}

}
