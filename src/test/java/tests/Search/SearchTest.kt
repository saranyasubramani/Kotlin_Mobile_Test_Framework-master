package tests.Search

import com.google.gson.Gson
import core.utils.JsonReader
import io.qameta.allure.Description
import io.qameta.allure.Feature
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import org.assertj.core.api.Assertions
import org.testng.annotations.Test
import tests.BaseTest
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.util.logging.Logger

data class SearchContent (

    @SerializedName("type"       ) var type       : String? = null,
    @SerializedName("searchText" ) var searchText : String? = null,
    @SerializedName("tab" ) var tab : String? = null

)

class SearchTest : BaseTest() {
    private val log: Logger = Logger.getLogger(SearchTest::class.java.name)
    @Test
    @Description("Test Description: Verify if user can search for Team/Player/League Page and open tab of their choice ")
    @Feature("Navigate")
    fun navigationTest() {

        log.info("Get testdata from Json and convert to Array")
        var jsonFileString = JsonReader().getJsonDataFromAsset("src/test/java/data/SearchContent.json")
        var searchData: Array<SearchContent> = convertJsonToSearchContent(jsonFileString)

        log.info("Loop through Array of testdata set and perform verification")
       for(content in searchData) {
           if (pages.homePage.isOpen()) {
               pages.homePage.clickSearchBar()
           }
           Assertions.assertThat(pages.searchPage.isOpen())
           pages.searchPage.searchAndGoTo(content.searchText.toString())
           if(content.type=="Team") {
               log.info("Performing verification for Content Type: Team")
               pages.teamPage.verifyTeamName(content.searchText.toString())
               pages.teamPage.goToInfoTab()
               pages.teamPage.verifyIfTabIsEnable(content.tab.toString())
               pages.teamPage.goBack()
               Assertions.assertThat(pages.searchPage.isOpen())
               pages.searchPage.goBack()
               Assertions.assertThat(pages.homePage.isOpen())
           }else if (content.type=="Player"){
               log.info("Performing verification for Content Type: Player")
               pages.playerPage.verifyPlayerName(content.searchText.toString())
               pages.teamPage.goToInfoTab()
               pages.teamPage.verifyIfTabIsEnable(content.tab.toString())
               pages.playerPage.goBack()
               Assertions.assertThat(pages.searchPage.isOpen())
               pages.searchPage.goBack()
               Assertions.assertThat(pages.homePage.isOpen())

           }else if(content.type=="League"){
               log.info("Performing verification for Content Type: League")
               pages.leaguePage.verifyLeagueName(content.searchText.toString())
               pages.leaguePage.goBack()
               Assertions.assertThat(pages.searchPage.isOpen())
               pages.searchPage.goBack()
               Assertions.assertThat(pages.homePage.isOpen())
           }
       }
    }

    private fun convertJsonToSearchContent(value: String?): Array<SearchContent>{
        val gson = Gson()
        val searchContentData = object : TypeToken<Array<SearchContent>>() {}.type
        var data: Array<SearchContent> = gson.fromJson(value, searchContentData)
        return data
    }

}