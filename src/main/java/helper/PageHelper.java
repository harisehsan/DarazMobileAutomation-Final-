package helper;

import global.Global;
import org.openqa.selenium.By;
import pages.PageObject;

public class PageHelper extends PageObject {

    public static String GetVenture(){

        String url = Global.browser.getUrl();
        if (url.contains("lazada.vn"))
            return "VN";
        else if (url.contains("lazada.co.id"))
            return "ID";
        else if (url.contains("lazada.sg"))
            return "SG";
        else if (url.contains("lazada.co.th"))
            return "TH";
        else if (url.contains("lazada.com.my"))
            return "MY";
        else if (url.contains("lazada.com.ph"))
            return "PH";
        else
            return "null";
    }
    public static By getByXpath(String xpathSG, String xpathTH){
        String country = PageHelper.GetVenture();

        return null;
    }
    public static By getByCss(String css){
        String country = PageHelper.GetVenture();
        return null;
    }
    public static By getByID(String css){
        return null;
    }
}
