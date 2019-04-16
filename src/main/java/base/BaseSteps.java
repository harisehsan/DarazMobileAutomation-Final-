package base;

import global.Global;

/**
 * Created by admin.son.ton on 1/26/18.
 */
public class BaseSteps {

    @SuppressWarnings("unchecked")
    protected <T extends PageObject> void visit(Class<T> page){
        Global.getBrowser().goTo(Global.getPageHierachy().getPageUrl(page));
    }

    @SuppressWarnings("unchecked")
    protected <T extends PageObject> void visitWithParam(Class<T> page, String param){
        Global.getBrowser().goTo(Global.getPageHierachy().getPageUrl(page)+param);
    }

    @SuppressWarnings("unchecked")
    protected <T extends PageObject>T on(Class<T> page){
        return (T) Global.getPageHierachy().getPageInstance(page);
    }
}
