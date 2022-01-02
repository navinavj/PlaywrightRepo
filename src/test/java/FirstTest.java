import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FirstTest {

    private static Browser browser;
    private static Playwright playwright;

    @BeforeMethod
    public void beforeMethod(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @Test
    public void AmazonSearchExample(){

        Page page = browser.newPage();
        page.navigate("https://www.amazon.com/");

        page.fill("#twotabsearchtextbox","Superman");
        page.click("input[id=nav-search-submit-button]");

        String text = page.textContent("span.a-color-state");
        Assert.assertTrue(text.contains("Superman"));
    }
}
