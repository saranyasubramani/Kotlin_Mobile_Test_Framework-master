package pages.android

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import io.qameta.allure.Step
import org.assertj.core.api.Assertions
import org.openqa.selenium.By
import pages.TeamPage
import pages.android.tabs.InfoTabAndroid
import java.util.logging.Logger

class TeamPageAndroid : TeamPage {
    private val log: Logger = Logger.getLogger(TeamPageAndroid::class.java.name)

    private val lblNewsTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"News\"]/android.widget.TextView"))
    private val lblScheduleTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Schedule\"]/android.widget.TextView"))

    private val lblInfoTab: SelenideElement = `$`(By.xpath("//android.widget.LinearLayout[@content-desc=\"Info\"]/android.widget.TextView"))

    private val lblTeamName: SelenideElement = `$`(By.id("team_name"))

    private val btnBack: SelenideElement = `$`(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))
    private var teamInfoTab = InfoTabAndroid()

    @Step("Team page is opened")
    override fun isOpen(): Boolean {
        log.info("Team page is opened")
        return lblTeamName.shouldBe(Condition.visible).exists()
    }

    @Step("Go Back")
    override fun goBack() {
       ElementHelpers().tap(btnBack)
    }

    @Step("Get Title name")
    override fun getTitleName(): String {
        log.info("Getting Team Name text")
        return lblTeamName.text
    }

    @Step("Verify Team name")
    override  fun verifyTeamName(teamName: String){
        log.info("Assert Team Name")
        Assertions.assertThat(teamName==getTitleName())
    }

    @Step("Go To Info tab")
    override fun goToInfoTab(){
        ElementHelpers().tap(lblInfoTab)
    }

    @Step("Verify If tab is enabled")
    override fun verifyIfTabIsEnable(tab: String){
        if(tab=="Info"){
            Assertions.assertThat(teamInfoTab.isOpen())
        }
    }

}