package com.PlaywrightTesting.ex01_PlaywrightBasics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestPlaywright01 {
    public static void main(String[] args) {
        Playwright pw = Playwright.create();
        BrowserType browserType = pw.chromium();
        Browser browser = browserType.launch();
        Page page= browser.newPage();
        page.navigate("https://playwright.dev/java/docs/intro#first-script");
        String title= page.title();
        System.out.println("Title is: "+title);
        page.close();
        browser.close();
        pw.close();
    }
}
