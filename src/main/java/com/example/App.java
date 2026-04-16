package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class App {
    public static void main(String[] args) {

        // Headless Chrome (REQUIRED for Jenkins)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        // Wait handling
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Open site
            driver.get("https://practicetestautomation.com/practice-test-login/");

            // Login
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            // Validation (CRITICAL)
            if (!driver.getCurrentUrl().contains("logged-in")) {
                throw new RuntimeException("Login failed");
            }

            System.out.println("Login successful!");

        } finally {
            driver.quit();
        }
    }
}
