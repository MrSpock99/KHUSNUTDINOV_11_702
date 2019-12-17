package tests;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.Note;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FirstTest extends AuthBase {

    @Test
    @Order(3)
    public void testAddNote() throws InterruptedException, IOException {
       /* TestBase.applicationManager.getNavigationHelper().goToLoginPage();
        User user = new User("metallica1981fan@gmail.com", "Metallica1981");
        *//*XmlMapper xmlMapper = new XmlMapper();
        File file = new File("E:/user.xml");
        String xml = inputStreamToString(new FileInputStream(file));
        User user = xmlMapper.readValue(xml, User.class);*//*
         */
        /*User user = new User("metallica1981fan@gmail.com", "Metallica1981");

        TestBase.applicationManager.getLoginHelper().login(user);
        */
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("E:/notes/note0" + ".xml");
        String xml = inputStreamToString(new FileInputStream(file));
        Note note = xmlMapper.readValue(xml, Note.class);

        TestBase.applicationManager.getNotesHelper().addNote(note);
    }

    @Test
    @Order(4)
    public void testEditNote() throws InterruptedException, IOException {
        //TestBase.applicationManager.getNavigationHelper().goToLoginPage();
        /*XmlMapper xmlMapper = new XmlMapper();
        File file = new File("E:/user.xml");
        String xml = inputStreamToString(new FileInputStream(file));
        User user = xmlMapper.readValue(xml, User.class);
*/
       /* User user = new User("metallica1981fan@gmail.com", "Metallica1981");
        TestBase.applicationManager.getLoginHelper().login(user);
       */
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("E:/notes/note0" + ".xml");
        String xml = inputStreamToString(new FileInputStream(file));
        Note oldNote = xmlMapper.readValue(xml, Note.class);

        file = new File("E:/notes/note1" + ".xml");
        xml = inputStreamToString(new FileInputStream(file));
        Note newNote = xmlMapper.readValue(xml, Note.class);

        TestBase.applicationManager.getNotesHelper().editNote(oldNote, newNote);
    }
}
