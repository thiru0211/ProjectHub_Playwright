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

public class PH_5_Report {
	public Page page;
	public Browser browser;
	public Playwright playwright;
	public Locator locator;

	@Given("To Check Report user is navigating to ProjectHub URL is {string}")
	public void to_check_Report_user_is_navigating_to_project_hub_url_is(String url) {
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
	@When("To Check Report Enter username and password are {string} and {string}")
	public void to_check_Report_enter_username_and_password_are_and(String email, String passWord) {
		String title = page.url();
		System.out.println("Current page title is: " + title);
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}
	@When("Click the Login button To Check Report")
	public void click_the_login_button_to_check_Report() {
		Locator loginBtn = page.locator("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		loginBtn.click();
	}
	@Then("Close Report page")
	public void close_Report_page() throws InterruptedException {
		Thread.sleep(5000);
		page.close();
		browser.close();
		playwright.close();
	}
	@Then("Click Report button in the menu bar")
	public void click_Report_button_in_the_menu_bar() {
		page.waitForSelector("//h6[normalize-space(text())='Report']");
		page.locator("//h6[normalize-space(text())='Report']").click();
	}
	@Given("Click Project Report button in the menu bar")
	public void click_project_report_button_in_the_menu_bar() {
		page.waitForSelector("//h6[normalize-space(text())='Project Report']");
		page.locator("//h6[normalize-space(text())='Project Report']").click();
	}
	@When("Select valid time {string} option in Project Report")
	public void select_valid_time_option_in_project_report(String time) {
		page.waitForSelector("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[1]");
		page.locator("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[1]").click();
		page.click("text=" + time);
	}
	@When("Select valid project {string} option in Project Report")
	public void select_valid_project_option_in_project_report(String project) {
		page.waitForSelector("//div[@class='MuiBox-root css-70qvj9']");
		page.locator("//div[@class='MuiBox-root css-70qvj9']").click();
		page.click("text=" + project);
	}
	@When("Click view all issues button in Project Report")
	public void click_view_all_issues_button_in_project_report() {
		page.waitForSelector("(//a[text()='View all issues'])[1]");
		page.locator("(//a[text()='View all issues'])[1]").click();
	}
	@When("Check page landed to kanban board page or not from Project Report")
	public void check_page_landed_to_kanban_board_page_or_not_from_project_report() {
		String currentURL = page.url();
		String expURL="http://192.168.1.33/proj/TaskManagement/Kanbandboard";
		System.out.println("Current URL is: "+currentURL);
		assert currentURL.equals(expURL):"Page doesnot navigate to kanban board page";
	}
	@Given("Click Resource Report button in the menu bar")
	public void click_resource_report_button_in_the_menu_bar() {
		page.waitForSelector("//h6[normalize-space(text())='Resource Report']");
		page.locator("//h6[normalize-space(text())='Resource Report']").click();
	}
	@When("Select valid time {string} option in Resource Report")
	public void select_valid_time_option_in_resource_report(String time) {
		page.waitForSelector("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[1]");
		page.locator("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[1]").click();
		page.click("text=" + time);
	}
	@When("Select valid project {string} option in Resource Report")
	public void select_valid_project_option_in_resource_report(String project) {
		page.waitForSelector("//div[@class='MuiBox-root css-70qvj9']");
		page.locator("//div[@class='MuiBox-root css-70qvj9']").click();
		page.click("text=" + project);
	}
	@When("Select valid assignee name {string} option in Resource Report")
	public void select_valid_assignee_name_option_in_resource_report(String assigneeName) {
		page.waitForSelector("#autocomplete-assignee");
		page.locator("#autocomplete-assignee").click();
		page.click("text=" + assigneeName);
	}
	@When("Check entered name {string} is displayed or not in Resource Report")
	public void check_entered_name_is_displayed_or_not_in_resource_report(String assignee) throws InterruptedException {
//		Thread.sleep(3000);
//		Locator assigneeName = page.locator("//div[contains(@class,'apexcharts-canvas apexchartsx4kpapr6')]");
//		String actUserName = assigneeName.textContent();
//		System.out.println("Actual assignee name: "+actUserName);
//		String expUserName = assignee;
//		System.out.println("Expected assignee name: "+expUserName);
//		assertEquals(expUserName, actUserName, "Assignee dropdown is not working");
		String tooltipText = page.locator("//g[contains(@class,'apexcharts-xaxis-texts-g')]//title").textContent().trim();
		System.out.println("Text is: "+tooltipText);
	}
	@When("Click export excel button in Resource Report")
	public void click_export_excel_button_in_resource_report() {
		page.waitForSelector("//span[contains(@class,'MuiButton-icon MuiButton-startIcon')]");
		page.locator("//span[contains(@class,'MuiButton-icon MuiButton-startIcon')]").click();
	}
	@Given("Click Budget Report button in the menu bar")
	public void click_budget_report_button_in_the_menu_bar() {
		page.waitForSelector("//h6[normalize-space(text())='Budget Report']");
		page.locator("//h6[normalize-space(text())='Budget Report']").click();
	}
	@When("Select valid project {string} option in Budget Report")
	public void select_valid_project_option_in_budget_report(String project) {
		page.waitForSelector("//div[@class='MuiBox-root css-70qvj9']");
		page.locator("//div[@class='MuiBox-root css-70qvj9']").click();
		page.click("text=" + project);
	}
}
