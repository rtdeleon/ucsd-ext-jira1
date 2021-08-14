package TestSelenium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

    public static String browser = "ChroMe";
//    public static String browser = "fF";
    public static String url = "https://id.atlassian.com/login?continue=https%3A%2F%2Fucsd-ext.atlassian.net%2Flogin%3FredirectCount%3D1%26application%3Djira&application=jira";
    public static WebDriver driver;
//    private static final Logger log = LogManager.getLogger(Test1.class.getName());
    public static final String USERNAME = "ucsd.ext1@gmail.com";
    public static final String PASSWORD = "Murray08";

    public static void main(String[] args) throws InterruptedException {
        Map<String, String> map = null;
        List<WebElement> lst = null;
        String method = new Object() {}.getClass().getEnclosingMethod().getName();
        String userDir = System.getProperty("user.dir");


        System.out.println("method: "+ method);
        System.out.println("userDir:"+ userDir);

        System.out.println("browser is: " + browser);
        System.out.println("url: " + url);

        if (browser.equalsIgnoreCase("ff")) {
//			<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.id("username")).sendKeys(USERNAME);
        driver.findElement(By.id("login-submit")).click();
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("login-submit")).click();
//        String test = driver.findElement(By.xpath("//button[@id='createGlobalItem']")).getAttribute("outerHTML");
//        System.out.println(test);
        driver.findElement(By.xpath("//button[@id='createGlobalItem']")).click();
//        driver.findElement(By.xpath("//input[@id='project-field']")).click();
        driver.findElement(By.xpath("//input[@id='issuetype-field']")).click();
//        driver.findElement(By.xpath("//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[starts-with(@id,'test-team-2-r')]/a")).click();
//        String test = driver.findElement(By.xpath("//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]//li[starts-with(@id,'test-team-2-r')]/a"))
//                .getAttribute("outerHTML");
//        System.out.println(test);
        List<WebElement> project = driver.findElements(By.xpath("//body/div[starts-with(@class,'ajs-layer') and contains(@aria-hidden,'false')]"));
//        List<WebElement> project = driver.findElements(By.xpath("//body"));



        for (WebElement e:project) {
            System.out.println(e.getAttribute("outerHTML"));

        }





        Thread.sleep(10000);

        driver.quit();
    }

}
