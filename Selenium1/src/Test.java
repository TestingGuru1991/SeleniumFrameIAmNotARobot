import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Web Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // driver.get("https://socialblade.com/register");
        // https://www.finalwebsites.com/demos/custom-captcha-image-script/
        // https://www.eobot.com/login
        //https://patrickhlauke.github.io/recaptcha/

        driver.get("https://www.eobot.com/login");

        int number = findFrameNumber(driver,
                By.cssSelector("[id='recaptcha-anchor'] [class='recaptcha-checkbox-checkmark']"));
        driver.switchTo().frame(number);
        driver.findElement(By.cssSelector("[id='recaptcha-anchor'] [class='recaptcha-checkbox-checkmark']")).click();

        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        int number1 = findFrameNumber(driver, By.xpath(".//*[@id='recaptcha-verify-button']"));
        driver.switchTo().frame(number1);
        driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).click();

    }

    public static int findFrameNumber(WebDriver driver1, By by)

    {
        driver1.switchTo().defaultContent();
        int i;
        int num = -1;
        int a = driver1.findElements(By.tagName("iframe")).size();
        for (i = 0; i < a; i++)
        {
            driver1.switchTo().defaultContent();
            driver1.switchTo().frame(i);
            int b = driver1.findElements(by).size();
            if (b > 0)
            {
                num = i;
                break;
            }
        }
        driver1.switchTo().defaultContent();
        return num;

    }

}
