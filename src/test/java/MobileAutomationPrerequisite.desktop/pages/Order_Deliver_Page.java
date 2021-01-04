package MobileAutomationPrerequisite.desktop.pages;

import MobileAutomationPrerequisite.desktop.get_property.DeliveredOrderedSetProperty;
import MobileAutomationPrerequisite.desktop.get_property.OrderGetProperty;
import MobileAutomationPrerequisite.desktop.get_property.OrderSetProperty;
import MobileAutomationPrerequisite.desktop.get_property.SellerAccountsGetProperty;
import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class Order_Deliver_Page extends PageObject {

    OrderSetProperty orderSetProperty = new OrderSetProperty();
    OrderGetProperty orderGetProperty = new OrderGetProperty();
    SellerAccountsGetProperty sellerAccountsGetProperty = new SellerAccountsGetProperty();
    DeliveredOrderedSetProperty deliveredOrderedSetProperty = new DeliveredOrderedSetProperty();
    public static final String page_url = Global.getConfig().getString("homepage.home_url");
    String PK_Seller_Url = "https://sellercenter.daraz.pk/order/query";
    String BD_Seller_Url = "https://sellercenter.daraz.com.bd/order/query";
    String LK_Seller_Url = "https://sellercenter.daraz.lk/order/query";
    String NP_Seller_Url = "https://sellercenter.daraz.com.np/order/query";
    String MM_Seller_Url = "https://sellercenter.shop.com.mm/order/query";
    String Seller_Invoice = "123";
    String Order_Push_Tool_Url = "https://imp-test-pre.alibaba-inc.com/ofc/autoPushForwardOrder?venture=";


    @FindBy(xpath = "//span[text()='Buy Now']")
    private WebElement buyNowbtn;
    @FindBy(xpath = "//button[text()='Google']")
    private WebElement googlebtn;
    @FindBy(xpath = "//div[contains(text(),'Use another account')]")
    private WebElement useAnotherAccountlnktxt;
    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement emailtxtbox;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    private WebElement nextbtn;
    @FindBy(css = "input[name='password']")
    private WebElement passwordtxtbox;
    @FindBy (css = "//span[contains(text(),'Allow')]")
    private WebElement allowbtn;
    @FindBy (xpath = "//a[contains(text(),'ogin')] | //a[contains(text(),'OGIN')]")
    private WebElement loginbtn;
    @FindBy (xpath = "//span[@class='thank-you-order-number']")
    private WebElement orderNumberlbl;
    @FindBy (xpath = "//span[@class='step-close']")
    private WebElement orderManagementClosebtn;
    @FindBy (xpath = "//input[@type='text'][@name='orderNumber']")
    private WebElement sellerOrdertxtbox;
    @FindBy (xpath = "//button[text()='Search']")
    private WebElement sellerSearchbtn;
    @FindBy (xpath = "//a[text()='Ready To Ship'] | //a[text()='Ready to Ship']")
    private WebElement readyToShiplnktxt;
    @FindBy (css = " div#dialog-body-1 input[type='text']")
    private WebElement sellerInvoicetxtbox;
    @FindBy (xpath = "//button[text()='Save invoice ID']")
    private WebElement sellerSaveInvoicebtn;
    @FindBy (xpath = "//button[text()='Ready to ship']")
    private WebElement sellerReadyToShipbtn;
    @FindBy (xpath = "//input[@type='text'][@name='TPL_username']")
    private WebElement sellerEmailtxtbox;
    @FindBy (xpath = "//input[@type='password'][@name='TPL_password']")
    private WebElement sellerPasswordtxtbox;
    @FindBy (xpath = "//button[text()='SIGN IN']")
    private WebElement sellerSignInbtn;
    @FindBy(xpath = "//input[@type='text'][@name='domainAccount']")
    private WebElement alibabaUserNametxtbox;
    @FindBy(xpath = "//input[@type='password'][@name='password']")
    private WebElement alibabaPasswordtxtbox;
    @FindBy(xpath = "//text()[.='Login']/ancestor::button[1]")
    private WebElement alibabaLoginbtn;
    @FindBy(xpath = "//*[@name='tradeOrderId']")
    private WebElement alibabaTradeOrdertxtbox;
    @FindBy(xpath = "//text()[contains(.,'WAREHOUSE_ACCEPTED')]/ancestor::span[1]")
    private WebElement warehHouseAcceptedOrderStatus;
    @FindBy(xpath = "//span[text()='DELIVERED']")
    private WebElement deliveredOrderStatus;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement orderStatusSubmitbtn;
    @FindBy (xpath = "//button[text()='Create Package']")
    private WebElement createPackagebtn;
    @FindBy (xpath = "//span[text()='ADD 2 PRODUCTS TO CART']")
    private WebElement addComboToCart;
    @FindBy (xpath = "//button[text()='CHECK OUT']")
    private WebElement checkOutbtn;
    @FindBy (xpath = "//*[@class='lzd-layout-next-icon lzd-layout-next-icon-close lzd-layout-next-icon-xs closeAd']")
    private WebElement hubPopupClosebtn;


    private By googlebtnBy = By.xpath("//button[text()='Google']");
    public By useAnotherAccountlnktxtBy = By.xpath("//div[contains(text(),'Use another account')");
    private By emailtxtboxBy = By.xpath("//input[@id='identifierId']");
    private By nextbtnBy = By.xpath("//span[contains(text(),'Next')]");
    public By allowbtnBy = By.xpath("//span[contains(text(),'Allow')]");
    private By passwordtxtBoxBy = By.xpath("//div[contains(text(),'Enter your password')]");
    private By loginbtnBy = By.xpath("//a[contains(text(),'ogin')] | //a[contains(text(),'OGIN')]");
    private By orderManagementClosebtnBy = By.xpath("//span[@class='step-close']");
    private By sellerOrdertxtboxBy = By.xpath("//input[@type='text'][@name='orderNumber']");
    private By readyToShiplnktxtBy = By.xpath("//a[text()='Ready To Ship'] | //a[text()='Ready to Ship']");
    private By sellerInvoicetxtboxBy = By.cssSelector("div#dialog-body-1 input[type='text']");
    private By sellerSaveInvoicebtnBy = By.xpath("//button[text()='Save invoice ID']");
    private By sellerReadyToShipbtnBy = By.xpath("//button[text()='Ready to ship'] | //button[text()='Ready to Ship']");
    private By sellerRTSPopupClosebtnBy = By.xpath("//button[text()='Close']");
    private By sellerEmailtxtboxBy = By.xpath("//input[@type='text'][@name='TPL_username']");
    private By alibabaUserNametxtboxBy = By.xpath("//input[@type='text'][@name='domainAccount']");
    private By alibabaLoginbtnBy = By.xpath("//text()[.='Login']/ancestor::button[1]");
    private By alibabaTradeOrdertxtboxBy = By.xpath("//*[@name='tradeOrderId']");
    private By deliveredOrderStatusBy = By.xpath("//span[text()='DELIVERED']");
    private By warehHouseAcceptedOrderStatusBy = By.xpath("//text()[contains(.,'WAREHOUSE_ACCEPTED')]/ancestor::span[1]");
    private By orderStatusSubmitbtnBy = By.xpath("//button[text()='Submit']");
    private By orderDeliveredSuccessBy = By.xpath("//div[contains(text(),'success')] | //div[contains(text(),'Success')]");
    private By hubPopupClosebtnBy = By.xpath("//*[@class='lzd-layout-next-icon lzd-layout-next-icon-close lzd-layout-next-icon-xs closeAd']");


    String winHandleBefore = driver.getWindowHandle();


    public void selectBuyNowbutton()
    {
        buyNowbtn.click();
    }

    public void selectGooglebutton()
    {

      loginbtn.click();
        // Perform the click operation that opens new window

// Switch to new window opened

        waitUntilClickable(googlebtnBy);
        googlebtn.click();
//        waitUntilClickable(useAnotherAccountlnktxtBy);
//        useAnotherAccountlnktxt.click();
    }

    public void signinWithGoogle(String emailAddress, String password)
    {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

       waitUntilClickable(emailtxtboxBy);
       emailtxtbox.clear();
        emailtxtbox.sendKeys(emailAddress);
        waitUntilClickable(nextbtnBy);
        clickWithoutException(nextbtn);
        waitUntilClickable(passwordtxtBoxBy);
        passwordtxtbox.clear();
        passwordtxtbox.sendKeys(password);
        waitUntilClickable(nextbtnBy);
        clickWithoutException(nextbtn);
        waitUntilClickable(nextbtnBy);
//       clickWithoutException(allowbtn);
// Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
        waitLongUntilInvisibilityOf(loginbtnBy,60);
    }

    public void saveTheOrderNumberAndVenture(String orderType) throws IOException {
      switch (orderType) {

          case "Normal":
            orderSetProperty.setNormalOrderNumber(orderNumberlbl.getText());
            break;

          case "Free Gift":
              orderSetProperty.setFreeGiftOrderNumber(orderNumberlbl.getText());
              break;

          case "Combo":
              orderSetProperty.setComboOrderNumber(orderNumberlbl.getText());
              break;

          case "Save More":
              orderSetProperty.setBuyMoreSaveMoreOrderNumber(orderNumberlbl.getText());
              break;

          case "B1G1":
              orderSetProperty.setBuyOneGetOneOrderNumber(orderNumberlbl.getText());
              break;
      }
        if(driver.getCurrentUrl().contains("pk"))
            orderSetProperty.setVenture("pk");
        else if (driver.getCurrentUrl().contains("bd"))
            orderSetProperty.setVenture("bd");
        else if (driver.getCurrentUrl().contains("lk"))
            orderSetProperty.setVenture("lk");
        else if (driver.getCurrentUrl().contains("np"))
            orderSetProperty.setVenture("np");
        else
            orderSetProperty.setVenture("mm");
    }

    public void goToSellerOrderManagement(String orderType) throws IOException {
        switch (orderGetProperty.getVenture())
        {
            case "pk":
            {
               driver.navigate().to(PK_Seller_Url);
            }
            break;
            case "bd":
            {
                driver.navigate().to(BD_Seller_Url);
            }
            break;
            case "lk":
            {
                driver.navigate().to(LK_Seller_Url);
            }
            break;
            case "np":
            {
                driver.navigate().to(NP_Seller_Url);
            }
            break;
            case "mm":
            {
                driver.navigate().to(MM_Seller_Url);
            }
            break;
        }
        signIntoSellerCenter(orderGetProperty.getVenture());
        if (booleanwaitUntilPresentOfElementBy(hubPopupClosebtnBy,10))
            hubPopupClosebtn.click();
        waitUntilClickable(orderManagementClosebtnBy);
        orderManagementClosebtn.click();
        waitUntilClickable(sellerOrdertxtboxBy);
        sellerOrdertxtbox.sendKeys(getOrderNumber(orderType));
        sellerSearchbtn.click();
        waitUntilClickable(readyToShiplnktxtBy);
        readyToShiplnktxt.click();
        markOrderRTS();
    }



    public void makeTheOrderDelivered(String orderType) throws IOException {
        waitUntilClickable(alibabaTradeOrdertxtboxBy,1000);
        alibabaTradeOrdertxtbox.sendKeys(getOrderNumber(orderType));
        warehHouseAcceptedOrderStatus.click();
        waitUntilClickable(deliveredOrderStatusBy);
        deliveredOrderStatus.click();
        waitUntilInvisibilityOf(warehHouseAcceptedOrderStatusBy);
        waitUntilClickable(orderStatusSubmitbtnBy);
        orderStatusSubmitbtn.click();
        }

    public void goToOrderPushTool() throws IOException {
        driver.navigate().to(Order_Push_Tool_Url+orderGetProperty.getVenture());
    }

    public void loginUsingAliBabaAccount(String email, String password) {
        waitUntilClickable(alibabaUserNametxtboxBy);
        alibabaUserNametxtbox.sendKeys(email);
        alibabaPasswordtxtbox.sendKeys(password);
        waitUntilClickable(alibabaLoginbtnBy);
        alibabaLoginbtn.click();
    }

    private void markOrderRTS() throws IOException {

        if(orderGetProperty.getVenture().equalsIgnoreCase("bd"))
        {
            waitUntilVisible(createPackagebtn);
            createPackagebtn.click();
        }
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
//        waitUntilVisible(sellerInvoicetxtbox);
      if (booleanwaitUntilPresentOfElementBy(sellerInvoicetxtboxBy,20)) {
          sellerInvoicetxtbox.sendKeys(Seller_Invoice);
      }
        waitUntilClickable(sellerSaveInvoicebtnBy);
        sellerSaveInvoicebtn.click();
        waitUntilClickable(sellerReadyToShipbtnBy);
        sellerReadyToShipbtn.click();
        waitUntilPresentOfElementBy(sellerRTSPopupClosebtnBy);
        driver.switchTo().window(winHandleBefore);
    }

    private void signIntoSellerCenter(String venture) throws IOException {
        waitUntilClickable(sellerEmailtxtboxBy);
        switch (venture)
        {
            case "pk":
            {
                sellerEmailtxtbox.sendKeys(sellerAccountsGetProperty.getPKEmail());
                sellerPasswordtxtbox.sendKeys(sellerAccountsGetProperty.getPKPassword());
            }
            break;

            case "bd":
            {
                sellerEmailtxtbox.sendKeys(sellerAccountsGetProperty.getBDEmail());
                sellerPasswordtxtbox.sendKeys(sellerAccountsGetProperty.getBDPassword());
            }
            break;

            case "lk":
            {
                sellerEmailtxtbox.sendKeys(sellerAccountsGetProperty.getLKEmail());
                sellerPasswordtxtbox.sendKeys(sellerAccountsGetProperty.getLKPassword());
            }
            break;

            case "np":
            {
                sellerEmailtxtbox.sendKeys(sellerAccountsGetProperty.getNPEmail());
                sellerPasswordtxtbox.sendKeys(sellerAccountsGetProperty.getNPPassword());
            }
            break;

            case "mm":
            {
                sellerEmailtxtbox.sendKeys(sellerAccountsGetProperty.getMMEmail());
                sellerPasswordtxtbox.sendKeys(sellerAccountsGetProperty.getMMPassword());
            }
            break;

        }
        sellerSignInbtn.click();
    }

    public boolean verifyForTheOrderSuccessStatus()
    {
        return booleanwaitUntilPresentOfElementBy(orderDeliveredSuccessBy,30);
    }

    public void saveDeliveredOrderedNumber(String productType) throws IOException {

        switch (orderGetProperty.getVenture())
        {
            case "pk":
            {
               if (productType.equalsIgnoreCase("Normal"))
                   deliveredOrderedSetProperty.pkNormalOrder(orderGetProperty.getNormalOrderNumber());
               else if (productType.equalsIgnoreCase("B1G1"))
                   deliveredOrderedSetProperty.pkB1G1Order(orderGetProperty.getBuyOneGetOneOrderNumber());
               else if (productType.equalsIgnoreCase("Free Gift"))
                   deliveredOrderedSetProperty.pkFreeGiftOrder(orderGetProperty.getFreeGiftOrderNumber());
               else if (productType.equalsIgnoreCase("Save More"))
                   deliveredOrderedSetProperty.pkBuyMoreSaveMoreOrder(orderGetProperty.getBuyMoreSaveMoreOrderNumber());
               else
                   deliveredOrderedSetProperty.pkComboOrder(orderGetProperty.getComboOrderNumber());
            }
            break;

            case "bd":
            {
                if (productType.equalsIgnoreCase("Normal"))
                    deliveredOrderedSetProperty.bdNormalOrder(orderGetProperty.getNormalOrderNumber());
                else if (productType.equalsIgnoreCase("B1G1"))
                    deliveredOrderedSetProperty.bdB1G1Order(orderGetProperty.getBuyOneGetOneOrderNumber());
                else if (productType.equalsIgnoreCase("Free Gift"))
                    deliveredOrderedSetProperty.bdFreeGiftOrder(orderGetProperty.getFreeGiftOrderNumber());
                else if (productType.equalsIgnoreCase("Save More"))
                    deliveredOrderedSetProperty.bdBuyMoreSaveMoreOrder(orderGetProperty.getBuyMoreSaveMoreOrderNumber());
                else
                    deliveredOrderedSetProperty.bdComboOrder(orderGetProperty.getComboOrderNumber());
            }
            break;

            case "lk":
            {
                if (productType.equalsIgnoreCase("Normal"))
                    deliveredOrderedSetProperty.lkNormalOrder(orderGetProperty.getNormalOrderNumber());
                else if (productType.equalsIgnoreCase("B1G1"))
                    deliveredOrderedSetProperty.lkB1G1Order(orderGetProperty.getBuyOneGetOneOrderNumber());
                else if (productType.equalsIgnoreCase("Free Gift"))
                    deliveredOrderedSetProperty.lkFreeGiftOrder(orderGetProperty.getFreeGiftOrderNumber());
                else if (productType.equalsIgnoreCase("Save More"))
                    deliveredOrderedSetProperty.lkBuyMoreSaveMoreOrder(orderGetProperty.getBuyMoreSaveMoreOrderNumber());
                else
                    deliveredOrderedSetProperty.lkComboOrder(orderGetProperty.getComboOrderNumber());
            }
            break;

            case "np":
            {
                if (productType.equalsIgnoreCase("Normal"))
                    deliveredOrderedSetProperty.npNormalOrder(orderGetProperty.getNormalOrderNumber());
                else if (productType.equalsIgnoreCase("B1G1"))
                    deliveredOrderedSetProperty.npB1G1Order(orderGetProperty.getBuyOneGetOneOrderNumber());
                else if (productType.equalsIgnoreCase("Free Gift"))
                    deliveredOrderedSetProperty.npFreeGiftOrder(orderGetProperty.getFreeGiftOrderNumber());
                else if (productType.equalsIgnoreCase("Save More"))
                    deliveredOrderedSetProperty.npBuyMoreSaveMoreOrder(orderGetProperty.getBuyMoreSaveMoreOrderNumber());
                else
                    deliveredOrderedSetProperty.npComboOrder(orderGetProperty.getComboOrderNumber());
            }
            break;

            case "mm":
            {
                if (productType.equalsIgnoreCase("Normal"))
                    deliveredOrderedSetProperty.mmNormalOrder(orderGetProperty.getNormalOrderNumber());
                else if (productType.equalsIgnoreCase("B1G1"))
                    deliveredOrderedSetProperty.mmB1G1Order(orderGetProperty.getBuyOneGetOneOrderNumber());
                else if (productType.equalsIgnoreCase("Free Gift"))
                    deliveredOrderedSetProperty.mmFreeGiftOrder(orderGetProperty.getFreeGiftOrderNumber());
                else if (productType.equalsIgnoreCase("Save More"))
                    deliveredOrderedSetProperty.mmBuyMoreSaveMoreOrder(orderGetProperty.getBuyMoreSaveMoreOrderNumber());
                else
                    deliveredOrderedSetProperty.mmComboOrder(orderGetProperty.getComboOrderNumber());
            }
            break;
        }

    }

    public void addComboToCart()
    {
        waitUntilVisible(addComboToCart);
        addComboToCart.click();
        waitUntilVisible(checkOutbtn);
        checkOutbtn.click();
    }

    private String getOrderNumber(String orderType) throws IOException {
          switch (orderType)
          {
              case "Normal":
               return orderGetProperty.getNormalOrderNumber();

              case "Free Gift":
                return orderGetProperty.getFreeGiftOrderNumber();

              case "Combo":
                 return orderGetProperty.getComboOrderNumber();

              case "Save More":
                 return orderGetProperty.getBuyMoreSaveMoreOrderNumber();

              case "B1G1":
                 return orderGetProperty.getBuyOneGetOneOrderNumber();

              default:
                 throw new RuntimeException("Order Number Not Found!");
          }
    }
}
