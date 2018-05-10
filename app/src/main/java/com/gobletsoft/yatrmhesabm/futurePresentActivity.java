package com.gobletsoft.yatrmhesabm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class futurePresentActivity extends AppCompatActivity {

    private String explanationText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_future_present);

        Button btnCalculate = findViewById(R.id.buttonCalculate);
        final EditText etInvestmentValue = findViewById(R.id.editTextInvestmentValue);
        final EditText etInterestRate = findViewById(R.id.editTextInterestRate);
        final EditText etPeriod = findViewById(R.id.editTextPeriod);
        final TextView tvResult = findViewById(R.id.textViewResult);
        final TextView tvExplanation = findViewById(R.id.textViewExplanation);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etInvestmentValue.getText().toString().isEmpty() || etInterestRate.getText().toString().isEmpty() || etPeriod.getText().toString().isEmpty()){

                    Toast.makeText(getApplicationContext(), "skdjf", Toast.LENGTH_LONG).show();
                }

                else{

                    Double InvestmentValue = Double.parseDouble(etInvestmentValue.getText().toString());
                    Double InterestRate = Double.parseDouble(etInterestRate.getText().toString());
                    Integer Period = Integer.parseInt(etPeriod.getText().toString());

                    Double Result = InvestmentValue * Math.pow((1 + (InterestRate / 100)), Period);

                    Result = Math.floor(Result * 100) / 100;



                    explanationText = Period.toString() + " " + getString(R.string.aciklama);

                    tvExplanation.setText(explanationText);

                    tvResult.setText(Result.toString());
                }
            }
        });
    }
}
