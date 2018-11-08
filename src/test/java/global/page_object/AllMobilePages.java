package global.page_object;

import com.codeborne.selenide.SelenideElement;
import global.helpers.AbstractPage;
import global.helpers.NameOfElement;
import org.openqa.selenium.support.FindBy;

public class AllMobilePages extends AbstractPage {

    @NameOfElement("Grey area")
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div[3]/div/div")
    public SelenideElement greyArea;

}
