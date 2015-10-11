package org.golonzovsky.todomvcangular.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author golonzovsky on 10/10/15
 */
public class TodoPage {

  private static final String NEW_TODO_INPUT_ID = "new-todo";

  @FindBy(id = NEW_TODO_INPUT_ID)
  WebElement input;

  @FindBy(id = "toggle-all")
  WebElement toggleAll;

  @FindBy(id = "clear-completed")
  WebElement clearCompleted;

  @FindBy(css = "#todo-list div.view label")
  WebElement latestTodoLabel;

  @FindBy(css = "#todo-count strong")
  WebElement count;

  public TodoPage(WebDriver driver) {
    driver.get("http://todomvc.com/examples/angularjs/#/");

    WebDriverWait wait = new WebDriverWait(driver, 3);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(NEW_TODO_INPUT_ID)));
  }

  public void newTodo(String text) {
    input.sendKeys(text);
    input.submit();
  }

  public String latestText() {
    return latestTodoLabel.getText();
  }

  public void toggleAll(){
    toggleAll.click();
  }

  public void clearCompleted(){
    clearCompleted.click();
  }

  public String getCount(){
    return count.getText();
  }

}
