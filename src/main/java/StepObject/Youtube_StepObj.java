package StepObject;

import PageObject.Youtube_PageObj;
import Utils.Setup;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

import static Utils.Setup.page;


public class Youtube_StepObj {

    private static Youtube_PageObj pageObj = new Youtube_PageObj();


    public void SearchQuery(String query) {
        try {
            page.fill(pageObj.SEARCH_INPUT, query);
            page.click(pageObj.SEARCH_BUTTON );
            page.waitForTimeout(1500);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(pageObj.SEARCH).setExact(true)).click();
        } catch (Exception e) {
            throw new RuntimeException("Error entering search query: " + e.getMessage());
        }
    }

    public void playVideo() {
        try {
            page.getByText("3:11 3:11 Now playing Georgia").dblclick();

            page.waitForTimeout(25000);
        } catch (Exception e) {
            throw new RuntimeException("Error entering search query: " + e.getMessage());
        }
    }




}
