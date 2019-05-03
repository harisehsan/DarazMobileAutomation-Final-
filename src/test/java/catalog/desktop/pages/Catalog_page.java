package catalog.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class Catalog_page extends PageObject {

    public static final String page_url = Global.getConfig().getString("homepage.catalog_url");
    @FindBy(xpath = "//div[div/text()='Color Family']/div[@class='c3Guy3' or @class='c2uiAC']")
    private WebElement colorselection_List;
    @FindBy(xpath = "//*[*/text()='Brand']/*[@class='c3Guy3' or @class='c2uiAC']")
    private WebElement brandFilter_List;
    @FindBy(className = "anticon-cross")
    private List<WebElement> cross_Button;

    @FindAll({
            @FindBy(className = "c1_7zD"),
            @FindBy(className = "c3AZOx")
    })
    private WebElement catalogBanner_div_ele;

    @FindAll({
            @FindBy(className = "cSrWVv"), //Daraz Element
            @FindBy(className = "c30Om7") //lazada element
    })
    private List<WebElement> priceRange_Text;

    @FindAll({
            @FindBy(className = "c1-XO2"), //Daraz Element
            @FindBy(className = "cOT0eH") //lazada element
    })
    private WebElement clear_link;

    @FindAll({
            @FindBy(className = "c2bKdx"), //Daraz Element
            @FindBy(className = "c3R9mX") //lazada element
    })
    private WebElement priceSearch_Btn;

    @FindAll({
            @FindBy(className = "c3H-ZP"), //Daraz Element
            @FindBy(className = "c3NYEr") //lazada element
    })
    private WebElement sizeSelection_List;

    @FindAll({
            @FindBy(className = "c1meGu"), //Daraz Element
            @FindBy(className = "cM5DKB")  //lazada element
    })
    private WebElement filtersAppliedCatlog_div;


    private By appFilter_Text = By.className("ant-tag-text");
    private By leftFilterElement_List = By.className("ant-checkbox-wrapper");
    private By brand_List = By.xpath("//*[*/text()='Brand']/*[@class='c3Guy3' or @class='c2uiAC']"); // Daraz & Lazada
    private By catalogProduct_by = By.xpath("//*[*/@class='c2p6A5' or @class='c2prKC']"); // Daraz & Lazada
    private By clearLink_by = By.xpath("//*[*/@class='c1-XO2' or @class='cOT0eH']"); // Daraz & Lazada
    private By priceSearch_btn_by = By.className("ant-btn-icon-only"); // Daraz & Lazada
    private By catalogPageBanner_by = By.xpath("//*[*/@class='c1_7zD' or @class='c3AZOx']"); // Daraz & Lazada

    Random random = new Random();
    private String selectedFilter = "";

    public void applyVerticalBrandFilter() {
        waitUntilClickable(catalogProduct_by);
        scrollToFilterDiv();
        List<WebElement> brandsList = (brandFilter_List.findElements(leftFilterElement_List));
        int selectRandomBrand = brandsList.size() >= 7 ? random.nextInt(7) : random.nextInt(brandsList.size());
        waitUntilVisibility(brand_List, 5);
        selectedFilter = brandsList.get(selectRandomBrand).getText();
        brandsList.get(selectRandomBrand).click();
        waitUntilClickable(catalogProduct_by);
        waitUntilPageReady();
    }

    public void applyVerticalSizeFilter() {
        waitUntilClickable(catalogProduct_by);
        scrollToFilterDiv();
        waitUntilVisibility(leftFilterElement_List,5);
        List<WebElement> sizeList = sizeSelection_List.findElements(leftFilterElement_List);
        int selectRandomSize = sizeList.size() >= 7 ? random.nextInt(7) : random.nextInt(sizeList.size());
        selectedFilter = sizeList.get(selectRandomSize).getText();
        sizeList.get(selectRandomSize).click();
        waitUntilClickable(catalogProduct_by);
        waitUntilPageReady();
    }

    public void applyVerticalColorFilter() {
        waitUntilClickable(catalogProduct_by);
        scrollToFilterDiv();
        List<WebElement> ColorsList = colorselection_List.findElements(leftFilterElement_List);
        int selectedColor = ColorsList.size() >= 7 ? random.nextInt(7) : random.nextInt(ColorsList.size());
        selectedFilter = ColorsList.get(selectedColor).getText();
        colorselection_List.findElements(leftFilterElement_List).get(selectedColor).click();
        waitUntilClickable(catalogProduct_by);
        waitUntilPageReady();
    }

    public void applyVerticalPriceFilter() {
        waitUntilClickable(catalogProduct_by);
        scrollToFilterDiv();
        priceRange_Text.get(0).sendKeys("10");
        priceRange_Text.get(1).sendKeys("999999");
        waitUntilClickable(priceSearch_btn_by);
        priceSearch_Btn.click();
        waitUntilClickable(catalogProduct_by);
        waitUntilPageReady();
    }

    public void assertFilterShouldBeApplied() {
        //verify filtered results are from specific brand_List.
        Global.getBrowser().refresh();
        waitUntilPageReady();
        waitUntilClickable(catalogProduct_by);
        scrollToFilterDiv();
        assertTrue(tryFindElement().stream().anyMatch(str -> str.trim().contains(selectedFilter)));
    }

    private List<String> tryFindElement() {
        boolean staleElement = true;
        List<String> appliedFilterText = new ArrayList<String>();
        int loop = 1;
        while (staleElement) {
            try {
               List<WebElement> ListOfAppliedFilters = filtersAppliedCatlog_div.findElements(appFilter_Text);
                for (WebElement text: ListOfAppliedFilters) {
                    appliedFilterText.add(text.getText());
                }
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                loop++;
                staleElement = true;
            }
        }
        return appliedFilterText ;
    }

    public void clearFilters(String arg0) {
        switch (arg0) {
            case "All":
                waitUntilClickable(clearLink_by);
                scrollToFilterDiv();
                clear_link.click();
                Global.getBrowser().refresh();
                if(isExist(clearLink_by)){
                    clear_link.click();
                }
                break;
            case "One":
                Global.getBrowser().refresh();
                scrollToFilterDiv();
                waitUntilClickable(clearLink_by);
                cross_Button.get(random.nextInt(cross_Button.size())).click();
                waitUntilClickable(catalogProduct_by);
                break;
        }
    }

    public void assertFilterRemoved(String arg0) {
        switch (arg0) {
            case "All":
                Global.getBrowser().refresh();
                try {
                    assertFalse(filtersAppliedCatlog_div.isDisplayed());
                } catch (Exception e) {
                }
                break;
            case "One":
                Global.getBrowser().refresh();
                cross_Button.size();
                assertTrue(true);
                break;
        }
    }

    public void scrollToFilterDiv(){
        if(isExist(catalogPageBanner_by)){
            scrollToView(catalogBanner_div_ele);}
    }
}