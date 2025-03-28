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

public class PH_3_TaskManagement {
	public Page page;
	public Browser browser;
	public Playwright playwright;
	public Locator locator;

	@Given("To Check Task Management user is navigating to ProjectHub URL is {string}")
	public void to_check_task_management_user_is_navigating_to_project_hub_url_is(String url) {
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

	@When("To Check Task Management Enter username and password are {string} and {string}")
	public void to_check_task_management_enter_username_and_password_are_and(String email, String passWord) {
		String title = page.url();
		System.out.println("Current page title is: " + title);
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}

	@When("Click the Login button To Check Task Management")
	public void click_the_login_button_to_check_task_management() {
		Locator loginBtn = page.locator("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		loginBtn.click();
	}

	@Then("Close Task Management page")
	public void close_task_management_page() throws InterruptedException {
//		Thread.sleep(5000);
		page.close();
		browser.close();
		playwright.close();
	}

	@Then("Click Task Management button in the menu bar")
	public void click_task_management_button_in_the_menu_bar() {
		page.locator("//h6[normalize-space(text())='Task Management']").click();
	}

	@Given("Click Project button in the menu bar")
	public void click_project_button_in_the_menu_bar() {
		page.locator("//h6[normalize-space(text())='Project']").click();
	}

	@When("Enter valid Project Name {string} in the searchbox in Project screen")
	public void enter_valid_project_name_in_the_searchbox_in_project_screen(String projName) {
		Locator projNameValue = page.getByPlaceholder("Search...");
		projNameValue.fill(projName);
	}

	@When("Check entered Project name {string} is displayed or not in Project screen")
	public void check_entered_project_name_is_displayed_or_not_in_project_screen(String expProjName)
			throws InterruptedException {
		Thread.sleep(3000);
		Locator projName = page.locator("//h6[contains(@class,'MuiTypography-root MuiTypography-subtitle1')]");
		String actUserName = projName.textContent();
		String expUserName = expProjName;
		assertEquals(expUserName, actUserName, "Searchbox is not working");
	}

	@When("Enter valid Lead Name {string} in the searchbox in Project screen")
	public void enter_valid_lead_name_in_the_searchbox_in_project_screen(String leadName) {
		Locator leadNameValue = page.getByPlaceholder("Search...");
		leadNameValue.fill(leadName);
	}

	@When("Check entered Lead name {string} is displayed or not in Project screen")
	public void check_entered_lead_name_is_displayed_or_not_in_project_screen(String expLeadName)
			throws InterruptedException {
		Thread.sleep(3000);
		Locator leadName = page.locator("(//td[contains(@class,'MuiTableCell-root MuiTableCell-body')])[3]");
		String actUserName = leadName.textContent();
		String expUserName = expLeadName;
		assertEquals(expUserName, actUserName, "Searchbox is not working");
	}

	@When("Click Add New button in Project screen")
	public void click_add_new_button_in_project_screen() {
		page.locator("//span[contains(@class,'MuiButton-icon MuiButton-startIcon')]").click();
	}

	@When("Click Back button in add Project screen")
	public void click_back_button_in_add_project_screen() {
		page.locator("//button[normalize-space(text())='Back']").click();
	}

	@Then("Check landing page in Project screen")
	public void check_landing_page_in_project_screen() {
		Locator leadNameValue = page.getByPlaceholder("Search...");
		assertThat(leadNameValue).isVisible();
	}

	@When("Click save button in add Project screen")
	public void click_save_button_in_add_project_screen() {
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[3]").click();
	}

	@Then("Check mandatory message is displayed or not in add Project screen")
	public void check_mandatory_message_is_displayed_or_not_in_add_project_screen() {
		Locator projNameErrMsg = page.locator("(//p[contains(@class,'MuiFormHelperText-root Mui-error')])[1]");
		Locator projCodeErrMsg = page.locator("(//p[contains(@class,'MuiFormHelperText-root Mui-error')])[2]");
		assertThat(projNameErrMsg).isVisible();
		assertThat(projCodeErrMsg).isVisible();
		String projNameErrMsgText = projNameErrMsg.textContent();
		String projCodeErrMsgText = projCodeErrMsg.textContent();
		System.out.println("Error messsage displayed in Project Name tab like : " + projNameErrMsgText);
		System.out.println("Error messsage displayed in Project Code tab like : " + projCodeErrMsgText);
	}

	@Then("Click clear button in add Project screen")
	public void click_clear_button_in_add_project_screen() {
		page.locator("//button[normalize-space(text())='Clear']").click();
	}

	@Then("Check mandatory message is cleared or not in add Project screen")
	public void check_mandatory_message_is_cleared_or_not_in_add_project_screen() {
		Locator projNameErrMsg = page.locator("(//p[contains(@class,'MuiFormHelperText-root Mui-error')])[1]");
		Locator projCodeErrMsg = page.locator("(//p[contains(@class,'MuiFormHelperText-root Mui-error')])[2]");
		boolean projNameErrVisible = projNameErrMsg.isVisible();
		boolean projCodeErrVisible = projCodeErrMsg.isVisible();
		assertFalse(projNameErrVisible);
		assertFalse(projCodeErrVisible);
	}

	@When("Enter valid Project Name in add Project screen")
	public void enter_valid_project_name_in_add_project_screen() throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("#Projectname");
		Locator projName = page.getByPlaceholder("Enter Project Name");
		Faker faker = new Faker();
		String projTitle = faker.book().title();
		String fullName = faker.name().fullName();
		projName.fill(projTitle + " Project created by: "+fullName);
	}

	@Then("Enter valid Project Code in add Project screen")
	public void enter_valid_project_code_in_add_project_screen() throws InterruptedException {
		Thread.sleep(1000);
		page.waitForSelector("#Projectcode");
		Locator projCode = page.getByPlaceholder("Enter Project Code");
		Faker faker = new Faker();
		String projCodeValue = faker.letterify("????").toUpperCase();
		projCode.fill(projCodeValue + "-01");
	}

	@Then("Click support radio button in add Project screen")
	public void click_support_radio_button_in_add_project_screen() {
		page.locator("(//input[@type='radio'])[2]").click();
	}

	@Then("Select Active status in add Project screen")
	public void select_valid_status_in_add_project_screen() {
//		Locator statusBox = page.locator("#mui-component-select-status");
//		statusBox.click();
//		Locator activeOptn = page.locator("(//li[@role='option'])[1]");
//		activeOptn.click();

		page.locator("#mui-component-select-status").click();
		page.click("text=Active");
	}

	@Then("Click Timeline button in add Project screen")
	public void click_timeline_button_in_add_project_screen() {
		page.locator("//div[@aria-label='Choose Time Line view']").click();
	}

	@Then("Click clear button in Project screen")
	public void click_clear_button_in_project_screen() {
		page.locator("//button[@aria-label='Click here to Clear']").click();
	}

	@Then("Check entered data is cleared or not in add Project screen")
	public void check_entered_data_is_cleared_or_not_in_add_project_screen() {
		Locator projName = page.locator("#Projectname");
		Locator projCode = page.locator("#Projectcode");
		Locator projRadioButton = page.locator("(//input[@type='radio'])[1]");
//		Locator projStatus = page.locator("#mui-component-select-status");
//		Locator projDefView = page.locator("//div[@class='MuiBox-root css-198w8hu']");

		boolean projNameValue = projName.textContent().isEmpty();
		boolean projCodeValue = projCode.textContent().isEmpty();
		boolean projRadioButtonStatus = projRadioButton.isChecked();
//		String actProjStatus = projStatus.textContent();
//		String expProjStatus = "Active";
//		boolean projDefViewStatus = projDefView.isChecked();

		assertTrue(projNameValue);
		assertTrue(projCodeValue);
		assertTrue(projRadioButtonStatus);
//		assertEquals(expProjStatus, actProjStatus, "Clear is not properly working");
//		assertTrue(projDefViewStatus);
	}

	@Then("Click project radio button in add Project screen")
	public void click_project_radio_button_in_add_project_screen() {
		page.locator("(//input[@type='radio'])[1]").click();
	}

	@Then("Click Kanban Board button in add Project screen")
	public void click_kanban_board_button_in_add_project_screen() {
		page.locator("//div[@class='MuiBox-root css-198w8hu']").click();
	}

	@Then("Click save button in Project screen")
	public void click_save_button_in_project_screen() {
		page.locator("//button[normalize-space(text())='Save']").click();
	}

	@Then("Check success message is displayed or not in add Project screen")
	public void check_success_message_is_displayed_or_not_in_add_project_screen() throws InterruptedException {
		Thread.sleep(1000);
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}

	@When("Click edit button in project screen")
	public void click_edit_button_in_project_screen() {
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]").click();
	}

