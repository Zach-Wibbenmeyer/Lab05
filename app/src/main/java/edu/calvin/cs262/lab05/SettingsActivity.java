package edu.calvin.cs262.lab05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity to display the settings page, consisting of one settings fragment
 *
 * @author Zach Wibbenmeyer
 */
public class SettingsActivity extends AppCompatActivity {

    /**
     * Handles behavior upon loading of the view, particularly
     * by displaying the settings fragment
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lab 05 - Settings");
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}
