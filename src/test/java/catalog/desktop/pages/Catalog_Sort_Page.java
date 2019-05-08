package catalog.desktop.pages;

import _base.api_helpers.ApiService;
import _base.api_helpers.buyer.BuyerSearchApi;
import base.PageObject;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;


public class Catalog_Sort_Page extends PageObject {

@FindBy(css = "div#root div.c3trXJ > div > div > div > div") private WebElement sort_By_drpDown;
@FindBy(className = "ant-select-dropdown-menu-item") private List<WebElement> low_To_High_lstItem;
@FindBy(className = "c3gUW0") private List<WebElement> product_Price_lbl;

private By sort_By_drpDown_By = By.cssSelector("div#root div.c3trXJ > div > div > div > div");

Catalog_page catalogPage = new Catalog_page();

BuyerSearchApi buyerSearchApi = new BuyerSearchApi();

ApiService apiService = new ApiService();

private String url;

private String urlSplit[];

private List<Float> price_lst;

private String json_Format = "&ajax=true";

    public void applyPriceLowToHighFilter()  {
        waitUntilPageReady();;
        catalogPage.scrollToFilterDiv();
        waitUntilClickable(sort_By_drpDown_By);
        sort_By_drpDown.click();
        low_To_High_lstItem.get(1).click();
        catalogPage.scrollToFilterDiv();
        url = currentUrl()+json_Format;
    }

    public List<Float> getProductPrices() {
        List<Float> productPrices_lst = new ArrayList<Float>();
        urlSplit = url.split("page=1",2);
        for(int i=1;i<=3;++i) {
            url = urlSplit[0]+"page="+i+urlSplit[1];
            price_lst = buyerSearchApi.getListProductPriceFromCatalog(url);
            productPrices_lst.addAll(price_lst);
         }
        return productPrices_lst;
        }

        public boolean verifyProductPrices(List <Float> productPrices) {
            return Ordering.natural().isOrdered(productPrices);

          }
        }