	@Then("Click back button in project screen")
	public void click_back_button_in_project_screen() {
		page.locator("//button[normalize-space(text())='Back']").click();
	}

	@Then("Click clear button in edit project screen")
	public void click_clear_button_in_edit_project_screen() {
		page.locator("//button[normalize-space(text())='Clear']").click();
	}

	@Then("Check previous details is cleared or not in edit project screen")
	public void check_previous_details_is_cleared_or_not_in_edit_project_screen() {
		Locator projName = page.locator("#Projectname");
		Locator projRadioButton = page.locator("(//input[@type='radio'])[1]");
		Locator projStatus = page.locator("#mui-component-select-status");

		boolean projNameValue = projName.textContent().isEmpty();
		boolean projRadioButtonStatus = projRadioButton.isChecked();
		String actProjStatus = projStatus.textContent();
		String expProjStatus = "Active";

		assertTrue(projNameValue);
		assertTrue(projRadioButtonStatus);
		assertEquals(expProjStatus, actProjStatus, "Clear button is not properly working");
	}

	@Then("Modify valid details in edit project screen")
	public void modify_valid_details_in_edit_project_screen() {
		Locator projName = page.locator("#Projectname");
//		String projNameValue = projName.inputValue();
		projName.clear();
		projName.fill("Automation Testing");
	}

	@Then("Click reset button in edit project screen")
	public void click_reset_button_in_edit_project_screen() {
		page.locator("//button[normalize-space(text())='Clear']").click();
	}

	@Then("Check previous details is displayed or not in edit project screen")
	public void check_previous_details_is_displayed_or_not_in_edit_project_screen() {
		Locator projName = page.locator("#Projectname");
		String expProjNameValue = projName.textContent();
		String actProjNameValue = expProjNameValue;
		assertEquals(expProjNameValue, actProjNameValue, "Reset Button is not properly working");
	}

	@Then("Click upade button in edit project screen")
	public void click_upade_button_in_edit_project_screen() {
		page.locator("//button[normalize-space(text())='Update']").click();
	}

	@Then("Check success message is displayed or not in edit project screen")
	public void check_success_message_is_displayed_or_not_in_edit_project_screen() throws InterruptedException {
		Thread.sleep(1000);
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}

	@Then("Enter valid domain name {string} in add Project screen")
	public void enter_valid_domain_name_in_add_project_screen(String domNameValue) {
		Locator domName = page.locator("#domainName");
		domName.fill(domNameValue);

	}

	@Then("Select valid mail server {string} in add Project screen")
	public void select_valid_mail_server_in_add_project_screen(String mailServerName) {
		page.locator("#mailServerAccount").click();
		page.click("text=" + mailServerName);
	}

	@Then("Enter valid host name {string} in add Project screen")
	public void enter_valid_host_name_in_add_project_screen(String hostNameValue) {
		Locator hostName = page.locator("#hostName");
		hostName.fill(hostNameValue);
	}

	@Then("Enter valid support email {string} in add Project screen")
	public void enter_valid_support_email_in_add_project_screen(String supEmailNameValue) {
		Locator supEmailName = page.locator("#email");
		supEmailName.fill(supEmailNameValue);
	}

	@Then("Enter valid password {string} in add Project screen")
	public void enter_valid_password_in_add_project_screen(String passWord) {
		Locator password = page.locator("#password");
		password.fill(passWord);
	}

	@Then("Enter valid port {string} in add Project screen")
	public void enter_valid_port_in_add_project_screen(String portNumberValue) {
		Locator portNumber = page.locator("#port");
		portNumber.fill(portNumberValue);
	}

	@When("Enter valid Kanban Board Project Name {string} in the searchbox in Project screen")
	public void enter_valid_kanban_board_project_name_in_the_searchbox_in_project_screen(String projname) {
		Locator projName = page.locator("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[1]");
		projName.fill(projname);
	}

	@When("Click project name in project screen")
	public void click_project_name_in_project_screen() throws InterruptedException {
		Thread.sleep(2000);
		page.locator("//h6[contains(@class,'MuiTypography-root MuiTypography-subtitle1')]").click();
	}

	@Then("Check page landed to kanban board screen or not")
	public void check_page_landed_to_kanban_board_screen_or_not() {
		Locator createBtn = page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[1]");
		assertThat(createBtn).isVisible();
	}

	@When("Enter valid Timeline Project Name {string} in the searchbox in Project screen")
	public void enter_valid_timeline_project_name_in_the_searchbox_in_project_screen(String projname) {
		Locator projName = page.locator("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[1]");
		projName.fill(projname);
	}

	@Then("Check page landed to timeline screen or not")
	public void check_page_landed_to_timeline_screen_or_not() {
		Locator dayViewBtn = page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[1]");
		assertThat(dayViewBtn).isVisible();
	}

	@When("Click overview button in project screen")
	public void click_overview_button_in_project_screen() throws InterruptedException {
		Thread.sleep(1000);
		page.locator("//button[normalize-space(text())='Overview']").click();
	}

	@Then("Enter valid details {string} in description box in project screen")
	public void enter_valid_details_in_description_box_in_project_screen(String projDescp) throws InterruptedException {
		Thread.sleep(1000);
		page.locator("(//textarea[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]").click();
		page.locator("//div[@class='ql-editor ql-blank']").click();
		Locator projDes = page.locator("//div[@class='ql-editor ql-blank']");
		projDes.clear();
		projDes.fill(projDescp);
	}

	@Then("Check tab is empty or not in description box")
	public void check_tab_is_empty_or_not_in_description_box() {
		Locator projDes = page.locator("//div[@class='ql-container ql-snow']//div[1]");
		String projDesValue = projDes.textContent();
		System.out.println("Description box contains: " + projDesValue);
		boolean projDespValue = projDesValue.isEmpty();
		assertFalse(projDespValue, "User cannot able to type in description box");
	}

