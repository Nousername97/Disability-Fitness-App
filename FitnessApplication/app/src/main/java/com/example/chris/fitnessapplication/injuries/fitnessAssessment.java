package com.example.chris.fitnessapplication.injuries;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.chris.fitnessapplication.R;
import com.example.chris.fitnessapplication.injuries.HeadPage;
import com.example.chris.fitnessapplication.injuries.LegsPage;
import com.example.chris.fitnessapplication.injuries.TorsoPage;
import com.example.chris.fitnessapplication.injuries.lArmPage;
import com.example.chris.fitnessapplication.injuries.rArmPage;


public class fitnessAssessment extends Fragment {

    private Button headButton;
    private Button rArmButton;
    private Button lArmButton;
    private Button torsoButton;
    private Button legsButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_assessment, container, false);

        headButton = (Button)rootView.findViewById(R.id.btn_head);
        rArmButton = (Button)rootView.findViewById(R.id.btn_rightarm);
        lArmButton = (Button)rootView.findViewById(R.id.btn_leftarm);
        torsoButton = (Button)rootView.findViewById(R.id.btn_torso);
        legsButton = (Button)rootView.findViewById(R.id.btn_legs);

        onHeadClick();
        onRightArmClick();
        onLeftArmClick();
        onTorsoClick();
        onLegsClick();

        return rootView;
    }

    public void onHeadClick() {

        headButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), HeadPage.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onTorsoClick() {

        torsoButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), TorsoPage.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onLegsClick() {

        legsButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), LegsPage.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onRightArmClick() {

        rArmButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), rArmPage.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void onLeftArmClick() {

        lArmButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(getActivity(), lArmPage.class);
                        startActivity(i);
                    }
                }
        );
    }

}
