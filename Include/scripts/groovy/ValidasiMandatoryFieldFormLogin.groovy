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



class ValidasiMandatoryFieldFormLogin {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User navigates to saucedemo.com untuk triger Validasi Mandatory Field Form Login")
	def NavigatesToSaucedemoWeb() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('saucedemo.com')
		WebUI.maximizeWindow()
		WebUI.delay(5)
	}

	@When("Kosongkan field username {string} pada form login")
	def KosongkanFieldUsernamePadaFormLogin(String username) {
		WebUI.verifyElementPresent(findTestObject('Login Page/input_username'), 0)
		WebUI.setText(findTestObject('Login Page/input_username'), username)
		
	}
	
	@And("Kosongkan field password {string} pada form login")
	def KosongkanFieldPasswordPadaFormLogin(String password) {
		WebUI.verifyElementPresent(findTestObject('Login Page/input_password'), 0)
		WebUI.setText(findTestObject('Login Page/input_password'), password)	
	}

	@And("Click Login Button untuk triger Validasi Mandatory Field Form Login")
	
	def ClickLoginButtonUntukTrigerValidasiMandatoryFieldFormLogin() {
		WebUI.verifyElementPresent(findTestObject('Login Page/btn_login'), 0)
		WebUI.enhancedClick(findTestObject('Login Page/btn_login'), FailureHandling.STOP_ON_FAILURE)	
		WebUI.delay(5)
	}
	
	@Then("Berhasil menampilkan Validasi Mandatory Field Form Login dibuktikan dengan evidence")
	def BerhasilMenampilkanValidasiMandatoryFieldFormLogin() {
		WebUI.verifyElementPresent(findTestObject('Login Page/lbl_errorMandatory'), 0)
		WebUI.takeScreenshot()
	}
}