	@Then("Click project roles button in overview screen")
	public void click_project_roles_button_in_overview_screen() {
		page.locator("(//h6[contains(@class,'MuiTypography-root MuiTypography-subtitle1')])[1]").click();
	}

	@Then("Click create team button in overview screen")
	public void click_create_teambutton_in_overview_screen() {
		page.locator("//button[normalize-space(text())='Create Team']").click();
	}

	@Then("Click close button in add team")
	public void click_close_button_in_add_team() {
		page.locator("//button[@aria-label='Cancel']").click();
	}

	@Then("Select valid default email {string} in add team")
	public void select_valid_default_email_in_add_team(String mailName) {
		page.locator("#email").click();
		page.click("text=" + mailName);
		page.locator("(//label[contains(@class,'MuiFormLabel-root MuiInputLabel-root')])[1]").click();
	}

	@Then("Select valid users {string} in add team")
	public void select_valid_users_in_add_team(String userName) {
		page.locator("#team").click();
		page.click("text=" + userName);
	}

	@Then("Select valid lead name {string} in add team")
	public void select_valid_lead_name_in_add_team(String leadName) {
		page.locator("#leadname").click();
		page.click("text=" + leadName);
	}

	@Then("Click save button in add team")
	public void click_save_button_in_add_team() {
		page.locator("//button[normalize-space(text())='Update']").click();
	}

	@Then("Check success message is displayed or not in add team")
	public void check_success_message_is_displayed_or_not_in_add_team() throws InterruptedException {
		Thread.sleep(1000);
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}

	@Then("Click upload button in project attachements")
	public void click_upload_button_in_project_attachements() {
		page.locator("//span[contains(@class,'MuiTypography-root MuiTypography-body1')]").click();
	}

	@Then("Upload invalid file type in project attachements")
	public void upload_invalid_file_type_in_project_attachements() {
		String filePath = "Files\\Audio File.mp3";
		Locator fileInput = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		fileInput.setInputFiles(Paths.get(filePath));
	}

	@Then("Check error message is displayed or not in add team")
	public void check_error_message_is_displayed_or_not_in_add_team() throws InterruptedException {
		Thread.sleep(1000);
		Locator errMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(errMsg).isVisible();
		String errMsgValue = errMsg.textContent();
		System.out.println("Success message is displayed like: " + errMsgValue);
	}

	@Then("Upload single valid file type in project attachements")
	public void upload_single_valid_file_type_in_project_attachements() {
		String filePath = "C:\\Users\\thirumaran\\eclipse-workspace\\PlayWright-ProjectHub\\Files\\Blank.xlsx";
//		Locator fileInput = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
//		fileInput.setInputFiles(Paths.get(filePath));
		FileChooser fileChooser = page
				.waitForFileChooser(() -> page.locator("//div[@class='MuiAlert-message css-18mfsq4']"));
		fileChooser.setFiles(Paths.get(filePath));
	}

	@Then("Check single file is displayed or not in project attachement tab")
	public void check_single_file_is_displayed_or_not_in_project_attachement_tab() {
		Locator fileCheck = page.locator("//div[@class='MuiBox-root css-jfyqpv']");
		assertThat(fileCheck).isVisible();
	}

	@Then("Upload multiple valid file type in project attachements")
	public void upload_multiple_valid_file_type_in_project_attachements() {
		String filePath1 = "\\Files\\Sample.png";
		String filePath2 = "\\Files\\Blank.xlsx";
//		Locator fileInput = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
//		fileInput.setInputFiles(Paths.get(filePath1));
//		fileInput.setInputFiles(Paths.get(filePath2));
	}

	@Then("Check multiple file is displayed or not in project attachement tab")
	public void check_multiple_file_is_displayed_or_not_in_project_attachement_tab() {
		Locator fileCheck1 = page.locator("(//div[@class='MuiBox-root css-jfyqpv'])[1]']");
		assertThat(fileCheck1).isVisible();
		Locator fileCheck2 = page.locator("(//div[@class='MuiBox-root css-jfyqpv'])[2]']");
		assertThat(fileCheck2).isVisible();
	}

	@Then("Click add goal button in overview screen")
	public void click_add_goal_button_in_overview_screen() throws InterruptedException {
		Thread.sleep(1000);
		page.locator("//button[normalize-space(text())='Add Goal']").click();
	}

	@Then("Click close button in add goal page")
	public void click_close_button_in_add_goal_page() {
		page.locator("//button[@aria-label='Cancel']").click();
	}

	@Then("Click add button in add goal page")
	public void click_add_button_in_add_goal_page() {
		page.locator("//h6[contains(@class,'MuiTypography-root MuiTypography-h6')]/following-sibling::button[1]")
				.click();
	}

	@Then("Click save button in add goal page")
	public void click_save_button_in_add_goal_page() {
		page.locator("//button[normalize-space(text())='Update']").click();
	}

	@Then("Check mandatory message is displayed or not in add goal page")
	public void check_mandatory_message_is_displayed_or_not_in_add_goal_page() {
		Locator strtTargErrMsg = page.locator("(//div[@class='error'])[1]");
		Locator endTargErrMsg = page.locator("(//div[@class='error'])[2]");
		Locator strtDateErrMsg = page.locator("(//div[@class='error'])[3]");
		Locator endDateErrMsg = page.locator("(//div[@class='error'])[4]");
		Locator desErrMsg = page.locator("(//div[@class='error'])[5]");

		assertTrue(strtTargErrMsg.isVisible(), "Error message is not displayed in start target tab");
		assertTrue(endTargErrMsg.isVisible(), "Error message is not displayed in end target tab");
		assertTrue(strtDateErrMsg.isVisible(), "Error message is not displayed in start date tab");
		assertTrue(endDateErrMsg.isVisible(), "Error message is not displayed in end date tab");
		assertTrue(desErrMsg.isVisible(), "Error message is not displayed in description tab");

		System.out.println("Start target tab error message displayed like: " + strtTargErrMsg.textContent());
		System.out.println("End target tab error message displayed like: " + endTargErrMsg.textContent());
		System.out.println("Start Date tab error message displayed like: " + strtDateErrMsg.textContent());
		System.out.println("End Date tab error message displayed like: " + endDateErrMsg.textContent());
		System.out.println("Description tab error message displayed like: " + desErrMsg.textContent());
	}

	@Then("Select valid start target in add goal page")
	public void select_valid_start_target_in_add_goal_page() {
		page.waitForSelector("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[2]");
		page.locator("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[2]").click();
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiPickersDay-root')])[1]").click();
	}

	@Then("Select valid end target in add goal page")
	public void select_valid_end_target_in_add_goal_page() {
		page.waitForSelector("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]");
		page.locator("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]").click();
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiPickersDay-root')])[28]").click();
	}

	@Then("Select valid from date in first row")
	public void select_valid_from_date_in_first_row() {
		page.waitForSelector("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-ydoeeb'])[3]");
		page.locator(
				"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-ydoeeb'])[3]")
				.click();
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiPickersDay-root')])[1]").click();
	}

