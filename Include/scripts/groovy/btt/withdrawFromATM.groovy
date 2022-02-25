package btt
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class withdrawFromATM {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	def dispense

	@Given("the account (.*) balance is (.*)")
	public void the_account_balance_is(String accountNumber, String initBalance) {
		// Write code here that turns the phrase above into concrete actions
		println accountNumber + " " + initBalance
		WS.callTestCase(findTestCase("Test Cases/btt/verify getAccountBalance"),["accountNumber":accountNumber, "balance":initBalance], FailureHandling.OPTIONAL)
	}

	@Given("the card (.*) is valid")
	public void the_card_is_valid(String accountNumber) {
		// Write code here that turns the phrase above into concrete actions
		println accountNumber
		WS.callTestCase(findTestCase("Test Cases/btt/verify isCardValid"),["accountNumber":accountNumber, "cardValid":"true"], FailureHandling.OPTIONAL)

	}

	@Given("the ATM (.*) contains enough money")
	public void the_ATM_atm_contains_enough_money(String atmNumber) {
		println "cek nihhh " + atmNumber
		// Write code here that turns the phrase above into concrete actions
		WS.callTestCase(findTestCase("Test Cases/btt/verify getATMBalance"),["atmNumber":atmNumber, "balance":0], FailureHandling.OPTIONAL)

	}

	@When("the Account Holder (.*) (.*) requests (.*)")
	public void the_Account_Holder_atm_requests(String accountNumber, String atmNumber, String amount) {
		// Write code here that turns the phrase above into concrete actions
		WS.callTestCase(findTestCase("Test Cases/btt/verify withdrawATM"),["accountNumber":accountNumber,"atmNumber":atmNumber, "amount":amount], FailureHandling.OPTIONAL)
	}

	@Then("the ATM should dispense {int}")
	public void the_ATM_should_dispense(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		println int1
	}

	@Then("the account (.*) balance should be (.*)")
	public void the_account_balance_should_be(String accountNumber, String balance) {
		// Write code here that turns the phrase above into concrete actions
		WS.callTestCase(findTestCase("Test Cases/btt/verify getAccountBalance"),["accountNumber":accountNumber, "balance":balance], FailureHandling.OPTIONAL)

	}

	@Then("the card (.*) should be returned (.*)")
	public void the_card_should_be_returned_true(String accountNumber, String cardValid) {
		// Write code here that turns the phrase above into concrete actions
		println true
		WS.callTestCase(findTestCase("Test Cases/btt/verify isCardReturn"),["accountNumber":accountNumber,"cardReturn":"true"], FailureHandling.OPTIONAL)

	}
}