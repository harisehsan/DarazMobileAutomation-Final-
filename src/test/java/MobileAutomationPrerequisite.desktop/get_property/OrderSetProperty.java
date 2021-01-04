package MobileAutomationPrerequisite.desktop.get_property;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class OrderSetProperty {
    private Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("src\\test\\java\\MobileAutomationPrerequisite.desktop\\property\\order.property"));
    }

    private void fileOutputStream() throws IOException {
        prop.store(new FileOutputStream("src\\test\\java\\MobileAutomationPrerequisite.desktop\\property\\order.property"),null);
    }

    public void setNormalOrderNumber (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("NORMAL_ORDER_NUMBER", orderNumber);
        fileOutputStream();
    }

    public void setFreeGiftOrderNumber (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("FREE_GIFT_ORDER_NUMBER", orderNumber);
        fileOutputStream();
    }

    public void setComboOrderNumber (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("COMBO_ORDER_NUMBER", orderNumber);
        fileOutputStream();
    }

    public void setBuyMoreSaveMoreOrderNumber (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("BUY_MORE_SAVE_MORE_ORDER_NUMBER", orderNumber);
        fileOutputStream();
    }

    public void setBuyOneGetOneOrderNumber (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("BUY_ONE_GET_ONE_ORDER_NUMBER", orderNumber);
        fileOutputStream();
    }


    public void setVenture (String venture) throws IOException {
        fileInputStream();
        prop.setProperty("VENTURE", venture);
        fileOutputStream();
    }


}
