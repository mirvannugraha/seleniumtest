package pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

public class homePages{
    WebDriver driver;

    public homePages(WebDriver driver){
        this.driver=driver;
    }

    //locator dari register button
    By RegisterButton = By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input");

    //Metode click register button
    public void clickRegister(){
        driver.findElement(RegisterButton).click();
    }
}

