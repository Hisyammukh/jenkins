package Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class config {
    public static WebDriver driver;

    public static void initialize(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://dashboard.xendit.co/");
        driver.manage().window().fullscreen();
    }

    public static void quit(){
        driver.quit();
    }
    
}
