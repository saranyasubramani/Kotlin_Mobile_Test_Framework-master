package pages.android

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import core.utils.ElementHelpers
import io.qameta.allure.Step
import org.openqa.selenium.By
import pages.SearchPage
import java.util.logging.Logger


class SearchPageAndroid : SearchPage {
    private val log: Logger = Logger.getLogger(SearchPageAndroid::class.java.name)
    private val txtHomeSearchBar: SelenideElement = Selenide.`$`(By.id("search_src_text"))

    private val selectSearchContent: String = "//android.widget.TextView[contains(@text,\"%s\")]"
    private val btnBack: SelenideElement =
        Selenide.`$`(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"))

    @Step("Search Page is open")
    override fun isOpen(): Boolean {
        log.info("Search page is opened")
        return txtHomeSearchBar.shouldBe(Condition.visible).exists()
    }

    @Step("type Search Content")
    override fun typeSearchContent(searchText: String) {
        ElementHelpers().typeText(txtHomeSearchBar,searchText)
    }
    @Step("Click Search Content")
    override fun clickSearchContent(searchText: String) {
        val selectSearchContentElement: SelenideElement =
            Selenide.`$`(By.xpath(java.lang.String.format(selectSearchContent, searchText)))
        ElementHelpers().tap(selectSearchContentElement)
    }

    @Step("Search and go to content")
    override fun searchAndGoTo(searchText: String) {
        typeSearchContent(searchText)
        clickSearchContent(searchText)
    }

    @Step("Go Back")
    override fun goBack() {
        ElementHelpers().tap(btnBack)
    }
}