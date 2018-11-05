package ngoc_checkout_practice.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class Cart_Page extends PageObject {

    @FindBy(css = ".content") private List<WebElement> productlist;


    @FindBy(css = ".automation-checkout-order-total-button-cartButton") private WebElement goToCart_btn;
    public void clickGoToCartButton()
    {
        waitUntilVisible(goToCart_btn);
        goToCart_btn.click();
    }


    public boolean checkProductExistInTheList(){
        boolean productExist = false;
        for (WebElement element : productlist) {
            String myText = element.findElement(By.cssSelector("a[class~=title]")).getText();

            if (myText.equals(Global.map.get("ProductTitle"))) {
                productExist = true;
            }

        }
        return productExist;

        }

}
