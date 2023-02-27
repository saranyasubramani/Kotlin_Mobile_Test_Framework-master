package core.utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.IOException

class JsonReader {
    fun getJsonDataFromAsset(fileName: String): String {
        var lines: String
        try {
            lines = File(fileName).readText()

        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return "sorry"
        }
        return lines
    }

    fun <T> convertToJson(value: String?): Array<T> {
    val gson = Gson()
    val searchContentData = object : TypeToken<Array<T>>() {}.type
    var data: Array<T> = gson.fromJson(value, searchContentData)
        return data
    }
}