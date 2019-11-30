package tests;

import model.Note;
import model.User;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FirstTest extends TestBase {

    @Test
    @Order(1)
    public void test() throws InterruptedException {
        TestBase.applicationManager.getNavigationHelper().goToLoginPage();
        User user = new User("metallica1981fan@gmail.com", "Metallica1981");
        TestBase.applicationManager.getLoginHelper().login(user);
        TestBase.applicationManager.getLoginHelper().logout();
    }

    @Test
    @Order(2)
    public void test2() throws InterruptedException {
        TestBase.applicationManager.getNavigationHelper().goToLoginPage();
        User user = new User("metallica1981fan@gmail.com", "Metallica1981");
        TestBase.applicationManager.getLoginHelper().login(user);
        Note note = new Note("a", "b");
        TestBase.applicationManager.getNotesHelper().addNote(note);
    }

    @Test
    @Order(3)
    public void testEditNote() throws InterruptedException {
        TestBase.applicationManager.getNavigationHelper().goToLoginPage();
        User user = new User("metallica1981fan@gmail.com", "Metallica1981");
        TestBase.applicationManager.getLoginHelper().login(user);
        Note oldNote = new Note("a", "b");
        Note newNote = new Note("hahaha", "b");
        TestBase.applicationManager.getNotesHelper().editNote(oldNote, newNote);
    }
}
