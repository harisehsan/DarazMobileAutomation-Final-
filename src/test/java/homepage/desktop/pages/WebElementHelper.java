package homepage.desktop.pages;

import global.Global;
import org.openqa.selenium.By;

public class WebElementHelper {

    static boolean hasElement(By selector) {
        return Global.browser.getWebDriver().findElements(selector).size() > 0;
    }

}
