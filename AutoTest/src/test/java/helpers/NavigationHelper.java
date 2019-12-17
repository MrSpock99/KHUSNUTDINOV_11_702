package helpers;

import manager.ApplicationManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {
    private String baseUrl;
    private static ChromeDriver driver;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
        driver = applicationManager.getDriver();
    }

    public void goToLoginPage() {
        driver.get(baseUrl + "create_account");
    }
}
