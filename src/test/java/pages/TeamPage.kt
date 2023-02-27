package pages

interface TeamPage:BaseContentPage {
    fun verifyTeamName(teamName: String)
    fun goToInfoTab()
    fun verifyIfTabIsEnable(tab: String)
}