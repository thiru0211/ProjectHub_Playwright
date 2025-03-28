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

public class PH_4_Timesheet {
	public Page page;
	public Browser browser;
	public Playwright playwright;
	public Locator locator;

	@Given("To Check Timesheet user is navigating to ProjectHub URL is {string}")
	public void to_check_timesheet_user_is_navigating_to_project_hub_url_is(String url) {
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
	@When("To Check Timesheet Enter username and password are {string} and {string}")
	public void to_check_timesheet_enter_username_and_password_are_and(String email, String passWord) {
		String title = page.url();
		System.out.println("Current page title is: " + title);
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}
	@When("Click the Login button To Check Timesheet")
	public void click_the_login_button_to_check_timesheet() {
		Locator loginBtn = page.locator("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		loginBtn.click();
	}
	@Then("Close Timesheet page")
	public void close_timesheet_page() throws InterruptedException {
//		Thread.sleep(5000);
		page.close();
		browser.close();
		playwright.close();
	}
	@Then("Click Timesheet button in the menu bar")
	public void click_timesheet_button_in_the_menu_bar() {
		page.waitForSelector("//h6[normalize-space(text())='Time Tracking']");
		page.locator("//h6[normalize-space(text())='Time Tracking']").click();
	}
	@Given("Click Enter Timesheet button in the menu bar")
	public void click_enter_timesheet_button_in_the_menu_bar() {
		page.waitForSelector("//h6[normalize-space(text())='Enter Timesheet']");
		page.locator("//h6[normalize-space(text())='Enter Timesheet']").click();
	}
	@When("Click previous week button in Enter Timesheet")
	public void click_previous_week_button_in_enter_timesheet() {
		page.waitForSelector("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root')])[3]");
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root')])[3]").click();
	}
	@When("Click next week button in Enter Timesheet")
	public void click_next_week_button_in_enter_timesheet() {
		page.waitForSelector("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root')])[4]");
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root')])[4]").click();
	}
	@Then("Click Today button in Enter Timesheet")
	public void click_today_button_in_enter_timesheet() {
		page.waitForSelector("//button[normalize-space(text())='Today']");
		page.locator("//button[normalize-space(text())='Today']").click();
	}
	@Given("Click Add new new button in the menu bar")
	public void click_add_new_new_button_in_the_menu_bar() {
		page.waitForSelector("//button[contains(@class,'MuiButtonBase-root MuiFab-root')]");
		page.locator("//button[contains(@class,'MuiButtonBase-root MuiFab-root')]").click();
	}
	@When("Click close button in Add event popup")
	public void click_close_button_in_add_event_popup() {
		page.waitForSelector("//button[@aria-label='Cancel']");
		page.locator("//button[@aria-label='Cancel']").click();
	}
	@When("Click save button in Add event popup")
	public void click_save_button_in_add_event_popup() {
		page.waitForSelector("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[3]");
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[3]").click();
	}
	@When("Check mandatory message is displayed or not in Add event popup")
	public void check_mandatory_message_is_displayed_or_not_in_add_event_popup() {
		page.waitForSelector("#project-name-autocomplete-helper-text");
		Locator selProjErrMsg = page.locator("#project-name-autocomplete-helper-text");
		assertTrue(selProjErrMsg.isVisible(), "Error message is not displayed in Select Project dropdown tab");
		System.out.println("Select Project dropdown error message displayed like: " + selProjErrMsg.textContent());
		
		page.waitForSelector("#task-autocomplete-helper-text");
		Locator selIssErrMsg = page.locator("#task-autocomplete-helper-text");
		assertTrue(selIssErrMsg.isVisible(), "Error message is not displayed in Select Issue dropdown tab");
		System.out.println("Select Issue dropdown error message displayed like: " + selIssErrMsg.textContent());
	}
	
	@When("Select valid project {string} in Add event popup")
	public void select_valid_project_in_add_event_popup(String projName) {
		page.waitForSelector("#project-name-autocomplete");
		page.locator("#project-name-autocomplete").click();
		page.click("text=" + projName);
	}
	@When("Select valid issue {string} in Add event popup")
	public void select_valid_issue_in_add_event_popup(String issName) {
		page.waitForSelector("#task-autocomplete");
		page.locator("#task-autocomplete").click();
		page.click("text=" + issName);
	}
	@When("Select valid Start time in Add event popup")
	public void select_valid_start_time_in_add_event_popup() throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]");
		page.locator("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]").click();
		Thread.sleep(1000);
		page.waitForSelector("(//button[contains(@class,'MuiButtonBase-root MuiTab-root')])[2]");
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiTab-root')])[2]").click();
		Thread.sleep(1000);
		page.locator("//span[normalize-space(text())='2']").click();
//		Thread.sleep(1000);
//		page.locator("//span[@aria-label='30 minutes']").click();
//		Thread.sleep(1000);
//		page.locator("//button[normalize-space(text())='OK']").click();
		
	}
	@Then("Select valid End time in Add event popup")
	public void select_valid_end_time_in_add_event_popup() {
		page.waitForSelector("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[4]");
		page.locator("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[4]").click();
		
		page.waitForSelector("(//button[contains(@class,'MuiButtonBase-root MuiTab-root')])[2]");
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiTab-root')])[2]").click();
		
		page.locator("//div[@aria-label='Select minutes. Selected time is 3:00 PM']").click();
	}
	@Then("Enter valid description {string} in Add event popup")
	public void enter_valid_description_in_add_event_popup(String descriptionDetails) {
		page.waitForSelector("//div[@class='ql-container ql-snow']");
		page.locator("//div[@class='ql-container ql-snow']").click();
		Locator description = page.locator("//div[@class='ql-editor ql-blank']");
		description.clear();
		description.fill(descriptionDetails);
	}
	@Then("Click clear button in Add event popup")
	public void click_clear_button_in_add_event_popup() {
		page.waitForSelector("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]");
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]").click();
	}
	@Then("Check success message is displayed or not in Add event popup")
	public void check_success_message_is_displayed_or_not_in_add_event_popup() throws InterruptedException {
		Thread.sleep(1000);
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}
	@Given("Click View Timesheet button in the menu bar")
	public void click_view_timesheet_button_in_the_menu_bar() {
		page.waitForSelector("//h6[normalize-space(text())='View Timesheet']");
		page.locator("//h6[normalize-space(text())='View Timesheet']").click();
	}
	@When("Select valid assignee name {string} in view timesheet")
	public void select_valid_assignee_name_in_view_timesheet(String assigneeName) {
		page.waitForSelector("#autocomplete-assignee");
		page.locator("#autocomplete-assignee").click();
		page.click("text=" + assigneeName);
	}
	@Then("Check entered name {string} is displayed or not in view timesheet")
	public void check_entered_name_is_displayed_or_not_in_view_timesheet(String assignee) throws InterruptedException {
		Thread.sleep(3000);
		Locator assigneeName = page.locator("(//div[contains(@class,'MuiAvatar-root MuiAvatar-circular')]/following-sibling::span)[2]");
		String actUserName = assigneeName.textContent();
		String expUserName = assignee;
		assertTrue(actUserName.contains(expUserName), "Assignee dropdown is not working");
	}
	@When("Select valid month name {string} in view timesheet")
	public void select_valid_month_name_in_view_timesheet(String monthName) {
		page.waitForSelector("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[1]");
		page.locator("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[1]").click();
		page.click("text=" + monthName);
	}
	@When("Select valid project name {string} in view timesheet")
	public void select_valid_project_name_in_view_timesheet(String projectName) {
		page.waitForSelector("#project-name-select");
		page.locator("#project-name-select").click();
		page.click("text=" + projectName);
	}
	@When("Click export button in view timesheet")
	public void click_export_button_in_view_timesheet() {
		page.waitForSelector("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		Locator expBtn=page.locator("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		expBtn.click();
	}
}
