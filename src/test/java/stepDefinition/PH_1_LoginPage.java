package stepDefinition;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Dimension;
import java.awt.Toolkit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PH_1_LoginPage {
	public Page page;
	public Browser browser;
	public Playwright playwright;

	@Given("To Check Login user is navigating to ProjectHub URL is {string}")
	public void to_check_login_user_is_navigating_to_project_hub_url_is(String url) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		System.out.println("Screen size is: " + width + ":" + height);
		playwright = Playwright.create();

		browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

//		Browser browser =playwright.firefox().launch(
//				new LaunchOptions().setHeadless(false)
//				);

//		Browser browser =playwright.webkit().launch(
//				new LaunchOptions().setHeadless(false)
//				);

//		page = browser.newPage();
		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		page = browserContext.newPage();
		page.navigate(url);
	}

	@When("To Check Login Enter username and password are {string} and {string}")
	public void to_check_login_enter_username_and_password_are_and(String email, String passWord) {
		String title = page.url();
		System.out.println("Current page title is: " + title);
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}

	@When("Click the Login button To Check Login")
	public void click_the_login_button_to_check_login() {
		Locator loginBtn = page.locator("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		loginBtn.click();
	}

	@Then("Check display homepage or not To Check Login")
	public void check_display_homepage_or_not_to_check_login() {
		Locator userLogoBtn = page.locator("//button[@class='MuiButtonBase-root css-1cokcfh']");
		assertThat(userLogoBtn).isVisible();
	}

	@Then("Close Login page")
	public void close_login_page() {
		page.close();
		browser.close();
		playwright.close();
	}

	@Then("Click User logo button in Top right corner")
	public void click_user_logo_button_in_top_right_corner() {
		Locator loginBtn = page.locator("//button[@class='MuiButtonBase-root css-1cokcfh']");
		loginBtn.click();
	}

	@Then("Click SignOut button")
	public void click_sign_out_button() {
		Locator loginBtn = page.locator("//span[normalize-space(text())='Logout']");
		loginBtn.click();
	}

	@Then("Check login page is displayed or not using assert")
	public void check_login_page_is_displayed_or_not_using_assert() {
		Locator loginBtn = page.locator("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		assertThat(loginBtn).isVisible();
	}

	@When("To Check Login Enter Invalid username and valid password are {string} and {string}")
	public void to_check_login_enter_invalid_username_and_valid_password_are_and(String email, String passWord) {
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}

	@Then("Check alert message is displayed or not in login page")
	public void check_alert_message_is_displayed_or_not_in_login_page() {
		Locator errMsg = page.locator("//p[contains(@class,'MuiFormHelperText-root Mui-error')]");
		assertThat(errMsg).isVisible();
		String errMsgText = errMsg.textContent();
		System.out.println("Error Message displayed like: " + errMsgText);
	}
	@Then("Check alert message is displayed or not for inactive in login page")
	public void check_alert_message_is_displayed_or_not_for_inactive_in_login_page() {
		Locator errMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(errMsg).isVisible();
		String errMsgText = errMsg.textContent();
		System.out.println("Error Message displayed like: " + errMsgText);
	}
	@When("To Check Login Enter valid username and Invalid password are {string} and {string}")
	public void to_check_login_enter_valid_username_and_invalid_password_are_and(String email, String passWord) {
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}

	@When("To Check Login Enter Invalid username and Invalid password are {string} and {string}")
	public void to_check_login_enter_invalid_username_and_invalid_password_are_and(String email, String passWord) {
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}

	@When("To Check Login Enter username only {string}")
	public void to_check_login_enter_username_only(String email) {
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
	}

	@Then("Check alert toast message is displayed in password tab or not in login page")
	public void check_alert_toast_message_is_displayed_in_password_tab_or_not_in_login_page() {
		Locator errMsg = page.locator("//p[contains(@class,'MuiFormHelperText-root Mui-error')]");
		assertThat(errMsg).isVisible();
		// Getting the text
		String actErrMsg = errMsg.textContent();
		String expErrMsg = "Password is required";
		System.out.println("Error message is displayed like : " + actErrMsg);
		assertEquals(expErrMsg, actErrMsg, "Error message is not displayed in Password Tab");
	}

	@When("To Check Login Enter password only {string}")
	public void to_check_login_enter_password_only(String passWord) {
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}

	@Then("Check alert toast message is displayed in email tab or not in login page")
	public void check_alert_toast_message_is_displayed_in_email_tab_or_not_in_login_page() {
		Locator errMsg = page.locator("//p[contains(@class,'MuiFormHelperText-root Mui-error')]");
		assertThat(errMsg).isVisible();
		// Getting the text
		String actErrMsg = errMsg.textContent();
		String expErrMsg = "Email Address is required";
		System.out.println("Error message is displayed like : " + actErrMsg);
		assertEquals(expErrMsg, actErrMsg, "Error message is not displayed in Email Tab");
	}

	@When("Without enter email id click Forget password button")
	public void without_enter_email_id_click_forget_password_button() {
		Locator forgetBtn = page.locator("//a[normalize-space(text())='Forgot Password?']");
		forgetBtn.click();
	}

	@Then("Check alert toast message is displayed or not in login page")
	public void check_alert_toast_message_is_displayed_or_not_in_login_page() {
		Locator errToast = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(errToast).isVisible();
		// Getting the text
		String actErrMsg = errToast.textContent();
		String expErrMsg = "Please enter your Email Address.";
		System.out.println("Error message is displayed like : " + actErrMsg);
		assertEquals(expErrMsg, actErrMsg, "Error message is not displayed in Email Tab");
	}

	@When("To Check Forget Password Enter valid email id {string}")
	public void to_check_forget_password_enter_valid_email_id(String email) {
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
	}

	@When("click Forget password button")
	public void click_forget_password_button() {
		Locator forgetBtn = page.locator("//a[normalize-space(text())='Forgot Password?']");
		forgetBtn.click();
	}

	@Then("Click Ok button")
	public void click_ok_button() {
		Locator okBtn = page.locator("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		okBtn.click();
	}

	@Then("Check Login page is displayed or not")
	public void check_login_page_is_displayed_or_not() {
		Locator loginBtn = page.locator("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		assertThat(loginBtn).isVisible();
	}

	@When("Enter username and password are {string} and {string}")
	public void enter_username_and_password_are_and(String email, String passWord) {
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}

	@Then("Check alert message is displayed or not")
	public void check_alert_message_is_displayed_or_not() {
		Locator errToast = page.locator("//p[contains(@class,'MuiFormHelperText-root Mui-error')]");
		assertThat(errToast).isVisible();
		System.out.println("Error Message is displayed like: " + errToast.textContent());
	}

	@When("Enter valid username and valid password are {string} and {string}")
	public void enter_valid_username_and_valid_password_are_and(String email, String passWord) {
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}

	@When("Press ENTER button")
	public void press_enter_button() {
		page.getByPlaceholder("Enter Password").press("Enter");
	}

	@Then("Check landing page after press Enter button")
	public void check_landing_page_after_press_enter_button() throws InterruptedException {
		Locator userLogoBtn = page.locator("//button[@class='MuiButtonBase-root css-1cokcfh']");
		assertThat(userLogoBtn).isVisible();
	}
	@Then("Check the landing page using assert function")
	public void check_the_landing_page_using_assert_function() {
		Locator twoFACheck = page.locator("//h3[contains(@class,'MuiTypography-root MuiTypography-h3')]");
		assertThat(twoFACheck).isVisible();
	}
	@When("Enter inactive username {string}")
	public void enter_inactive_username(String email) {
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
	}
	@When("Enter inactive username and valid password are {string} and {string}")
	public void enter_inactive_username_and_valid_password_are_and(String email, String passWord) {
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}
	@Then("Click Admin button to unlock account")
	public void click_admin_button_to_unlock_account() {
		page.locator("//h6[normalize-space(text())='Admin']").click();
	}
	@Then("Click Users button to unlock account")
	public void click_users_button_to_unlock_account() {
		page.locator("//h6[normalize-space(text())='Users']").click();
	}
	@Then("Search valid username {string} in the searchbox to unlock the account")
	public void search_valid_username_in_the_searchbox_to_unlock_the_account(String userName) {
		page.getByPlaceholder("Search Name , Designation & Email Id").fill(userName);
	}
	@Then("Click edit button to unlock the account")
	public void click_edit_button_to_unlock_the_account() {
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]").click();
	}
	@Then("Click unlock button to unlock the account")
	public void click_unlock_button_to_unlock_the_account() {
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[1]").click();
	}
}
