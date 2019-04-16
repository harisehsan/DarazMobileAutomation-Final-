package asc.desktop.pages.orders_management;

import global.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageObject;

import java.util.List;

public class OrderManagement_Page extends PageObject {

    public static final String page_url = Global.getConfig().getString("asc.home_url")+"/order/query";


    @FindBy(css = ".orders-table") private WebElement orders_table;
    @FindBy(css = ".next-pagination-list .next-btn:last-child") private WebElement last_page_button;
    @FindBy(css = ".next-table-row.last") private WebElement last_table_row;
    @FindBy(css = ".next-table-row.last [type='checkbox']") private WebElement last_table_row_checkbox;
    @FindBy(xpath = "//div[@class='next-tabs-tab-inner']//span//span[contains(., 'Ready to Ship')]") private WebElement rts_tab_span;
    @FindBy(xpath = "//div[@class='next-tabs-tab-inner']//span//span[contains(., 'Pending')]") private WebElement pending_tab_span;
    @FindBy(xpath = "//div[@class='next-tabs-tab-inner']//span//span[contains(., 'Completed')]") private WebElement completed_tab_span;
    @FindBy(xpath = "//li[@class='next-menu-item']//span[contains(., 'All')]") private WebElement all_pending_orders_menu_span;
    @FindBy(xpath = "//li[@class='next-menu-item']//span[contains(., 'Cancelled')]") private WebElement cancelled_orders_menu_span;
    @FindBy(css = ".next-table-row.last .actions") private WebElement last_row_actions_collumn;
    @FindBy(css = "input[name='orderNumber']") private WebElement order_number_search_field;
    @FindBy(css = ".condition-tags .next-tag-opt") private List<WebElement> search_filter_list;



    private By menuAllPendingOrders_by = By.xpath("//li[@class='next-menu-item']//span[contains(., 'All')]");
    private By menuCancelledOrders_by = By.xpath("//li[@class='next-menu-item']//span[contains(., 'Cancelled')]");
    private By cancelDialog_by = By.cssSelector(".cancel-dialog");
    private By rtsDialog_by = By.cssSelector(".rts-dialog");
    private By loadingIcon_by = By.cssSelector(".next-feedback-loading");




    private WebElement orderRow(String orderNumber){
        return orders_table.findElement(By.xpath(String.format("//tr[contains(.,'%s')]",orderNumber)));
    }



    private void waitUntilLoaded(){
        waitUntilPageReady();
        waitUntilInvisibilityOf(loadingIcon_by);
        waitUntilVisible(orders_table);
    }

    public void openPendingTab(){
        waitUntilLoaded();
        scrollToView(pending_tab_span);
        hover(pending_tab_span);
        waitUntilClickable(menuAllPendingOrders_by);
        all_pending_orders_menu_span.click();
        waitUntilLoaded();
    }

    public void clearFilter(){
        waitUntilLoaded();
        search_filter_list.forEach(WebElement::click);
        waitUntilLoaded();
    }

    public void openReadyToShipTab(){
        waitUntilLoaded();
        scrollToView(rts_tab_span);
        rts_tab_span.click();
        waitUntilLoaded();
    }

    public void openCancelledTab(){
        waitUntilLoaded();
        waitUntilVisible(completed_tab_span);
        scrollToView(completed_tab_span);
        waitUntilLoaded();
        hover(completed_tab_span);
        waitUntilClickable(menuCancelledOrders_by);
        cancelled_orders_menu_span.click();
        waitUntilLoaded();
    }

    public String getLastOrderNumber(){
        waitUntilLoaded();
        scrollToView(last_page_button);
        last_page_button.click();
        waitUntilVisible(last_row_actions_collumn);
        return last_table_row.findElement(By.cssSelector(".orderNumber")).getText();
    }

    public void selectAction(int action, String orderNumber){
        waitUntilVisible(orderRow(orderNumber));
        WebElement actionEle = orderRow(orderNumber).findElements(By.cssSelector(".actions a")).get(action);
        actionEle.click();
    }

    public void openCancelForm(String orderNumber){
        selectAction(1,orderNumber);
        waitUntilVisibility(cancelDialog_by);
    }

    public void openRTSForm(String orderNumber){
        selectAction(0,orderNumber);
        waitUntilVisibility(rtsDialog_by);
    }

    public void searchOrder(String orderNumber){
        scrollToView(order_number_search_field);
        waitUntilPageReady();
        for(String s: orderNumber.split("")){
            order_number_search_field.sendKeys(s);
        }
        waitUntilPageReady();
        order_number_search_field.sendKeys(Keys.ENTER);
        waitUntilLoaded();
    }

    public boolean orderDisplayed(String orderNumber){
        waitUntilVisible(last_table_row);
        String actualOrderNumber = last_table_row.findElement(By.cssSelector(".orderNumber")).getText();
        return actualOrderNumber.equals(orderNumber);
    }
}
