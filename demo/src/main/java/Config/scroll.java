package Config;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class scroll extends config{
    public void scrollToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.perform();
    }
    
}