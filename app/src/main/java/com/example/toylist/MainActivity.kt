package com.example.toylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.toylist.utilities.NetworkUtils
import java.net.URL

class MainActivity : AppCompatActivity() {

    // TODO (26) Create an EditText variable called mSearchBoxEditText
    lateinit var mSearchBoxEditText: EditText

    // TODO (27) Create a TextView variable called mUrlDisplayTextView
    lateinit var mUrlDisplayTextView: TextView

    // TODO (28) Create a TextView variable called mSearchResultsTextView
    lateinit var mSearchResultsTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO (29) Use findViewById to get a reference to mSearchBoxEditText
        mSearchBoxEditText = findViewById(R.id.et_search_box)

        // TODO (30) Use findViewById to get a reference to mUrlDisplayTextView
        mUrlDisplayTextView = findViewById(R.id.tv_url_display)

        // TODO (31) Use findViewById to get a reference to mSearchResultsTextView
        mSearchResultsTextView = findViewById(R.id.tv_github_search_results_json)

    }

    fun makeGithubSearchQuery() {
        val githubQuery = mSearchBoxEditText.text.toString()
        val githubSearchUrl = NetworkUtils.buildUrl(githubQuery)
        mUrlDisplayTextView.text = githubSearchUrl.toString()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    // TODO (11) Override onOptionsItemSelected
    // TODO (12) Within onOptionsItemSelected, get the ID of the item that was selected
    // TODO (13) If the item's ID is R.id.action_search, show a Toast and return true to tell Android that you've handled this menu click
    // TODO (14) Don't forgot to call .show() on your Toast
    // TODO (15) If you do NOT handle the menu click, return super.onOptionsItemSelected to let Android handle the menu click

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemThatWasClickedId: Int = item.itemId
        if (itemThatWasClickedId == R.id.action_search) {
            //Toast.makeText(this, "Search clicked", Toast.LENGTH_LONG).show()
            makeGithubSearchQuery()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}