package pages.ios

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.assertj.core.api.Assertions
import org.openqa.selenium.By
import pages.TeamPage
import java.util.logging.Logger

class TeamPageIOS : TeamPage {
    private val log: Logger = Logger.getLogger(TeamPageIOS::class.java.name)

    private val homePageHeader: SelenideElement = `$`(By.xpath("//android.widget.TextView[@text='Bag']"))

    @Step("Hope page is opened")
    override fun isOpen(): Boolean {
        log.info("Home page is opened")
        return homePageHeader.shouldBe(Condition.visible).exists()
    }

    override fun goBack() {
        TODO("Not yet implemented")
    }

    override fun getTitleName(): String {
        return "exit"
    }

    override  fun verifyTeamName(teamName: String){

    }

    override fun goToInfoTab() {
        TODO("Not yet implemented")
    }

    override fun verifyIfTabIsEnable(tab: String) {
        TODO("Not yet implemented")
    }
}