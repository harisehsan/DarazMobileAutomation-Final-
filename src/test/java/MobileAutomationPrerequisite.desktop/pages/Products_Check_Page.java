package MobileAutomationPrerequisite.desktop.pages;

import MobileAutomationPrerequisite.desktop.get_property.PdpGetProperty;
import MobileAutomationPrerequisite.desktop.get_property.ProductsGetProperty;
import base.PageObject;
import global.Global;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class Products_Check_Page extends PageObject {
    public static String page_url = Global.getConfig().getString("member.url") + "/user/profile";

    public String digitalProduct = "Will be sent to your email address";

    @FindBy(id = "q")
    public WebElement searchBar;
    @FindBy(xpath = "//button[text()='SEARCH']")
    public WebElement searchButton;
    @FindBy(css = ".c2prKC .c1ZEkM")
    public List<WebElement> productslst;
    @FindBy(xpath = "//span[text()='Chat Now']")
    public List <WebElement> chatNowlnktxt;
    @FindBy (css = ".sku-variable-size")
    public List <WebElement> skuSizebtn;
    @FindBy (css = ".tag-name")
    public WebElement tagNamelbl;
    @FindBy (xpath = "//*[@class='next-icon next-icon-close next-icon-small']")
    public WebElement overSeasPopupClosebtn;

    public By searchBarBy = By.id("q");
    public By searchButtonBy = By.xpath("//button[text()='SEARCH']");
    public By productslstBy = By.cssSelector(".c2prKC .c1ZEkM");
    public By productTitleBy = By.cssSelector("span[class='pdp-mod-product-badge-title']");
    public By outOfStockBy = By.cssSelector("span[class='quantity-content-warning']");
    public By chatNowlnktxtBy = By.xpath("//span[text()='Chat Now']");
    public By tagNamelblBy = By.cssSelector(".tag-name");
    public By overSeasPopupClosebtnBy = By.xpath("//*[@class='next-icon next-icon-close next-icon-small']");

    ProductsGetProperty productsGetProperty = new ProductsGetProperty();
    PdpGetProperty pdpGetProperty = new PdpGetProperty();

    public void productCheck(int productNumber, String productFile) throws IOException {
        if (page_url.contains(".pk")) {
//            waitUntilPageReady();
            waitUntilClickable(searchBarBy);
            if (productFile.equalsIgnoreCase("Product")) {
                sendKeysWithoutException(searchBar, productsGetProperty.pkProducts().get(productNumber-1));
          }
            else if (productFile.equalsIgnoreCase("Pdp"))
            {
                sendKeysWithoutException(searchBar, pdpGetProperty.productPK().get(productNumber-1));
            }
      }
       else if (page_url.contains(".bd")) {
//            waitUntilPageReady();
            waitUntilClickable(searchBarBy);
            if (productFile.equalsIgnoreCase("Product")) {
                sendKeysWithoutException(searchBar, productsGetProperty.bdProducts().get(productNumber-1));
            }
            else if (productFile.equalsIgnoreCase("Pdp"))
            {
                sendKeysWithoutException(searchBar, pdpGetProperty.productBD().get(productNumber-1));
            }
        }
        else if (page_url.contains(".lk")) {
//            waitUntilPageReady();
            waitUntilClickable(searchBarBy);
            if (productFile.equalsIgnoreCase("Product")) {
                sendKeysWithoutException(searchBar, productsGetProperty.lkProducts().get(productNumber-1));
            }
            else if (productFile.equalsIgnoreCase("Pdp"))
            {
                sendKeysWithoutException(searchBar, pdpGetProperty.productLK().get(productNumber-1));
            }
        }
        else if (page_url.contains(".np")) {
//            waitUntilPageReady();
            waitUntilClickable(searchBarBy);
            if (productFile.equalsIgnoreCase("Product")) {
                sendKeysWithoutException(searchBar, productsGetProperty.npProducts().get(productNumber-1));
            }
            else if (productFile.equalsIgnoreCase("Pdp"))
            {
                sendKeysWithoutException(searchBar, pdpGetProperty.productNP().get(productNumber-1));
            }
        }
        else if (page_url.contains(".mm")) {
//            waitUntilPageReady();
            waitUntilClickable(searchBarBy);
            if (productFile.equalsIgnoreCase("Product")) {
                sendKeysWithoutException(searchBar, productsGetProperty.mmProducts().get(productNumber-1));
            }
            else if (productFile.equalsIgnoreCase("Pdp"))
            {
                sendKeysWithoutException(searchBar, pdpGetProperty.productMM().get(productNumber-1));
            }
        }
        else
            throw new RuntimeException("Venture does not exist!");

                waitUntilPresentOfElementBy(searchButtonBy);
                searchButton.click();
    }

    public void goToProduct ()
    {
        try {
            waitUntilPresentOfElementBy(productslstBy);
            waitUntilClickable(productslstBy);
            productslst.get(0).click();
            waitUntilPresentOfElementBy(productTitleBy);
        } catch (Exception e) {
           // e.printStackTrace();
            throw new RuntimeException("The product is not active or searchable!");
        }
    }

    public boolean verifyTheOutOfStock ()
    {
        return isExist(outOfStockBy);
    }

    public boolean verifyTheExistenceOfChatFeatureOnPdp()
    {
       return isExist(chatNowlnktxtBy);
    }

    public void selectTheLaskSku()
    {
        skuSizebtn.get(skuSizebtn.size()-1).click();
    }

    public boolean verifyTheExistenceOfPromotion(String promotionName)
    {
        return isExistByTextContains(promotionName);
    }

    public boolean verifyforDigitalItem()
    {
       return isExistByTextContains(digitalProduct);
    }

    public boolean verifyForTheSellerVoucher(String voucherType)
    {
        waitUntilVisibility(tagNamelblBy);
        if (booleanwaitUntilPresentOfElementBy(overSeasPopupClosebtnBy,10))
            overSeasPopupClosebtn.click();
        waitUntilClickable(tagNamelblBy);
        tagNamelbl.click();
        return isExistedByButtonText(voucherType);
    }
}
