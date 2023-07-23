package org.pkg.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.yoga.loginpages.LoginPage;
import org.yoga.seleniumBase.BaseClass;

public class TC001Login extends BaseClass
{
@Test
	public void loginTest() {
	
	LoginPage lp = new LoginPage(driver);
	boolean usernameLabel = lp.getUsernameLabel();
	Assert .assertEquals(usernameLabel, true);
	boolean passwordlabel =lp.getPasswordLabel();
	Assert.assertTrue(passwordlabel);
	
	new LoginPage(driver)
		.enterUserName("admin")
		.enterPassword("U1+Ga*XL1luuFQzs")
		.clickLogin();
		
	}
}
