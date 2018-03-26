package helper;

import global.Global;
import pages.PageObject;

public class PageHelper extends PageObject {

    public String GetVenture(){

        String url = Global.browser.getUrl();
        if (url.contains(""))
        return "";

    }
}
