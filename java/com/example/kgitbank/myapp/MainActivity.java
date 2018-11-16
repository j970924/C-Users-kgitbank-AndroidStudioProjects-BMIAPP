package com.example.kgitbank.myapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText num = findViewById(R.id.num); /*값 유지 -> 속성*/
        final TextView result = findViewById(R.id.result);
        // inner class
        class Calc{
            private int num, res; // 인스턴스 변수
            String op;
            public void exe() {
                switch (op) {
                    case "+":
                        res += num;
                        break;
                    case "-":
                        res -= num;
                        break;
                    case "x":
                        res *= num;
                        break;
                    case "/":
                        res /= num;
                        break;
                }
            }
            public void setNum(int num){this.num=num;}
            public void setRes(int res){this.res=res;}
            public void setOp(String op){this.op=op;}
            public int getNum(){return this.num;}
            public int getRes(){return this.res;}
            public String getOp(){return this.op;}
        }

        final Calc calc = new Calc();

        final Context ctx = MainActivity.this;
        /*이벤트 -> 기능 처리 */
        findViewById(R.id.plusBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num.getText().toString());
                Log.d("입력값",a+"");
                calc.setNum(a);
                int b = Integer.parseInt(num.getText().toString());
                Log.d("입력값",b+"");
                calc.setOp("+");
                calc.exe();
                int c = calc.getRes();
                Log.d("결과값",c+"");

            }
        });

        findViewById(R.id.minusBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num.getText().toString());
                calc.setNum(a);
                calc.setOp("-");
                calc.exe();
                int c = calc.getRes();
                Toast.makeText(ctx,"뺼셈 결과 : "+ c ,Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.multiplyBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num.getText().toString());
                calc.setNum(a);
                calc.setOp("x");
                calc.exe();
                int c = calc.getRes();
                Toast.makeText(ctx,"곱셈 결과 : "+ c ,Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.divideBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num.getText().toString());
                calc.setNum(a);
                calc.setOp("/");
                calc.exe();
                int c = calc.getRes();
                Toast.makeText(ctx,"나눗셈 결과 : "+ c ,Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.resultBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(calc.getRes());
            }
        });
    }
}
