package homepage.desktop.pages;

import global.Global;
import base.*;

public class HomePage_Base  {



    public void visit_URL(String Page_URL) {
        Global.browser.goTo(Page_URL);
    }



    public void process_Login(String username, String password) {


    }


}
