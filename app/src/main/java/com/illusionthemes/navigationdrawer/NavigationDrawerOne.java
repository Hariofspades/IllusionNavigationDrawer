package com.illusionthemes.navigationdrawer;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

/** created by Hari from Illusion Themes
 * This activity is for the default navigation drawer according to the material design guideliness
 * This contains header image as the backdrop, user profile icon, two TextView for displaying info
 * and the menu items with image. Additionally you can also add badges or the count value for each
 * list items
 *
 * Follow up the comments to hack the code according to your use case
 *
 * Dependant XML files foe this Java class
 *
 * 1. Activity_navigation_drawe_one.xml
 * 2. app_bar_navigation_drawer_one.xml (displaying content)
 * 3. content_navigation_drawer_one.xml (displaying content)
 * 4. nav_header_navigation_drawer_one.xml (user icon and header info of navigation drawer)
 *
 * */

public class NavigationDrawerOne extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /** Varable initialization
     * */
    TextView slideshow,gallery;
    AppCompatSpinner account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflate the XML activity_navigation_drawer_one.xml
        setContentView(R.layout.activity_navigation_drawer_one);
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click event of the button
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // Navigation drawer declaration
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        //toggling the state of the drawer
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //adding listener for the navigation drawer item selection
        View headerLayout = navigationView.getHeaderView(0);
        //Inititalise items to add count value/badge value
        gallery=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_gallery));
        slideshow=(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_slideshow));
        initializeCountDrawer();
    }

    /**
     * This function is to inintialise the count value. This provides cinstant value.
     * If your use case uses Value from API, concatenate a string with the previous count value and
     *  call this fuction in OnResume or when ever needed
     */
    private void initializeCountDrawer(){
        gallery.setGravity(Gravity.CENTER_VERTICAL);
        gallery.setTypeface(null, Typeface.BOLD);
        gallery.setTextColor(getResources().getColor(R.color.colorAccent));
        gallery.setText("99+");
        slideshow.setGravity(Gravity.CENTER_VERTICAL);
        slideshow.setTypeface(null,Typeface.BOLD);
        slideshow.setTextColor(getResources().getColor(R.color.colorAccent));
        slideshow.setText("7");
    }

    /**
     *  This function handles backpress event for navigation drawer and activity termination
     */

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer_one, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *  This function onNavigationItemSelected handles the action to be performed when each item
     *  is clicked under navigation drawer
     * */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //TODO replace your own action
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
