package tests;

import manager.ApplicationManager;
import model.User;
import org.junit.jupiter.api.BeforeAll;
import settings.Settings;

import java.io.IOException;

public class AuthBase extends TestBase{

    @BeforeAll
    public static void beforeAll() throws IOException {
        applicationManager = ApplicationManager.getInstance();
        applicationManager.getNavigationHelper().goToLoginPage();
        TestBase.applicationManager.getLoginHelper().login(Settings.getBaseUser());
    }

}
