package EventListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MyEventHandler implements WebDriverEventListener{

	public void beforeAlertAccept(WebDriver driver) {
		
		System.out.println("Before accepting the alert");
		
	}

	public void afterAlertAccept(WebDriver driver) {
		
		System.out.println("After accepting the alert");
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		
		System.out.println("After dismissing the alert");
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		
		System.out.println("Before dismissing the alert");
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		
		System.out.println("Before navigating to "+driver.getCurrentUrl());
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		
		System.out.println("After navigating to "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		
		System.out.println("Before navigating back "+driver.getCurrentUrl());
		
	}

	public void afterNavigateBack(WebDriver driver) {
		
		System.out.println("After navigate back "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		
		System.out.println("Before navigating forward "+driver.getCurrentUrl());
		
	}

	public void afterNavigateForward(WebDriver driver) {
		
		System.out.println("After navigating forward "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		
		System.out.println("Before refreshing the page "+driver.getCurrentUrl());
	}

	public void afterNavigateRefresh(WebDriver driver) {

		System.out.println("After refreshing the page "+driver.getCurrentUrl());
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
	
		System.out.println("Before finding the WebElement "+element);
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("After finding the WebElement "+element);
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("Before clicking on "+element);
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {

		System.out.println("After clicking on "+element);
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		System.out.println("Before clearing/typing text into element "+element);
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		System.out.println("After clearing/typing text into element "+element);
		
	}

	public void beforeScript(String script, WebDriver driver) {
		
		System.out.println("Before executing the script");
		
	}

	public void afterScript(String script, WebDriver driver) {
		
		System.out.println("After executing the script");
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		
		System.out.println("Before Switching to a window");
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		
		System.out.println("After switching to a window");
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		
		System.out.println("On getting exception "+throwable.getMessage());
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		
		System.out.println("Before taking screenshot");
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		
		System.out.println("After taking screenshot");
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		
		System.out.println("Before retrieving text of "+element);
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		
		System.out.println("After retrieving text of "+element);
		
	}
	
	
	
}