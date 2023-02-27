package pages

import core.utils.ElementHelpers

interface BaseContentPage {
    fun isOpen(): Boolean
    fun goBack()
    fun getTitleName(): String
}