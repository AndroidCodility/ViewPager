package com.codility.tabviewpager

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.codility.tabviewpager.adapter.Adapter
import com.codility.tabviewpager.fragment.AddFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "This Is Sample Program For TabLayout with ViewPager..!!", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

        setupViewPager(pager)
        tabs.setupWithViewPager(pager)
    }

    private fun setupViewPager(pager: ViewPager?) {
        val adapter = Adapter(supportFragmentManager)

        val f1 = AddFragment.newInstance("Home")
        adapter.addFragment(f1, "Home")

        val f2 = AddFragment.newInstance("Dashboard")
        adapter.addFragment(f2, "Dashboard")

        val f3 = AddFragment.newInstance("Profile")
        adapter.addFragment(f3, "Profile")

        pager?.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuAbout ->
                showToast("You clicked about")

            R.id.menuSettings ->
                showToast("You clicked settings")

            R.id.menuLogout ->
                showToast("You clicked logout")
        }
        return true
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}