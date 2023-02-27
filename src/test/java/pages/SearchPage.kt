package pages


interface SearchPage {
    fun isOpen(): Boolean
    fun typeSearchContent(searchText: String)

    fun clickSearchContent(searchText: String)
    fun searchAndGoTo(searchText: String)
    fun goBack()
}