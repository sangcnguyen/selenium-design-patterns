package builder;

import org.testng.annotations.Test;
import template.TestTemplate;

public class PurchaseTest extends TestTemplate {
    private PurchasePage purchasePage;

    BillingInfo billingWithRequireFields = new BillingInfo.BillingInformationBuilder("sang", "123 example.com", "hcm").build();

    BillingInfo billingWithOptionalFields = new BillingInfo.BillingInformationBuilder("sang", "123 example.com", "hcm").state("hcm").zipCode("700000").build();

    BillingInfo billingWithAllFields = new BillingInfo.BillingInformationBuilder("sang", "123 example.com", "hcm").state("hcm").zipCode("700000").cardType("American Express").cardNumber("2313156439").cardMonth("11").cardYear("2020").nameOnCard("SANG C NGUYEN").build();

    @Test
    public void verifyPurchaseWithRequireFields() {
        purchasePage = new PurchasePage(webDriver);
        purchasePage.goToPage();
        purchasePage.enterBillingInfo(billingWithRequireFields);
        purchasePage.submitForm();
    }

    @Test
    public void verifyPurchaseWithOptionalFields() {
        purchasePage = new PurchasePage(webDriver);
        purchasePage.goToPage();
        purchasePage.enterBillingInfo(billingWithOptionalFields);
        purchasePage.submitForm();
    }

    @Test
    public void verifyPurchaseWithAllFields() {
        purchasePage = new PurchasePage(webDriver);
        purchasePage.goToPage();
        purchasePage.enterBillingInfo(billingWithAllFields);
        purchasePage.submitForm();
    }
}
