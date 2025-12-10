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



class SuksesLogout {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User sudah melakukan Login")
	def I_want_to_write_a_step_with_name(String name) {
		WebUI.callTestCase(findTestCase('Positive/Success Login'), [('username') : 'standard_user', ('password') : 'secret_sauce'], 
    FailureHandling.STOP_ON_FAILURE)
	}

	@When("Click Button Burger Menu")
	def I_check_for_the_value_in_step(int value) {
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Products/btn_burgerMenu'), 0)
		WebUI.enhancedClick(findTestObject('Products/btn_burgerMenu'), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
	}
	
	@And("Click Button Logout")
	def ClickingLogoutButton() {
		WebUI.verifyElementPresent(findTestObject('Products/btn_logout'), 0)
		WebUI.enhancedClick(findTestObject('Products/btn_logout'), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(3)
	}

	@Then("Berhasil melakukan Logout, dibuktikan dengan capture halaman Login")
	def I_verify_the_status_in_step(String status) {
		WebUI.verifyElementPresent(findTestObject('Login Page/btn_login'), 0)
		WebUI.takeScreenshot()
	}
}