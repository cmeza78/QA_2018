package com.Requests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class getGoogleInfo {

    public static void  main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys("Selenium");
        element.sendKeys(Keys.ENTER);
        WebElement mainDiv = driver.findElement(By.id("res"));
        List<WebElement> divs = mainDiv.findElements(By.xpath("//div[@class='g']//div[@class='rc']"));
        System.out.println(divs.size());
        for(int p = 1; p<=3 ; p++) {
            for (int i = 1; i <= divs.size(); i++) {
                System.out.println(driver.findElement(By.xpath("//div[@class='g'][" + i + "]//div[@class='rc']/h3/a")).getText());
                System.out.print(driver.findElement(By.xpath("//div[@class='g'][" + i + "]//div[@class='rc']//cite")).getText());
                if (driver.findElements(By.xpath("//div[@class='g'][" + i +
                        "] //div[@class='rc']//div[@class = 'action-menu ab_ctl']//following-sibling::a[1]")).size() > 0) {
                    System.out.println(" " + driver.findElement(By.xpath("//div[@class='g'][" + i +
                            "] //div[@class='rc']//div[@class = 'action-menu ab_ctl']//following-sibling::a[1]")).getText());
                } else
                    System.out.println(" ");

                System.out.println(driver.findElement(By.xpath("//div[@class='g'][" + i + "]//div[@class='rc']//span[@class='st']")).getText());
                System.out.println(" ");
            }
            // driver.findElement(By.xpath("//a[@aria-label ='Page " + p + "']"));
            if (driver.findElements(By.xpath("//a[@aria-label ='Page " + (p + 1) + "']")).size() > 0 && p <3){

                System.out.println("********* Page "  + (p + 1) + "*********" );
                driver.findElement(By.xpath("//a[@aria-label ='Page " + (p + 1)+ "']")).click();
            }
            else {
                break;
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }

}
