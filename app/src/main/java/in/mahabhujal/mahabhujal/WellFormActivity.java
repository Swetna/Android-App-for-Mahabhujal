package in.mahabhujal.mahabhujal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class WellFormActivity extends AppCompatActivity {

    private TextView W_data;
    private EditText W_vol_name;
    private EditText W_owner_name;
    private EditText W_code;
    private EditText W_address;
    private EditText W_elevation;
    private EditText W_depth;
    private RadioButton W_public;
    private RadioButton W_private;
    private RadioButton  W_shared;
    private RadioButton  W_agri;
    private RadioButton  W_dome;
    private RadioButton W_others;
    private Button Submit;
    private TextView Wpurpose;
    private TextView Wown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well_form);

        W_data=(TextView) findViewById(R.id.wdata);
        Wpurpose=(TextView) findViewById(R.id.wpurpose);
        Wown=(TextView) findViewById(R.id.wownership);
        W_vol_name=(EditText) findViewById(R.id.vol_name);
       // W_owner_name=(EditText) findViewById(R.id.w_own);
        W_code=(EditText) findViewById(R.id.w_code);
       // W_address=(EditText) findViewById(R.id.w_add);
        W_elevation=(EditText) findViewById(R.id.w_elevation);
        W_depth=(EditText) findViewById(R.id.w_depth);
        W_public=(RadioButton) findViewById(R.id.w_public);
        W_private=(RadioButton) findViewById(R.id.w_private);
        W_shared=(RadioButton) findViewById(R.id.w_shared);
        W_agri=(RadioButton) findViewById(R.id.w_agri);
        W_dome=(RadioButton) findViewById(R.id.w_dome);
        W_others=(RadioButton) findViewById(R.id.w_others);
        Submit=(Button) findViewById(R.id.submit);

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

        }
    }
}
