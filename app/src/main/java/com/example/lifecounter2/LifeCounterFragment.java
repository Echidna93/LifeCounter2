package com.example.lifecounter2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LifeCounterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LifeCounterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "lifecounterfragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LifeCounterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LifeCounterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LifeCounterFragment newInstance(String param1, String param2) {
        LifeCounterFragment fragment = new LifeCounterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        View ll = inflater.inflate(R.layout.life_counter, container, false);
        Log.d(TAG, "here");
        final List<Button> dButtons = new ArrayList<Button>();
        List<Button> iButtons = new ArrayList<Button>();
        final List<TextView> lifeCounts = new ArrayList<TextView>();
        TextView lifeCountView1 = (TextView) ll.findViewById(R.id.lifeCountView1ID);
        lifeCountView1.setText("40");
        lifeCounts.add(lifeCountView1);
        TextView lifeCountView2 = (TextView) ll.findViewById(R.id.lifeCountView2ID);
        lifeCountView2.setText("40");
        lifeCounts.add(lifeCountView2);
        TextView lifeCountView3 = (TextView) ll.findViewById(R.id.lifeCountView3ID);
        lifeCountView3.setText("40");
        lifeCounts.add(lifeCountView3);
        TextView lifeCountView4 = (TextView) ll.findViewById(R.id.lifeCountView4ID);
        lifeCountView4.setText("40");
        lifeCounts.add(lifeCountView4);
        // decrease buttons
        Button decreaseLifeCountButtonView1 = (Button) ll.findViewById(R.id.decreaseLifeCountButtonView1ID);
        dButtons.add(decreaseLifeCountButtonView1);
        Button decreaseLifeCountButtonView2 = (Button) ll.findViewById(R.id.decreaseLifeCountButtonView2ID);
        dButtons.add(decreaseLifeCountButtonView2);
        Button decreaseLifeCountButtonView3 = (Button) ll.findViewById(R.id.decreaseLifeCountButtonView3ID);
        dButtons.add(decreaseLifeCountButtonView3);
        Button decreaseLifeCountButtonView4 = (Button) ll.findViewById(R.id.decreaseLifeCountButtonView4ID);
        dButtons.add(decreaseLifeCountButtonView4);

        //increase buttons
        Button increaseLifeCountButtonView1 = (Button) ll.findViewById(R.id.increaseLifeCountButtonView1ID);
        iButtons.add(increaseLifeCountButtonView1);
        Button increaseLifeCountButtonView2 = (Button) ll.findViewById(R.id.increaseLifeCountButtonView2ID);
        iButtons.add(increaseLifeCountButtonView2);
        Log.d(TAG, "here");
        Button increaseLifeCountButtonView3 = ll.findViewById(R.id.increaseLifeCountButtonView3ID);
        Log.d(TAG, "below increaseLifeCountButtonView3");
        iButtons.add(increaseLifeCountButtonView3);
        Button increaseLifeCountButtonView4 = (Button) ll.findViewById(R.id.increaseLifeCountButtonView4ID);
        iButtons.add(increaseLifeCountButtonView4);

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

    private void changeLifeTotal(TextView view, Button b){
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
    private void setUpLifeCountViews(int numPlayers){
        for(int i = 0; i < numPlayers; i++){
            int id = getResources().getIdentifier()
        }
    }
*/
}
