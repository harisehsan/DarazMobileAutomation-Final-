package allure;

import global.Global;
import io.qameta.allure.Attachment;

public interface AllureAttachment {

    @Attachment("{0}")
    static byte[] attachScreenShot(String name) {
        return Global.browser.takeScreenShot();
    }

    @Attachment(value = "{0}", type = "text/html",fileExtension = ".html")
    static String attachHtml(String name) {
        return Global.browser.getHtml();
    }

    @Attachment(value = "{0}", type = "text/plain")
    static String attachURL(String name) {
        return Global.browser.getUrl();
    }

    @Attachment(value = "{0}", type = "text/plain")
    static String attachComment(String name, String comment) {
        return comment;
    }
}

