package _base.page_helpers;

import global.Global;

public class BuyerSitePageHelper {

    public static void switchToEnglish(){
        String languageCookieValue = Global.getBrowser().getCookiesAsMap().get("hng");
        String [] languageValueCookieSplit = languageCookieValue.split("\\|");
        String defaultLanguage = languageValueCookieSplit[1].split("-")[0];
        if(!defaultLanguage.equalsIgnoreCase("en")){
            String englishCookieValue = languageCookieValue.replace(defaultLanguage,"en");
            Global.getBrowser().addCookie("hng",englishCookieValue);
            Global.getBrowser().refresh();
        }
    }
}