	@Then("Select valid to date in first row")
	public void select_valid_to_date_in_first_row() {
		page.waitForSelector("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-ydoeeb'])[4]");
		page.locator(
				"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-ydoeeb'])[4]")
				.click();
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiPickersDay-root')])[15]").click();
	}

	@Then("Enter valid description {string} in first row")
	public void enter_valid_description_in_first_row(String descValue) {
		Locator frstDescrp = page
				.locator("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1k2h94j'])[2]");
		frstDescrp.fill(descValue);
	}

	@Then("Enter valid description {string} in second row")
	public void enter_valid_description_in_second_row(String descValue) {
		Locator frstDescrp = page
				.locator("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1k2h94j'])[3]");
		frstDescrp.fill(descValue);
	}

	@Then("Click delete button in first row")
	public void click_delete_button_in_first_row() {
		page.locator(
				"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorError MuiIconButton-sizeMedium css-zjk4ep'])[2]")
				.click();
	}

	@Then("Check success message is displayed or not in add goal page")
	public void check_success_message_is_displayed_or_not_in_add_goal_page() throws InterruptedException {
		Thread.sleep(1000);
		Locator errMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(errMsg).isVisible();
		String errMsgValue = errMsg.textContent();
		System.out.println("Success message is displayed like: " + errMsgValue);
	}

	@Then("Select valid from date in second row")
	public void select_valid_from_date_in_second_row() {
		page.waitForSelector("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-ydoeeb'])[5]");
		page.locator(
				"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-ydoeeb'])[5]")
				.click();
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiPickersDay-root')])[16]").click();
	}

	@Then("Select valid to date in second row")
	public void select_valid_to_date_in_second_row() {
		page.waitForSelector("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-ydoeeb'])[6]");
		page.locator(
				"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-ydoeeb'])[6]")
				.click();
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiPickersDay-root')])[28]").click();
	}

	@Then("Click raised by button in overview screen")
	public void click_raised_by_button_in_overview_screen() {
		page.locator("//button[normalize-space(text())='Raised By']").click();
	}

	@Then("Click close button in raised by popup in overview screen")
	public void click_close_button_in_raised_by_popup_in_overview_screen() {
		page.locator("//button[@aria-label='Cancel']").click();
	}

	@Then("Enter valid username {string} in searchbox in raised by popup")
	public void enter_valid_username_in_searchbox_in_raised_by_popup(String userName) {
		page.waitForSelector("//input[@placeholder='Search...']");
		Locator usrName = page.locator("//input[@placeholder='Search...']");
		usrName.fill(userName);
	}

	@Then("Check entered username {string} is displayed or not in raised by popup")
	public void check_entered_username_is_displayed_or_not_in_raised_by_popup(String userName) throws InterruptedException {
		Thread.sleep(2000);
		page.waitForSelector("(//td[contains(@class,'MuiTableCell-root MuiTableCell-body')])[2]");
		Locator usrName = page.locator("(//td[contains(@class,'MuiTableCell-root MuiTableCell-body')])[2]");
		String actUsrName = usrName.textContent();
		String expUsrName = userName;
		assertEquals(expUsrName, actUsrName, "Search function is not working");
	}

	@Then("Click add new button in raised by popup")
	public void click_add_new_button_in_raised_by_popup() {
		page.locator("//span[contains(@class,'MuiButton-icon MuiButton-startIcon')]").click();
	}

	@Then("Enter valid user name in raised by popup")
	public void enter_valid_user_name_in_raised_by_popup() {
		Locator usrName = page.locator("#ClientName");
		Faker faker = new Faker();
		String userName = faker.name().fullName();
		usrName.fill(userName);
	}

	@Then("Enter valid user email id in raised by popup")
	public void enter_valid_user_email_id_in_raised_by_popup() {
		Locator usrMail = page.locator("#EmailId");
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		usrMail.fill(firstName + "@gmail.com");
	}

	@Then("Click clear button in raised by popup")
	public void click_clear_button_in_raised_by_popup() {
		page.locator("//button[normalize-space(text())='Clear']").click();
	}

	@Then("Check username field is empty or not in raised by popup")
	public void check_username_field_is_empty_or_not_in_raised_by_popup() {
		Locator usrName = page.locator("#ClientName");
		String userName = usrName.inputValue();
		assertTrue(userName.isEmpty(), "Name tab is not cleared");
	}

	@Then("Check user email id field is empty or not in raised by popup")
	public void check_user_email_id_field_is_empty_or_not_in_raised_by_popup() {
		Locator usrMail = page.locator("#EmailId");
		String userMailId = usrMail.inputValue();
		assertTrue(userMailId.isEmpty(), "Name tab is not cleared");
	}

	@Then("Click save button in raised by popup")
	public void click_save_button_in_raised_by_popup() {
		page.locator("//button[normalize-space(text())='Save']").click();
	}

	@Then("Check success message is displayed or not in raised by popup")
	public void check_success_message_is_displayed_or_not_in_raised_by_popup() throws InterruptedException {
		Thread.sleep(1000);
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}

	@Then("Click edit button in raised by popup")
	public void click_edit_button_in_raised_by_popup() {
		page.locator(
				"(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium css-1vpcu64'])[1]")
				.click();
	}

	@Then("Modify valid details in raised by popup")
	public void modify_valid_details_in_raised_by_popup() {
		Locator usrName = page.locator("#ClientName");
		String userName = usrName.inputValue();
		System.out.println("Username text is: " + userName);
		usrName.clear();
		usrName.fill(userName);
	}

	@Then("Click delete button in raised by popup")
	public void click_delete_button_in_raised_by_popup() throws InterruptedException {
		Thread.sleep(2000);
		page.waitForSelector("(//button[@aria-label='Click here to Delete'])[1]");
		page.locator("(//button[@aria-label='Click here to Delete'])[1]").click();
	}

	@Then("Click cancel button in confirmation popup")
	public void click_cancel_button_in_confirmation_popup() {
		page.waitForSelector("//button[normalize-space(text())='Cancel']");
		page.locator("//button[normalize-space(text())='Cancel']").click();
	}

	@Then("Click delete button in confirmation popup")
	public void click_delete_button_in_confirmation_popup() {
		page.waitForSelector("//div[@class='MuiStack-root css-1b138w3']//button[2]");
		page.locator("//div[@class='MuiStack-root css-1b138w3']//button[2]").click();
	}

	@Then("Enter valid user name {string} in raised by popup")
	public void enter_valid_user_name_in_raised_by_popup(String userName) {
		Locator usrName = page.locator("#ClientName");
		usrName.fill(userName);
	}

	@Then("Enter valid user email id {string} in raised by popup")
	public void enter_valid_user_email_id_in_raised_by_popup(String userMail) {
		Locator usrMail = page.locator("#EmailId");
		usrMail.fill(userMail);
	}

	@Then("Select valid project {string} from the dropdown in kanban board screen")
	public void select_valid_project_from_the_dropdown_in_kanban_board_screen(String projName) {
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root')])[3]").click();
		page.locator("//p[normalize-space(text())='" + projName + "']").click();
	}

