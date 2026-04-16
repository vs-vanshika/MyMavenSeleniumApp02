package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless=new");
	options.addArguments("--disable-gpu");
	options.addArguments("--window-size=1920,1080");

// ⭐ MOST IMPORTANT FIX
	options.addArguments("--no-sandbox");
	options.addArguments("--disable-dev-shm-usage");
	options.addArguments("--remote-allow-origins=*");
	options.setAcceptInsecureCerts(true);
	options.addArguments("--ignore-certificate-errors");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://practicetestautomation.com/practice-test-login/");

            // Enter username
            driver.findElement(By.id("username")).sendKeys("student");

            // Enter password
            driver.findElement(By.id("password")).sendKeys("Password123");

            // Click login
            driver.findElement(By.id("submit")).click();

            // Validation
            String currentUrl = driver.getCurrentUrl();

            if (currentUrl.contains("logged-in-successfully")) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
