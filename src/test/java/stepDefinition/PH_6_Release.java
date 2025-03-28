package stepDefinition;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FileChooser;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PH_6_Release {
	public Page page;
	public Browser browser;
	public Playwright playwright;
	public Locator locator;

	@Given("To Check Release user is navigating to ProjectHub URL is {string}")
	public void to_check_Release_user_is_navigating_to_project_hub_url_is(String url) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		System.out.println("Screen size is: " + width + ":" + height);
		playwright = Playwright.create();

		browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
//	 	browser =playwright.firefox().launch(
//				new LaunchOptions().setHeadless(false)
//				);

//		browser =playwright.webkit().launch(
//				new LaunchOptions().setHeadless(false)
//				);

//		page = browser.newPage();
		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		page = browserContext.newPage();
		page.navigate(url);
	}
	@When("To Check Release Enter username and password are {string} and {string}")
	public void to_check_Release_enter_username_and_password_are_and(String email, String passWord) {
		String title = page.url();
		System.out.println("Current page title is: " + title);
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}
	@When("Click the Login button To Check Release")
	public void click_the_login_button_to_check_Release() {
		Locator loginBtn = page.locator("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		loginBtn.click();
	}
	@Then("Close Release page")
	public void close_Release_page() throws InterruptedException {
		Thread.sleep(5000);
		page.close();
		browser.close();
		playwright.close();
	}
	@Then("Click Release button in the menu bar")
	public void click_Release_button_in_the_menu_bar() throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("(//h6[text()='Release'])[1]");
		page.locator("(//h6[text()='Release'])[1]").click();
	}
	@Given("Click Release screen button in the menu bar")
	public void click_release_screen_button_in_the_menu_bar() throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("(//h6[text()='Release'])[2]");
		page.locator("(//h6[text()='Release'])[2]").click();
	}
	@When("Enter valid release version name {string} in Release screen")
	public void enter_valid_release_version_name_in_release_screen(String version) {
		Locator relVer = page.getByPlaceholder("Search Release...");
		relVer.clear();
		relVer.fill(version);
	}
	@When("Check entered release name {string} is displayed or not in Release screen")
	public void check_entered_release_name_is_displayed_or_not_in_release_screen(String relVersion) throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("//h6/span/a");
		Locator relVer = page.locator("//h6/span/a");
		String actRelVersion = relVer.innerText();
		System.out.println("Text content: "+ actRelVersion);
		String expRelVersion = relVersion;
		assertEquals(expRelVersion,actRelVersion,"Search function is not working");
	}
	@When("Select valid from date {string} in Release screen")
	public void select_valid_from_date_in_release_screen(String fromDate) throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("//label[normalize-space(text())='From Date']");
		Locator dateInput = page.locator("//label[normalize-space(text())='From Date']");
		dateInput.click();
		dateInput.press("Control+A");
		dateInput.press("Backspace");
		dateInput.pressSequentially(fromDate); 
		dateInput.press("Enter"); 
	}
	@When("Select valid to date {string} in Release screen")
	public void select_valid_to_date_in_release_screen(String toDate) throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("//label[normalize-space(text())='To Date']");
		Locator dateInput = page.locator("//label[normalize-space(text())='To Date']");
		dateInput.click();
		dateInput.press("Control+A");
		dateInput.press("Backspace");
		dateInput.pressSequentially(toDate); 
		dateInput.press("Enter");
	}
	@When("Select valid project name {string} in Release screen")
	public void select_valid_project_name_in_release_screen(String projName) throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("#project-name-select");
		page.locator("#project-name-select").click();
		page.click("text=" + projName);
	}
	@When("Select valid status name {string} in Release screen")
	public void select_valid_status_name_in_release_screen(String statusName) {
		page.locator("#status-select").click();
		page.click("text=" + statusName);
	}
	@When("Click add new button in Release screen")
	public void click_add_new_button_in_release_screen() {
		page.waitForSelector("//span[contains(@class,'MuiButton-icon MuiButton-startIcon')]");
		page.locator("//span[contains(@class,'MuiButton-icon MuiButton-startIcon')]").click();
	}
	@When("Click close button in add Release popup")
	public void click_close_button_in_add_release_popup() {
		page.waitForSelector("//button[@aria-label='Cancel']");
		page.locator("//button[@aria-label='Cancel']").click();
	}
	@When("Click save button in add Release popup")
	public void click_save_button_in_add_release_popup() {
		page.waitForSelector("//button[normalize-space(text())='Save']");
		page.locator("//button[normalize-space(text())='Save']").click();
	}
	@Then("Check mandatory message is displayed or not in add Release popup")
	public void check_mandatory_message_is_displayed_or_not_in_add_release_popup() {
		Locator relVerErrMsg = page.locator("#Releaseversion-helper-text");
		Locator selProjErrMsg = page.locator("#project-name-autocomplete-helper-text");
		Locator strtDateErrMsg = page.locator("(//div[@class='error'])[1]");
		Locator relDateErrMsg = page.locator("(//div[@class='error'])[2]");
		Locator relStrtErrMsg = page.locator("#startTime-helper-text");
		Locator relEndErrMsg = page.locator("#endTime-helper-text");

		assertTrue(relVerErrMsg.isVisible(), "Error message is not displayed in Release Version tab");
		assertTrue(selProjErrMsg.isVisible(), "Error message is not displayed in Select Project tab");
		assertTrue(strtDateErrMsg.isVisible(), "Error message is not displayed in start date tab");
		assertTrue(relDateErrMsg.isVisible(), "Error message is not displayed in end date tab");
		assertTrue(relStrtErrMsg.isVisible(), "Error message is not displayed in Release Start Time tab");
		assertTrue(relEndErrMsg.isVisible(), "Error message is not displayed in Release End Time tab");

		System.out.println("Start target tab error message displayed like: " + relVerErrMsg.textContent());
		System.out.println("End target tab error message displayed like: " + selProjErrMsg.textContent());
		System.out.println("Start Date tab error message displayed like: " + strtDateErrMsg.textContent());
		System.out.println("End Date tab error message displayed like: " + relDateErrMsg.textContent());
		System.out.println("Description tab error message displayed like: " + relStrtErrMsg.textContent());
		System.out.println("Description tab error message displayed like: " + relEndErrMsg.textContent());
	}
	@When("Enter valid release version name in add Release popup")
	public void enter_valid_release_version_name_in_add_release_popup() {
		page.waitForSelector("#Releaseversion");
		Locator relVer = page.locator("#Releaseversion");
		Faker faker=new Faker();
		int frstNumber = faker.number().numberBetween(1, 10);
		int secondNumber = faker.number().numberBetween(1, 100);
		relVer.fill("V"+frstNumber+"."+secondNumber);
	}
	@Then("Select valid Project name {string} in add Release popup")
	public void select_valid_project_name_in_add_release_popup(String projName) throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("#project-name-autocomplete");
		page.locator("#project-name-autocomplete").click();
		page.waitForSelector("//li[contains(@class, 'MuiAutocomplete-option')]");
		page.locator("//li[contains(@class, 'MuiAutocomplete-option') and text()='Automation Testing']").click();
	}
	@Then("Select valid task option {string} in add Release popup")
	public void select_valid_task_option_in_add_release_popup(String taskName) {
		page.locator("#taskname").click();
		page.click("text=" + taskName);
	}
	@Then("Select valid start date {string} in add Release popup")
	public void select_valid_start_date_in_add_release_popup(String strtDate) {
		page.waitForSelector("(//input[@placeholder='MM/DD/YYYY'])[1]");
		page.locator("(//input[@placeholder='MM/DD/YYYY'])[1]").click();
		page.locator("//button[normalize-space(text())='"+strtDate+"']").click();
	}
	@Then("Select valid release date {string} in add Release popup")
	public void select_valid_release_date_in_add_release_popup(String endDate) throws InterruptedException {
		page.waitForSelector("(//input[@placeholder='MM/DD/YYYY'])[2]");
		page.locator("(//input[@placeholder='MM/DD/YYYY'])[2]").click();
		Thread.sleep(1000);
		page.locator("//button[@title='Next month']").click();
		Thread.sleep(1000);
		page.locator("//button[normalize-space(text())='"+endDate+"']").click();
	}
	@Then("Select valid release start time {string} and {string} and {string} in add Release popup")
	public void select_valid_release_start_time_and_and_in_add_release_popup(String hh, String mm, String format) {
		page.waitForSelector("#startTime");
		Locator strtTime = page.locator("#startTime");
		strtTime.click();
		strtTime.pressSequentially(hh);
		strtTime.pressSequentially(mm);
		strtTime.pressSequentially(format);
		
	}
	@Then("Select valid release end time {string} and {string} and {string} in add Release popup")
	public void select_valid_release_end_time_and_and_in_add_release_popup(String hh, String mm, String format) {
		page.waitForSelector("#endTime");
		Locator endTime = page.locator("#endTime");
		endTime.click();
		endTime.pressSequentially(hh);
		endTime.pressSequentially(mm);
		endTime.pressSequentially(format);
	}
	@Then("Enter valid description {string} in add Release popup")
	public void enter_valid_description_in_add_release_popup(String description) {
		page.waitForSelector("#Notes");
		Locator descp = page.locator("#Notes");
		descp.fill(description);
	}
	@Then("Click clear button in add Release popup")
	public void click_clear_button_in_add_release_popup() {
		page.waitForSelector("#reset");
		page.locator("#reset").click();
	}
	@Then("Check success message is displayed or not in Release")
	public void check_success_message_is_displayed_or_not_in_release() {
		page.waitForSelector("//div[@class='MuiAlert-message css-18mfsq4']");
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}
	@When("Click edit button in release screen")
	public void click_edit_button_in_release_screen() {
		page.waitForSelector("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]");
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]").click();
	}
	@Then("Modify the details in edit release popup")
	public void modify_the_details_in_edit_release_popup() throws InterruptedException {
		page.waitForSelector("#Releaseversion");
		Locator relVer = page.locator("#Releaseversion");
		String actValue = relVer.inputValue();
		relVer.clear();
		Thread.sleep(1000);
		relVer.fill("R");

		Thread.sleep(1000);
		page.waitForSelector("#startTime");
		Locator strtTime = page.locator("#startTime");
		strtTime.click();
		strtTime.pressSequentially("11");
		strtTime.pressSequentially("00");
		strtTime.pressSequentially("P");
		
		Thread.sleep(1000);
		page.waitForSelector("#endTime");
		Locator endTime = page.locator("#endTime");
		endTime.click();
		endTime.pressSequentially("11");
		endTime.pressSequentially("50");
		endTime.pressSequentially("P");
		
	}
	@Then("Click update button in edit release popup")
	public void click_update_button_in_edit_release_popup() throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("//button[normalize-space(text())='Update']");
		page.locator("//button[normalize-space(text())='Update']").click();
	}
	
	@Given("Click user logo button in dashboard")
	public void click_user_logo_button_in_dashboard() {
		page.waitForSelector("(//img[@class='MuiAvatar-img css-1hy9t21'])[1]");
		page.locator("(//img[@class='MuiAvatar-img css-1hy9t21'])[1]").click();
	}
	@Given("Click logout button in profile tab")
	public void click_logout_button_in_profile_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Enter valid release manager mail id {string} in email tab")
	public void enter_valid_release_manager_mail_id_in_email_tab(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Enter valid password {string} in login page")
	public void enter_valid_password_in_login_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("Click the login button for release manager")
	public void click_the_login_button_for_release_manager() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Click the release version name in release screen")
	public void click_the_release_version_name_in_release_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Check page landed to deployment request page or not in release screen")
	public void check_page_landed_to_deployment_request_page_or_not_in_release_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
