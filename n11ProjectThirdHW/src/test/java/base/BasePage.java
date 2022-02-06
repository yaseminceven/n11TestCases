package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


//class to implement driver operations
public class BasePage{
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    //find web element method
    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    //find web element list
    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    //click method
    public void clickElement(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    //method to clear the field
    public void clearField(By by){
        findElement(by).clear();
    }

    //method to send keys
    public void sendKey(By by,String text){
        findElement(by).sendKeys(text);
    }
    public void sendKey(By by, Keys key){
        findElement(by).sendKeys(key);
    }

    //method to select from dropdown
    public void selectDropdown(By by,String text){
        Select dropdown = new Select(findElement(by));
        dropdown.selectByValue(text);
    }

}
