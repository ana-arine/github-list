package com.example.toylist.utilities

import android.net.Uri
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

class NetworkUtils {

    companion object {

    val GITHUB_BASE_URL = "https://api.github.com/search/repositories"
    val PARAM_QUERY = "q"
    val PARAM_SORT = "sort"
    val sortBy = "starts"


        fun buildUrl(githubSearchQuery: String): URL? {
            val builtUri: Uri

            builtUri = Uri.parse(GITHUB_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, githubSearchQuery)
                .appendQueryParameter(PARAM_SORT, sortBy)
                .build()

            var url: URL? = null
            try {
                url = URL(builtUri.toString())
            } catch (exception: MalformedURLException) {
                exception.printStackTrace()
            }
            return url
        }
    }

    @Throws(IOException::class)
    fun getResponseFromHttpUrl(url: URL) : String? {
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val a: InputStream = urlConnection.inputStream

            val scanner = Scanner(a)
            scanner.useDelimiter("\\A")

            val hasInput: Boolean = scanner.hasNext()
            if (hasInput) {
                return scanner.next()
            } else {
                return null
            }
        } finally {
            urlConnection.disconnect()
        }
    }

}