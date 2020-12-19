package in.mahabhujal.mahabhujal.ui.waterQuality;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import in.mahabhujal.mahabhujal.R;
import in.mahabhujal.mahabhujal.WaterQualityData;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WaterQualityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WaterQualityFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button but_water_quality_data;

    public WaterQualityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WaterQualityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WaterQualityFragment newInstance(String param1, String param2) {
        WaterQualityFragment fragment = new WaterQualityFragment();
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
        // Inflate the layout for this fragmentreturn inflater.inflate(R.layout.fragment_water_qualty, container, false);
        View v = inflater.inflate(R.layout.fragment_water_qualty, container, false);
        but_water_quality_data= (Button) v.findViewById(R.id.but_water_quality_data);
        but_water_quality_data.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), WaterQualityData.class);
                startActivity(intent1);
            }
        });

    return v;
    }

    @Override
    public void onClick(View view) {

    }
}