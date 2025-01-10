package practiceProblems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1 {
    public static void main(String[] args) {
        int noOfPersons = 4;
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.airbnb.co.in/");
        driver.manage().window().maximize();
        WebElement searchDestination = driver.findElement(By.xpath(null));
        searchDestination.click();
        WebElement selectFromMap = driver.findElement(By.xpath(null));
        selectFromMap.click();
        WebElement date1Field = driver.findElement(By.xpath(null));
        date1Field.click();
        WebElement date1 = driver.findElement(By.xpath(null));
        date1.click();

        WebElement date2Field = driver.findElement(By.xpath(null));
        date1Field.click();
        WebElement date2 = driver.findElement(By.xpath(null));
        date1.click();

        WebElement who = driver.findElement(By.xpath(null));
        who.click();
        WebElement noPersons = driver.findElement(By.xpath(null));
        for(int i = 0; i< noOfPersons; i++){
        noPersons.click();
        }

        WebElement search = driver.findElement(By.xpath(null));
        search.click();


    }
}