package core.utils

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import core.constants.Constants.Companion.IS_ANDROID
import org.openqa.selenium.By
import pages.android.HomePageAndroid
import java.lang.Exception
import java.util.logging.Logger

class InitialSetupUtils {
    private val log: Logger = Logger.getLogger(InitialSetupUtils::class.java.name)

    var btnGetStarted: SelenideElement = Selenide.`$`(By.id("action_button_text"))
    var btnContinue: SelenideElement = Selenide.`$`(By.id("action_button_text"))
    var lblRecommended: SelenideElement = Selenide.`$`(By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"))
    var btnContinuefav: SelenideElement = Selenide.`$`(By.id("action_button_text"))
    var btnMaybeLater: SelenideElement = Selenide.`$`(By.id("btn_disallow"))
    var btnDone: SelenideElement = Selenide.`$`(By.id("action_button_text"))
    var btnAllow: SelenideElement = Selenide.`$`(By.xpath(".//android.widget.Button[@text='Allow']"))
    var btnClose: SelenideElement = Selenide.`$`(By.id("dismiss_modal"))

    fun firstTimeAppLaunchSetup(){
        if(IS_ANDROID) {
            ElementHelpers().tap(btnGetStarted)
            btnContinue.click()
            btnMaybeLater.click()
            lblRecommended.click()
            btnContinuefav.click()
            btnDone.click()
            if(btnAllow.isDisplayed) {
                btnAllow.click()
            }
            btnClose.click()
        }

    }

}