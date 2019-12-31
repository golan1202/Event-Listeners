package EventListeners;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		
		//Registering the Event listener
		MyEventHandler eventsHanlder = new MyEventHandler();
		eventDriver.register(eventsHanlder);
		
		//Navigating to applications in two ways
		eventDriver.get("http://www.omayo.blogspot.com");
		eventDriver.navigate().to("http://www.omayo.blogspot.com");
		
		//Finding the element
		WebElement searchBox = eventDriver.findElement(By.name("q"));
		
		//Clear and type the text into the search box field
		searchBox.clear();
		searchBox.sendKeys("Page One");
		
		//Click on a button 
		eventDriver.findElement(By.id("alert1")).click();
		
		//Accept the alert
		Alert alert = eventDriver.switchTo().alert();
		alert.accept();
		eventDriver.switchTo().defaultContent();
		
		//Dismissing the alert
		eventDriver.findElement(By.id("alert1")).click();
		Alert alert2 = eventDriver.switchTo().alert();
		alert2.dismiss();
		eventDriver.switchTo().defaultContent();
		
		//Refreshing the page
		eventDriver.navigate().refresh();
		
		//Refreshing the page using JavaScript
		JavascriptExecutor jse = (JavascriptExecutor)eventDriver;
		jse.executeScript("history.go(0)");
		
		//Retrieve the text of a paragraph
		String text = eventDriver.findElement(By.id("pah")).getText();
		System.out.println("Retrieved text "+text);
		
		//Switching to a window
		eventDriver.findElement(By.linkText("Open a popup window")).click();
		Set<String> windowHandles = eventDriver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
		String mainWindow = itr.next();
		String childWindow = itr.next();
		eventDriver.switchTo().window(childWindow);
		eventDriver.close();
		eventDriver.switchTo().window(mainWindow);
		
		//Taking the screenshot
		File screenshotFile = ((TakesScreenshot) eventDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("screenshots\\screenshot1.jpg"));
		
		//Navigating back
		eventDriver.findElement(By.linkText("compendiumdev")).click();
		eventDriver.navigate().back();
		eventDriver.navigate().forward();
		
		//Intentionally get an exception
		try {
			eventDriver.findElement(By.id("xyzabc"));
		}catch(Exception e) {
			
		}
		
		eventDriver.unregister(eventsHanlder);
		driver.quit();
		
	}

}