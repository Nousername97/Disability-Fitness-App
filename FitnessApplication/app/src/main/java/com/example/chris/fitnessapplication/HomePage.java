package com.example.chris.fitnessapplication;

import android.app.ActionBar;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;
import android.support.v4.app.Fragment;


import com.example.chris.fitnessapplication.data.Exercises.ExerciseDetailsDatabase;
import com.example.chris.fitnessapplication.data.Exercises.ExercisesDetails;
import com.example.chris.fitnessapplication.data.Users.UserDetails;
import com.example.chris.fitnessapplication.data.Users.UserDetailsDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomePage extends Fragment{
    private ListView ExersizeList ;
    private ArrayAdapter<String> listAdapter ;
    private Button legsButton;
    private Button tricepButton;
    private Button backButton;
    private Button calfButton;
    private Button absButton;
    private Button shoulderButton;
    private Button bicepsButton;
    private Button chestButton;
    private Button forearmButton;

    private String [] currentArray = new String[]{};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hompage, container, false);

        ExersizeList = rootView.findViewById(R.id.ExersizeList);
        bicepsButton = rootView.findViewById(R.id.btn_biceps);
        legsButton = rootView.findViewById(R.id.btn_legs);
        absButton = rootView.findViewById(R.id.btn_abs);
        chestButton = rootView.findViewById(R.id.btn_chest);
        calfButton = rootView.findViewById(R.id.btn_calf);
        backButton = rootView.findViewById(R.id.btn_back);
        tricepButton = rootView.findViewById(R.id.btn_tricep);
        forearmButton = rootView.findViewById(R.id.btn_forearm);
        shoulderButton = rootView.findViewById(R.id.btn_shoulder);

        exersizeList();
        //onProfileButtonClick();
        onButtonLegsClick();
        onButtonAbsClick();
        onButtonBackClick();
        onButtonCalfClick();
        onButtonChestClick();
        onButtonForearmClick();
        onButtonShoulderClick();
        onButtonTricepsClick();
        onButtonBicepsClick();

        return rootView;
    }

    public void exersizeList() {
        List<String> exersizeList = new ArrayList<String>();
        exersizeList = populateList("biceps");
        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
        listAdapter.notifyDataSetChanged();
        ExersizeList.setAdapter( listAdapter );
        ExersizeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent x = new Intent(getActivity(), exersizeTemplate.class);
                x.putExtra("ExerciseClicked", ExersizeList.getItemAtPosition(i).toString());
                startActivity(x);
            }
        });
    }

    public void onButtonBicepsClick(){
        bicepsButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View chest) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("biceps");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonLegsClick(){
        legsButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View legs) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("legs");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }

    public void onButtonAbsClick(){
        absButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View abs) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("abs");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonChestClick(){
        chestButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View chest) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("chest");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonCalfClick(){
        calfButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View calf) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("calf");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonBackClick(){
        backButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View back) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("back");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonTricepsClick(){
        tricepButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View tricep) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("triceps");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonForearmClick(){
        forearmButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View forearm) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("forearm");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }
    public void onButtonShoulderClick(){
        shoulderButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View shoulder) {
                        listAdapter.clear();
                        List<String> exersizeList = new ArrayList<String>();
                        exersizeList = populateList("shoulder");
                        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow, exersizeList);
                        listAdapter.notifyDataSetChanged();
                        ExersizeList.setAdapter(listAdapter);
                    }
                }
        );
    }

    public List<String> populateList(String group)
    {
        //Example of adding tags
        //Stand Alone Tags
        ArrayList<String> Leg = new ArrayList<String>();
        Leg.add("Legs");
        ArrayList<String> BothArms = new ArrayList<String>();
        BothArms.add("Both Arms");
        ArrayList<String> OneArm = new ArrayList<String>();
        OneArm.add("One Arm");
        ArrayList<String> StrongBack = new ArrayList<String>();
        StrongBack.add("Strong Back");
        ArrayList<String> HealthyHeart = new ArrayList<String>();
        HealthyHeart.add("Healthy Heart");

        //Combination Tags
        ArrayList<String> BackandHeart = new ArrayList<String>();
        BackandHeart.add("Healthy Heart" + "Strong Back");
        ArrayList<String> BackandLegs = new ArrayList<String>();
        BackandLegs.add("Legs" + "Strong Back");
        ArrayList<String> BackandBothArms = new ArrayList<String>();
        BackandBothArms.add("Strong Back" + "Both Arms");
        ArrayList<String> BackArmsHeart = new ArrayList<String>();
        BackArmsHeart.add("Strong Back" + "Both Arms" + "Healthy Heart");
        ArrayList<String> BothArmsLegsBack = new ArrayList<String>();
        BothArmsLegsBack.add("Boths Arms" + "Legs" + "Strong Back");
        ArrayList<String> BackOneArm = new ArrayList<String>();
        BackOneArm.add("One Arm" + "Strong Back");

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Leg Raises", "Leg Raises", R.drawable.legraises, "Lay on a flat mat with your arms at your sides with palms touching the floor and your legs as out stretched as possible, slowly raise your legs whilst keeping them rigid as high as you can and once you reach your limit hold the position for 1 second, then slowly return to the starting position.", "abs", Leg));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("One Armed DumbBell Curl", "One Armed DumbBell Curl", R.drawable.onehandeddumbbellcurl, "Stand Holding the Dumb-Bell with your palms facing upwards, curl the Dumb-Bell upwards as far as possible then slowly lower the weight down without it touching your body.", "biceps", OneArm));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Barbell Curl", "Barbell Curl", R.drawable.barbellcurl, "Stand Upright and hold the Barbell with a shoulder width grip and palms facing upwards, keep your elbows close to your torso, curl the weight forward whilst breathing out and keeping your upper arms stationary, bring the bar to shoulder level before bringing it back to starting position whilst breathing in.", "biceps", BothArmsLegsBack));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Overhead Cable Curl", "Overhead Cable Curl", R.drawable.overheadcablecurl,"Set the Height of the pulleys so that they are both equal height above your shoulders, stand in the middle of both pulleys and grip them with palms facing upwards, keep your feet shoulder width apart and ensure that both arms are fully extended while griping the pulleys, then pull them inwards until your biceps and forearms touch while exhaling, while inhaling move your forearms back to their starting position.","biceps", BackandBothArms));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Bench Dips", "Bench Dips", R.drawable.benchdips, "Place a bench behind your back, With the bench perpendicular to your body and whilst looking away from it, hold on to the bench with both arms fully extended and at shoulder length apart, fully extend and cross your legs on another bench of similar height, slowly lower your body whilst inhaling by bending your elbows until there is an angle slightly smaller than 90 degrees between your upper arm and forearm, use your triceps to push yourself back to the starting position.", "triceps", BothArmsLegsBack));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Seated Tricep Press with Dumb-Bell", "Seated Tricep Press with Dumb-Bell", R.drawable.seatedtriceppresswithdumbbell,"Sit down on a bench with a back support, grasp a Dumb-Bell in both hand and hold it at arm’s length overhead, Have the palm of your hand facing inwards, keeping your arms close to your head with elbows in and perpendicular to the flow, lower the weight om a semi-circular motion behind your head until your forearms touch your biceps. ", "triceps", BackandBothArms));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Tricep Extensions Using Machone", "Tricep Extensions using Machine", R.drawable.tricepextensionusingmachine, "Place your upper arm against the pad and grasp the handles, extend your elbow pushing your lower arm away from your upper arm, hold the position once your arm is fully extended and then slowly return the weight to the starting position.", "triceps", BothArms));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Seated Cable Rows", "Seated Cable Rows", R.drawable.seatedcablerows,"Sit down on the machine placing your feet on the platform provided, make sure your knees are slightly bent. Grasp both pulleys with your palms facing towards each other, with your arms extended pull back until your torso is at a 90 degree angle to your legs to assume the starting position, Keeping your torso stationary pull the handles towards your torso until your arms reach your abdominals, breath out whilst performing this movement. Hold the position momentarily before slowly returning to the start position while exhaling.", "back", BothArmsLegsBack));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Reverse Grip Bent Over Barbell Rows", "Reverse Grip Bent Over Barbell Rows", R.drawable.reversegripbentoverbarbellrows, "From an upright standing position, bend your knees slightly and bring your torso forward by bending at the waist,, grip the barbell with your palms facing upwards, while keeping your torso stationary, lift the barbell whilst exhaling, keep your elbows close to your body, once fully raised hold the position momentarily then slowly lower the weight to the starting position while inhaling.", "back", BothArmsLegsBack));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Pull Ups", "Pull Ups", R.drawable.pullups, "Grasp the Pull bar with your palms facing forward, make sure your grip is slightly wider than the width of your shoulders, Pull your torso up until the bar touches your upper chest by pulling shoulders and upper arms down and back. Exhale whilst performing the part of the movement. Once you upper chest has reached the bar, hold the contracted position for 1 second before lowering yourself back to the starting position.", "back", BackandBothArms));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Arnold Press", "Arnold Press", R.drawable.arnoldpress, "Sit on a bench and hold two dumb-bells to your side with your palms facing towards you and your forearm at a 90-degree angle to your upper arm, raise the dumb-bells as you rotate your arms so that your palm is facing forwards. Hold the position momentarily before returning to the start position by slowly lowering the dumb-bells and reversing the rotation of your arms.", "shoulder",BackOneArm));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Front Raises2", "Front Raises", R.drawable.frontraises,"Grasp a Dumb-bell with the palm of your hand facing downwards towards the floor, hold the dumb-bell slightly in front of you at waist height to get into the starting position, from this position whilst keeping your back straight raise your arm until it is fully extended and the dumb-bell is at shoulder height, hold this position momentarily before returning to the start position.", "shoulder", BackOneArm));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Seated Military Press","Seated Military Press",R.drawable.seatedmilitarypress,"Sit on an exercise bench, and grip the barbell with your palms facing forward, to assume the start position keep your back straight and raise the barbell to the level of your collar bone, from this position raise the barbell above your head and hold the position, then slowly lower the barbell back to collar bone level.", "shoulder", BackandBothArms));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Incline Dumb-Bell Press", "Incline Dumb-Bell Press", R.drawable.inclineddumbbellpress, "Lie back on an incline bench with a dumbbell in each hand, have your palms facing towards your legs and the dumbbells raised by having your forearm at a 90-degree angle to your upper arm, from this starting position raise the dumbbells until your arms are fully extended whilst breathing out, from this position slowly lower your arms back to the start position whilst breathing in. You should spend double the time lowering back to the starting position as you did lifting the weights.", "chest", OneArm));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Bench Press", "Bench Press", R.drawable.benchpress,"Lie back on a flat bench grip the bar with both hands with your palms facing forward and your palms at slightly more than shoulder length apart, from the starting position lower the bar to your middle chest whilst breathing in, pause briefly and then push the bar back to the starting position using your chest muscles as you breath out.", "chest", BothArms));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Cable Crossover", "Cable Crossover", R.drawable.cablecrossover,"Place the pulleys in a high position above your head, grasp each puller with your palms facing each other and angle your torso slightly forward by bending your waist to assume the starting position, bend your elbows slightly to ensure that the tension is on your chest and not your bicep, from this position bring the pulleys together so that your knuckles almost touch, then return to a position with your arms outstretched, whilst doing this ensure that your arms and torso are kept stationary and that only your shoulders are moving.", "chest", BackOneArm));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Leg Press", "Leg Press", R.drawable.legpress, "Place your feet on the platform of the leg press machine at shoulder width, press the platform until your legs are near fully extended but taking care not to lock your knees. Slowly lower the platform until your upper and lower legs make a 90-degree angle to return to the starting position.", "legs", Leg));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Squats with Barbell", "Squats with Barbell", R.drawable.squatswithbarbell,"Begin in a hip width stance with feet slightly out turned, descend by flexing the knees whilst keeping your back straight and trying not to move your hips, keep lowering until the upper legs contact the lower legs, then reverse the motion back to the starting position.", "legs", BothArmsLegsBack));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Leg Extensions", "Leg Extensions", R.drawable.legextensions, "Sit on the machine with your legs under the pad and your feet pointed forward, hold on to the side bars or the seat itself with your hands, once the weight is set extend your legs to the maximum whilst exhaling and hold the position momentarily before returning to the start position.", "legs", Leg));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Air Bike", "Air Bike", R.drawable.airbike, "Lay flat on your back with your shoulders slightly raised and your hands behind your head, raise your legs so that your knees form a 90 degree angle and begin a motion similar to peddling a bike, when your knee comes close to your face move your opposite elbow to meet it.","abs", Leg));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Crunches", "Crunches", R.drawable.crunches, "Lie on a mat facing upwards with your knees bent, you can use a bench to help keep your knees in this position if required, from the start position curl your shoulders towards your pelvis and then return to the starting position.", "abs", BackandLegs));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Barbell Curl", "Barbell Curl", R.drawable.barbellcurl, "Stand Upright and hold the Barbell with a shoulder width grip and palms facing upwards, keep your elbows close to your torso, curl the weight forward whilst breathing out and keeping your upper arms stationary, bring the bar to shoulder level before bringing it back to starting position whilst breathing in.", "biceps",BothArmsLegsBack ));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Front Cable Raises", "Front Cable Raises", R.drawable.frontcableraises,"Stand with your feet shoulder width apart with your knees slightly bent and your abs drawn inwards, Hold the pulley at waist height with your palm facing towards the floor, raise your arm to shoulder height while keeping it staight and hold the position before returning the pulley to waist height.", "forearm", BackOneArm));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Front Raises", "Front Raises", R.drawable.frontraises,"Grasp a Dumb-bell with the palm of your hand facing downwards towards the floor, hold the dumb-bell slightly in front of you at waist height to get into the starting position, from this position whilst keeping your back straight raise your arm until it is fully extended and the dumb-bell is at shoulder height, hold this position momentarily before returning to the start position.", "forearm", BackOneArm));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Lateral DumbBell Raises", "Lateral DumbBell Raises", R.drawable.lateraldumbbellraises, "Grasp a DumbBell in each hand with your palms facing inwards towards your body and DumbBells at your sides, stand with your feet shoulder width apart and your knees slightly bent, while keeping your torso still and with your elbows slightly bent raise your arms until they are level with your shoulders and your palms are facing the floor, hold the position momentarily before returning to the starting position.", "forearm", BackandBothArms));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Calf Raises with Band", "Calf Raises with band", R.drawable.calfraiseswithband,"Stand with your toes on an exercise band and raise the handles to your shoulders, raise up on your toes while keeping your hands by your shoulders, hold the position for a moment before returning your heels to the floor.","calf", BothArmsLegsBack));

        ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().insertNewExercise(new ExercisesDetails("Seated Calf raise using a Machine", "Seated Calf raise using a Machine", R.drawable.seatedcalfraiseusingmachine, "Sit at a calf raise machine, place the balls of your feet on the footpad and place your thighs under the legpad, unlock the bar and slowly raise your toes as far as possible before returning them to the starting position.", "calf", Leg));

        /*List<String> listToBeFilled = new ArrayList<String>();
        List<ExercisesDetails> currentExercise = ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().getExercisesByGroup(group);

        for ( ExercisesDetails temp: currentExercise)
        {
            UserDetails dataInput =  UserDetailsDatabase.getInstance(getActivity()).UserDetailsDao().getUserById(2);
            ArrayList<String> disabilityTagsForUsers = dataInput.getDisabilityTags();
            ArrayList<String> disabilityTagsForExercises = temp.getDisabilityTags();

            List<String> common = new ArrayList<String>(disabilityTagsForUsers);
            common.retainAll(disabilityTagsForExercises);

            if(common.isEmpty())
            {
                listToBeFilled.add(temp.getName());
            }

        }

        return  listToBeFilled;*/
        List<String> listToBeFilled = new ArrayList<String>();
        List<ExercisesDetails> currentExercise = ExerciseDetailsDatabase.getInstance(getActivity()).exercisesDetailsDao().getExercisesByGroup(group);

        for ( ExercisesDetails temp: currentExercise)
        {
            listToBeFilled.add(temp.getName());
        }

        return  listToBeFilled;
    }
}