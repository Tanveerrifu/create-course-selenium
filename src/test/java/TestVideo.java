import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestVideo {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;


    }

    @Test
    public void testLogin() {
        driver.get("https://adminqa.onestoplms.com/login");
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.cssSelector("button.login-btn.btn-primary"));

        emailInput.sendKeys("marufrahman897@gmail.com");
        passwordInput.sendKeys("Samtest1");
        loginButton.click();

//        String expectedDashboardURL = "https://adminqa.onestoplms.com/dashboard"; // Change this to the actual URL
//        wait.until(ExpectedConditions.urlToBe(expectedDashboardURL));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Course")));


        WebElement searchCourseLink = driver.findElement(By.linkText("Add Course"));
        searchCourseLink.click();

        WebElement courseNameInput = driver.findElement(By.name("course_name"));
        courseNameInput.sendKeys("Test Course ABCDEFGH");

        WebElement typeInstructor = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]"));

//
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", typeInstructor);
        Actions builder = new Actions(driver);
        builder.moveToElement(typeInstructor).click().perform();

        // Type "Tanvir" into the input field
        builder.moveToElement(typeInstructor).sendKeys("Tanvir").perform();

        // Wait for 30 seconds for the instructor name to appear in the dropdown
        WebDriverWait wait = new WebDriverWait(driver, 30);
//        By instructorNameLocator = By.xpath("//xpath_to_instructor_name_in_dropdown");
//        WebElement instructorNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(instructorNameLocator));

        // Click on the instructor name in the dropdown
//        instructorNameElement.click();





    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}