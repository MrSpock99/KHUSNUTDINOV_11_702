package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected static ApplicationManager applicationManager;

    @BeforeEach
    public void before() {
        applicationManager = ApplicationManager.getInstance();
    }
}
