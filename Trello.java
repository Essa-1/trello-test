package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Trello {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		driver.get("https://trello.com/");
		WebElement loginlink = driver.findElement(By.xpath("//div[contains(@class,'Buttonsstyles__ButtonGroup')]/a[text()='Log in']"));
				
		loginlink.click();
		wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
		String actualTitle = driver.getTitle();
		if (actualTitle.equals("Log in to continue - Log in with Atlassian account")) {
			System.out.println("Pass: Title is verified and found correct");
		} else {
			System.out.println("Fail: Title is verified and found incorrect");

		}
		WebElement enterEmail = driver.findElement(By.id("username"));
		enterEmail.sendKeys("essasahu@gmail.com");
		WebElement continueButton = driver.findElement(By.id("login-submit"));
		continueButton.submit();
		WebElement enterPassword = driver.findElement(By.id("password"));
		enterPassword.sendKeys("Essa@2002");
		WebElement loginButton = driver.findElement(By.id("login-submit"));
		loginButton.submit();
		WebElement createNewBoard = driver.findElement(By.xpath("//span[text()='Create new board']"));
		createNewBoard.click();
		WebElement boardTitleTextfield = driver
				.findElement(By.xpath("//input[@data-testid='create-board-title-input']"));
		boardTitleTextfield.sendKeys("M10");
		WebElement createButton = driver.findElement(By.xpath("//button[@data-testid='create-board-submit-button']"));
		wait.until(ExpectedConditions.elementToBeClickable(createButton));
		createButton.click();
		WebElement menuOpt = driver.findElement(By.xpath("//button[@aria-label='Show menu']"));
		menuOpt.click();
		WebElement closeboardOpt = driver.findElement(By.xpath("//div[text()='Close board']"));
		closeboardOpt.click();
		WebElement closeOpt = driver.findElement(By.xpath("//input[@value='Close']"));
		closeOpt.click();
		WebElement permanentlyDeleteBoardOpt = driver
				.findElement(By.xpath("//button[@data-testid='close-board-delete-board-button']"));
		permanentlyDeleteBoardOpt.click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
 driver.findElement(By.xpath("//span[@aria-label='Essa sahu (essasahu)']")).click();

 driver.findElement(By.xpath("//span[text()='Log out']")).click();
 System.out.println("Complete");
	driver.manage().window().minimize();
	driver.quit();
	System.out.println("Script Completed");

 


}
}
