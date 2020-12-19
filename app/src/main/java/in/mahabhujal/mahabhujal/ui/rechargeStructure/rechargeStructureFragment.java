package in.mahabhujal.mahabhujal.ui.rechargeStructure;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import in.mahabhujal.mahabhujal.CalculateRecharge;
import in.mahabhujal.mahabhujal.R;
import in.mahabhujal.mahabhujal.ui.AddStructFragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link rechargeStructureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class rechargeStructureFragment extends Fragment implements View.OnClickListener  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button but_add_recharge,cal_volume;

    public rechargeStructureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment rechargeStructureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static rechargeStructureFragment newInstance(String param1, String param2) {
        rechargeStructureFragment fragment = new rechargeStructureFragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recharge_structure, container, false);
        but_add_recharge = (Button) v.findViewById(R.id.but_recharge);
        but_add_recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddStructFragment.class);
                startActivity(intent);
            }
        });
        cal_volume=(Button) v.findViewById(R.id.cal_volume);
        cal_volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = (new Intent(v.getContext(), CalculateRecharge.class));
                startActivity(intent1);
            }
        });
        return v;





        /*


    @Override
    public void onClick(View v){

            Log.i("Nilesh", "success 333");
            Intent intent = new Intent(getActivity(), AddStructFragment.class);
            startActivity(intent);

        }
        /*
        switch (v.getId()) {

            //case R.id.but_recharge:
                //Log.i("Nilesh","success 444");
                //Intent intent = (new Intent(v.getContext(), AddStructFragment.class));
                //startActivity(intent);
                //break;
           case R.id.cal_volume:
            Log.i("Nilesh","success 444");
            Intent intent1 = (new Intent(v.getContext(), CalculateRecharge.class));
            startActivity(intent1);
            break;


        }

         */


    }

    @Override
    public void onClick(View v) {

    }



}
