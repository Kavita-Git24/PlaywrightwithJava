package com.PlaywrightTesting.ex03_PlaywrightLocator;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import java.util.regex.Pattern;

public class TesPlaywright06_Locator {
    public static void main(String[] args) {
        Browser browser=null;
        Page page=null;
        try{
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page=browser.newPage();

            page.navigate("https://freelance-learn-automation.vercel.app/login");
            PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
            //page.locator("#email1").fill("admin@email.com");
            //page.locator("xpath=//input[@name='email1']").fill("admin@email.com");
           //page.locator("css=input[name='email1']").fill("admin@email.com");
            page.getByPlaceholder("Enter Email").fill("admin@email.com");
            page.getByPlaceholder("Enter Password").fill("admin@123");
            //page.locator("xpath=//button[@class='submit-btn']").click();
            page.getByText("Sign in").nth(1).click();
            //page.getByText("Sign in").last().click();
            PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");

            page.getByAltText("menu").click();
            page.getByText("Sign out").click();

            PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
            page.waitForTimeout(3000);
          //  System.out.println("Page ended");

        }
        finally {
            page.close();
            browser.close();
        }
    }
}