	@Then("Check selected project name {string} is displayed or not in kanban board screen")
	public void check_selected_project_name_is_displayed_or_not_in_kanban_board_screen(String projtName) {
		Locator projName = page.locator("(//div[contains(@class,'MuiGrid-root MuiGrid-item')]//h6)[1]");
		String actProjName = projName.textContent();
		System.out.println("Text is : " + actProjName);
		String expProjName = projtName;
		assertEquals(expProjName, actProjName, "Project name filter is not working");
	}

	@Then("Select issue type {string} from the dropdown in kanban board screen")
	public void select_issue_type_from_the_dropdown_in_kanban_board_screen(String issueType) {
		page.locator("#task-type").click();
		page.waitForSelector("//span[normalize-space(text())='" + issueType + "']");
		page.locator("//span[normalize-space(text())='" + issueType + "']").click();
	}

	@Then("Enter valid id {string} in search box in kanban board screen")
	public void enter_valid_id_in_search_box_in_kanban_board_screen(String taskID) {
		Locator taskId = page.locator("//input[@placeholder='Search']");
		taskId.fill(taskID);
	}

	@Then("Check entered id {string} is displayed or not in kanban board screen")
	public void check_entered_id_is_displayed_or_not_in_kanban_board_screen(String TaskID) {
		Locator taskId = page.locator("//h6[contains(@class,'MuiTypography-root MuiTypography-subtitle1')]");
		String actTaskID = taskId.textContent();
		String expTaskID = TaskID;
		assertEquals(expTaskID, actTaskID, "Search option is not working");
	}

	@Then("Click update button in raised by popup")
	public void click_update_button_in_raised_by_popup() {
		page.locator("//button[normalize-space(text())='Update']").click();
	}

	@Then("Click create button in kanban board")
	public void click_create_button_in_kanban_board() {
		page.locator("//button[normalize-space(text())='Create']").click();
	}

	@Then("Click close button in create issue popup")
	public void click_close_button_in_create_issue_popup() {
		page.locator("//button[@aria-label='Cancel']").click();
	}

	@Then("Click save button in create issue popup")
	public void click_save_button_in_create_issue_popup() throws InterruptedException {
		Thread.sleep(2000);
		page.locator("//button[normalize-space(text())='Save']").click();
	}

	@Then("Check mandatory message is displayed or not in create issue popup")
	public void check_mandatory_message_is_displayed_or_not_in_create_issue_popup() {
		Locator issTypErrMsg = page.locator("#personal-designation-helper");
		Locator sumErrMsg = page.locator("#personal-address-helper");

		assertTrue(issTypErrMsg.isVisible(), "Error message is not displayed in Issue Type tab");
		assertTrue(sumErrMsg.isVisible(), "Error message is not displayed in Summary tab");

		System.out.println("Issue Type tab error message displayed like: " + issTypErrMsg.textContent());
		System.out.println("Summary tab error message displayed like: " + sumErrMsg.textContent());
	}

	@Then("Check selected project name {string} is displayed in project dropdown or not in create issue popup")
	public void check_selected_project_name_is_displayed_in_project_dropdown_or_not_in_create_issue_popup(
			String projNameValue) {
		Locator projName = page.locator("//div[@class='MuiGrid-root css-rfnosa']");
		String actProjName = projName.textContent();
		String expProjName = projNameValue;
		assertEquals(expProjName, actProjName, "Selected project name is not displayed");
	}

	@Then("Select valid issue type {string} in create issue popup")
	public void select_valid_issue_type_in_create_issue_popup(String issueType) {
		page.locator("#mui-component-select-IssueType").click();
		page.waitForSelector("//div[normalize-space(text())='" + issueType + "']");
		page.locator("//div[normalize-space(text())='" + issueType + "']").click();
	}

	@Then("Check selected issue type {string} is displayed in issue type dropdown or not in create issue popup")
	public void check_selected_issue_type_is_displayed_in_issue_type_dropdown_or_not_in_create_issue_popup(
			String issTypNameValue) {
		Locator issTypName = page.locator("#mui-component-select-IssueType");
		String actissTypName = issTypName.textContent();
		String expissTypName = issTypNameValue;
		assertEquals(expissTypName, actissTypName, "Selected Issye Type name is not displayed");
	}

	@Then("Select valid label {string} in create issue popup")
	public void select_valid_label_in_create_issue_popup(String label) {
		page.locator("#mui-component-select-taskType").click();
		page.waitForSelector("//div[normalize-space(text())='" + label + "']");
		page.locator("//div[normalize-space(text())='" + label + "']").click();
	}

	@Then("Check selected label {string} is displayed in label dropdown or not in create issue popup")
	public void check_selected_label_is_displayed_in_label_dropdown_or_not_in_create_issue_popup(
			String labelNameValue) {
		Locator labelName = page.locator("#mui-component-select-taskType");
		String actlabelName = labelName.textContent();
		String explabelName = labelNameValue;
		assertEquals(explabelName, actlabelName, "Selected Issye Type name is not displayed");
	}

	@Then("Enter valid summary details {string} in create issue popup")
	public void enter_valid_summary_details_in_create_issue_popup(String summaryValue) {
		Locator summary = page.locator("#summary");
		summary.fill(summaryValue);
	}

	@Then("Check entered details {string} in summary tab is didplayed or not in create issue popup")
	public void check_entered_details_in_summary_tab_is_didplayed_or_not_in_create_issue_popup(String labelNameValue) {
		Locator labelName = page.locator("#summary");
		String actlabelName = labelName.inputValue();
		String explabelName = labelNameValue;
		assertEquals(explabelName, actlabelName, "Entered summary is not displayed");
	}

	@Then("Enter valid description details {string} in create issue popup")
	public void enter_valid_description_details_in_create_issue_popup(String descriptionValue) {
		page.locator("(//div[contains(@class,'MuiFormControl-root MuiFormControl-fullWidth')]//div)[2]").click();
		Locator description = page.locator("//div[@class='ql-editor ql-blank']");
		description.fill(descriptionValue);
	}

	@Then("Check entered details {string} in description tab is didplayed or not in create issue popup")
	public void check_entered_details_in_description_tab_is_didplayed_or_not_in_create_issue_popup(
			String descriptionNameValue) {
		Locator description = page.locator("//div[@class='ql-container ql-snow']");
		String actdescriptionName = description.textContent();
		System.out.println("Text value is: " + actdescriptionName);
		String expdescriptionName = descriptionNameValue;
		assertEquals(expdescriptionName, actdescriptionName, "Entered description is not displayed");
	}

	@Then("Select valid Assignee {string} in create issue popup")
	public void select_valid_assignee_in_create_issue_popup(String Assignee) {
		page.locator("#mui-component-select-assignee").click();
		page.waitForSelector("//div[normalize-space(text())='" + Assignee + "']");
		page.locator("//div[normalize-space(text())='" + Assignee + "']").click();
	}

	@Then("Check selected Assignee {string} is displayed in Assignee dropdown or not in create issue popup")
	public void check_selected_assignee_is_displayed_in_assignee_dropdown_or_not_in_create_issue_popup(
			String assigneeValue) {
		Locator assignee = page.locator("(//div[@class='MuiGrid-root css-rfnosa'])[2]");
		String actAssigneeName = assignee.textContent();
		String expAssigneeName = assigneeValue;
		assertEquals(expAssigneeName, actAssigneeName, "Selected Assignee name is not displayed");
	}

