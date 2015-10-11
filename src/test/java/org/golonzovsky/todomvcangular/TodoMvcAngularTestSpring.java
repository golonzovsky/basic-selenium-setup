package org.golonzovsky.todomvcangular;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.golonzovsky.todomvcangular.config.ScreenShotService;
import org.golonzovsky.todomvcangular.config.SeleniumTestConfig;
import org.golonzovsky.todomvcangular.pages.TodoPage;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SeleniumTestConfig.class)
//@ActiveProfiles("remote")
public class TodoMvcAngularTestSpring {

  @Autowired ScreenShotService screenShotService;
  @Autowired TodoPage page;

  @Rule public TestName name = new TestName();

  @After
  public void saveScreenShotAndClean() throws IOException {
    screenShotService.saveScreenShot("todomvc_" + name.getMethodName());
    page.toggleAll();
    page.clearCompleted();
  }

  @Test
  public void testNewTodo() throws IOException {
    String text = "new todo";
    page.newTodo(text);
    assertEquals(text, page.latestText());
  }

  @Test
  public void testCounter() throws IOException {
    page.newTodo("todo for count");
    page.newTodo("testing count");
    page.newTodo("counter");
    assertEquals("3", page.getCount());
  }


}