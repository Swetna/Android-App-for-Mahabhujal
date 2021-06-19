package in.mahabhujal.mahabhujal.ui.well;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import in.mahabhujal.mahabhujal.R;
import in.mahabhujal.mahabhujal.WellFormActivity;
import in.mahabhujal.mahabhujal.WellPumpHrs;
import in.mahabhujal.mahabhujal.WellPumpTest;
import in.mahabhujal.mahabhujal.WellSection;
import in.mahabhujal.mahabhujal.WellStruct;
import in.mahabhujal.mahabhujal.WellWaterLevel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WellFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WellFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button but_regwell;
    Button water_struct;
    Button well_level;
    Button well_section;
    Button pumping_hrs;
    Button pumping_test;

    public WellFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WellFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WellFragment newInstance(String param1, String param2) {
        WellFragment fragment = new WellFragment();
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
        // Inflate the layout for this fragment return inflater.inflate(R.layout.activity_well_main, container, false);
        View v = inflater.inflate(R.layout.activity_well_main, container, false);
        but_regwell= (Button) v.findViewById(R.id.but_registerwell);
        but_regwell.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WellFormActivity.class);
                startActivity(intent);
            }
        });

        water_struct= (Button) v.findViewById(R.id.w_water_struct_level);
        water_struct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), WellStruct.class);
                startActivity(intent1);
            }
        });


        well_level= (Button) v.findViewById(R.id.well_water_level);
       well_level.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity(), WellWaterLevel.class);
                startActivity(intent2);
            }
        });


        well_section= (Button) v.findViewById(R.id.well_section);
        well_section.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getActivity(), WellSection.class);
                startActivity(intent3);
            }
        });

        pumping_hrs= (Button) v.findViewById(R.id.pumping_hrs);
        pumping_hrs.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getActivity(), WellPumpHrs.class);
                startActivity(intent4);
            }
        });

        pumping_test= (Button) v.findViewById(R.id.pumping_test);
        pumping_test.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(getActivity(), WellPumpTest.class);
                startActivity(intent5);
            }
        });



        return v;
    }




    @Override
    public void onClick(View view) {

    }
}