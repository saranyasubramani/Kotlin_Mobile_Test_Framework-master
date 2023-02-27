package pages.android.tabs

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.tabs.InfoTab
import java.util.logging.Logger

class InfoTabAndroid : InfoTab {
    private val log: Logger = Logger.getLogger(InfoTabAndroid::class.java.name)

    private val lblTabName: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Info\"]/android.widget.TextView"))

    @Step(" Info Tab is opened")
    override fun isOpen(): Boolean {
        log.info("Info tab is opened")
        return lblTabName.isEnabled
    }
}