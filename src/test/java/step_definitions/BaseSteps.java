package step_definitions;

import global.Global;
import pages.PageObject;

/**
 * Created by admin.son.ton on 1/26/18.
 */
public class BaseSteps {

    @SuppressWarnings("unchecked")
    protected <T extends PageObject> void visit(Class<T> page){
        Global.browser.goTo(Global.pageHierarchy.getPageUrl(page));
    }

    @SuppressWarnings("unchecked")
    protected <T extends PageObject> void visitWithParam(Class<T> page, String param){
        Global.browser.goTo(Global.pageHierarchy.getPageUrl(page)+param);
    }

    @SuppressWarnings("unchecked")
    protected <T extends PageObject>T on(Class<T> page){
        return (T) Global.pageHierarchy.getPageInstance(page);
    }
}
