package helpers;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    static ChromeDriver driver;
    static WebDriverWait driverWait;
    public HelperBase(ApplicationManager applicationManager){
        driver = applicationManager.getDriver();
        driverWait = applicationManager.getDriverWait();
    }
    protected void assertAndVerifyElement(By element) {
        boolean isPresent = false;

        for (int i = 0; i < 5; i++) {
            try {
                if (driver.findElement(element) != null) {
                    isPresent = true;
                    break;
                }
            } catch (Exception e) {
                // System.out.println(e.getLocalizedMessage());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
