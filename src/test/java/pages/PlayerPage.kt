package pages

interface PlayerPage:BaseContentPage {
    fun verifyPlayerName(teamName: String)
    fun goToInfoTab()
    fun verifyIfTabIsEnable(tab: String)
}