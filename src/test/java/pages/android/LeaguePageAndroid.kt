package pages.android

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import io.appium.java_client.MobileBy
import io.qameta.allure.Step
import org.assertj.core.api.Assertions
import org.openqa.selenium.By
import pages.HomePage
import pages.LeaguePage
import pages.TeamPage
import java.util.logging.Logger

class LeaguePageAndroid : LeaguePage {
    private val log: Logger = Logger.getLogger(LeaguePageAndroid::class.java.name)

    private val lblNewsTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"News\"]/android.widget.TextView"))
    private val lblScheduleTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Schedule\"]/android.widget.TextView"))

    private val lblInfoTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Info\"]/android.widget.TextView"))

    private val lblTeamName: SelenideElement = `$`(By.id("team_name"))

    private val btnBack: SelenideElement = `$`(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))

    @Step("League page is opened")
    override fun isOpen(): Boolean {
        log.info("Team page is opened")
        return lblTeamName.shouldBe(Condition.visible).exists()
    }

    @Step("Go Back")
    override fun goBack() {
       ElementHelpers().tap(btnBack)
    }

    @Step("Get League title name")
    override fun getTitleName(): String {
        log.info("Getting League Name text")
        return lblTeamName.text
    }
    @Step("Verify League Name")
    override fun verifyLeagueName(teamName: String){
        log.info("Assert Team Name")
        Assertions.assertThat(teamName==getTitleName())
    }


}