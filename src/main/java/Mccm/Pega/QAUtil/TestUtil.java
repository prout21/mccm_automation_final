package Mccm.Pega.QAUtil;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;

public class TestUtil extends TestBase {
	
	private static final By By = null;
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;
	
	
	public void WindowHandling()
	{
		String mainWindow=driver.getWindowHandle();
	      System.out.println(mainWindow);
	      // It returns no. of windows opened by WebDriver and will return Set of Strings
	      Set<String> set =driver.getWindowHandles();
	      // Using Iterator to iterate with in windows
	      Iterator<String> itr= set.iterator();
	      while(itr.hasNext())
	      {
	      String childWindow=itr.next();
	      // Compare whether the main windows is not equal to child window. If not equal, we will close.
	      if(!mainWindow.equals(childWindow)){
	      driver.switchTo().window(childWindow);
	      try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      }
	   }
	}
	
	public void SwitcToFrame(int x)
	{
		driver.switchTo().frame(x);
	}
	
	public void SwitchToFrame(String x)
	{
		driver.switchTo().frame(x);
	}
	
	public void SwitcTodefaultContent()
	{
		driver.switchTo().defaultContent();
	}
	
public void RobertAction() throws AWTException
{
	Actions actions = new Actions(driver);

    Robot robot = new Robot();

  //  robot.mouseMove(50,50);
    robot.mouseMove(30,30);

    actions.click().build().perform();

  //  robot.mouseMove(200,70);
    robot.mouseMove(100,20);

    actions.click().build().perform();
}

public void JavascriptExecutor(WebElement webelement)
{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement element1 = webelement;
		 
		 js.executeScript("arguments[0].scrollIntoView();", element1);
	
}

public void ActionMouseMov(WebElement webelement)
{
	    WebElement element2 =  webelement;
        Actions  action = new Actions(driver);
        action.moveToElement(element2).click().build().perform();
}


@SuppressWarnings("deprecation")
public void fluentWait(WebElement webelement1)
{
FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
wait.withTimeout(2, TimeUnit.MINUTES);
wait.ignoring(NoSuchElementException.class);  

WebElement element = wait.until(new Function<WebDriver, WebElement>()
 
{
public WebElement apply(WebDriver driver) {
System.out.println("Checking for the element!!");
WebElement element = webelement1;
if(element != null)
{
System.out.println("Applay Target element found");
}
return element;
}
});
 
}
}
	
