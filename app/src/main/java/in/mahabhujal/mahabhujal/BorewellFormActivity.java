package in.mahabhujal.mahabhujal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class BorewellFormActivity extends Activity {

    private TextView B_data;
    private EditText B_vol_name;
    private EditText B_owner_name;
    private EditText B_code;
    private EditText B_address;
    private EditText B_elevation;
    private EditText B_depth;
    private RadioButton B_public;
    private RadioButton B_private;
    private RadioButton  B_shared;
    private RadioButton  B_agri;
    private RadioButton  B_dome;
    private RadioButton B_others;
    private Button Submit;
    private TextView Bpurpose;
    private TextView Bown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borewell_form);


        B_data=(TextView) findViewById(R.id.bdata);
        Bpurpose=(TextView) findViewById(R.id.bpurpose);
        Bown=(TextView) findViewById(R.id.bownership);
        B_vol_name=(EditText) findViewById(R.id.vol_name);
        B_owner_name=(EditText) findViewById(R.id.b_owner);
        B_code=(EditText) findViewById(R.id.b_code);
        B_address=(EditText) findViewById(R.id.b_add);
        B_elevation=(EditText) findViewById(R.id.b_elevation);
        B_depth=(EditText) findViewById(R.id.b_depth);
        B_public=(RadioButton) findViewById(R.id.b_public);
        B_private=(RadioButton) findViewById(R.id.b_private);
        B_shared=(RadioButton) findViewById(R.id.b_shared);
        B_agri=(RadioButton) findViewById(R.id.b_agri);
        B_dome=(RadioButton) findViewById(R.id.b_dome);
        B_others=(RadioButton) findViewById(R.id.b_others);
        Submit=(Button) findViewById(R.id.submit);

    }

    //private void valid(String code,String own_name,String vol_name){
    //   if(code=="1234")
    //}
}