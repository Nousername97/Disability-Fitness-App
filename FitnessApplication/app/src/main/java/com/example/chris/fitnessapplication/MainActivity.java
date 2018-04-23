package com.example.chris.fitnessapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chris.fitnessapplication.injuries.fitnessAssessment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);

        // Default page on app startup
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Profile()).commit();
        }
        else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomePage()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);

        // not only show about in menu
        menu.getItem(0).setVisible(false);
        menu.getItem(1).setVisible(false);
        menu.getItem(2).setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_about:
                aboutContent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new HomePage();
                            break;
                        case R.id.navigation_profile:
                            selectedFragment = new Profile();
                            break;
                        case R.id.navigation_health:
                            selectedFragment = new fitnessAssessment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    private void aboutContent() {
        String strLink = "<a href=\"http://db.everkinetic.com\">Everkinetic</a>";
        String message = "All of the exercises information and images used are from " + strLink + "." +
                        "<br><br>Creators of the app:" +
                        "<br>Chris <br>James <br>Mike <br>Kelvin ";
        Spanned myMessage = Html.fromHtml(message);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("About");
        builder.setMessage(myMessage);
        builder.setCancelable(true);
        AlertDialog alertDialog = builder.create();

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialog.show();
        TextView msgTxt = (TextView) alertDialog.findViewById(android.R.id.message);
        msgTxt.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
