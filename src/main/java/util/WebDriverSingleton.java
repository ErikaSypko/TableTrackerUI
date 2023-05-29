package util;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@Slf4j
public class WebDriverSingleton {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver instance = new ChromeDriver(options) {
            {
                manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
        };
        webDriverThreadLocal.set(instance);
        return webDriverThreadLocal.get();
    }

    public static void close() {
        try {
            if (webDriverThreadLocal != null) {
                webDriverThreadLocal.get().quit();
            }
        } catch (Exception e) {
            log.error(e.toString());
        } finally {
            webDriverThreadLocal.remove();
        }
    }
}
