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

public class ScrollUntilFindElement {
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

        scrollUntilFindElement();
    }

    // sayfa sonuna git. ama en fazla 5 defa scroll yap (sayfa sonsuz ise boşuna çok scroll yapmasın)
    public void scrollUntilFindElement() {
        boolean check = true;
        String prevPageSource = driver.getPageSource();
        String currentPageSource;
        WebElement element = null;
        int i = 0;
        do {
            try {
                element = driver.findElement(By.xpath("ibrahim"));

            } catch (Exception e) {

            }
            if (element != null) {
                check = false;
            } else {
                scollDown();
                currentPageSource = driver.getPageSource();
                if (prevPageSource.equals(currentPageSource) || i == 5) {
                    check = false;
                } else {
                    prevPageSource = currentPageSource;
                }
            }
            i++;
        } while (check);

    }


    public void scollDown() {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() * 3 / 4;
        int endX = driver.manage().window().getSize().getWidth() / 2;
        int endY = driver.manage().window().getSize().getHeight() / 4;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "scroll");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scroll));

    }
}
