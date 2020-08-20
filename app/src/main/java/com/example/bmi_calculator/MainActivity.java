package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText height,weight;
    Button calculate;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height=(EditText)findViewById(R.id.height);
        weight=(EditText)findViewById(R.id.weight);
        calculate=(Button)findViewById(R.id.calc);
        answer=(TextView)findViewById(R.id.ans);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String h=height.getText().toString();
                String w=weight.getText().toString();
                if(h!=null&&!h.equals("")&&w!=null&&!w.equals(""))
                {
                    float ht=Float.parseFloat(h);
                    float wt=Float.parseFloat(w);
                    float bmi=(wt/(ht*ht))*10000;
                    answer.setText(String.valueOf(bmi));
                    if(bmi <18.5) {
                        Toast.makeText(MainActivity.this, "You are Underweight!", Toast.LENGTH_SHORT).show();
                    }
                    else if(bmi>18.5 && bmi<24.9) {
                        Toast.makeText(MainActivity.this, "You have Normal Weight.", Toast.LENGTH_SHORT).show();
                    }
                    else if(bmi>24.9 && bmi<30){
                        Toast.makeText(MainActivity.this, "You are Overweight!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Obesity!!", Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(MainActivity.this, "Please Enter Height And Weight", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}