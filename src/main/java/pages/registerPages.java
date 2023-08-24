package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPages{
    WebDriver driver;

    public registerPages(WebDriver driver){
        this.driver=driver;
    }

    //locator dari register button
    By firstnameField = By.id("customer.firstName");
    By lastnameField = By.id("customer.lastName");

    //Metode click register button
    public void inputNameData(String firstname, String lastname){
        driver.findElement(firstnameField).sendKeys(firstname);
        driver.findElement(lastnameField).sendKeys(lastname);
    }
}