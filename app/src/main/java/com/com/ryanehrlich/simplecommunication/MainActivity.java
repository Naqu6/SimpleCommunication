package com.com.ryanehrlich.simplecommunication;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private String IP = "10.25.1.242";
    private final int PORT = 5005;

    protected Networking connection;
    protected EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button send = (Button) findViewById(R.id.send);
        this.text = (EditText) findViewById(R.id.data);

        send.setVisibility(View.INVISIBLE);
        send.setClickable(false);

        boolean passed = true;

        try {
            this.connection = new Networking(IP, PORT);
        } catch (Exception e){
            this.connection = null;
            passed = false;
            e.printStackTrace();
        }
        if (passed) {
            send.setVisibility(View.VISIBLE);
            send.setClickable(true);

            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    connection.send(text.getText().toString());
                    try {
                        Log.d("Recivded Data", connection.recive());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            TextView msg = (TextView) findViewById(R.id.msg);
            msg.setText("There was an error while creating the socket");
        }
    }
}
