package tests;

import helpers.LoginHelper;
import model.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import settings.Settings;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTests extends TestBase {

    @Test
    @Order(1)
    public void testLoginValidData() throws InterruptedException, IOException {
        if (!TestBase.applicationManager.getLoginHelper().isLogged())
            return;
        TestBase.applicationManager.getNavigationHelper().goToLoginPage();
        /*XmlMapper xmlMapper = new XmlMapper();
        File file = new File("E:/user.xml");
        String xml = inputStreamToString(new FileInputStream(file));
        User user = xmlMapper.readValue(xml, User.class);*/
        TestBase.applicationManager.getLoginHelper().login(Settings.getBaseUser());
        TestBase.applicationManager.getLoginHelper().logout();
    }

    @Test
    @Order(2)
    public void testLoginInvalidData() throws InterruptedException, IOException {
        if (!TestBase.applicationManager.getLoginHelper().isLogged())
            return;
        TestBase.applicationManager.getNavigationHelper().goToLoginPage();
        User user = new User("AAAAAAAAAA", "AAAAAAAAA");
        /*XmlMapper xmlMapper = new XmlMapper();
        File file = new File("E:/user.xml");
        String xml = inputStreamToString(new FileInputStream(file));
        User user = xmlMapper.readValue(xml, User.class);*/
        TestBase.applicationManager.getLoginHelper().loginInvalid(user);
    }

}
