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

//class to implemenet driver operations
public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    //method to return current url
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    //method to go to the web page
    public void goToUrl(String url){
        driver.navigate().to(url);
    }

    //method to go back to previous page
    public void goBack(){
        driver.navigate().back();
    }

    //method to find web element
    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    //method to find web elements
    public List<WebElement> findElements(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }

    //methods to click
    public void clickElement(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public void clickElement(WebElement element){
        element.click();
    }

    //method to clear the field
    public void clearElement(By by){
        findElement(by).clear();
    }

    //methods to send keys
    public void sendKeysElement(By by,String key){
        findElement(by).sendKeys(key);
    }
    public void sendKeysElement(By by, Keys key){
        findElement(by).sendKeys(key);
    }
    public void sendKeysElement(WebElement element,String key){
        element.sendKeys(key);
    }

    //method to select from dropdown
    public void selectDropdown(By by,String text){
        Select dropdown = new Select(findElement(by));
        dropdown.selectByVisibleText(text);
    }
}
