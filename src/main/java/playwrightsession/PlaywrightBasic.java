package playwrightsession;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasic {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
//		Browser browser = playwright.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false));
//		Browser browser = playwright.firefox().launch( new BrowserType.LaunchOptions().setHeadless(false));
//		Browser browser = playwright.webkit().launch( new BrowserType.LaunchOptions().setHeadless(false));
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("firefox");
		lp.setHeadless(false);
		
		Browser browser = playwright.firefox().launch(lp);
		
		Page page = browser.newPage();
		page.navigate("https://www.amazon.com");
		
		String pagetitle = page.title();
		System.out.println(pagetitle);
		String pageurl = page.url();
		System.out.println(pageurl);
		
		browser.close();
		playwright.close();
	}

}
