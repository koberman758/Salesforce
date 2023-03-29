package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    String label;
    WebDriver driver;
    String baseLocator = "//span[contains(text(), '%s')]/ancestor::div[contains(@class, 'uiInput')]//textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(baseLocator, label))).sendKeys(text);
    }
}
