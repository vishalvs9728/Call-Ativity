package com.example.admin.call_activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener, Runnable{

    TextView tv;
    Button btn1,btn2,btn3;
    EditText edt;
    ImageView image1;
    LinearLayout li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.t1);
        edt=(EditText)findViewById(R.id.ed1);

        btn1=(Button)findViewById(R.id.b1);
        btn2=(Button)findViewById(R.id.b2);
        btn3=(Button)findViewById(R.id.b3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


    }


    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.b1:
            Intent i=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edt.getText().toString()));
                startActivity(i);
                break;
            case R.id.b2:
                if(edt.getText().toString().length()==0)
                {
                    Toast.makeText(MainActivity.this, "Enter No.", Toast.LENGTH_SHORT).show();}
                else {

                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }break;
            case R.id.b3:

                if(edt.getText().toString().length()==1||edt.getText().toString().length()==0)
                {edt.setText(null);}
                else
                {
                   long x = Long.valueOf(edt.getText().toString());
                    x=x/10;

                    edt.setText(String.valueOf(x));
                }
                edt.setSelection(edt.getText().length());
                //edt.setText((edt.getText().toString().length())-1);
        }

    }

    @Override
    public void run() {

    }
}
