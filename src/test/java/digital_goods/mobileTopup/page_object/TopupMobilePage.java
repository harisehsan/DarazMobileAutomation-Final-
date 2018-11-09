package digital_goods.mobileTopup.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import global.helpers.AbstractPage;
import global.helpers.NameOfElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TopupMobilePage extends AbstractPage {

    @NameOfElement("Phone input")
    @FindBy(xpath = "//*[@id='phoneInput']")
    public SelenideElement phoneInput;

    @NameOfElement("Phone input error")
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[3]")
    public SelenideElement phoneInputError;

    @NameOfElement("Product tabs")
    @FindAll(@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[2]/div"))
    public ElementsCollection productTabs;

    @NameOfElement("Product list")
    @FindAll(@FindBy(xpath = "//*[@id='productList']/div/div"))
    public ElementsCollection productList;

    @NameOfElement("Selected product")
    @FindBy(xpath = "//*[@id=\"selectedProduct\"]")
    public SelenideElement selectedProduct;

    @NameOfElement("Product price list")
    @FindAll(@FindBy(xpath = "//*[@id='productList']/div/div/span[1]"))
    public ElementsCollection productPriceList;

    @NameOfElement("Voucher input")
    @FindBy(xpath = "//*[@id='voucherInput']")
    public SelenideElement voucherInput;

    @NameOfElement("Voucher apply")
    @FindBy(xpath = "//*[@id='applyVoucherButton']")
    public SelenideElement voucherApply;

    @NameOfElement("Remove Voucher")
    @FindBy(xpath = "//*[@id=\"scrollContainer\"]/div/div[2]/div/div/div[2]/div/div/div/div")
    public SelenideElement removeVoucher;

    @NameOfElement("Voucher applied")
    @FindBy(xpath = "//*[@id=\"scrollContainer\"]/div/div[2]/div/div/div[2]/div/div/div/span[2]")
    public SelenideElement voucherApplied;

    @NameOfElement("Voucher subtotal")
    @FindBy(xpath = "//*[@id=\"scrollContainer\"]/div/div[2]/div/div/div[1]/div/div/span[2]")
    public SelenideElement voucherSubtotal;

    @NameOfElement("Voucher error")
    @FindBy(xpath = "//*[@id=\"scrollContainer\"]/div/div[2]/div/div/div[2]/span")
    public SelenideElement voucherError;

    @NameOfElement("Operator button")
    @FindBy(xpath = "//*[@id=\"operatorButton\"]")
    public SelenideElement operatorButton;

    @NameOfElement("Operator list")
    @FindAll(@FindBy(xpath = "//*[@id='telcoList']/div"))
    public ElementsCollection operatorList;

    @NameOfElement("Grey area")
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div[3]/div/div")
    public SelenideElement greyArea;

    @NameOfElement("Select operator block")
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[2]/div/div/div/div/div[1]")
    public SelenideElement operatorBlock;

    @NameOfElement("Icon of selected operator")
    @FindBy(xpath = "//*[@id='iconOfSelectedOperator']")
    public SelenideElement iconOfSelectedOperator;

    @NameOfElement("Previous phone block")
    @FindBy(xpath = "//*[@id='suggestionList']")
    public SelenideElement previousPhoneBlock;

    @NameOfElement("Previous phone list")
    @FindAll(@FindBy(xpath = "//*[@id='suggestionList']/div/span"))
    public ElementsCollection previousPhonelist;

    @NameOfElement("Subtotal")
    @FindBy(xpath = "//*[@id='scrollContainer']/div/div[2]/div/div/div[1]/div/div/span[2]")
    public SelenideElement subtotal;

    @NameOfElement("Topup now button")
    @FindBy(xpath = "//*[@id='topupNowButton']")
    public SelenideElement topupNowButton;

    @NameOfElement("Total")
    @FindBy(xpath = "//html/body/div[2]/div[3]/div[1]/div/div[1]/span[2]")
    public SelenideElement total;

}
