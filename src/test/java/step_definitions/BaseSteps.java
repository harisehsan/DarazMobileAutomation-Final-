package step_definitions;

import global.Global;
import net.bytebuddy.implementation.bytecode.Throw;
import pages.Base_Page;

/**
 * Created by admin.son.ton on 1/26/18.
 */
public class BaseSteps {

    protected void visit(Class page){
        try {
            String url = String.valueOf(page.getField("page_url").get(null));
            Global.browser.goTo(url);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(String.format("page_url is not defined for Page: %s | ERROR: %s ",page.toString(),e.getMessage()));
        }
    }

    protected <T extends Base_Page> T on(Class<T> page){
        try {
            return page.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(String.format("Page is not found: %s | ERROR: %s ",page.toString(),e.getMessage()));
        }
    }

}
