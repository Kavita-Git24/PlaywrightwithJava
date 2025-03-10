package com.PlaywrightTesting.ex02_Playwright_Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TestPlaywright04_Assert {
    public static void main(String[] args) {
       Browser browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
       // PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
        PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses by");
        page.close();
        browser.close();

    }
}
