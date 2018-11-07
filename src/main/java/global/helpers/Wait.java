package global.helpers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Wait {



    public void waitUntilClickable(SelenideElement elem) {
        WebDriver driver = getWebDriver();
        WebElement webElem = elem.toWebElement();
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(webElem));
    }

    public void waitUntilValueNotEmpty (final SelenideElement elem) {
        WebDriver driver = getWebDriver();
        new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                if (elem.getValue().length() > 0)
                    return true;
                else
                    return false;
            }
        });
    }

    public void waitUntilUrlContant(final String expectedValue) {
        WebDriver driver = getWebDriver();
        new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                if (url().contains(expectedValue))
                    return true;
                else
                    return false;
            }
        });
    }


    public void waitUntilSrcContent(SelenideElement elem, String expectedValue) {
        WebDriver driver = getWebDriver();
        new WebDriverWait(driver, 30)
                .until(Conditions.elementSrcContains(elem, expectedValue));
    }











}

