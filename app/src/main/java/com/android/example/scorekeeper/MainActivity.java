package com.android.example.scorekeeper;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private int mScoreCount1 = 0, mScoreCount2 = 0;
  private TextView  mShowScore1, mShowScore2;

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    //Inflate the menu from XML
    getMenuInflater().inflate(R.menu.main_menu, menu);

    //Change the label of the menu based on the state of the app
    int nightMode = AppCompatDelegate.getDefaultNightMode();
    if(nightMode	==	AppCompatDelegate.MODE_NIGHT_YES){
      menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
    }	else{
      menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
    }
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    //Check if the correct item was clicked
    if(item.getItemId()==R.id.night_mode){
      AppCompatDelegate.getDefaultNightMode();
      //Get the night mode state of the app
      int nightMode = AppCompatDelegate.getDefaultNightMode();
      //Set the theme mode for the restarted activity
      if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
      }
      else{
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
      }
    }
    recreate();
    return true;
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    //Save the scores
    outState.putInt("STATE_SCORE_1", mScoreCount1);
    outState.putInt("STATE_SCORE_2", mScoreCount2);
    super.onSaveInstanceState(outState);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if(savedInstanceState != null){
      mScoreCount1 = savedInstanceState.getInt("STATE_SCORE_1");
      mScoreCount2 = savedInstanceState.getInt("STATE_SCORE_2");

      //Set the score text views
      mShowScore1.setText(String.valueOf(mScoreCount1));
      mShowScore2.setText(String.valueOf(mScoreCount2));
    }

    mShowScore1 = (TextView) findViewById(R.id.score_1);
    mShowScore2 = (TextView) findViewById(R.id.score_2);
  }

  /**
   * Method that handles the onClick of both the decrement buttons
   * @param view The button view that was clicked
   */
  public void decreaseScore(View view) {
    //Get the ID of the button that was clicked
    int viewID = view.getId();
    switch (viewID){
      //If Team 1:
      case R.id.decreaseTeam1:
        //Decrement the score and update the TextView
        mScoreCount1--;
        mShowScore1.setText(String.valueOf(mScoreCount1));
        break;
      //If Team 2:
      case R.id.decreaseTeam2:
        //Decrement the score and update the TextView
        mScoreCount2--;
        mShowScore2.setText(String.valueOf(mScoreCount2));
        break;
    }
  }

  public void increaseScore(View view) {
    //Get the ID of the button that was clicked
    int viewID = view.getId();
    switch (viewID){
      //If Team 1:
      case R.id.increaseTeam1:
        //Decrement the score and update the TextView
        mScoreCount1++;
        mShowScore1.setText(String.valueOf(mScoreCount1));
        break;
      //If Team 2:
      case R.id.increaseTeam2:
        //Decrement the score and update the TextView
        mScoreCount2++;
        mShowScore2.setText(String.valueOf(mScoreCount2));
        break;
    }
  }
}