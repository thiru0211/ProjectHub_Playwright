package stepDefinition;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Dimension;
import java.awt.Toolkit;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PH_2_Admin {
	public Page page;
	public Browser browser;
	public Playwright playwright;

	@Given("To Check Admin user is navigating to ProjectHub URL is {string}")
	public void to_check_admin_user_is_navigating_to_project_hub_url_is(String url) {

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

	@When("To Check Admin Enter username and password are {string} and {string}")
	public void to_check_admin_enter_username_and_password_are_and(String email, String passWord) {
		String title = page.url();
		System.out.println("Current page title is: " + title);
		Locator emailId = page.getByPlaceholder("Enter Email Address");
		emailId.fill(email);
		Locator password = page.getByPlaceholder("Enter Password");
		password.fill(passWord);
	}

	@When("Click the Login button To Check Admin")
	public void click_the_login_button_to_check_admin() {
		Locator loginBtn = page.locator("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
		loginBtn.click();
	}

	@Then("Close Admin page")
	public void close_admin_page() 
			throws InterruptedException 
	{
		Thread.sleep(10000);
		page.close();
		browser.close();
		playwright.close();
	}

	@Then("Click Admin button in the menu bar")
	public void click_admin_button_in_the_menu_bar() {
		page.locator("//h6[normalize-space(text())='Admin']").click();
	}

	@Given("Click Users button in the menu bar")
	public void click_users_button_in_the_menu_bar() {
		page.locator("//h6[normalize-space(text())='Users']").click();
	}

	@When("Enter valid username {string} in the searchbox in user screen")
	public void enter_valid_username_in_the_searchbox_in_user_screen(String username) {
		Locator userName = page.getByPlaceholder("Search Name , Designation & Email Id");
		userName.type(username);
	}

	@When("Check entered username {string} is displayed or not in user screen")
	public void check_entered_username_is_displayed_or_not_in_user_screen(String username) throws InterruptedException {
		Thread.sleep(3000);
		Locator userName = page.locator("//h6[contains(@class,'MuiTypography-root MuiTypography-subtitle1')]");
		String actUserName = userName.textContent();
		String expUserName = username;
		assertEquals(expUserName, actUserName, "Searchbox is not working");
	}

	@Then("Enter valid email id {string} in the searchbox in user screen")
	public void enter_valid_email_id_in_the_searchbox_in_user_screen(String emailId) {
		Locator userName = page.getByPlaceholder("Search Name , Designation & Email Id");
		userName.clear();
		userName.type(emailId);
	}

	@Then("Check entered email id {string} is displayed or not in user screen")
	public void check_entered_email_id_is_displayed_or_not_in_user_screen(String emailID) {
		Locator userName = page.locator("(//p[contains(@class,'MuiTypography-root MuiTypography-body1')])[3]");
		String actUserName = userName.textContent();
		String expUserName = emailID;
		assertEquals(expUserName, actUserName, "Searchbox is not working");
	}

	@Then("Enter valid designation {string} in the searchbox in user screen")
	public void enter_valid_designation_in_the_searchbox_in_user_screen(String designation) {
		Locator userName = page.getByPlaceholder("Search Name , Designation & Email Id");
		userName.clear();
		userName.type(designation);
	}

	@Then("Check entered designation {string} is displayed or not in user screen")
	public void check_entered_designation_is_displayed_or_not_in_user_screen(String designation) {
		Locator userName = page.locator("(//td[contains(@class,'MuiTableCell-root MuiTableCell-body')])[3]");
		String actUserName = userName.textContent();
		String expUserName = designation;
		assertEquals(expUserName, actUserName, "Searchbox is not working");
	}

	@When("Select {string} 1st option in the filter dropdown")
	public void select_1st_option_in_the_filter_dropdown(String string) {
		Locator statusBox = page.locator("#status");
		statusBox.click();
		Locator allOptn = page.locator("(//li[@role='option'])[1]");
		allOptn.click();
	}

	@When("Select {string} 2nd option in the filter dropdown")
	public void select_2nd_option_in_the_filter_dropdown(String string) {
		Locator statusBox = page.locator("#status");
		statusBox.click();
		Locator allOptn = page.locator("(//li[@role='option'])[2]");
		allOptn.click();
	}

	@Then("Check {string} 2nd option is displayed or not in user screen")
	public void check_2nd_option_is_displayed_or_not_in_user_screen(String status) {
		Locator statusBox = page.locator("(//span[contains(@class,'MuiChip-label MuiChip-labelSmall')])[1]");
		String actStatus = statusBox.textContent();
		String expStatus = status;
		assertEquals(expStatus, actStatus, "Status filter is not working");
	}

	@Then("Select {string} 3rd option in the filter dropdown")
	public void select_3rd_option_in_the_filter_dropdown(String string) {
		Locator statusBox = page.locator("#status");
		statusBox.click();
		Locator allOptn = page.locator("(//li[@role='option'])[3]");
		allOptn.click();
	}

	@Then("Check {string} 3rd option is displayed or not in user screen")
	public void check_3rd_option_is_displayed_or_not_in_user_screen(String status) {
		Locator statusBox = page.locator("(//span[contains(@class,'MuiChip-label MuiChip-labelSmall')])[1]");
		String actStatus = statusBox.textContent();
		String expStatus = status;
		assertEquals(expStatus, actStatus, "Status filter is not working");
	}

	@When("Click Add New button in user screen")
	public void click_add_new_button_in_user_screen() {
		Locator addBtn = page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[1]");
		addBtn.click();
	}

	@When("Click Back button in add user screen")
	public void click_back_button_in_add_user_screen() {
		Locator backBtn = page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[1]");
		backBtn.click();
	}

	@Then("Check page navigates to previous page or not in user screen")
	public void check_page_navigates_to_previous_page_or_not_in_user_screen() {
		Locator addBtn = page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[1]");
		assertThat(addBtn).isVisible();
	}

	@When("Click save button in add user screen")
	public void click_save_button_in_add_user_screen() {
		Locator saveBtn = page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[3]");
		saveBtn.click();
	}

	@Then("Check mandatory message is displayed in mandatory tabs or not user screen")
	public void check_mandatory_message_is_displayed_in_mandatory_tabs_or_not_user_screen() {
		Locator frstNameErrMsg = page.locator("#personal-first-name-helper");
		boolean frstnameCheck = frstNameErrMsg.isVisible();
		assertFalse(frstnameCheck, "Error message should be cleared");
		Locator lastNameErrMsg = page.locator("#personal-last-name-helper");
		boolean lastnameCheck = lastNameErrMsg.isVisible();
		assertFalse(lastnameCheck, "Error message should be cleared");
		Locator emailAddErrMsg = page.locator("#personal-email-helper");
		boolean emailnameCheck = emailAddErrMsg.isVisible();
		assertFalse(emailnameCheck, "Error message should be cleared");
		Locator phNumErrMsg = page.locator("#personal-contact-helper");
		boolean phNumCheck = phNumErrMsg.isVisible();
		assertFalse(phNumCheck, "Error message should be cleared");
		Locator desgErrMsg = page.locator("#personal-designation-helper");
		boolean desgCheck = desgErrMsg.isVisible();
		assertFalse(desgCheck, "Error message should be cleared");
		Locator timeZoneErrMsg = page.locator("#timezone-helper-text");
		boolean timeZoneCheck = timeZoneErrMsg.isVisible();
		assertFalse(timeZoneCheck, "Error message should be cleared");
	}

	@Then("Check mandatory red border is displayed in mandatory tabs or not user screen")
	public void check_mandatory_red_border_is_displayed_in_mandatory_tabs_or_not_user_screen() {
		Locator frstName = page.locator("#firstname");
		String color = frstName.evaluate(
				"ele => {" + "   return window.getComputedStyle(ele).getPropertyValue('background-color');" + "}")
				.toString();

		System.out.println(color);
	}

	@Then("Click clear button in add user screen")
	public void click_clear_button_in_add_user_screen() {
		Locator clrBtn = page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]");
		clrBtn.click();
	}

	@When("Enter special characters {string} in first name field in add user screen")
	public void enter_special_characters_in_first_name_field_in_add_user_screen(String frstname) {
		Locator frstName = page.locator("#firstname");
		frstName.fill(frstname);
	}

	@Then("Check first name tab is empty or not in add user screen")
	public void check_first_name_tab_is_empty_or_not_in_add_user_screen() {
		Locator frstName = page.locator("#firstname");
		String frstnameTab = frstName.inputValue();
		assertTrue(frstnameTab.isEmpty());
	}

	@When("Enter numerical characters {string} in first name field in add user screen")
	public void enter_numerical_characters_in_first_name_field_in_add_user_screen(String frstname) {
		Locator frstName = page.locator("#firstname");
		frstName.fill(frstname);
	}

	@When("Enter alpha characters {string} in first name field in add user screen")
	public void enter_alpha_characters_in_first_name_field_in_add_user_screen(String frstname) {
		Locator frstName = page.locator("#firstname");
		frstName.fill(frstname);
	}

	@Then("Check entered characters {string} in first name tab is displayed or not in add user screen")
	public void check_entered_characters_in_first_name_tab_is_displayed_or_not_in_add_user_screen(String frstname) {
		Locator frstName = page.locator("#firstname");
		String actfrstname = frstName.inputValue();
		String expfrstname = frstname;
		assertEquals(expfrstname, actfrstname, "Alpha characters is not enter in First name tab");
	}

	@When("Enter special characters {string} in last name field in add user screen")
	public void enter_special_characters_in_last_name_field_in_add_user_screen(String lastname) {
		Locator frstName = page.locator("#lastname");
		frstName.fill(lastname);
	}

	@Then("Check last name tab is empty or not in add user screen")
	public void check_last_name_tab_is_empty_or_not_in_add_user_screen() {
		Locator lastName = page.locator("#lastname");
		String lastnameTab = lastName.inputValue();
		assertTrue(lastnameTab.isEmpty());
	}

	@When("Enter numerical characters {string} in last name field in add user screen")
	public void enter_numerical_characters_in_last_name_field_in_add_user_screen(String lastname) {
		Locator lastName = page.locator("#lastname");
		lastName.fill(lastname);
	}

	@When("Enter alpha characters {string} in last name field in add user screen")
	public void enter_alpha_characters_in_last_name_field_in_add_user_screen(String lastname) {
		Locator lastName = page.locator("#lastname");
		lastName.fill(lastname);
	}

	@Then("Check entered characters {string} in last name tab is displayed or not in add user screen")
	public void check_entered_characters_in_last_name_tab_is_displayed_or_not_in_add_user_screen(String lastname) {
		Locator lastName = page.locator("#lastname");
		String actlastname = lastName.inputValue();
		String explastname = lastname;
		assertEquals(explastname, actlastname, "Alpha characters is not enter in First name tab");
	}

	@When("Enter email address {string} in email address field in add user screen")
	public void enter_email_address_in_email_address_field_in_add_user_screen(String emailAddress) {
		Locator emailAdd = page.locator("#lastname");
		emailAdd.fill(emailAddress);
	}

	@Then("Check error message is displayed or not in email address tab in add user screen")
	public void check_error_message_is_displayed_or_not_in_email_address_tab_in_add_user_screen() {
		Locator emailAddErrMsg = page.locator("#personal-email-helper");
		System.out.println("Emaild Address error message is displayed like: " + emailAddErrMsg.textContent());
	}

	@When("Enter special characters {string} in Phone Number field in add user screen")
	public void enter_special_characters_in_phone_number_field_in_add_user_screen(String phonenumber) {
		Locator phoneNumber = page.locator("#contact");
		phoneNumber.fill(phonenumber);
	}

	@Then("Check Phone Number tab is empty or not in add user screen")
	public void check_phone_number_tab_is_empty_or_not_in_add_user_screen() {
		Locator phoneNumber = page.locator("#contact");
		String phoneNumberTab = phoneNumber.inputValue();
		assertTrue(phoneNumberTab.isEmpty());
	}

	@When("Enter alpha characters {string} in Phone Number field in add user screen")
	public void enter_alpha_characters_in_phone_number_field_in_add_user_screen(String phonenumber) {
		Locator phoneNumber = page.locator("#contact");
		phoneNumber.fill(phonenumber);
	}

	@Then("Check entered characters {string} in Phone Number tab is displayed or not in add user screen")
	public void check_entered_characters_in_phone_number_tab_is_displayed_or_not_in_add_user_screen(String string) {
		Locator phoneNumber = page.locator("#contact");
		String phoneNumberTab = phoneNumber.inputValue();
		assertFalse(phoneNumberTab.isEmpty());
	}

	@Then("Select valid project name {string} in add user screen")
	public void select_valid_project_name_in_add_user_screen(String projName) {
		Locator projMap = page.getByPlaceholder("Add Project");
		projMap.click();
		 page.click("text="+projName);
	}

	@Then("Check select name {string} is displayed or not in add user screen")
	public void check_select_name_is_displayed_or_not_in_add_user_screen(String projName) {
		Locator projMapName = page.locator("//span[contains(@class,'MuiChip-label MuiChip-labelMedium')]");
		String actProjName = projMapName.inputValue();
		String expProjName = projName;
		assertEquals(expProjName, actProjName, "Project Mapping is not working");
	}

	@When("Enter valid details in first name tab in add user screen")
	public void enter_valid_details_in_first_name_tab_in_add_user_screen() {
		Locator projMap = page.locator("#firstname");
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		projMap.fill(firstName);
	}

	@Then("Enter valid details in last name tab in add user screen")
	public void enter_valid_details_in_last_name_tab_in_add_user_screen() {
		Locator projMap = page.locator("#lastname");
		Faker faker = new Faker();
		String lastName = faker.name().lastName();
		projMap.fill(lastName);
	}

	@Then("Enter valid email id in add user screen")
	public void enter_valid_email_id_in_add_user_screen() {
		Locator projMap = page.locator("#email");
		Faker faker = new Faker();
		String emailID = faker.name().username() + "@gmail.com";
		projMap.fill(emailID);
	}

	@Then("Enter valid phone number in add user screen")
	public void enter_valid_phone_number_in_add_user_screen() {
		Locator phNum = page.locator("#contact");
		phNum.fill("1234567890");
	}

	@Then("Select valid report to option in add user screen")
	public void select_valid_report_to_option_in_add_user_screen() {
		Locator reportTo = page.locator("#mui-component-select-reportTo");
		reportTo.click();
		Locator reportToOptn = page.locator("//li[normalize-space(text())='Thirumaran R']");
		reportToOptn.click();
	}

	@Then("Select valid designation in add user screen")
	public void select_valid_designation_in_add_user_screen() {
		Locator designation = page.locator("#personal-designation");
		designation.click();
		Locator designationOptn = page.locator("//li[normalize-space(text())='Testing Engineer']");
		designationOptn.click();
	}

	@Then("Select valid timezone in add user screen")
	public void select_valid_timezone_in_add_user_screen() {
		Locator timeZone = page.locator("#timezone");
		timeZone.click();
		Locator timeZoneOptn = page.locator("//li[normalize-space(text())='Asia/Kolkata']");
		timeZoneOptn.click();
	}

	@Then("Click Yes radio button in 2FA in add user screen")
	public void click_yes_radio_button_in_2fa_in_add_user_screen() {
		Locator yesBtn = page.locator("(//input[@type='radio'])[1]");
		yesBtn.click();
	}

	@Then("Click Email radio button in send 2FA in add user screen")
	public void click_email_radio_button_in_send_2fa_in_add_user_screen() {
		Locator emailBtn = page.locator("(//input[@name='TFAOption'])[1]");
		emailBtn.click();
	}

	@Then("Click clear button in user screen")
	public void click_clear_button_in_user_screen() {
		Locator clrBtn = page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]");
		clrBtn.click();
	}

	@Then("Click SMS radio button in send 2FA in add user screen")
	public void click_sms_radio_button_in_send_2fa_in_add_user_screen() {
		Locator smsBtn = page.locator("(//input[@name='TFAOption'])[2]");
		smsBtn.click();
	}

	@Then("Click No radio button in 2FA in add user screen")
	public void click_no_radio_button_in_2fa_in_add_user_screen() {
		Locator noBtn = page.locator("(//input[@type='radio'])[2]");
		noBtn.click();
	}

	@Then("Check success message is displayed or not in add user screen")
	public void check_success_message_is_displayed_or_not_in_add_user_screen() throws InterruptedException {
		Thread.sleep(3000);
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}

	@When("Click edit button in user screen")
	public void click_edit_button_in_user_screen() throws InterruptedException {
		Thread.sleep(5000);
		Locator editBtn = page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]");
		editBtn.click();
	}

	@Then("Modify valid details in edit user screen")
	public void modify_valid_details_in_edit_user_screen() {
		Locator frstNameTab = page.locator("#firstname");
		String frstNameTabValue = frstNameTab.inputValue();
		frstNameTab.clear();
		frstNameTab.fill(frstNameTabValue);
	}

	@Then("Click update button in edit user screen")
	public void click_update_button_in_edit_user_screen() {
		Locator updBtn = page.locator("//button[normalize-space(text())='Update']");
		updBtn.scrollIntoViewIfNeeded();
		updBtn.click();
	}

	@Then("Check success message is displayed or not in edit user screen")
	public void check_success_message_is_displayed_or_not_in_edit_user_screen() throws InterruptedException {
		Thread.sleep(3000);
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}
	@Given("Click Team button in the menu bar")
	public void click_team_button_in_the_menu_bar() {
		page.locator("//h6[normalize-space(text())='Team']").click();
	}
	@When("Click create team button in Team")
	public void click_create_team_button_in_team() {
		page.locator("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[1]").click();
	}
	@Then("Click close button in Create Team")
	public void click_close_button_in_create_team() {
		page.locator("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorError MuiIconButton-sizeMedium css-zjk4ep']").click();
	}
	@Then("Click save button in Create Team")
	public void click_save_button_in_create_team() {
		page.locator("//button[@aria-label='Click here to Save']").click();
	}
	@Then("Check mandatory message is displayed or not in Create Team")
	public void check_mandatory_message_is_displayed_or_not_in_create_team() {
		Locator teamNameMsg = page.locator("#customer-TeamName-helper-text");
		boolean teamNameCheck = teamNameMsg.isVisible();
		assertTrue(teamNameCheck, "Error message is not displayed");
		
		Locator selUsersErrMsg = page.locator("#team-helper-text");
		boolean selUsersCheck = selUsersErrMsg.isVisible();
		assertTrue(selUsersCheck, "Error message is not displayed");
	}
	@Then("Enter valid team name {string} in Create Team")
	public void enter_valid_team_name_in_create_team(String teamName) {
		page.locator("#customer-TeamName").fill(teamName);
	}
	@Then("Select valid users {string} in Create Team")
	public void select_valid_users_in_create_team(String teamName) throws InterruptedException {
		page.locator("#team").click();
		page.click("text=" + teamName);
	}
	@Then("Select valid status {string} in Create Team")
	public void select_valid_status_in_create_team(String status) {
		page.locator("#customer-status").click();
		page.click("text=" + status);
	}
	@Then("Click clear button in Create Team")
	public void click_clear_button_in_create_team() {
		page.locator("#reset").click();
	}
	@Then("Check details cleared or not in Create Team")
	public void check_details_cleared_or_not_in_create_team() {
		String teamNameValue = page.locator("#customer-TeamName").inputValue();
		String userValue = page.locator("#team").inputValue();
		assertTrue(teamNameValue.isEmpty());
		assertTrue(userValue.isEmpty());
	}
	@Then("Check success message is displayed or not in Create Team")
	public void check_success_message_is_displayed_or_not_in_create_team() throws InterruptedException {
		Thread.sleep(1000);
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}
	@Given("Click edit button in Team")
	public void click_edit_button_in_team() throws InterruptedException {
		Thread.sleep(3000);
		page.locator("(//button[@aria-label='Click here to Edit'])[8]").click();
	}
	@When("Click clear button in edit Team")
	public void click_clear_button_in_edit_team() {
		page.locator("#reset").click();
	}
	@When("Check details are cleared or not in edit Team")
	public void check_details_are_cleared_or_not_in_edit_team() {
		String teamNameValue = page.locator("#customer-TeamName").inputValue();
		String userValue = page.locator("#team").inputValue();
		assertTrue(teamNameValue.isEmpty());
		assertTrue(userValue.isEmpty());
	}
	@When("Modify valid details in edit Team")
	public void modify_valid_details_in_edit_team() {
		Locator teamName = page.locator("#customer-TeamName");
		String teamNameValue = teamName.textContent();
		teamName.clear();
		teamName.fill(teamNameValue);
	}
	@When("Click update button in edit Team")
	public void click_update_button_in_edit_team() {
		page.locator("//button[@aria-label='Click here to Update']").click();
	}
	@Given("Click delete button in Team")
	public void click_delete_button_in_team() {
		page.locator("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-y4lmc4'])[8]").click();
	}
	@When("Click cancel button in Team")
	public void click_cancel_button_in_team() {
		page.locator("//button[@aria-label='Click here to cancel']").click();
	}
	@When("Click delete button in delete popup in Team")
	public void click_delete_button_in_delete_popup_in_team() {
		page.locator("//button[normalize-space(text())='Delete']").click();
	}
	@When("Check success message is displayed or not in Team")
	public void check_success_message_is_displayed_or_not_in_team() throws InterruptedException {
		Thread.sleep(1000);
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}
	@Given("Click Screen Rights button in the menu bar")
	public void click_screen_rights_button_in_the_menu_bar() {
		page.locator("//h6[normalize-space(text())='Screen Rights']").click();
	}
	@When("Unselect the all checkbox in screen rights page")
	public void unselect_the_all_checkbox_in_screen_rights_page() {
		page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[101]").click();
		page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[101]").click();
	}
	@When("Click save button in screen rights page")
	public void click_save_button_in_screen_rights_page() {
		page.locator("(//button[normalize-space(text())='Save'])[6]").click();
	}
	@Then("Check the alert message in screen rights page")
	public void check_the_alert_message_in_screen_rights_page() throws InterruptedException {
		Thread.sleep(1000);
		Locator alrtMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(alrtMsg).isVisible();
		String alrtMsgValue = alrtMsg.textContent();
		System.out.println("Success message is displayed like: " + alrtMsgValue);
	}
	@When("Click one checkbox in screen rights page")
	public void click_one_checkbox_in_screen_rights_page() {
		page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[102]").click();
	}
	@Then("Check the success message in screen rights page")
	public void check_the_success_message_in_screen_rights_page() throws InterruptedException {
		Thread.sleep(1000);
		Locator succMsg = page.locator("//div[@class='MuiAlert-message css-18mfsq4']");
		assertThat(succMsg).isVisible();
		String succMsgValue = succMsg.textContent();
		System.out.println("Success message is displayed like: " + succMsgValue);
	}
	@When("Select all checkbox in screen rights page")
	public void select_all_checkbox_in_screen_rights_page() {
		page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[101]").click();
	}
	@Then("Check all checkbox is selected or not in screen rights page")
	public void check_all_checkbox_is_selected_or_not_in_screen_rights_page() {
		Locator chckBox1 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[102]");
		Assertions.assertTrue(chckBox1.isChecked(), "Checkbox is not selected");
//		Locator chckBox2 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[103]");
//		Assertions.assertTrue(chckBox2.isChecked(), "Checkbox is not selected");
//		Locator chckBox3 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[104]");
//		Assertions.assertTrue(chckBox3.isChecked(), "Checkbox is not selected");
//		Locator chckBox4 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[105]");
//		Assertions.assertTrue(chckBox4.isChecked(), "Checkbox is not selected");
//		Locator chckBox5 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[106]");
//		Assertions.assertTrue(chckBox5.isChecked(), "Checkbox is not selected");
//		Locator chckBox6 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[107]");
//		Assertions.assertTrue(chckBox6.isChecked(), "Checkbox is not selected");
//		Locator chckBox7 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[108]");
//		Assertions.assertTrue(chckBox7.isChecked(), "Checkbox is not selected");
//		Locator chckBox8 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[109]");
//		Assertions.assertTrue(chckBox8.isChecked(), "Checkbox is not selected");
//		Locator chckBox9 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[110]");
//		Assertions.assertTrue(chckBox9.isChecked(), "Checkbox is not selected");
//		Locator chckBox10 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[111]");
//		Assertions.assertTrue(chckBox10.isChecked(), "Checkbox is not selected");
//		Locator chckBox11 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[112]");
//		Assertions.assertTrue(chckBox11.isChecked(), "Checkbox is not selected");
//		Locator chckBox12 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[113]");
//		Assertions.assertTrue(chckBox12.isChecked(), "Checkbox is not selected");
//		Locator chckBox13 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[114]");
//		Assertions.assertTrue(chckBox13.isChecked(), "Checkbox is not selected");
//		Locator chckBox14 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[115]");
//		Assertions.assertTrue(chckBox14.isChecked(), "Checkbox is not selected");
//		Locator chckBox15 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[116]");
//		Assertions.assertTrue(chckBox15.isChecked(), "Checkbox is not selected");
//		Locator chckBox16 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[117]");
//		Assertions.assertTrue(chckBox16.isChecked(), "Checkbox is not selected");
//		Locator chckBox17 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[118]");
//		Assertions.assertTrue(chckBox17.isChecked(), "Checkbox is not selected");
//		Locator chckBox18 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[119]");
//		Assertions.assertTrue(chckBox18.isChecked(), "Checkbox is not selected");
//		Locator chckBox19 = page.locator("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[120]");
//		Assertions.assertTrue(chckBox19.isChecked(), "Checkbox is not selected");
	}
	
	
	
	
	
	
	
	
	
}
