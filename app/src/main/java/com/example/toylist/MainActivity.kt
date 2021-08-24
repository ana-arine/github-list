package com.example.toylist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

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

    // Do 2 - 7 in main.xml ///////////////////////////////////////////////////////////////////////
    // TODO (2) Create a menu xml called 'main.xml' in the res->menu folder
    // TODO (3) Add one menu item to your menu
    // TODO (4) Give the menu item an id of @+id/action_search
    // TODO (5) Set the orderInCategory to 1
    // TODO (6) Show this item if there is room (use app:showAsAction, not android:showAsAction)
    // TODO (7) Set the title to the search string ("Search") from strings.xml
    // Do 2 - 7 in main.xml ///////////////////////////////////////////////////////////////////////

    // TODO (8) Override onCreateOptionsMenu
    // TODO (9) Within onCreateOptionsMenu, use getMenuInflater().inflate to inflate the menu
    // TODO (10) Return true to display your menu
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
        val menuItemThatWasSelected: Int = item.itemId
        if (menuItemThatWasSelected == R.id.action_search) {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

}