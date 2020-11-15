package MobileAutomationPrerequisite.desktop.get_property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SellerAccountsGetProperty {
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\MobileAutomationPrerequisite.desktop\\property\\sellerAccounts.property"));
    }

    public String getPKEmail() throws IOException {
        fileInputStream();
        return (prop.getProperty("PK_EMAIL"));
    }

    public String getPKPassword() throws IOException {
        fileInputStream();
        return (prop.getProperty("PK_PASSWORD"));
    }

    public String getBDEmail() throws IOException {
        fileInputStream();
        return (prop.getProperty("BD_EMAIL"));
    }

    public String getBDPassword() throws IOException {
        fileInputStream();
        return (prop.getProperty("BD_PASSWORD"));
    }

    public String getLKEmail() throws IOException {
        fileInputStream();
        return (prop.getProperty("LK_EMAIL"));
    }

    public String getLKPassword() throws IOException {
        fileInputStream();
        return (prop.getProperty("LK_PASSWORD"));
    }

    public String getNPEmail() throws IOException {
        fileInputStream();
        return (prop.getProperty("NP_EMAIL"));
    }

    public String getNPPassword() throws IOException {
        fileInputStream();
        return (prop.getProperty("NP_PASSWORD"));
    }

    public String getMMEmail() throws IOException {
        fileInputStream();
        return (prop.getProperty("MM_EMAIL"));
    }

    public String getMMPassword() throws IOException {
        fileInputStream();
        return (prop.getProperty("MM_PASSWORD"));
    }
}
