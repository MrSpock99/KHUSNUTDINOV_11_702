package manager;

import helpers.LoginHelper;
import helpers.NavigationHelper;
import helpers.NotesHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Settings;

import java.io.IOException;

public class ApplicationManager {
    private ChromeDriver driver;
    private WebDriverWait driverWait;
    private String baseUrl;
    private LoginHelper loginHelper;
    private NotesHelper notesHelper;
    private NavigationHelper navigationHelper;
    private static ThreadLocal<ApplicationManager> app;

    private ApplicationManager() throws IOException {
        System.setProperty("webdriver.chrome.driver", "E:\\Downloads\\chromeDriver\\chromedriver.exe");
        setUp();
        baseUrl = Settings.getBaseUrl();
        loginHelper = new LoginHelper(this);
        notesHelper = new NotesHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        driver.quit();
    }

    public void setUp() {
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 100);
    }

    public static ApplicationManager getInstance() throws IOException {
        if (app == null) {
            app = new ThreadLocal<>();
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.navigationHelper.goToLoginPage();
            app.set(newInstance);
        }
        return app.get();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public NotesHelper getNotesHelper() {
        return notesHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public ChromeDriver getDriver() {
        return driver;
    }
}
