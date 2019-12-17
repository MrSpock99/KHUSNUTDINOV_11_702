import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class TestDataGenerator {
    public static void main(String[] args) throws IOException {
        //generateNotes();
        generateSettingsData();
    }

    public static void generateNotes() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        for (int i = 0; i < 2; i++) {
            xmlMapper.writeValue(new File("E:/notes/note" + i + ".xml"),
                    new Note(Utils.INSTANCE.generateRandomString(5),
                            Utils.INSTANCE.generateRandomString(5)));
        }
    }

    public static void generateSettingsData() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        SettingsData settingsData = new SettingsData();
        settingsData.setUser(new User("metallica1981fan@gmail.com", "Metallica1981"));
        settingsData.setBaseUrl("https://anotepad.com/");
        xmlMapper.writeValue(new File("settings.xml"), settingsData);
    }
}
