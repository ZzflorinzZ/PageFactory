package test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindBrokenLinks extends BaseTest{
	
	static List<String> brokenLinks = new ArrayList<String>();
	
	@Test
	public void testBrokenLinks() throws IOException {
		List<WebElement> link = driver.findElements(By.cssSelector("a[href*='http']"));	
		System.out.println(link.size());
		
		for(int i = 0; i<link.size(); i++) {
			WebElement element = link.get(i);
			String url = element.getAttribute("href");
			if(url == null) {
				continue;
			}
			
			checkLinks(url);
			
			assertTrue(brokenLinks.size() == 0);
		}
	}
	
	public static void checkLinks(String linkURL) throws IOException {
		try {
			URL url = new URL(linkURL);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setConnectTimeout(3000);
			httpUrlConn.connect();
			
			if(httpUrlConn.getResponseCode() == 200) {
				System.out.println(linkURL + httpUrlConn.getResponseCode());
			}
			
			if(httpUrlConn.getResponseCode() == 404) {
				System.out.println(linkURL + httpUrlConn.getResponseCode());
				brokenLinks.add(linkURL);
			}
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

}
