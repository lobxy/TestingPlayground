package com.lobxy.testingplayground;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit;
    TextView text;
    CheckBox check_toast;
    CheckBox check_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.main_text);

        edit = findViewById(R.id.main_edit);

        check_toast = findViewById(R.id.main_check_toast);
        check_dialog = findViewById(R.id.main_check_dialog);

        Button btn_set_text = findViewById(R.id.main_btn_set_text);
        Button btn_showAlert = findViewById(R.id.main_btn_show_alert);
        Button btn_start_activity = findViewById(R.id.main_btn_start_new_activity);

        btn_set_text.setOnClickListener(this);
        btn_showAlert.setOnClickListener(this);
        btn_start_activity.setOnClickListener(this);

        text.setText("Main Activity");

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.main_btn_set_text:
                text.setText(edit.getText().toString().trim());
                break;
            case R.id.main_btn_show_alert:
                showAlert();
                break;
            case R.id.main_btn_start_new_activity:
                startActivity(new Intent(MainActivity.this, SecondaryActivity.class));
                break;
            default:
                break;
        }
    }

    private void showAlert() {
        if (check_toast.isChecked()) {
            Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
        } else if (check_dialog.isChecked()) {
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("Alert")
                    .setMessage("Alert Dialog")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog alertDialog = b.create();
            alertDialog.show();

        } else {
            text.setText("No option is checked");
        }
    }
}
