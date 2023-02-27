package pages.android

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.HomePage
import java.util.logging.Logger

class HomePageAndroid : HomePage {
    private val log: Logger = Logger.getLogger(HomePageAndroid::class.java.name)

    private val homeSearchBar: SelenideElement = `$`(By.id("search_bar_text_view"))


    @Step("Hope page is opened")
    override fun isOpen(): Boolean {
        log.info("Home page is opened")
        return homeSearchBar.shouldBe(Condition.visible).exists()
    }

    @Step("Click Search Bar")
    override fun clickSearchBar() {
        ElementHelpers().tap(homeSearchBar)
    }

}