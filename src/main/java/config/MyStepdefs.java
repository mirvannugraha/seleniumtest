package config;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.registerPages;
import pages.homePages;
import java.time.Duration;
import java.util.Random;

public class MyStepdefs extends env_target {
    @Given("^User is on parabank homepage$")
    public void userIsOnParabankHomepage() {
        System.setProperty("webdriver.chrome.driver","src\\\\main\\\\resources\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(paraBank);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("headerPanel"))
        );

    }

    @When("^User click register link button$")
    public void userClickRegisterLinkButton() {
        driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a")).click();
    }

    @Then("^User is in register page$")
    public void userIsInRegisterPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/h1"))
        );
    }

//    @When("^User input name$")
//    public void userInputName() {
//        driver.findElement(By.id("customer.firstName")).sendKeys("Ahmad");
//        driver.findElement(By.id("customer.lastName")).sendKeys("Sumaker");
//    }

    @And("^User input address detail$")
    public void userInputAddressDetail() {
        driver.findElement(By.id("customer.address.street")).sendKeys("Jl. Dipatiukur");
        driver.findElement(By.xpath("//*[@id='customer.address.city']")).sendKeys("Bandung");
        driver.findElement(By.id("customer.address.state")).sendKeys("Indonesia");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("40404");
        driver.findElement(By.xpath("//*[@id='customer.phoneNumber']")).sendKeys("08572564564");
        driver.findElement(By.xpath("//*[@id='customer.ssn']")).sendKeys("123321");
    }

    @And("^User fill valid username and password$")
    public void userFillValidUsernameAndPassword() {
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        driver.findElement(By.xpath("//*[@id='customer.username']")).sendKeys("user"+userRand);
        driver.findElement(By.xpath("//*[@id='customer.password']")).sendKeys("123456");

    }

    @And("^User input password confirmation$")
    public void userInputPasswordConfirmation() {
        driver.findElement(By.xpath("//*[@id='repeatedPassword']")).sendKeys("123456");
    }

//    @When("^User click Register button$")
//    public void userClickRegisterButton() {
//        driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
//    }

    @Then("^User register successfully$")
    public void userRegisterSuccessfully() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/h1"))
        );
        driver.quit();
    }

    @And("^User input invalid password confirmation$")
    public void userInputInvalidPasswordConfirmation() {
        driver.findElement(By.xpath("//*[@id='repeatedPassword']")).sendKeys("123123");
    }

    @Then("^User get error password did not match$")
    public void userGetErrorPasswordDidNotMatch() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='repeatedPassword.errors']"))
        );
        driver.quit();
    }

    //POM
    @When("^User click Register button$")
    public void userClickRegisterButton() {
        homePages homepages = new homePages(driver);

        homepages.clickRegister();
    }

    @When("^User input name$")
    public void userInputName() {
        registerPages inputName = new registerPages(driver);

        inputName.inputNameData("Ahmad","Sumaker");
    }
}
