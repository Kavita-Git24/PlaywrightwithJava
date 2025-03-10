package com.PlaywrightTesting.ex04_PlaywrightTestNG;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class TestPlaywright08_TestNG {
    @Test
    public void loginTest() {
        Browser browser=null;
        Page page=null;
        try{
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page=browser.newPage();

            page.navigate("https://freelance-learn-automation.vercel.app/login");
            //PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
            Assert.assertTrue(page.title().contains("Learn Automation Courses"));

            page.getByPlaceholder("Enter Email").fill("admin@email.com");
            page.getByPlaceholder("Enter Password").fill("admin@123");
            page.getByText("Sign in").nth(1).click();

           // PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
            String Exp_Text=page.locator(".welcomeMessage").innerText();
            Assert.assertTrue(Exp_Text.contains("Welcome"));
            //System.out.println("Passed2");
            page.getByAltText("menu").click();
            page.getByText("Sign out").click();
            page.waitForTimeout(3000);
           // PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
            String page_url= page.url();
           // System.out.println(page_url);
            Assert.assertTrue(page_url.contains("login"));

        }
        finally {
            page.close();
            browser.close();
        }
    }
}
