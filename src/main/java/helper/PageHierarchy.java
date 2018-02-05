package helper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin.son.ton on 2/5/18.
 */
public class PageHierarchy<T> {

    private Map<Class<T>, T> pageHierarchy;
    private static final String PAGE_URL = "page_url";

    public PageHierarchy() {
        pageHierarchy = new HashMap<>();
    }

    public T getPageInstance(Class<T> page) {
        T pageObject;
        try {
            if (pageHierarchy.get(page) != null)
                pageObject = pageHierarchy.get(page);
            else {
                pageObject = page.newInstance();
                pageHierarchy.put(page, pageObject);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(String.format("Page: %s is not found | ERROR: %s ", page.toString(), e.getMessage()));
        }
        return pageObject;
    }

    public String getPageUrl(Class<T> page) {
        String url;
        try {
            url = String.valueOf(page.getField(PAGE_URL).get(null));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(String.format("page_url is not defined for Page: %s | ERROR: %s ", page.toString(), e.getMessage()));
        }
        return url;
    }
}
