package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Project-3 - ProjectName : com-herokuapp
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */

public class MultiBrowserTest {

    //static variables
    static String browser = "Chrome";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {
        // Nested if else to launch the browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //Open baseUrl
        driver.get(baseUrl);

        // Maximise the browser window
        driver.manage().window().maximize();

        System.out.println("The title of the page: " + driver.getTitle()); // get the title of the page
        System.out.println("The current URL:  " + driver.getCurrentUrl()); //get the current Url of the page
        System.out.println("The page source: " + driver.getPageSource()); // get page source

        driver.findElement(By.name("username")).sendKeys("tomsmith"); // Enter the email to email field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!"); // Enter the password to password field
        driver.findElement(By.className("fa-sign-in")).click(); // Click on Login Button
        System.out.println("Get current URl:" + driver.getCurrentUrl()); //get the current Url of the page

        driver.navigate().refresh(); // Refresh the page
        driver.close(); // close the current window where Selenium automation is running
    }
}