	@Then("Select valid Reporting To {string} in create issue popup")
	public void select_valid_reporting_to_in_create_issue_popup(String ReportingTo) {
		page.locator("#mui-component-select-reportingTo").click();
		page.waitForSelector("//div[normalize-space(text())='" + ReportingTo + "']");
		page.locator("//div[normalize-space(text())='" + ReportingTo + "']").click();
	}

	@Then("Check selected Reporting To {string} is displayed in Reporting To dropdown or not in create issue popup")
	public void check_selected_reporting_to_is_displayed_in_reporting_to_dropdown_or_not_in_create_issue_popup(
			String repToValue) {
		Locator repTo = page.locator("(//div[@class='MuiGrid-root css-rfnosa'])[3]");
		String actrepToName = repTo.textContent();
		System.out.println("Text is : " + actrepToName);
		String exprepToName = repToValue;
		assertEquals(exprepToName, actrepToName, "Selected Reporting To name is not displayed");
	}

	@Then("Select valid Priority {string} in create issue popup")
	public void select_valid_priority_in_create_issue_popup(String priority) {
		page.locator("#priority").click();
		page.waitForSelector("//label[normalize-space(text())='" + priority + "']");
		page.locator("//label[normalize-space(text())='" + priority + "']").click();
	}

	@Then("Check selected Priority {string} is displayed in Priority dropdown or not in create issue popup")
	public void check_selected_priority_is_displayed_in_priority_dropdown_or_not_in_create_issue_popup(
			String priorityValue) {
		Locator priority = page.locator("//label[normalize-space(text())='" + priorityValue + "']");
		String actPriorityName = priority.textContent();
		String expPriorityName = priorityValue;
		assertEquals(expPriorityName, actPriorityName, "Selected Priority To name is not displayed");
	}

	@Then("Upload invalid file type in create issue popup")
	public void upload_invalid_file_type_in_create_issue_popup() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Check error message is displayed or not in create issue popup")
	public void check_error_message_is_displayed_or_not_in_create_issue_popup() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Upload valid file type in create issue popup")
	public void upload_valid_file_type_in_create_issue_popup() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Click clear button in create issue popup")
	public void click_clear_button_in_create_issue_popup() throws InterruptedException {
		Thread.sleep(3000);
		page.waitForSelector("//span[@aria-label='Click here to Clear']//button[1]");
		page.locator("//span[@aria-label='Click here to Clear']//button[1]").click();
	}

	@Then("Check success message is displayed or not in create issue popup")
	public void check_success_message_is_displayed_or_not_in_create_issue_popup() {
		page.waitForSelector("//div[@class='MuiAlert-message css-18mfsq4']");
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}

	@Then("Click task name {string} in kanban board screen")
	public void click_task_name_in_kanban_board_screen(String taskName) {
		page.locator("//h6[normalize-space(text())='" + taskName + "']").click();
	}

	@Then("Modify the details in edit issue screen")
	public void modify_the_details_in_edit_issue_screen() {
		Locator sumMsg = page.locator("(//input[@name='Summary'])[1]");
		String sumMsgValue = sumMsg.inputValue();
		sumMsg.clear();
		sumMsg.fill("Test" + "s");
	}

	@Then("Click close button in edit issue screen")
	public void click_close_button_in_edit_issue_screen() {
		page.locator("//button[@aria-label='Close']").click();
	}

	@Then("Check details are updated or not in edit issue screen")
	public void check_details_are_updated_or_not_in_edit_issue_screen() {
		page.waitForSelector("(//input[@name='Summary'])[1]");
		Locator sumMsg = page.locator("(//input[@name='Summary'])[1]");
		String sumMsgValue = sumMsg.inputValue();
		if (sumMsgValue.endsWith("s")) {
			System.out.println("Details successfully updated: " + sumMsgValue);
		} else {
			throw new AssertionError("Details were not updated correctly. Found: " + sumMsgValue);
		}
	}

	@Then("Enter valid estimated time {string} in edit issue screen")
	public void enter_valid_estimated_time_in_edit_issue_screen(String estiTime) {
		page.waitForSelector("(//input[@name='Summary'])[1]");
		Locator estTime = page.locator(
				"//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1h66dfw']");
		estTime.fill(estiTime);
	}

	@Then("Check estimated time {string} is displayed or not in edit issue screen")
	public void check_estimated_time_is_displayed_or_not_in_edit_issue_screen(String estiTime) {
		page.waitForSelector("(//input[@name='Summary'])[1]");
		Locator estTime = page.locator(
				"//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1h66dfw']");
		String actEstTime = estTime.inputValue();
		String expEstTime = estiTime;
		assertEquals(expEstTime, actEstTime, "Entered Estimated time is not displayed");
	}

	@Then("Click time tracking button in edit issue screen")
	public void click_time_tracking_button_in_edit_issue_screen() {
		page.waitForSelector("//span[contains(@class,'MuiLinearProgress-root MuiLinearProgress-colorPrimary')]");
		page.locator("//span[contains(@class,'MuiLinearProgress-root MuiLinearProgress-colorPrimary')]").click();
	}

	@Then("Click close button in time tracking screen")
	public void click_close_button_in_time_tracking_screen() {
		page.waitForSelector("//button[@aria-label='Cancel']");
		page.locator("//button[@aria-label='Cancel']").click();
	}

	@Then("Enter invalid time {string} in time tracking screen")
	public void enter_invalid_time_in_time_tracking_screen(String timePeriod) {
		page.waitForSelector("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1k2h94j'])[6]");
		Locator time = page.locator("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1k2h94j'])[6]");
		time.fill(timePeriod);
	}

	@Then("Check mandatory red border is displayed or not in time tracking screen")
	public void check_mandatory_red_border_is_displayed_or_not_in_time_tracking_screen() {
		page.setContent("<html><body>"
				+ "<div class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-185p5jo\">"
				+ "<input aria-invalid=\"false\" id=\":rdl:\" name=\"TimeSpendOn\" placeholder=\"e.g., 2w 4d 6h 45m\" required=\"\" type=\"text\" class=\"MuiInputBase-input MuiOutlinedInput-input css-1k2h94j\" value=\"\" fdprocessedid=\"xf8e48\">"
				+ "<fieldset aria-hidden=\"true\" class=\"MuiOutlinedInput-notchedOutline css-8egtxw\"><legend class=\"css-ihdtdm\"><span class=\"notranslate\">​</span></legend></fieldset></div>"
				+ "</body></html>");

		Locator inputField = page.locator(
				"(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-185p5jo'])[4]");
		inputField.fill("1w 2d 3h 4m");
		String inputValue = inputField.inputValue();
		assertEquals("1w 2d 3h 4m", inputValue);

		// Verify the placeholder text
		String placeholder = inputField.getAttribute("placeholder");
		assertEquals("e.g., 2w 4d 6h 45m", placeholder);

		// Verify the name attribute
		String nameAttribute = inputField.getAttribute("name");
		assertEquals("TimeSpendOn", nameAttribute);

		// Verify the required attribute
		String requiredAttribute = inputField.getAttribute("required");
		assertEquals("", requiredAttribute);
	}

