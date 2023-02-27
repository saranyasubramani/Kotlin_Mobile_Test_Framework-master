package core.pageConfiguration

import com.google.inject.AbstractModule
import pages.*
import pages.ios.*

class iOSInit : AbstractModule() {
    override fun configure() {

        bind(SearchPage::class.java).to(SearchPageIOS::class.java)
        bind(TeamPage::class.java).to(TeamPageIOS::class.java)
    }
}