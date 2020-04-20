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

public class PoisonCounterFragment extends Fragment {
public PoisonCounterFragment(){
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
        View ll = inflater.inflate(R.layout.poison_counter, container, false);
        Log.d(TAG, "here");
        final List<Button> dButtons = new ArrayList<Button>();
        List<Button> iButtons = new ArrayList<Button>();
        int numPlayers = 4;
        final List<TextView> lifeCounts = new ArrayList<TextView>();
        //setUpPoisonCountViews(ll, lifeCounts, numPlayers);

        TextView lifeCountView1 = (TextView) ll.findViewById(R.id.poisonCountView1ID);
        lifeCountView1.setText("0");
        lifeCounts.add(lifeCountView1);
        TextView lifeCountView2 = (TextView) ll.findViewById(R.id.lifeCountView2ID);
        lifeCountView2.setText("0");
        lifeCounts.add(lifeCountView2);
        TextView lifeCountView3 = (TextView) ll.findViewById(R.id.lifeCountView3ID);
        lifeCountView3.setText("0");
        lifeCounts.add(lifeCountView3);
        TextView lifeCountView4 = (TextView) ll.findViewById(R.id.lifeCountView4ID);
        lifeCountView4.setText("0");
        lifeCounts.add(lifeCountView4);

        // decrease buttons

        Button decreasePoisonCountButtonView1 = (Button) ll.findViewById(R.id.decreasePoisonCountButtonView1ID);
        dButtons.add(decreasePoisonCountButtonView1);
        Button decreasePoisonCountButtonView2 = (Button) ll.findViewById(R.id.decreasePoisonCountButtonView2ID);
        dButtons.add(decreasePoisonCountButtonView2);
        Button decreasePoisonCountButtonView3 = (Button) ll.findViewById(R.id.decreasePoisonCountButtonView3ID);
        dButtons.add(decreasePoisonCountButtonView3);
        Button decreasePoisonCountButtonView4 = (Button) ll.findViewById(R.id.decreasePoisonCountButtonView4ID);
        dButtons.add(decreasePoisonCountButtonView4);

        //increase buttons
        Button increasePoisonCountButtonView1 = (Button) ll.findViewById(R.id.increasePoisonCountButtonView1ID);
        iButtons.add(increasePoisonCountButtonView1);
        Button increasePoisonCountButtonView2 = (Button) ll.findViewById(R.id.increasePoisonCountButtonView2ID);
        iButtons.add(increasePoisonCountButtonView2);
        Log.d(TAG, "here");
        Button increasePoisonCountButtonView3 = ll.findViewById(R.id.increasePoisonCountButtonView3ID);
        Log.d(TAG, "below increasePoisonCountButtonView3");
        iButtons.add(increasePoisonCountButtonView3);
        Button increasePoisonCountButtonView4 = (Button) ll.findViewById(R.id.increasePoisonCountButtonView4ID);
        iButtons.add(increasePoisonCountButtonView4);

        for(int i = 0; i < dButtons.size(); i++){
            Button iButton = iButtons.get(i);
            Button dButton = dButtons.get(i);
            final TextView lifeCount = lifeCounts.get(i);
            dButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int lTotal = Integer.parseInt(lifeCount.getText().toString());
                    lTotal -= 1;
                    lifeCount.setText(new String(String.valueOf(lTotal)));
                }
            });
            iButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int lTotal = Integer.parseInt(lifeCount.getText().toString());
                    lTotal += 1;
                    lifeCount.setText(new String(String.valueOf(lTotal)));
                }
            });
        }
        // Inflate the layout for this fragment
        return ll;
    }

    private void changePoisonTotal(TextView view, Button b){
        String id = b.getResources().getResourceEntryName(b.getId());
        int lifeCount = Integer.parseInt(view.getText().toString());
        if(id.contains("decrease")) {
            lifeCount = lifeCount - 1;
            view.setText(new String(String.valueOf(lifeCount)));
        }
        else if(id.contains("increase")){
            lifeCount = lifeCount + 1;
            view.setText(new String(String.valueOf(lifeCount)));
        }
    }
/*
    private void setUpPoisonCountViews(View v, List list, int numPlayers){
        for(int i = 1; i <= numPlayers; i++){
            String n = "lifeCountView" + i + "ID";
            TextView tv = (PoisonCounterFragment) getView().findViewById(R.id.n);
            tv.setText("40");
            list.add(tv);
        }
    }

 */
}
