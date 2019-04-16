package pdp.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyWishlist_Page extends PageObject {
    @FindBy(css = ".wishlist-item") private List<WebElement> productlist;

    public boolean isProductDisplayed() {
        waitUntilPageReady();
        boolean productExist = false;

        for (WebElement element : productlist) {
            try{
                String myText = element.findElement(By.cssSelector("a[class~=title]")).getText();
                if (myText.equals(Global.getMap().get("currentProductTitle"))) {
                    productExist = true;
                }
            }catch (StaleElementReferenceException ex){
                productExist = false;
                break;
            }
        }
        return productExist;
    }

}