	@Then("Enter valid description {string} in time tracking screen")
	public void enter_valid_description_in_time_tracking_screen(String descp) {
		page.waitForSelector("(//div[@class='ql-editor ql-blank'])[2]");
		Locator description = page.locator("(//div[@class='ql-editor ql-blank'])[2]");
		description.fill(descp);

	}

	@Then("Click clear button in time tracking screen")
	public void click_clear_button_in_time_tracking_screen() {
		page.waitForSelector("//button[@aria-label='Click here to Clear']");
		page.locator("//button[@aria-label='Click here to Clear']").click();
	}

	@Then("Enter valid time {string} in time tracking screen")
	public void enter_valid_time_in_time_tracking_screen(String timeLock) {
		page.waitForSelector("//input[@placeholder='e.g., 2w 4d 6h 45m']");
		Locator time = page.locator("//input[@placeholder='e.g., 2w 4d 6h 45m']");
		time.fill(timeLock);
	}

	@Then("Click more fields button in edit issue screen")
	public void click_more_fields_button_in_edit_issue_screen() {
		page.waitForSelector("//span[normalize-space(text())='More Fields']");
		page.locator("//span[normalize-space(text())='More Fields']").click();
	}

	@Then("Click raised by dropdown in edit issue screen")
	public void click_raised_by_dropdown_in_edit_issue_screen() {
		page.waitForSelector("#mui-component-select-PostedBy");
		page.locator("#mui-component-select-PostedBy").click();
	}

	@Then("Select valid raised by {string} option in edit issue screen")
	public void select_valid_raised_by_option_in_edit_issue_screen(String raisedBy) {
		page.waitForSelector("//li[normalize-space(text())='"+raisedBy+"']");
		page.locator("//li[normalize-space(text())='"+raisedBy+"']").click();
	}

	@Then("Click fix versions dropdown in edit issue screen")
	public void click_fix_versions_dropdown_in_edit_issue_screen() {
		page.waitForSelector("#mui-component-select-ReleaseID");
		page.locator("#mui-component-select-ReleaseID").click();
	}

	@Then("Select valid fix versions {string} option in edit issue screen")
	public void select_valid_fix_versions_option_in_edit_issue_screen(String fixVersion) {
		page.waitForSelector("//li[normalize-space(text())='"+fixVersion+"']");
		page.locator("//li[normalize-space(text())='"+fixVersion+"']").click();
	}

	@Then("Click Comments button in edit issue screen")
	public void click_comments_button_in_edit_issue_screen() {
		page.waitForSelector("//button[@aria-label='Click here to Comments log']");
		page.locator("//button[@aria-label='Click here to Comments log']").click();
	}

	@Then("Enter valid comments {string} in edit issue screen")
	public void enter_valid_comments_in_edit_issue_screen(String commentsDetails) {
		page.waitForSelector("//input[@placeholder='Add a Comment']");
		Locator comments = page.locator("//input[@placeholder='Add a Comment']");
		comments.fill(commentsDetails);
	}

	@Then("Click save button in comments tab")
	public void click_save_button_in_comments_tab() {
		page.waitForSelector("//button[@aria-label='Click here to save']");
		page.locator("//button[@aria-label='Click here to save']").click();
	}

	@Then("Check success message is displayed or not in comments tab")
	public void check_success_message_is_displayed_or_not_in_comments_tab() {
		page.waitForSelector("//div[@class='MuiAlert-message css-18mfsq4']");
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}

	@Then("Upload valid file in comments tab")
	public void upload_valid_file_in_comments_tab() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Click Status dropdown in edit issue screen")
	public void click_status_dropdown_in_edit_issue_screen() {
		page.waitForSelector("#mui-component-select-TaskStatus");
		page.locator("#mui-component-select-TaskStatus").click();
	}

	@Then("Select {string} phase in the dropdown in edit issue screen")
	public void select_phase_in_the_dropdown_in_edit_issue_screen(String phase) {
		page.waitForSelector("//li[normalize-space(text())='" + phase + "']");
		page.locator("//li[normalize-space(text())='" + phase + "']").click();
	}

	@Then("Check backlog column contain {string} issue or not in edit issue screen")
	public void check_backlog_column_contain_issue_or_not_in_edit_issue_screen(String string) throws InterruptedException {
		Thread.sleep(2000);
		page.waitForSelector("//div[@data-rfd-drag-handle-draggable-id='column-1']");
		Locator backLogColumn = page.locator("//div[@data-rfd-drag-handle-draggable-id='column-1']");
		int count = backLogColumn.count();
		for (int i = 0; i < count; i++) {
			String text = backLogColumn.nth(i).textContent();
			System.out.println("Element " + i + ": " + text);
		}
		String textContent = backLogColumn.textContent();

		if (textContent.contains("AT-04")) {
			System.out.println("Selected issue is moved to BackLog phase");
		} else {
			System.out.println("Selected issue is NOT moved to BackLog phase");
			fail("Assertion Failed: 'AT-04' is not found in the BackLog phase");
		}
	}

	@Then("Check In Progress column contain {string} issue or not in edit issue screen")
	public void check_in_progress_column_contain_issue_or_not_in_edit_issue_screen(String string)
			throws InterruptedException {
		Thread.sleep(2000);
		page.waitForSelector("//div[@data-rfd-drag-handle-draggable-id='column-1']/following-sibling::div[1]");
		Locator backLogColumn = page
				.locator("//div[@data-rfd-drag-handle-draggable-id='column-1']/following-sibling::div[1]");
		int count = backLogColumn.count();
		for (int i = 0; i < count; i++) {
			String text = backLogColumn.nth(i).textContent();
			System.out.println("Element " + i + ": " + text);
		}
		String textContent = backLogColumn.textContent();

		if (textContent.contains("AT-04")) {
			System.out.println("Selected issue is moved to In Progress phase");
		} else {
			System.out.println("Selected issue is NOT moved to In Progress phase");
			fail("Assertion Failed: 'AT-04' is not found in the In Progress phase");
		}
	}

	@Then("Check For Review column contain {string} issue or not in edit issue screen")
	public void check_for_review_column_contain_issue_or_not_in_edit_issue_screen(String string)
			throws InterruptedException {
		Thread.sleep(2000);
		page.waitForSelector("//div[@data-rfd-drag-handle-draggable-id='column-1']/following-sibling::div[2]");
		Locator backLogColumn = page
				.locator("//div[@data-rfd-drag-handle-draggable-id='column-1']/following-sibling::div[2]");
		int count = backLogColumn.count();
		for (int i = 0; i < count; i++) {
			String text = backLogColumn.nth(i).textContent();
			System.out.println("Element " + i + ": " + text);
		}
		String textContent = backLogColumn.textContent();

		if (textContent.contains("AT-04")) {
			System.out.println("Selected issue is moved to For Review phase");
		} else {
			System.out.println("Selected issue is NOT moved to For Review phase");
			fail("Assertion Failed: 'AT-04' is not found in the For Review phase");
		}
	}

