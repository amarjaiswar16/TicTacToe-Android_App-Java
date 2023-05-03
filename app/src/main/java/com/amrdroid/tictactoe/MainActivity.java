package com.amrdroid.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int flag=0;
    int count=0;

    //Additional
    ImageButton refresh_imgBtn;
    TextView result_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInit();

        //restartGame
        refresh_imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
                refresh_imgBtn.setVisibility(View.INVISIBLE);
                result_txt.setText("");
                setButtonAnimation();
            }
        });
    }

    private void btnInit() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        //imageButton
        refresh_imgBtn = findViewById(R.id.refresh_imgBtn);
        result_txt = findViewById(R.id.result_txt);

    }
    public void check(View view) {
        Button current_btn = (Button) view;

        if(current_btn.getText().toString().equals("")) {

            //custom toast
            Toast toast = new Toast(MainActivity.this);
            View v = getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.contentHolder));
            toast.setView(v);
            TextView winner_txt = v.findViewById(R.id.winner_txt);
            ImageView trophy_img = v.findViewById(R.id.trophy_img);

            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM,0,0);

            count++;
            if (flag == 0) {
                current_btn.setText("X");
                flag = 1;
            } else {
                current_btn.setText("O");
                flag = 0;
            }

            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                //conditions
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    //1
                    winner_txt.setText(b1 +" is Winner ");
                    toast.show();
                   // Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_LONG).show();
                    refresh_imgBtn.setVisibility(View.VISIBLE);
                    result_txt.setText(b1 +" is Winner ");

                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    //2
                    winner_txt.setText(b2 + " is Winner! ");
                    toast.show();
                   // Toast.makeText(this, "Winner is " + b4, Toast.LENGTH_LONG).show();
                    refresh_imgBtn.setVisibility(View.VISIBLE);
                    result_txt.setText(b2 + " is Winner! ");
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    //3
                    winner_txt.setText(b7 + " is Winner! ");
                    toast.show();
                   // Toast.makeText(this, "Winner is " + b7, Toast.LENGTH_LONG).show();
                    refresh_imgBtn.setVisibility(View.VISIBLE);
                    result_txt.setText(b7 + " is Winner! ");
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    //4
                    winner_txt.setText(b1 + " is Winner! ");
                    toast.show();
                   // Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_LONG).show();
                    refresh_imgBtn.setVisibility(View.VISIBLE);
                    result_txt.setText(b1 + " is Winner! ");
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    //5
                    winner_txt.setText(b2 + " is Winner! ");
                    toast.show();
                   // Toast.makeText(this, "Winner is " + b2, Toast.LENGTH_LONG).show();
                    refresh_imgBtn.setVisibility(View.VISIBLE);
                    result_txt.setText(b2 + " is Winner! ");
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    //6
                    winner_txt.setText(b3 + " is Winner! ");
                    toast.show();
                   // Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_LONG).show();
                    refresh_imgBtn.setVisibility(View.VISIBLE);
                    result_txt.setText(b3 + " is Winner! ");
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    //7
                    winner_txt.setText(b1 + " is Winner! ");
                    toast.show();
                   // Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_LONG).show();
                    refresh_imgBtn.setVisibility(View.VISIBLE);
                    result_txt.setText(b1 + " is Winner! ");
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    //8
                    winner_txt.setText(b3 + " is Winner! ");
                    toast.show();
                   // Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_LONG).show();
                    refresh_imgBtn.setVisibility(View.VISIBLE);
                    result_txt.setText(b3 + " is Winner! ");
                } else if(!b1.equals("") && !b2.equals("") && !b3.equals("") &&
                          !b4.equals("") && !b5.equals("") && !b6.equals("") &&
                          !b7.equals("") && !b8.equals("") && !b9.equals("")) {

                    winner_txt.setText("Match is Draw!");
                    trophy_img.setVisibility(View.INVISIBLE);
                    toast.show();
                   // Toast.makeText(this, "Match is Draw!", Toast.LENGTH_SHORT).show();
                    refresh_imgBtn.setVisibility(View.VISIBLE);
                    result_txt.setText("Match is Draw!");
                }
            }

        }


    }
    public void newGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count=0;
        flag=0;
    }

    public void setButtonAnimation() {
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_in_left);
        btn1.startAnimation(animation);
        btn2.startAnimation(animation);
        btn3.startAnimation(animation);
        btn4.startAnimation(animation);
        btn5.startAnimation(animation);
        btn6.startAnimation(animation);
        btn7.startAnimation(animation);
        btn8.startAnimation(animation);
        btn9.startAnimation(animation);

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit?");
        builder.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        builder.setMessage("Are you sure want to exit?");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Welcome Back!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Operation Cancelled!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}