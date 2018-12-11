package _base.page_helpers;

import global.Global;

public class BuyerSitePageHelper {

    public static void switchToEnglish(){
        String languageCookieValue = Global.browser.getCookiesAsMap().get("hng");
        String [] languageValueCookieSplit = languageCookieValue.split("\\|");
        String defaultLanguage = languageValueCookieSplit[1].split("-")[0];
        String englishCookieValue = languageCookieValue.replace(defaultLanguage,"en");
        Global.browser.addCookie("hng",englishCookieValue);
        Global.browser.refresh();
    }
}