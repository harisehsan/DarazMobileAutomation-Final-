package MobileAutomationPrerequisite.desktop.get_property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderGetProperty {
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\MobileAutomationPrerequisite.desktop\\property\\order.property"));
    }

    public String getNormalOrderNumber() throws IOException {
        fileInputStream();
       return (prop.getProperty("NORMAL_ORDER_NUMBER"));
    }

    public String getFreeGiftOrderNumber() throws IOException {
        fileInputStream();
        return (prop.getProperty("FREE_GIFT_ORDER_NUMBER"));
    }

    public String getComboOrderNumber() throws IOException {
        fileInputStream();
        return (prop.getProperty("COMBO_ORDER_NUMBER"));
    }

    public String getBuyMoreSaveMoreOrderNumber() throws IOException {
        fileInputStream();
        return (prop.getProperty("BUY_MORE_SAVE_MORE_ORDER_NUMBER"));
    }

    public String getBuyOneGetOneOrderNumber() throws IOException {
        fileInputStream();
        return (prop.getProperty("BUY_ONE_GET_ONE_ORDER_NUMBER"));
    }



    public String getVenture() throws IOException {
        fileInputStream();
        return (prop.getProperty("VENTURE"));
    }


}
