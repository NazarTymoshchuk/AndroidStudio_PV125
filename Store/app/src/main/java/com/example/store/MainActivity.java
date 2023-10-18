package com.example.store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

enum Action
{
    PLUS,
    SUBSTRACTION,
    MULTIPLY,
    DIVISION
}


public class MainActivity extends AppCompatActivity {
    private TextView result;
    private String text = "";
    private Action action = Action.PLUS;
    private double num1 = 0;
    private double num2 = 0;
    private boolean turn = true;
    private boolean IsActive = true;
    private double res = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
    }

    public void onClickNumber(View view) {
        if (IsActive) {
            Button button = (Button) view;
            String buttonText = button.getText().toString();
            text += buttonText;
            result.setText(text);
        }
        else {
            result.setText(" ");
            text = "";

            Button button = (Button) view;
            String buttonText = button.getText().toString();
            text += buttonText;
            result.setText(text);

            IsActive = true;
        }
    }

    public void onClickDot(View view) {
        if (IsActive) {
            Button button = (Button) view;
            String buttonText = button.getText().toString();

            if (!text.contains(".")) {
                text += buttonText;
                result.setText(text);
            }
        }
        else {
            result.setText(" ");
            text = "";

            Button button = (Button) view;
            String buttonText = button.getText().toString();

            if (!text.contains(".")) {
                text += buttonText;
                result.setText(text);
                IsActive = true;
            }
        }
    }

    public void onClickAction(View view) {

        IsActive = false;

        DoAction();

        Button button = (Button) view;

        setAction(button.getText().toString());

        if (!turn)
            num1 = res;

        else
            num2 = res;
    }

    private void setAction(String act)
    {
        switch (act)
        {
            case "+":
                action = Action.PLUS;
                break;
            case "-":
                action = Action.SUBSTRACTION;
                break;
            case "*":
                action = Action.MULTIPLY;
                break;
            case "/":
                action = Action.DIVISION;
                break;
        }
    }

    private void DoAction()
    {
        String txtNum = result.getText().toString();

        if (turn) {
            num1 = Double.valueOf(txtNum);
            turn = false;
        }
        else {
            num2 = Double.valueOf(txtNum);
            turn = true;
        }

        switch (action)
        {
            case PLUS:
                res = num1 + num2;
                result.setText(String.valueOf(res));
                break;
            case SUBSTRACTION:
                if (turn)
                    res = num1 - num2;
                else
                    res = num2 - num1;
                result.setText(String.valueOf(res));
                break;
            case MULTIPLY:
                res = num1 * num2;
                result.setText(String.valueOf(res));
                break;
            case DIVISION:
                if (turn)
                    res = num1 / num2;
                else
                    res = num2 / num1;

                result.setText(String.valueOf(res));
                break;
        }


    }

    public void onClickResult(View view)
    {
        DoAction();
    }
}