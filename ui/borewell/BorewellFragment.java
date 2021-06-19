package in.mahabhujal.mahabhujal.ui.borewell;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import in.mahabhujal.mahabhujal.BorewellFormActivity;
import in.mahabhujal.mahabhujal.BorewellLevel;
import in.mahabhujal.mahabhujal.BorewellPumpHrs;
import in.mahabhujal.mahabhujal.BorewellSection;
import in.mahabhujal.mahabhujal.BorewellStruct;
import in.mahabhujal.mahabhujal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BorewellFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BorewellFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button but_regborewell;
    Button borewell_water_struct;
    Button borewell_level;
    Button borewell_section;
    Button borewell_pumping_hrs;

    public BorewellFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BorewellFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BorewellFragment newInstance(String param1, String param2) {
        BorewellFragment fragment = new BorewellFragment();
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
        // Inflate the layout for this fragment return inflater.inflate(R.layout.activity_borewell_main, container, false);

        View v = inflater.inflate(R.layout.activity_borewell_main, container, false);
        but_regborewell= (Button) v.findViewById(R.id.but_registerborewell);
        but_regborewell.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BorewellFormActivity.class);
                startActivity(intent);
            }
        });

        borewell_water_struct= (Button) v.findViewById(R.id.b_water_struct);
       borewell_water_struct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), BorewellStruct.class);
                startActivity(intent1);
            }
        });


        borewell_level= (Button) v.findViewById(R.id.b_water_level);
        borewell_level.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity(), BorewellLevel.class);
                startActivity(intent2);
            }
        });


        borewell_section= (Button) v.findViewById(R.id.bore_sect);
        borewell_section.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getActivity(), BorewellSection.class);
                startActivity(intent3);
            }
        });

        borewell_pumping_hrs= (Button) v.findViewById(R.id.b_pump_hrs);
        borewell_pumping_hrs.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getActivity(), BorewellPumpHrs.class);
                startActivity(intent4);
            }
        });




    return v;
    }


    @Override
    public void onClick(View view) {

    }
}