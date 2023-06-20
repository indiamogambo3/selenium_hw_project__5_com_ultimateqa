package com_ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-5 - Project Name: com-ultimateqa
 * BaseUrl = https://courses.ultimateqa.com/users/sign_in
 * 1. Setup chrome browser
 * 2. Open URL
 * 3. Print the title of the page
 * 4. Print the current url
 * 5. Print the page source
 * 6. Enter the email to email field
 * 7. Enter the password to password field
 * 8. Close the browser
 */

public class LogInTestWithMultipleBrowser {

    static String browser = "Edge";
    static String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
    static WebDriver driver;

    public static void main(String[] args) {

        //if else condition to launch selected browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Incorrect browser name!!");
        }

        //Open URL in browser
        driver.get(baseUrl);
        //Maximise browser
        driver.manage().window().maximize();
        //Set implicit wait for driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get page title
        String getTitle = driver.getTitle();
        System.out.println("Page title is: " + getTitle);

        //Get current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        //Get page source
        String pageSource = driver.getPageSource();
        System.out.println("Page source is: " + pageSource);

        //Get email element
        WebElement email = driver.findElement(By.id("user[email]"));
        //Type email in email field
        email.sendKeys("mukz123@gmail.com");

        //Get password element
        WebElement password = driver.findElement(By.id("user[password]"));
        //Type password in password field
        password.sendKeys("Mogambo123");

        //close the browser
        driver.close();
    }

}