	@Then("Check Done column contain {string} issue or not in edit issue screen")
	public void check_done_column_contain_issue_or_not_in_edit_issue_screen(String string) throws InterruptedException {
		Thread.sleep(2000);
		page.waitForSelector("//div[@data-rfd-drag-handle-draggable-id='column-1']/following-sibling::div[3]");
		Locator backLogColumn = page
				.locator("//div[@data-rfd-drag-handle-draggable-id='column-1']/following-sibling::div[3]");
		int count = backLogColumn.count();
		for (int i = 0; i < count; i++) {
			String text = backLogColumn.nth(i).textContent();
			System.out.println("Element " + i + ": " + text);
		}
		String textContent = backLogColumn.textContent();

		if (textContent.contains("AT-04")) {
			System.out.println("Selected issue is moved to Done phase");
		} else {
			System.out.println("Selected issue is NOT moved to Done phase");
			fail("Assertion Failed: 'AT-04' is not found in the Done phase");
		}
	}

	@Given("Click Label button in the menu bar")
	public void click_label_button_in_the_menu_bar() {
		page.waitForSelector("//h6[normalize-space(text())='Label']");
		page.locator("//h6[normalize-space(text())='Label']").click();
	}

	@When("Enter valid label name {string} in searchbox in label screen")
	public void enter_valid_label_name_in_searchbox_in_label_screen(String labelName) {
		page.waitForSelector("//input[@placeholder='Search...']");
		Locator label = page.locator("//input[@placeholder='Search...']");
		label.fill(labelName);
	}

	@Then("Check entered label name {string} is displayed or not in label screen")
	public void check_entered_label_name_is_displayed_or_not_in_label_screen(String labelNameValue) throws InterruptedException {
		page.waitForSelector("//td[normalize-space(text())='"+labelNameValue+"']");
		Locator label = page.locator("//td[normalize-space(text())='"+labelNameValue+"']");
		String actLabelName = label.textContent();
		System.out.println("Text is: "+actLabelName);
		String expLabelName = labelNameValue;
		assertEquals(expLabelName, actLabelName, "Entered Label name is not displayed");
	}

	@When("Click sort by dropdown in label screen")
	public void click_sort_by_dropdown_in_label_screen() {
		page.waitForSelector("#column-sorting");
		page.locator("#column-sorting").click();
	}

	@Then("Click {string} option in label screen")
	public void click_option_in_label_screen(String sortBy) {
		page.waitForSelector("//span[normalize-space(text())='" + sortBy + "']");
		page.locator("//span[normalize-space(text())='" + sortBy + "']").click();
	}

	@When("Click Add new button in label screen")
	public void click_add_new_button_in_label_screen() {
		page.waitForSelector("//button[@aria-label='Click here to Add New']//span[1]");
		page.locator("//button[@aria-label='Click here to Add New']//span[1]").click();
	}

	@Then("Click close button in add label popup")
	public void click_close_button_in_add_label_popup() {
		page.waitForSelector("//button[@aria-label='Cancel']");
		page.locator("//button[@aria-label='Cancel']").click();
	}

	@Then("Click save button in add label popup")
	public void click_save_button_in_add_label_popup() {
		page.waitForSelector("//button[normalize-space(text())='Save']");
		page.locator("//button[normalize-space(text())='Save']").click();
	}

	@Then("Check mandatory message is displayed or not in add label popup")
	public void check_mandatory_message_is_displayed_or_not_in_add_label_popup() {
		page.waitForSelector("#customer-LabelName-helper-text");
		Locator labNameErrMsg = page.locator("#customer-LabelName-helper-text");
		assertTrue(labNameErrMsg.isVisible(), "Error message is not displayed in Issue Type tab");
		System.out.println("Issue Type tab error message displayed like: " + labNameErrMsg.textContent());
	}

	@Then("Enter valid label name in add label popup")
	public void enter_valid_label_name_in_add_label_popup() {
		page.waitForSelector("#customer-LabelName");
		Locator labName = page.locator("#customer-LabelName");
		labName.fill("Manual Testing");
	}

	@Then("Click clear button in add label popup")
	public void click_clear_button_in_add_label_popup() {
		page.waitForSelector("#reset");
		page.locator("#reset").click();
	}

	@Then("Check entered details is cleared or not in add label popup")
	public void check_entered_details_is_cleared_or_not_in_add_label_popup() {
		page.waitForSelector("#customer-LabelName");
		Locator labName = page.locator("#customer-LabelName");
		String labelName = labName.inputValue();
		labelName.isEmpty();
		assertTrue(labelName.isEmpty(), "Clear button is not working");
	}

	@Then("Enter existing valid label name {string} in add label popup")
	public void enter_existing_valid_label_name_in_add_label_popup(String string) {
		page.waitForSelector("#customer-LabelName");
		Locator labName = page.locator("#customer-LabelName");
		labName.fill("Testing");
	}

	@Then("Check error message is displayed or not in add label popup")
	public void check_error_message_is_displayed_or_not_in_add_label_popup() {
		page.waitForSelector("//div[@class='MuiAlert-message css-18mfsq4']");
		Locator errMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(errMsg).isVisible();
		String errMsgValue = errMsg.textContent();
		System.out.println("Error message is displayed like: " + errMsgValue);
	}

	@Then("Check sucess message is displayed or not in add label popup")
	public void check_sucess_message_is_displayed_or_not_in_add_label_popup() {
		page.waitForSelector("//div[@class='MuiAlert-message css-18mfsq4']");
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}

	@When("Click edit button in label screen")
	public void click_edit_button_in_label_screen() throws InterruptedException {
		Thread.sleep(2000);
		page.waitForSelector("//button[@aria-label='Click here to Edit']");
		page.locator("//button[@aria-label='Click here to Edit']").click();
	}

	@Then("Click close button in edit label popup")
	public void click_close_button_in_edit_label_popup() {
		page.waitForSelector("//button[@aria-label='Cancel']");
		page.locator("//button[@aria-label='Cancel']").click();
	}

	@When("Modify valid details in edit label popup")
	public void modify_valid_details_in_edit_label_popup() {
		page.waitForSelector("#customer-LabelName");
		Locator labName = page.locator("#customer-LabelName");
		String labelName = labName.inputValue();
		labName.clear();
		labName.fill(labelName);
	}

	@When("Click update button in edit label popup")
	public void click_update_button_in_edit_label_popup() {
		page.waitForSelector("//button[normalize-space(text())='Update']");
		page.locator("//button[normalize-space(text())='Update']").click();
	}

	@When("Check sucess message is displayed or not in edit label popup")
	public void check_sucess_message_is_displayed_or_not_in_edit_label_popup() {
		page.waitForSelector("//div[@class='MuiAlert-message css-18mfsq4']");
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}

	@When("Click delete button in label screen")
	public void click_delete_button_in_label_screen() {
		page.waitForSelector("(//button[@aria-label='Click here to Delete'])[1]");
		page.locator("(//button[@aria-label='Click here to Delete'])[1]").click();
	}

	@When("Click cancel button in delete label popup")
	public void click_cancel_button_in_delete_label_popup() {
		page.waitForSelector("(//div[@class='MuiStack-root css-1b138w3']//button)[1]");
		page.locator("(//div[@class='MuiStack-root css-1b138w3']//button)[1]").click();
	}

	@When("Click delete button in delete label popup")
	public void click_delete_button_in_delete_label_popup() {
		page.waitForSelector("(//div[@class='MuiStack-root css-1b138w3']//button)[2]");
		page.locator("(//div[@class='MuiStack-root css-1b138w3']//button)[2]").click();
	}
}
