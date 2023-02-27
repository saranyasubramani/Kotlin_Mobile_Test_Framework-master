package core.pageConfiguration

import com.google.inject.Inject
import pages.*
import pages.tabs.InfoTab

open class Pages {

    @Inject
    lateinit var homePage: HomePage

    @Inject
    lateinit var playerPage: PlayerPage

    @Inject
    lateinit var leaguePage: LeaguePage

    @Inject
    lateinit var teamPage: TeamPage

    @Inject
    lateinit var searchPage: SearchPage
    @Inject
    lateinit var infoTab: InfoTab
}