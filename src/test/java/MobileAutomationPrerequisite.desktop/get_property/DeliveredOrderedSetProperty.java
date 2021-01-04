package MobileAutomationPrerequisite.desktop.get_property;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DeliveredOrderedSetProperty {
    private Properties prop = new Properties();


    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("D:\\Haris\\MobileAutomation2\\MobileAutomation\\src\\test\\java\\global\\APP\\properties\\delivered.property"));
    }

    private void fileOutputStream() throws IOException {
        prop.store(new FileOutputStream("D:\\Haris\\MobileAutomation2\\MobileAutomation\\src\\test\\java\\global\\APP\\properties\\delivered.property"),null);
    }

    public void pkNormalOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("NORMAL_PK", orderNumber);
        fileOutputStream();
    }

    public void pkB1G1Order (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("B1G1_PK", orderNumber);
        fileOutputStream();
    }

    public void pkFreeGiftOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("FG_PK", orderNumber);
        fileOutputStream();
    }

    public void pkBuyMoreSaveMoreOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("BMSM_PK", orderNumber);
        fileOutputStream();
    }

    public void pkComboOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("COMBO_PK", orderNumber);
        fileOutputStream();
    }

    public void bdNormalOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("NORMAL_BD", orderNumber);
        fileOutputStream();
    }

    public void bdB1G1Order (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("B1G1_BD", orderNumber);
        fileOutputStream();
    }

    public void bdFreeGiftOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("FG_BD", orderNumber);
        fileOutputStream();
    }

    public void bdBuyMoreSaveMoreOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("BMSM_BD", orderNumber);
        fileOutputStream();
    }

    public void bdComboOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("COMBO_BD", orderNumber);
        fileOutputStream();
    }

    public void lkNormalOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("NORMAL_LK", orderNumber);
        fileOutputStream();
    }

    public void lkB1G1Order (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("B1G1_LK", orderNumber);
        fileOutputStream();
    }

    public void lkFreeGiftOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("FG_LK", orderNumber);
        fileOutputStream();
    }

    public void lkBuyMoreSaveMoreOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("BMSM_LK", orderNumber);
        fileOutputStream();
    }

    public void lkComboOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("COMBO_LK", orderNumber);
        fileOutputStream();
    }

    public void npNormalOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("NORMAL_NP", orderNumber);
        fileOutputStream();
    }

    public void npB1G1Order (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("B1G1_NP", orderNumber);
        fileOutputStream();
    }

    public void npFreeGiftOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("FG_NP", orderNumber);
        fileOutputStream();
    }

    public void npBuyMoreSaveMoreOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("BMSM_NP", orderNumber);
        fileOutputStream();
    }

    public void npComboOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("COMBO_NP", orderNumber);
        fileOutputStream();
    }

    public void mmNormalOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("NORMAL_MM", orderNumber);
        fileOutputStream();
    }

    public void mmB1G1Order (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("B1G1_MM", orderNumber);
        fileOutputStream();
    }

    public void mmFreeGiftOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("FG_MM", orderNumber);
        fileOutputStream();
    }

    public void mmBuyMoreSaveMoreOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("BMSM_MM", orderNumber);
        fileOutputStream();
    }

    public void mmComboOrder (String orderNumber) throws IOException {
        fileInputStream();
        prop.setProperty("COMBO_MM", orderNumber);
        fileOutputStream();
    }











}
