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

public class MainActivity extends Activity {

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

        /*
        btn.setOnTouchListener( new BtnListener() );
        btn.setOnKeyListener(new BtnKeyListener());
        */

        btn.setOnClickListener( new BtnClickListener() );

    }

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


}












