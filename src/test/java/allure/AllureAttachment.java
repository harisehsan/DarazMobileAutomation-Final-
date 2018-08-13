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
}

