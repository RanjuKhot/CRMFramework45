package PracticeProduct;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/frames/multiple?sublist=2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("email")).sendKeys("ranjana@test.com");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("confirm-password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().parentFrame();
		WebElement frame2= driver.findElement(By.xpath("(//iframe[@class='w-full h-96'])[2]"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("username")).sendKeys("ranjana@test.com");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
    
//           driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("abcd@gamil.com");
//           driver.findElement(By.xpath("//input[@type=\"password\"][1]")).sendKeys("12345");
//           driver.findElement(By.name("confirmPassword")).sendKeys("12345");
//           driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}

}
