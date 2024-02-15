import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Methods2 {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        UiAutomator2Options caps = new UiAutomator2Options();

        caps.setPlatformName("Android");
        caps.setAutomationName("UiAutomator2");
        //  caps.setAppPackage("trendyol.com");
        //  caps.setAppActivity("com.trendyol.common.splash.impl.ui.SplashActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


/*
       //   Telefon klavyesindeki bazı butonlara tıklama;

        driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
        driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
 */
        /*

        //package ismi verilen app yüklü mü?
        boolean appYukluMu = driver.isAppInstalled("trendyol.com");
        System.out.println("appYukluMu = " + appYukluMu);

        //Package si verilen app aç
        driver.activateApp("trendyol.com");
        Thread.sleep(3000);

        //Package si verilen app kapat;
        driver.terminateApp("trendyol.com");

         */


     /*
        //klavye açık mı?
        boolean klavyeAcıkMı = driver.isKeyboardShown();
        System.out.println("klavyeAcıkMı = " + klavyeAcıkMı);

        //klavye kapatıyor
        driver.hideKeyboard();

        //uygulamayı siler;
        driver.removeApp("trenyol.com");
        Thread.sleep(3000);

        //path değerini verdiğimiz app yi yükler:
        driver.installApp("/Users/ibrahim/IdeaProjects/AppiumMethods/src/main/resources/trendyol.apk");

      */

/*
        driver.activateApp("trendyol.com");
        Thread.sleep(3000);
        //içerisine yazdığımız süre boyunca uygulama arka plana atar sonra tekrar önplana getirir.
        driver.runAppInBackground(Duration.ofSeconds(10));

 */

        /*
        //cihaz kapalı mı kontrolu yapar;
        boolean cihazAcıkMI = driver.isDeviceLocked();
        System.out.println("cihazKapalıMI = " + cihazAcıkMI);

        //cihazın kapatma tuşuna basar
        driver.lockDevice();
        Thread.sleep(3000);

        //cihazı açmak için
        driver.unlockDevice();

        //açılırken pin girmek için;
        //driver.unpin(new ScriptKey("1234"));

         */

        /*
        //ekranı yan çevirme
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.rotate(ScreenOrientation.PORTRAIT);

         */

        /*
        //bildirimleri açma
        driver.openNotifications();

         */

        /*
        //wifi açıp kapatma
        driver.toggleWifi();
        //interterneti açıp kapatma
        driver.toggleData();
        //konum açıp kapatma
        driver.toggleLocationServices();
        //uçak modunu açıp kaptma
        driver.toggleAirplaneMode();

         */
        //SMS göndermek için
        driver.sendSMS("156", "bu bir deneme mesajıdır");

        //Arama simüle etme
        driver.makeGsmCall("155", GsmCallActions.CALL);
        Thread.sleep(13000);
        driver.makeGsmCall("05302501085", GsmCallActions.CANCEL);

/*
        //seleniumda olan methodlar

        driver.getPageSource();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("selenium"));
        driver.manage().window().getSize();

 */

    }

}
