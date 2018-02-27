package com.example.chris.fitnessapplication;

import android.app.ActionBar;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class HomePage extends AppCompatActivity /*implements OnClickListener*/ {
    private ListView ExersizeList ;
    private ArrayAdapter<String> listAdapter ;
    private TabLayout tabSelected;
    private Button profileBtn;
    String [] currentArray = new String[] {"Error Fetching List", "Null"};
    String[] bicepsArray = new String[] {"Dumbbell Curl", "Hammer Curl", "Kneeling Single arm Curl",
                                        "Cable bicep Curls", "Stability ball Dumbell Bicep curl seated"};
    String[] legsArray = new String[] {"leg content line 1", "Leg content line 2"};
    String[] backArray = new String[] {"back content line 1", "back content line 2"};
    String[] absArray = new String[] {"abs content line 1", "abs content line 2"};
    String[] calfArray = new String[] {"calf content line 1", "calf content line 2"};
    String[] chestArray = new String[] {"chest content line 1", "chest content line 2"};
    String[] forearmArray = new String[] {"forearm content line 1", "forearm content line 2"};
    String[] shoulderArray = new String[] {"Shoulder content line 1", "Shoulder content line 2"};
    String[] tricepsArray = new String[] {"Tricpes content line 1", "Triceps content line 2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hompage);
        exersizeList();
        /*TabItem biceps = (TabItem)findViewById(R.id.tab_Biceps);
        TabItem legs = (TabItem)findViewById(R.id.tab_Legs);
        TabItem back = (TabItem)findViewById(R.id.tab_Back);
        TabItem abs = (TabItem)findViewById(R.id.tab_Abs);
        TabItem calf = (TabItem)findViewById(R.id.tab_Calf);
        TabItem chest = (TabItem)findViewById(R.id.tab_Chest);
        TabItem forearm = (TabItem)findViewById(R.id.tab_Forearm);
        TabItem shoulder = (TabItem)findViewById(R.id.tab_Shoulder);
        TabItem tricep = (TabItem)findViewById(R.id.tab_Triceps);
        biceps.setOnClickListener(this);
        legs.setOnClickListener(this);
        back.setOnClickListener(this);
        abs.setOnClickListener(this);
        calf.setOnClickListener(this);
        chest.setOnClickListener(this);
        forearm.setOnClickListener(this);
        shoulder.setOnClickListener(this);
        tricep.setOnClickListener(this);*/
        onProfileButtonClick();
    }



    public void exersizeList() {
        ExersizeList = findViewById(R.id.ExersizeList);
        ArrayList<String> exersizeList = new ArrayList<String>();
        exersizeList.addAll(Arrays.asList(currentArray));
        listAdapter = new ArrayAdapter<String>(HomePage.this, R.layout.simplerow, exersizeList);
        listAdapter.notifyDataSetChanged();
        ExersizeList.setAdapter( listAdapter );
        ExersizeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent x = new Intent(HomePage.this, exersizeTemplate.class);
                startActivity(x);
            }
        });
    }

    public void onProfileButtonClick() {

        profileBtn = (Button)findViewById(R.id.btn_profile);
        profileBtn.setOnClickListener(
                new OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(HomePage.this, Profile.class);
                        startActivity(i);
                    }
                }
        );
    }

    /*@Override
    public void onClick(View v) {
        int targetId = v.getId();
        if (targetId == R.id.tab_Biceps){
            currentArray = bicepsArray;
        }
        else if (targetId == R.id.tab_Legs){
            currentArray = legsArray;
        }
        else if (targetId == R.id.tab_Back){
            currentArray = backArray;
        }
        else if (targetId == R.id.tab_Abs){
            currentArray = absArray;
        }
        else if (targetId == R.id.tab_Calf){
            currentArray = calfArray;
        }
        else if (targetId == R.id.tab_Chest){
            currentArray = chestArray;
        }
        else if (targetId == R.id.tab_Forearm){
            currentArray = forearmArray;
        }
        else if (targetId == R.id.tab_Shoulder){
            currentArray = shoulderArray;
        }
        else if (targetId == R.id.tab_Triceps){
            currentArray = tricepsArray;
        }
        else{
            currentArray = currentArray;
        }
    }*/
}
