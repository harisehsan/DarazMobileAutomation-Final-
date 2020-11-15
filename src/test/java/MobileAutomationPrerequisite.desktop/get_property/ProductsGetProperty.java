package MobileAutomationPrerequisite.desktop.get_property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Developed By: Muhammad Haris Ehsan
 * Date: 10-July-2019
 */

public class ProductsGetProperty {
    Properties prop = new Properties();

    private void fileInputStream() throws IOException {
        prop.load(new FileInputStream("D:\\Haris\\MobileAutomation2\\MobileAutomation\\src\\test\\java\\member\\APP\\properties\\products.properties"));
    }

    public List<String> pkProducts() throws IOException {
        fileInputStream();
        List<String> pkProducts = new ArrayList<>();
        pkProducts.add(prop.getProperty("TEST_PRODUCT1_PK"));
        pkProducts.add(prop.getProperty("TEST_PRODUCT2_PK"));
        pkProducts.add(prop.getProperty("TEST_PRODUCT3_PK"));
        pkProducts.add(prop.getProperty("TEST_PRODUCT4_PK"));
        pkProducts.add(prop.getProperty("TEST_PRODUCT5_PK"));
        pkProducts.add(prop.getProperty("TEST_PRODUCT6_PK"));
        return pkProducts;
    }

    public List<String> bdProducts() throws IOException {
        fileInputStream();
        List<String> bdProducts = new ArrayList<>();
        bdProducts.add(prop.getProperty("TEST_PRODUCT1_BD"));
        bdProducts.add(prop.getProperty("TEST_PRODUCT2_BD"));
        bdProducts.add(prop.getProperty("TEST_PRODUCT3_BD"));
        bdProducts.add(prop.getProperty("TEST_PRODUCT4_BD"));
        bdProducts.add(prop.getProperty("TEST_PRODUCT5_BD"));
        return bdProducts;
    }

    public List<String> lkProducts() throws IOException {
        fileInputStream();
        List<String> lkProducts = new ArrayList<>();
        lkProducts.add(prop.getProperty("TEST_PRODUCT1_LK"));
        lkProducts.add(prop.getProperty("TEST_PRODUCT2_LK"));
        lkProducts.add(prop.getProperty("TEST_PRODUCT3_LK"));
        lkProducts.add(prop.getProperty("TEST_PRODUCT4_LK"));
        lkProducts.add(prop.getProperty("TEST_PRODUCT5_LK"));
        return lkProducts;
    }

    public List<String> npProducts() throws IOException {
        fileInputStream();
        List<String> npProducts = new ArrayList<>();
        npProducts.add(prop.getProperty("TEST_PRODUCT1_NP"));
        npProducts.add(prop.getProperty("TEST_PRODUCT2_NP"));
        npProducts.add(prop.getProperty("TEST_PRODUCT3_NP"));
        npProducts.add(prop.getProperty("TEST_PRODUCT4_NP"));
        npProducts.add(prop.getProperty("TEST_PRODUCT5_NP"));
        return npProducts;
    }

    public List<String> mmProducts() throws IOException {
        fileInputStream();
        List<String> mmProducts = new ArrayList<>();
        mmProducts.add(prop.getProperty("TEST_PRODUCT1_MM"));
        mmProducts.add(prop.getProperty("TEST_PRODUCT2_MM"));
        mmProducts.add(prop.getProperty("TEST_PRODUCT3_MM"));
        mmProducts.add(prop.getProperty("TEST_PRODUCT4_MM"));
        mmProducts.add(prop.getProperty("TEST_PRODUCT5_MM"));
        return mmProducts;
    }
}