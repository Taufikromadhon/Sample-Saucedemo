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
import org.openqa.selenium.chrome.ChromeOptions
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



class SuksesLogin {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User navigates to saucedemo.com")
	def User_navigates_to_saucedemo_dotCom() {
		ChromeOptions options = new ChromeOptions()
		options.addArguments("--incognito")

		WebUI.openBrowser('')
		WebUI.navigateToUrl('saucedemo.com')
		WebUI.maximizeWindow()
		WebUI.delay(5)
	}

	@When("Input valid (.*) on username field")
	def Input_username(String username) {
		WebUI.verifyElementPresent(findTestObject('Login Page/input_username'), 0)
		WebUI.setText(findTestObject('Login Page/input_username'), username)
	}

	@And("Input valid (.*) on password field")
	def Input_password(String password) {
		WebUI.verifyElementPresent(findTestObject('Login Page/input_password'), 0)
		WebUI.setText(findTestObject('Login Page/input_password'), password)
	}

	@And("Click Login Button")
	def ClickLogin() {
		WebUI.verifyElementPresent(findTestObject('Login Page/btn_login'), 0)
		WebUI.enhancedClick(findTestObject('Login Page/btn_login'), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
	}

	@Then("Berhasil Login dibuktikan dengan evidence")
	def loginSuccess() {
		WebUI.verifyElementPresent(findTestObject('Products/lbl_products'), 0)
		WebUI.takeScreenshot()
	}
}