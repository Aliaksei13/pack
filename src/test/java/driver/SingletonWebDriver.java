package test.java.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SingletonWebDriver {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static SingletonWebDriver instance;

    private SingletonWebDriver() {
    }

    public static SingletonWebDriver getInstance(){
        if(instance == null){
            instance = new SingletonWebDriver();
        }
        return instance;
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    public void initilize(String nodeURL, String environment) {
        /*if(driver == null) {
            if(Constants.browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "F:\\tut2\\lib\\geckodriver-v0.24.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }*/
        if (environment.equals("port")) {
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");
            //cap.setPlatform(Platform.WINDOWS);
            try {
                driver.set(new RemoteWebDriver(new URL(nodeURL), cap));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if(environment.equals("local")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\anduser\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
            driver.set(new FirefoxDriver());
        } else {
            throw new RuntimeException("Environment is not selected");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //return getDriver();
    }

    public void quit() {
        getDriver().quit();
    }

    public void close() {
        getDriver().close();
    }

    public void openurl(String URL) {
        getDriver().get(URL);
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
