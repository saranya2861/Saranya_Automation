package intellipet.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class M3A1 {

	public static void main(String[] args) throws Exception {

		/*
		 * Tasks To Be Performed: 1. TC-1 launch Chrome browser 2. TC-2 go to test URL -
		 * https://netbanking.hdfcbank.com/netbanking/ 3. TC-3 maximize the browser
		 * window 4. TC-4 get the title of page 5. TC-5 click on know more link text 6.
		 * TC-6 switch from 0th window to 1st window 7. TC-7 after switching get the
		 * title of page 8. TC-8 switch from 1st window to 0th window 9. TC-9 after
		 * switching, get the title of page 10. TC-10 close all windows of the browser
		 */

		// 1. TC-1 launch Chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 2. TC-2 go to test URL - https://netbanking.hdfcbank.com/netbanking/
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		Thread.sleep(5000);

		// 3. TC-3 maximize the browser window
		driver.manage().window().maximize();

		// 4. TC-4 get the title of page
		System.out.println(driver.getTitle());

		// 5. TC-5 click on know more link text
		driver.switchTo().frame("login_page");

		WebElement linkElement = driver.findElement(By.xpath("//div[@id='nortonimg1']//a[contains(text(),'Know')]"));
		linkElement.click();

		// 6.TC-6 switch from 0th window to 1st window

		Set<String> winID = driver.getWindowHandles();

		List<String> winList = new ArrayList<String>(winID);

		String zeroWindow = winList.get(0);
		String firstWindow = winList.get(1);

		driver.switchTo().window(firstWindow);
		Thread.sleep(5000);

		// 7. TC-7 after switching get the title of page
		System.out.println("First Window Title: " + driver.getTitle());

		// 8. TC-8 switch from 1st window to 0th window

		driver.switchTo().window(zeroWindow);

		// 9. TC-9 after switching, get the title of page

		System.out.println("0th Window Title: " + driver.getTitle());

		// 10. TC-10 close all windows of the browser
		driver.quit();

	}

}
