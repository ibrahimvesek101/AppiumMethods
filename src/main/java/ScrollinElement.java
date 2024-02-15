import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class ScrollinElement {
    AndroidDriver driver;

    @Test
    public void scrollDeneme() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("Android");
        caps.setAutomationName("UiAutomator2");
        //  caps.setAppPackage("trendyol.com");
        //  caps.setAppActivity("com.trendyol.common.splash.impl.ui.SplashActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        swipeLeftInElement(AppiumBy.id("trendyol.com:id/recyclerViewSliderProduct"));
        swipeLeftInElement(AppiumBy.id("trendyol.com:id/recyclerViewSliderProduct"));
        swipeLeftInElement(AppiumBy.id("trendyol.com:id/recyclerViewSliderProduct"));
    }

    public void scrollDownInElement(By by) {
        WebElement element = driver.findElement(by);

        int startX = element.getRect().getX() + element.getSize().getWidth() / 2;
        int startY = element.getRect().getY() + element.getSize().getHeight() * 3 / 4;
        int endX = element.getRect().getX() + element.getSize().getWidth() / 2;
        int endY = element.getRect().getY() + element.getSize().getHeight() / 4;
        baseScrollMethod(startX, startY, endX, endY);

    }

    public void swipeLeftInElement(By by) {
        WebElement element = driver.findElement(by);

        int startX = element.getRect().getX() + element.getSize().getWidth() * 3 / 4;
        int startY = element.getRect().getY() + element.getSize().getHeight() / 2;
        int endX = element.getRect().getX() + element.getSize().getWidth() / 4;
        int endY = element.getRect().getY() + element.getSize().getHeight() / 2;
        baseScrollMethod(startX, startY, endX, endY);

    }

    public void baseScrollMethod(int startX, int startY, int endX, int endY) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "scroll");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scroll));

    }


}
