package catalog.desktop.pages;

import base.PageObject;
import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class Cataloge_page extends PageObject {



    public static final String page_url = Global.config.getString("homepage.catalog_url");

    @FindBy(xpath = "//div[div/text()='Color Family']/div[@class='c3Guy3' or @class='c2uiAC']")
    private WebElement colorselection_List;
    @FindBy(xpath = "//*[*/text()='Brand']/*[@class='c3Guy3' or @class='c2uiAC']")
    private WebElement brandFilter_List;
    @FindBy(className = "anticon-cross")
    private List<WebElement> cross_Button;

    @FindAll({
            @FindBy(className = "cSrWVv"), //Daraz Element
            @FindBy(className = "c30Om7") //lazada element
    })
    private List<WebElement> priceRange_Text;

    @FindAll({
            @FindBy(className = "c3Qp1f"), //Daraz Element
            @FindBy(className = "c3wo-b") //lazada element
    })
    private WebElement sortBy_Div;

    @FindAll({
            @FindBy(className = "c2p6A5"), //daraz list of products on catalog
            @FindBy(className = "c2prKC") //lazada List of products on catalog
    })
    private List<WebElement> catalogProduct_List;

    @FindAll({
            @FindBy(className = "c1-XO2"), //Daraz Element
            @FindBy(className = "cOT0eH") //lazada element
    })
    private WebElement clear_link;

    @FindBy(className = "ant-btn-icon-only")
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
    private By appliedFilterText_div = By.className("ant-tag");
    private By brand_List = By.xpath("//*[*/text()='Brand']/*[@class='c3Guy3' or @class='c2uiAC']"); // Daraz & Lazada



    Random random = new Random();
    private String selectedFilter = "";

    public void applyCatalogPageFilters(String arg0) {
        switch (arg0) {
            case "brand":
                waitUntilPageReady();
                List<WebElement> brandsList = (brandFilter_List.findElements(leftFilterElement_List));
                int selectRandomBrand = brandsList.size() >= 7 ? random.nextInt(7) : random.nextInt(brandsList.size());
                waitUntilVisibility(brand_List, 5);
                selectedFilter = brandsList.get(selectRandomBrand).getText();
                brandsList.get(selectRandomBrand).click();
                waitUntilPageReady();
                break;
            case "size":
                waitUntilPageReady();
                waitUntilVisibility(leftFilterElement_List,5);
                List<WebElement> sizeList = sizeSelection_List.findElements(leftFilterElement_List);
                int selectRandomSize = sizeList.size() >= 7 ? random.nextInt(7) : random.nextInt(sizeList.size());
                selectedFilter = sizeList.get(selectRandomSize).getText();
                sizeList.get(selectRandomSize).click();
                waitUntilPageReady();
                break;
            case "Color Family":
                waitUntilPageReady();
                waitUntilVisible(catalogProduct_List.get(0));
                List<WebElement> ColorsList = colorselection_List.findElements(leftFilterElement_List);
                int selectedColor = ColorsList.size() >= 7 ? random.nextInt(7) : random.nextInt(ColorsList.size());
                selectedFilter = ColorsList.get(selectedColor).getText();
                colorselection_List.findElements(leftFilterElement_List).get(selectedColor).click();
                waitUntilPageReady();
                break;
            case "Price Range":
                waitUntilPageReady();
                waitUntilVisible(priceRange_Text.get(0));
                priceRange_Text.get(0).sendKeys("10");
                priceRange_Text.get(1).sendKeys("999999");
                priceSearch_Btn.click();
                waitUntilPageReady();
                break;
            default:
                assertTrue(filtersAppliedCatlog_div.isDisplayed());
        }
    }

    public void assertFilteredResults(String arg0) {
        //verify filtered results are from specific brand_List.
        String appliedFilterText = tryFindElement();
        switch (arg0) {
            case "brand":
                scrollToView(sortBy_Div);
                assertTrue(appliedFilterText.contains(selectedFilter));
                break;
            case "size":
                scrollToView(sortBy_Div);
                assertTrue(appliedFilterText.contains(selectedFilter));
                break;
            case "Color Family":
                scrollToView(sortBy_Div);
                assertTrue(appliedFilterText.contains(selectedFilter));
                break;
            case "Price Range":
                scrollToView(sortBy_Div);
                assertTrue(appliedFilterText.contains((selectedFilter)));
                break;
        }
    }

    private String tryFindElement() {
        boolean staleElement = true;
        String appliedFilterText = "";
        int loop = 1;
        while (staleElement) {
            try {
                appliedFilterText = filtersAppliedCatlog_div.findElement(appliedFilterText_div).findElement(appFilter_Text).getText();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                loop++;
                staleElement = true;
            }
        }
        return appliedFilterText;
    }

    public void clearFilters(String arg0) {
        switch (arg0) {
            case "All":
                waitUntilVisible(clear_link);
                clear_link.click();
                break;
            case "One":
                waitUntilVisible(clear_link);
                cross_Button.get(0).click();
                break;
        }
    }

    public void assertFilterRemoved(String arg0) {
        switch (arg0) {
            case "All":
                Global.browser.refresh();
                try {
                    assertFalse(filtersAppliedCatlog_div.isDisplayed());
                } catch (Exception e) {
                    System.out.println("Element no longer available on the page");
                }
                break;
            case "One":
                Global.browser.refresh();
                cross_Button.size();
                assertTrue(true);
                break;
        }
    }
}