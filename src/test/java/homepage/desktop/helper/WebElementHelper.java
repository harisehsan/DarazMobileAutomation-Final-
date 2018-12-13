package homepage.desktop.helper;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class WebElementHelper {

    public static boolean hasElement(By selector) {
        return Global.browser.getWebDriver().findElements(selector).size() > 0;
    }

    public static Optional<WebElement> getWebElement(By selector) {
        List<WebElement> elements = Global.browser.getWebDriver().findElements(selector);
        return elements.size() > 0 ? Optional.of(elements.get(0)) : Optional.empty();
    }
}
