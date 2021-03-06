package com.williamcomartin.plexpyremote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;

import com.williamcomartin.plexpyremote.Helpers.UrlHelpers;
import com.williamcomartin.plexpyremote.SharedFragments.RecentlyAddedFragment;

public class RecentlyAddedActivity extends NavBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!UrlHelpers.hasServer()){
            onBackPressed();
        }
        setContentView(R.layout.activity_recently_added);
        setupActionBar();

        final RecentlyAddedFragment frag = new RecentlyAddedFragment();
        frag.setGlobal();
        getSupportFragmentManager().beginTransaction().add(R.id.recently_added_frame_layout, frag).commit();
    }

    protected void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.recently_added);
    }

    @Override
    public void onBackPressed() {
        if (mainDrawerLayout != null && mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            super.onBackPressed();
            return;
        }

        Intent intent = new Intent(this, ActivityActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
