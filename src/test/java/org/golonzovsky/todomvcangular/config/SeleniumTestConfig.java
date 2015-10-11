package org.golonzovsky.todomvcangular.config;

import java.net.MalformedURLException;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;
import org.golonzovsky.todomvcangular.pages.TodoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author golonzovsky on 10/11/15
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@Slf4j
public class SeleniumTestConfig {

  @Autowired private WebDriver webDriver;

  @Bean
  public TodoPage todoPage() {
    return PageFactory.initElements(webDriver, TodoPage.class);
  }

  @Profile("!remote")
  @Bean(destroyMethod = "quit")
  public WebDriver webDriver() {
    return new ChromeDriver();
  }

  @Bean
  @Profile("remote")
  public WebDriver webDriverRemote(@Value("${selenium.gridEndpoint}") String gridEndpoint) throws MalformedURLException {
    return new RemoteWebDriver(new URL(gridEndpoint), DesiredCapabilities.chrome());
  }
}

