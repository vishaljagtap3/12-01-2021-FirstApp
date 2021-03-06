package in.bitcode.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class NextAct extends Activity {

    private TextView txtInfo;
    private EditText edtInfo;
    private Button btnSetAndFinish;

    private LinearLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        container.setLayoutParams(layoutParams);

        txtInfo = new TextView(this);
        txtInfo.setText("Android@BitCode");
        txtInfo.setTextSize(40);
        txtInfo.setLayoutParams(layoutParams);
        container.addView(txtInfo);

        edtInfo = new EditText(this);
        edtInfo.setLayoutParams(layoutParams);
        container.addView(edtInfo);

        btnSetAndFinish = new Button(this);
        btnSetAndFinish.setText("Set and Finish");
        btnSetAndFinish.setLayoutParams(layoutParams);
        container.addView(btnSetAndFinish);

        setContentView(container);

        //Extract input
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String name = bundle.getString("name", "NA");
        int code = bundle.getInt("code", -1);

        txtInfo.setText(name + " " + code);

        btnSetAndFinish.setOnClickListener(new BtnSetAndFinishClickListener() );

    }

    class BtnSetAndFinishClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent();
            intent.putExtra("result", edtInfo.getText().toString());
            setResult(1, intent);
            finish();
        }
    }


}












