package Utils;

import com.microsoft.playwright.*;
import org.testng.Assert;

public class Setup {


    private static Browser browser;
    public static Page page;

    public  void setup() {
        Playwright playwright = Playwright.create();

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(false);
        browser = playwright.chromium().launch(options);
        page = browser.newPage();
        page.setViewportSize(1920, 1080);
        page.setDefaultTimeout(20000);

    }

    public  void Navigate_ToUrl(String Url) {
        try {
            page.navigate(Url);
        } catch (Exception e) {
            Assert.fail("Error navigating to URL: " + e.getMessage());
        }
    }

    public  void teardown() {
        browser.close();
    }

    public static Browser getBrowser() {
        return browser;
    }

    public static Page getPage() {
        return page;
    }
}
