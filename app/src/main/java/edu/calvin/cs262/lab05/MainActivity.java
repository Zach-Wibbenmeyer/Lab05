package edu.calvin.cs262.lab05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * MainActivity implements the main view screen for the app.
 *
 * @author Zach Wibbenmeyer
 */
public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;

    /**
     * Behavior upon initial loading of the view including updating the
     * text reporting the state of the preference
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        pref =  PreferenceManager.getDefaultSharedPreferences(this);
        showPreferences();

    }

    /**
     * Helper method to update text displaying the state of the preference
     */
    private void showPreferences() {
        TextView prefText = (TextView) findViewById(R.id.prefTextView);
        prefText.setText("Preference: " + pref.getBoolean("preference", false));
    }

    /**
     * Determines behavior of the options menu in the action bar
     * @param menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activitiy_main, menu);
        return true;
    }

    /**
     * Handles the user selection of an item in the options menu
     * @param item
     * @return true if selection valid, else call superclass method
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Updates the text reporting the state of the preference each time
     * the view is re-loaded
     */
    @Override
    public void onResume() {
        super.onResume();
        showPreferences();
    }
}
