package in.mahabhujal.mahabhujal.ui.borewell;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import in.mahabhujal.mahabhujal.BorewellFormActivity;
import in.mahabhujal.mahabhujal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link borewellFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class borewellFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Button b_regform;
    public borewellFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment borewellFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static borewellFragment newInstance(String param1, String param2) {
        borewellFragment fragment = new borewellFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Nilesh","success");

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public void onClick(View v) {
        // implements your things
        Log.i("Nilesh","success 333");

        switch (v.getId()) {
            case R.id.but_registerborewell:
                Log.i("Nilesh","success 444");
                Intent intent = (new Intent(v.getContext(), BorewellFormActivity.class));
                startActivity(intent);
                break;
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // Inflate the layout for this fragment
        Log.i("Nilesh","success 222");
        View v = inflater.inflate(R.layout.fragment_borewell, container, false);
        b_regform = (Button) v.findViewById(R.id.but_registerborewell);
        b_regform.setOnClickListener(this);
        return v;
    }
}