package com.example.owner.adutility_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat; // for output format when displaying cost of utilities


public class MainMenu extends AppCompatActivity {
    private EditText gas_in, elec_in, misc_in, num_tenants_in;
    private TextView utility_tot_out, cost_per_person_out;
    double gas =0,elec_etc =0,misc =0, total_utility_cost = 0, cost_per_person =0;
    int num_tenants = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //link [user] input/output to local variables (widget instances?)
        gas_in=(EditText) findViewById(R.id.editText2);
        elec_in=(EditText) findViewById(R.id.editText3);
        misc_in=(EditText) findViewById(R.id.editText4);
        num_tenants_in=(EditText) findViewById(R.id.editText5);
        utility_tot_out=(TextView) findViewById(R.id.textView8);
        cost_per_person_out=(TextView) findViewById(R.id.textView9);

        //code to calculate costs once button clicked
        final Button button = findViewById(R.id.calculate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Code here executes on main thread after user presses button
                gas = Double.parseDouble(gas_in.getText().toString());//gas is now equal to a double version of the string brought in from the EditText
                elec_etc = Double.parseDouble(elec_in.getText().toString());
                misc = Double.parseDouble(misc_in.getText().toString());
                num_tenants = Integer.parseInt(num_tenants_in.getText().toString());
                //calculate cost of utilities
                total_utility_cost = gas + elec_etc + misc;
                cost_per_person = total_utility_cost/num_tenants;
                //format calculations to proper format "#,###.#0"   Ex:  $85.00 instead of $85.0
                DecimalFormat output_format = new DecimalFormat ("#,##0.00");
                String total_util,
                        per_pers_cost;
                total_util = output_format.format(total_utility_cost);
                per_pers_cost = output_format.format(cost_per_person);
                //display what was calculated
                utility_tot_out.setText(total_util);
                cost_per_person_out.setText(per_pers_cost);
            }
        });
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }
/*
    public void buttonOnClick(View v) {
        // do something when the button is clicked


    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
