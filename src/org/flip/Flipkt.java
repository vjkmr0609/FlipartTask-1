package org.flip;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkt {
public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\aruna\\eclipse-workspace\\ProjFlipkt\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]")).sendKeys("9597666445");
	driver.findElement(By.xpath("(//input[@autocomplete='off'])[3]")).sendKeys("vijay1995");
	driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("reamle c21y black");
	driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	Thread.sleep(2000);
	
	WebElement text = driver.findElement(By.xpath("(//*[@class='_4rR01T'])[1]"));
	String first = text.getText();
	System.out.println(first);
	text.click();
	
	String par = driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	
	for(String x : child) {
		if(!par.equals(x)) {
			driver.switchTo().window(x);
		}
	}
	WebElement real = driver.findElement(By.xpath("//*[@class='B_NuCI']"));
	String second = real.getText();
	System.out.println(second);
	
	if(first == second) {
		System.out.println("The Parent Window Name and Child Window Name are SAME");
	}
	else {
		System.out.println("The Parent and child Window name are NOT SAME");
	}
	WebElement down = driver.findElement(By.xpath("//*[text()='RMX3261 / RMX3263']"));
	JavascriptExecutor jsc = (JavascriptExecutor)driver;
	jsc.executeScript("arguments[0].scrollIntoView(true)",down);
	Thread.sleep(2000);
	
	WebElement mark = driver.findElement(By.xpath("//*[text()='Smartphones']"));
	System.out.println(mark.getText());
	Thread.sleep(3000);
	Actions ac = new Actions(driver);
	Thread.sleep(3000);
	//ac.moveToElement(mark).perform();
	ac.doubleClick(mark).build().perform();
	
	
	TakesScreenshot ts= (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File des = new File("C:\\Users\\aruna\\eclipse-workspace\\ProjFlipkt\\screen\\shot");
	FileUtils.copyFile(src,des);
}
	
}
