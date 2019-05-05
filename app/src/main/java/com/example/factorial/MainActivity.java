package com.example.factorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.factorial.interfaces.AnotherInterface;
import com.example.factorial.interfaces.MyInterface;

public class MainActivity extends AppCompatActivity implements MyInterface, AnotherInterface {


    EditText etvfrom;
    EditText etvto;
    Button btn_calculate;
    String numberfrom;
    String numberto;
    TextView tv;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.txt4);
        tv3 = (TextView) findViewById(R.id.txt3);
        tv3.setMovementMethod(new ScrollingMovementMethod());

        calculate();

        btn_calculate = (Button) findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etvfrom = (EditText) findViewById(R.id.etxtfrom);
                etvto = (EditText) findViewById(R.id.etxtto);
                numberfrom = etvfrom.getText().toString();
                numberto = etvto.getText().toString();
                tv3.setText("Calculating Factorial from" + numberfrom + "!to " + numberto + "!");
                tv.setText("");
                calculate();
            }
        });
    }

    public void calculate(){
        Factorial f = new Factorial(this, this);
        f.execute("2", "8");
    }

    @Override
    public void done(String result) {

    }

    @Override
    public void hello(String res, int a, int b) {

    }


    @Override
    public void thisIsAnotherMethodFromAnotherInterface(String result) {

    }
}



