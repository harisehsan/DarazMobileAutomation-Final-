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
    private WebElement colorselectionEle;
    @FindBy(xpath = "//*[*/text()='Brand']/*[@class='c3Guy3' or @class='c2uiAC']")
    private WebElement brandFilter;
    @FindBy(className = "anticon-cross")
    private List<WebElement> crossButton;

    @FindAll({
            @FindBy(className = "cSrWVv"), //Daraz Element
            @FindBy(className = "c30Om7") //lazada element
    })
    private List<WebElement> priceRange;

    @FindAll({
            @FindBy(className = "c3Qp1f"), //Daraz Element
            @FindBy(className = "c3wo-b") //lazada element
    })
    private WebElement sortBy;

    @FindAll({
            @FindBy(className = "c2p6A5"), //daraz list of products on catalog
            @FindBy(className = "c2prKC") //lazada List of products on catalog
    })
    private WebElement listofProducts;

    @FindAll({
            @FindBy(className = "c1-XO2"), //Daraz Element
            @FindBy(className = "cOT0eH") //lazada element
    })
    private WebElement clearButton;

    @FindAll({
            @FindBy(className = "cahB9n"), //Daraz Element
            @FindBy(className = "c1nVRb") //lazada element
    })
    private WebElement noResults;

    @FindAll({
            @FindBy(className = "ant-btn-icon-only"), //Daraz Element
            @FindBy(className = "ant-btn-icon-only") //lazada element
    })
    private WebElement priceSearchButton;

    @FindAll({
            @FindBy(className = "c3H-ZP"), //Daraz Element
            @FindBy(className = "c3NYEr") //lazada element
    })
    private WebElement sizeSelectionListEle;

    @FindAll({
            @FindBy(className = "c1meGu"), //Daraz Element
            @FindBy(className = "cM5DKB")  //lazada element
    })
    private WebElement appliedFilter;


    private By appFilter = By.className("ant-tag-text");
    private By leftFilterElement = By.className("ant-checkbox-wrapper");
    private By anttag = By.className("ant-tag");
    private By noResult = By.xpath("//*[@class='cahB9n' or @class='c1nVRb']"); // Daraz & Lazada
    private By brand = By.xpath("//*[*/text()='Brand']/*[@class='c3Guy3' or @class='c2uiAC']"); // Daraz & Lazada
    private By apliedFilter = By.xpath("//*[@class='c1meGu' or @class='cM5DKB']"); // Daraz & Lazada
    private By productlist = By.xpath("//*[@class='c2p6A5' or @class='c2prKC']"); // Daraz & Lazada


    public void applyCatalogPageFilters(String arg0) {
        switch (arg0) {
            case "brand":
                waitUntilPageReady();
                waitUntilVisibility(brand, 5);
                List<WebElement> brandsList = (brandFilter.findElements(leftFilterElement));
                int selectRandomBrand = brandsList.size() >= 7 ? random.nextInt(7) : random.nextInt(brandsList.size());
                waitUntilClickable(productlist);
                selectedFilter = brandsList.get(selectRandomBrand).getText();
                brandsList.get(selectRandomBrand).click();
                waitUntilPageReady();
                break;
            case "size":
                waitUntilPageReady();
                List<WebElement> sizeList = sizeSelectionListEle.findElements(leftFilterElement);
                System.out.println(sizeList);
                int selectRandomSize = sizeList.size() >= 7 ? random.nextInt(7) : random.nextInt(sizeList.size());
                selectedFilter = sizeList.get(selectRandomSize).getText();
                sizeList.get(selectRandomSize).click();
                waitUntilPageReady();
                waitUntilVisible(listofProducts);
                break;
            case "Color Family":
                waitUntilPageReady();
                waitUntilVisible(listofProducts);
                List<WebElement> ColorsList = colorselectionEle.findElements(leftFilterElement);
                int selectedColor = ColorsList.size() >= 7 ? random.nextInt(7) : random.nextInt(ColorsList.size());
                selectedFilter = ColorsList.get(selectedColor).getText();
                colorselectionEle.findElements(leftFilterElement).get(selectedColor).click();
                waitUntilVisible(listofProducts);
                break;
            case "Price Range":
                waitUntilPageReady();
                waitUntilVisible(priceRange.get(0));
                maxPrice = random.nextInt(9999);
                minPrice = random.nextInt(maxPrice - 1) - 1;
                priceRange.get(0).sendKeys(String.valueOf(minPrice));
                priceRange.get(1).sendKeys(String.valueOf(maxPrice));
                priceSearchButton.click();
                waitUntilPageReady();
                waitUntilVisible(listofProducts);
                try {
                    waitUntilVisibility(noResult, 5);
                    if (noResults.isDisplayed()) {
                        waitUntilPageReady();
                        clearButton.click();
                        waitUntilPageReady();
                        waitUntilVisible(listofProducts);
                        applyCatalogPageFilters("Price Range");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            default:
                assertTrue(appliedFilter.isDisplayed());
        }
    }

    public void assertFilteredResults(String arg0) {
        //verify filtered results are from specific brand.
        String appliedFilterText = tryFindElement();
        switch (arg0) {
            case "brand":
                scrollToView(sortBy);
                assertTrue(appliedFilterText.contains(selectedFilter));
                break;
            case "size":
                scrollToView(sortBy);
                assertTrue(appliedFilterText.contains(selectedFilter));
                break;
            case "Color Family":
                scrollToView(sortBy);
                assertTrue(appliedFilterText.contains(selectedFilter));
                break;
            case "Price Range":
                scrollToView(sortBy);
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
                appliedFilterText = appliedFilter.findElement(anttag).findElement(appFilter).getText();
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
                clearButton.click();
                waitUntilInvisibilityOf(apliedFilter);
                break;
            case "One":
                waitUntilPageReady();
                crossButton.get(0).click();
                break;
        }
    }

    public void assertFilterRemoved(String arg0) {
        switch (arg0) {
            case "All":
                try {
                    assertTrue(!appliedFilter.findElement(anttag).isDisplayed());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "One":
                crossButton.size();
                assertTrue(true);
                break;
        }
    }
}


