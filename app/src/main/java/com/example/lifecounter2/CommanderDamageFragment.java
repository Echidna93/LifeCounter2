package com.example.lifecounter2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CommanderDamageFragment extends Fragment {
    public CommanderDamageFragment(){
    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "lifecounterfragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(container == null){
            return null;
        }
        View ll = inflater.inflate(R.layout.commander_damage, container, false);
        Log.d(TAG, "here");
        final List<Button> dButtons = new ArrayList<Button>();
        List<Button> iButtons = new ArrayList<Button>();
        int numPlayers = 4;
        final List<TextView> commanderDamageCounts = new ArrayList<TextView>();
        //setUpPoisonCountViews(ll, lifeCounts, numPlayers);

        TextView lifeCountView1 = (TextView) ll.findViewById(R.id.commanderDamageView1ID);
        lifeCountView1.setText("0");
        commanderDamageCounts.add(lifeCountView1);
        TextView commanderDamageView2 = (TextView) ll.findViewById(R.id.commanderDamageView2ID);
        commanderDamageView2.setText("0");
        commanderDamageCounts.add(commanderDamageView2);
        TextView commanderDamageView3 = (TextView) ll.findViewById(R.id.commanderDamageView3ID);
        commanderDamageView3.setText("0");
        commanderDamageCounts.add(commanderDamageView3);
        TextView commanderDamageView4 = (TextView) ll.findViewById(R.id.commanderDamageView4ID);
        commanderDamageView4.setText("0");
        commanderDamageCounts.add(commanderDamageView4);

        // decrease buttons

        Button decreaseCommanderDamageCountButtonView1 = (Button) ll.findViewById(R.id.decreaseCommanderDamageCountButtonView1ID);
        dButtons.add(decreaseCommanderDamageCountButtonView1);
        Button decreaseCommanderDamageCountButtonView2 = (Button) ll.findViewById(R.id.decreaseCommanderDamageCountButtonView2ID);
        dButtons.add(decreaseCommanderDamageCountButtonView2);
        Button decreaseCommanderDamageCountButtonView3 = (Button) ll.findViewById(R.id.decreaseCommanderDamageCountButtonView3ID);
        dButtons.add(decreaseCommanderDamageCountButtonView3);
        Button decreaseCommanderDamageCountButtonView4 = (Button) ll.findViewById(R.id.decreaseCommanderDamageCountButtonView4ID);
        dButtons.add(decreaseCommanderDamageCountButtonView4);

        //increase buttons
        Button increaseCommanderDamageCountButtonView1 = (Button) ll.findViewById(R.id.increaseCommanderDamageCountButtonView1ID);
        iButtons.add(increaseCommanderDamageCountButtonView1);
        Button increaseCommanderDamageCountButtonView2 = (Button) ll.findViewById(R.id.increaseCommanderDamageCountButtonView2ID);
        iButtons.add(increaseCommanderDamageCountButtonView2);
        Log.d(TAG, "here");
        Button increaseCommanderDamageCountButtonView3 = ll.findViewById(R.id.increaseCommanderDamageCountButtonView3ID);
        Log.d(TAG, "below increaseCommanderDamageCountButtonView3");
        iButtons.add(increaseCommanderDamageCountButtonView3);
        Button increaseCommanderDamageCountButtonView4 = (Button) ll.findViewById(R.id.increaseCommanderDamageCountButtonView4ID);
        iButtons.add(increaseCommanderDamageCountButtonView4);

        for(int i = 0; i < dButtons.size(); i++){
            Button iButton = iButtons.get(i);
            Button dButton = dButtons.get(i);
            final TextView commanderDamage = commanderDamageCounts.get(i);
            dButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int lTotal = Integer.parseInt(commanderDamage.getText().toString());
                    lTotal -= 1;
                    commanderDamage.setText(new String(String.valueOf(lTotal)));
                }
            });
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int lTotal = Integer.parseInt(commanderDamage.getText().toString());
                    lTotal += 1;
                    commanderDamage.setText(new String(String.valueOf(lTotal)));
                }
            });
        }
        // Inflate the layout for this fragment
        return ll;
    }

    private void changeCommanderDamageTotal(TextView view, Button b){
        String id = b.getResources().getResourceEntryName(b.getId());
        int commanderDamage = Integer.parseInt(view.getText().toString());
        if(id.contains("decrease")) {
            commanderDamage = commanderDamage - 1;
            view.setText(new String(String.valueOf(commanderDamage)));
        }
        else if(id.contains("increase")){
            commanderDamage = commanderDamage + 1;
            view.setText(new String(String.valueOf(commanderDamage)));
        }
    }
/*
    private void setUpCommanderDamageCountViews(View v, List list, int numPlayers){
        for(int i = 1; i <= numPlayers; i++){
            String n = "commanderDamageView" + i + "ID";
            TextView tv = (CommanderDamageCounterFragment) getView().findViewById(R.id.n);
            tv.setText("40");
            list.add(tv);
        }
    }

 */
}
