package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.TextArea;


import java.awt.*;

public class AccountsPage extends BasePage {
    //WebDriver driver;

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening the account creation page")
    public void createAccount() {
        driver.get("https://engineer2.lightning.force.com/lightning/o/Account/new");
    }

    /*
    public void open() {
        driver.get("https://engineer2.lightning.force.com/lightning/o/Account/list");
    }

    public void clickNew() {
        driver.findElement(By.cssSelector("[title=New]")).click();
    }
*/
    @Step("Filling in all fields")
    public void fillIn(String accountName, String parentAccount, String phone, String fax, String website,
                       String employees, String annualRevenue,
                       String description, String billingStreet, String shippingStreet, String billingCity,
                       String billingStateProvince, String shippingCity, String shippingState,
                       String billingZipPostalCode, String billingCountry, String shippingZipPostalCode,
                       String shippingCountry) {
        new Input(driver, "Account Name").write(accountName);
        new Input(driver, "Parent Account").write(parentAccount);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(website);
        new Input(driver, "Employees").write(employees);
        new Input(driver, "Annual Revenue").write(annualRevenue);
        new TextArea(driver, "Description").write(description);
        new TextArea(driver, "Billing Street").write(billingStreet);
        new TextArea(driver, "Shipping Street").write(shippingStreet);
        new Input(driver, "Billing City").write(billingCity);
        new Input(driver, "Billing State/Province").write(billingStateProvince);
        new Input(driver, "Shipping City").write(shippingCity);
        new Input(driver, "Shipping State").write(shippingState);
        new Input(driver, "Billing Zip/Postal Code").write(billingZipPostalCode);
        new Input(driver, "Billing Country").write(billingCountry);
        new Input(driver, "Shipping Zip/Postal Code").write(shippingZipPostalCode);
        new Input(driver, "Shipping Country").write(shippingCountry);

    }

    public void save() {
        driver.findElement(By.cssSelector("[title=Save]")).click();
    }

}
