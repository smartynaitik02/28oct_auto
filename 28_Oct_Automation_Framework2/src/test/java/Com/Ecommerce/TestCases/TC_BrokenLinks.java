package Com.Ecommerce.TestCases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;

public class TC_BrokenLinks extends Ecommerce_BaseClass {

	@Test
	public void Broken_links() throws MalformedURLException, IOException {

		List<WebElement> Links = driver.findElements(By.tagName("a"));

		System.out.println(Links.size());
		// 47

		int brokenlink = 0;

		for (WebElement element : Links) {

			String url = element.getAttribute("href");
			{
				if (url == null || url.isEmpty()) {

					System.out.println("URL is empty");
				}

				// URL & URI
				// Path para & query para , Authentication & Autjhorozation, URL &B URL
				// 401 and 403 diff , PAth & Put.

				URL Link = new URL(url);

				HttpURLConnection httpcode = (HttpURLConnection) Link.openConnection();
				httpcode.connect();
				// 200 ,201,300 ,401

				if (httpcode.getResponseCode() >= 400) { // 405 >=400 - true

					System.out.println(httpcode.getResponseCode() + "-->" + url + "   is broken link");
					brokenlink++;

				} else {

					System.out.println(httpcode.getResponseCode() + "-->" + url + "   is valid link");
				}

			}

		}

		System.out.println("Number of broken links-->" + brokenlink);

	}
}
