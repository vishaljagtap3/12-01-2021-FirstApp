package in.bitcode.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    private TextView txt;
    private EditText edt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        edt = findViewById(R.id.edt);
        btn = findViewById(R.id.btn);

        txt.setTextColor(Color.RED);

        txt.setText(R.string.app_name);
        int res = 200;
        txt.setText(res + "");

        /*
        btn.setOnTouchListener( new BtnListener() );
        btn.setOnKeyListener(new BtnKeyListener());
        */

        //btn.setOnClickListener( new BtnClickListener() );

        //way 2
        /*ViewClickListener viewClickListener = new ViewClickListener();
        txt.setOnClickListener(viewClickListener);
        btn.setOnClickListener(viewClickListener);*/

        //way 3
        /*txt.setOnClickListener(this);
        btn.setOnClickListener(this);*/

        txt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txt.setText("");
                    }
                }
        );

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(edt.getText().toString());
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view == txt) {
            txt.setText("");
        }
        if (view.getId() == R.id.btn) {
            txt.setText(edt.getText().toString());
            //finish();
        }
    }

    //way 2
    class ViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view == txt) {
                txt.setText("");
            }
            if (view.getId() == R.id.btn) {
                txt.setText(edt.getText().toString());
            }
        }
    }


    /*

    private class TxtClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            txt.setText("");
        }
    }

    private class BtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            txt.setText(edt.getText().toString());
        }
    }

    class BtnKeyListener implements View.OnKeyListener {

        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {

            return false;
        }
    }

    class BtnListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

     */


}












