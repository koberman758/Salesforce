package tests;

import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test(description = "Check if user can create new account")
    public void login() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        loginPage.userTitle();
        accountsPage.createAccount();
       accountsPage.fillIn("Account Name", "Parent Account", "Phone", "Fax",
               "Website", "100", "1000",
               "Description", "Billing Street", "Shipping Street",
               "Billing City", "Billing State/Province", "Shipping City",
               "Shipping State", "Billing Zip/Postal Code", "Billing Country",
               "Shipping Zip/Postal Code", "Shipping Country");
        accountsPage.save();
    }
}
