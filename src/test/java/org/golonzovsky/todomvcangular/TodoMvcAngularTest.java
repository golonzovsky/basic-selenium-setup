package org.golonzovsky.todomvcangular;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.golonzovsky.todomvcangular.pages.TodoPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@Ignore
public class TodoMvcAngularTest {
  private ChromeDriver driver;
  private TodoPage page;

  @Before
  public void openBrowser() {
    driver = new ChromeDriver();
    page = PageFactory.initElements(driver, TodoPage.class);
  }

  @After
  public void saveScreenShotAndClose() throws IOException {
    saveScreenShot("todomvc.png");
    driver.quit();
  }

  @Test
  public void testNewTodo() throws IOException {
    String text = "new todo";
    page.newTodo(text);
    Assert.assertEquals(text, page.latestText());
  }

  @Test
  public void testCounter() throws IOException {
    page.newTodo("todo for count");
    page.newTodo("testing count");
    page.newTodo("counter");
    assertEquals("3", page.getCount());
  }

  public void saveScreenShot(String screenshotFileName) throws IOException {
    FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(screenshotFileName));
  }
}