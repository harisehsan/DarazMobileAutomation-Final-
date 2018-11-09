package global.helpers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class Conditions {

    private static final Logger log = Logger.getLogger(ExpectedConditions.class.getName());

    public static ExpectedCondition<Boolean> elementSrcContains(final SelenideElement elem, final String expectedValue) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    String elementText = elem.getAttribute("src");
                    return elementText.contains(expectedValue);
                } catch (StaleElementReferenceException var3) {
                    return false;
                }
            }

            public String toString() {
                return String.format("text ('%s') to be present in element %s", expectedValue, elem);
            }
        };
    }
}