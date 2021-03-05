package com.example.lesson2_1dz;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    TextView textView;
    EditText edt1;
    EditText edt2;
    EditText edt3;
    final int resourceId = R.drawable.tachka;
    String firstNumber ,secondNumber ,thirdNumber;
    Integer result = 0;
    boolean mState = false;
    String resultIs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textResult);
        edt1 = findViewById(R.id.editTextText1);
        edt2 = findViewById(R.id.editTextText2);
        edt3 = findViewById(R.id.editTextText3);
        button = findViewById(R.id.button);
        if (savedInstanceState != null){
            mState = savedInstanceState.getBoolean("mState");
            resultIs = savedInstanceState.getString("result");
            textView.setText(resultIs);
        }
    }

    public void showResult(View view) {
        resultAndSavingData();
        changeOrientation();
    }
    public  void resultAndSavingData(){
        firstNumber = edt1.getText().toString();
        secondNumber =edt2.getText().toString();
        thirdNumber = edt3.getText().toString();
        try {
            result = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber) / Integer.parseInt(thirdNumber);
        }catch (Exception e){
            Toast toast = makeText(MainActivity.this,"Не получилось!",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP,160,0);
            toast.show();
        }
        resultIs=result.toString();

    }

    public void changeOrientation(){
        mState = !mState;
        if (!mState){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("mState",mState);
        outState.putString("result",resultIs);
    }

}