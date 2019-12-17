package settings;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.SettingsData;
import model.User;

import java.io.*;

public class Settings {

    private static SettingsData settingsData;
    private static String baseUrl;
    private static User baseUser;
    private static XmlMapper xmlMapper = new XmlMapper();

    public static String getBaseUrl() throws IOException {
        File file = new File("settings" + ".xml");
        String xml = inputStreamToString(new FileInputStream(file));
        settingsData = xmlMapper.readValue(xml, SettingsData.class);
        baseUrl = settingsData.getBaseUrl();
        return baseUrl;
    }

    public static User getBaseUser() throws IOException {
        File file = new File("settings" + ".xml");
        String xml = inputStreamToString(new FileInputStream(file));
        settingsData = xmlMapper.readValue(xml, SettingsData.class);
        baseUser = settingsData.getUser();
        return baseUser;
    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
