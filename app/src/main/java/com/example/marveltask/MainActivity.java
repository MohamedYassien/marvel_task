package com.example.marveltask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.marveltask.view.CharacterListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if the fragment is already added
        if (savedInstanceState == null) {
            // Create and add CharacterListFragment
            Fragment characterListFragment = new CharacterListFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, characterListFragment)
                    .commit();
        }
    }
}
