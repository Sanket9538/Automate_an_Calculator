package calculator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_an_Calculator {

WebDriver driver;
    
    @BeforeTest
    void setUp()
    {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp=new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
    	driver=new ChromeDriver(options);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	  
    	driver.get("https://www.calculator.net/");
    	driver.manage().window().maximize();
    	
    }
      
    @Test(priority=1)
    void multiplication() throws InterruptedException
    {    	  
    	
    	String n1="423";
    	String n2="525";
    	
    	Actions act=new Actions(driver);
    	
    	act.sendKeys(n1).perform();
    	Thread.sleep(2000);
     	act.sendKeys(Keys.MULTIPLY).perform();
     	Thread.sleep(2000);
    	act.sendKeys(n2).perform();
    	Thread.sleep(2000);
    	 
        String	res=driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
    	
         System.out.println("The multiplication of n1 + n2 is :"+res);
        driver.findElement(By.xpath("//span[normalize-space()='AC']")).click();
         Thread.sleep(5000);
    }
   
    
    @Test(priority=2)
    void division() throws InterruptedException
    {
    	String n1="4000";
    	String n2="200";
    	
    	Actions act=new Actions(driver);
    	
    	act.sendKeys(n1).perform();
    	Thread.sleep(2000);
    	act.sendKeys(Keys.DIVIDE);
    	Thread.sleep(2000);
    	act.sendKeys(n2).perform();
    	Thread.sleep(2000);
        String res1=driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
    	System.out.println("The division of n1 and n2 is :"+ res1);
    	driver.findElement(By.xpath("//span[normalize-space()='AC']")).click();
    	Thread.sleep(5000);
    }
  
    
    @Test(priority=3)
    void add() throws InterruptedException
    {
    	String n1="-234234";
    	String n2="345345";
    	
        Actions act=new Actions(driver);
    	
    	act.sendKeys(n1).perform();
    	Thread.sleep(2000);
    	act.sendKeys(Keys.ADD);
    	Thread.sleep(2000);
    	act.sendKeys(n2).perform();
    	Thread.sleep(2000);
    	
    	String res2=driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
    	System.out.println("The addition of n1 and n2 is:"+ res2);
    	driver.findElement(By.xpath("//span[normalize-space()='AC']")).click();
    	
    	Thread.sleep(5000);
    }

    
    @Test(priority=4)
    void substraction() throws InterruptedException
    {
    	String n1="234823";
    	String n2="-23094823";
    	
         Actions act=new Actions(driver);
     	
     	act.sendKeys(n1).perform();
     	Thread.sleep(2000);
     	act.sendKeys(Keys.SUBTRACT);
     	Thread.sleep(2000);
     	act.sendKeys(n2).perform();
     	Thread.sleep(2000);
    	
     	String res3=driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
    	System.out.println("The substraction of n1 and n2 is :" + res3);
    	driver.findElement(By.xpath("//span[normalize-space()='AC']")).click();
    	Thread.sleep(5000);
    }
    
    
    @AfterTest
    void tearDown()
    {
    	driver.close();
    }
    
	
	
	
	
	
	
	
	
}
