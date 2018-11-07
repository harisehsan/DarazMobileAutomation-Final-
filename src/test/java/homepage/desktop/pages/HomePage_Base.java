package homepage.PC.pages;

import global.Global;

public class HomePage_Base  {



    public void visit_URL(String Page_URL) {
        Global.browser.goTo(Page_URL);

    }



    public void process_Login(String username, String password) {


    }

    public void backToHomePage(){

    }
}
