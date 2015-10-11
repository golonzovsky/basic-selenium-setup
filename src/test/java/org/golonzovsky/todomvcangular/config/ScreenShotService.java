package org.golonzovsky.todomvcangular.config;

import java.io.File;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author golonzovsky on 10/11/15
 */
@Service
@Slf4j
public class ScreenShotService {

  @Autowired
  private TakesScreenshot driver;

  public void saveScreenShot(String fileName) throws IOException {
    FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(fileName + ".png"));
  }
}
