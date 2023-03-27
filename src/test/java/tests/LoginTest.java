package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        loginPage.userTitle();
        accountsPage.createAccount();
       accountsPage.fillIn("Account Name", "Parent Account", "Phone", "Fax",
               "Website", "Аналитик", "Employees", "Связь", "Annual Revenue",
               "Description", "Billing Street", "Shipping Street",
               "Billing City", "Billing State/Province", "Shipping City",
               "Shipping State", "Billing Zip/Postal Code", "Billing Country",
               "Shiping Zip/Postal Code", "Shipping Country");
        accountsPage.save();
    }
}
