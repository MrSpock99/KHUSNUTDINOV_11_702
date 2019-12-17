package helpers;

import manager.ApplicationManager;
import model.User;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import settings.Settings;

import java.io.IOException;
import java.util.List;

public class LoginHelper extends HelperBase{
    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(User user) throws IOException {
        WebElement emailField = driver.findElement(By.id("loginEmail"));
        List<WebElement> passwordField = driver.findElements(By.id("password"));
        List<WebElement> loginBtn = driver.findElements(By.id("submit"));

        emailField.sendKeys(user.getEmail());

        passwordField.get(1).sendKeys(user.getPassword());

        loginBtn.get(1).click();
        Assert.assertEquals(Settings.getBaseUrl(), driver.getCurrentUrl());
    }

    public String logout() {
        WebElement logoutBtn = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/nav/div[2]/div[2]/div/ul/li[5]/a")));
        logoutBtn.click();
        logoutBtn = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/nav/div[2]/div[2]/div/ul/li[4]/a")));
        Assert.assertEquals("Register/Login", logoutBtn.getAttribute("innerText"));

        return logoutBtn.getAttribute("innerText");
    }

    public void loginInvalid(User user) throws IOException {
        WebElement emailField = driver.findElement(By.id("loginEmail"));
        List<WebElement> passwordField = driver.findElements(By.id("password"));
        List<WebElement> loginBtn = driver.findElements(By.id("submit"));

        emailField.sendKeys(user.getEmail());

        passwordField.get(1).sendKeys(user.getPassword());

        loginBtn.get(1).click();
        Assert.assertEquals(Settings.getBaseUrl() + "create_account", driver.getCurrentUrl());
    }

    public boolean isLogged() throws IOException {
        return (Settings.getBaseUrl() + "create_account").equals(driver.getCurrentUrl());
    }
}
