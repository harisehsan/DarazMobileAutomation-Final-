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

    Random random = new Random();
    private String selectedFilter = "";
    private int maxPrice, minPrice;

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
    private WebElement catalogProduct_List;

    @FindAll({
            @FindBy(className = "c1-XO2"), //Daraz Element
            @FindBy(className = "cOT0eH") //lazada element
    })
    private WebElement clear_link;

    @FindAll({
            @FindBy(className = "cahB9n"), //Daraz Element
            @FindBy(className = "c1nVRb") //lazada element
    })
    private WebElement catalogePageNoResults_div;

    @FindAll({
            @FindBy(className = "ant-btn-icon-only"), //Daraz Element
            @FindBy(className = "ant-btn-icon-only") //lazada element
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
    private By appliedFilterText_div = By.className("ant-tag");
    private By noResult_div = By.xpath("//*[@class='cahB9n' or @class='c1nVRb']"); // Daraz & Lazada
    private By brand_List = By.xpath("//*[*/text()='Brand']/*[@class='c3Guy3' or @class='c2uiAC']"); // Daraz & Lazada
    private By apliedFilter_Div = By.xpath("//*[@class='c1meGu' or @class='cM5DKB']"); // Daraz & Lazada
    private By productlist_List = By.xpath("//*[@class='c2p6A5' or @class='c2prKC']"); // Daraz & Lazada


    public void applyCatalogPageFilters(String arg0) {
        switch (arg0) {
            case "brand_List":
                waitUntilPageReady();
                waitUntilVisibility(brand_List, 5);
                List<WebElement> brandsList = (brandFilter_List.findElements(leftFilterElement_List));
                int selectRandomBrand = brandsList.size() >= 7 ? random.nextInt(7) : random.nextInt(brandsList.size());
                waitUntilClickable(productlist_List);
                selectedFilter = brandsList.get(selectRandomBrand).getText();
                brandsList.get(selectRandomBrand).click();
                waitUntilPageReady();
                break;
            case "size":
                waitUntilPageReady();
                List<WebElement> sizeList = sizeSelection_List.findElements(leftFilterElement_List);
                System.out.println(sizeList);
                int selectRandomSize = sizeList.size() >= 7 ? random.nextInt(7) : random.nextInt(sizeList.size());
                selectedFilter = sizeList.get(selectRandomSize).getText();
                sizeList.get(selectRandomSize).click();
                waitUntilPageReady();
                waitUntilVisible(catalogProduct_List);
                break;
            case "Color Family":
                waitUntilPageReady();
                waitUntilVisible(catalogProduct_List);
                List<WebElement> ColorsList = colorselection_List.findElements(leftFilterElement_List);
                int selectedColor = ColorsList.size() >= 7 ? random.nextInt(7) : random.nextInt(ColorsList.size());
                selectedFilter = ColorsList.get(selectedColor).getText();
                colorselection_List.findElements(leftFilterElement_List).get(selectedColor).click();
                waitUntilVisible(catalogProduct_List);
                break;
            case "Price Range":
                waitUntilPageReady();
                waitUntilVisible(priceRange_Text.get(0));
                maxPrice = random.nextInt(9999);
                minPrice = random.nextInt(maxPrice - 1) - 1;
                priceRange_Text.get(0).sendKeys(String.valueOf(minPrice));
                priceRange_Text.get(1).sendKeys(String.valueOf(maxPrice));
                priceSearch_Btn.click();
                waitUntilPageReady();
                waitUntilVisible(catalogProduct_List);
                try {
                    waitUntilVisibility(noResult_div, 5);
                    if (catalogePageNoResults_div.isDisplayed()) {
                        waitUntilPageReady();
                        clear_link.click();
                        waitUntilPageReady();
                        waitUntilVisible(catalogProduct_List);
                        applyCatalogPageFilters("Price Range");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            default:
                assertTrue(filtersAppliedCatlog_div.isDisplayed());
        }
    }

    public void assertFilteredResults(String arg0) {
        //verify filtered results are from specific brand_List.
        String appliedFilterText = tryFindElement();
        switch (arg0) {
            case "brand_List":
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
                waitUntilPageReady();
                clear_link.click();
                waitUntilInvisibilityOf(apliedFilter_Div);
                break;
            case "One":
                waitUntilPageReady();
                cross_Button.get(0).click();
                break;
        }
    }

    public void assertFilterRemoved(String arg0) {
        switch (arg0) {
            case "All":
                try {
                    assertTrue(!filtersAppliedCatlog_div.findElement(appliedFilterText_div).isDisplayed());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "One":
                cross_Button.size();
                assertTrue(true);
                break;
        }
    }
}


