package com.com.ryanehrlich.simplecommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String IP = "10.25.1.242";
    private final int PORT = 25546;

    protected Networking connection;
    protected EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.connection = new Networking(IP, PORT);

        Button send = (Button) findViewById(R.id.send);
        this.text = (EditText) findViewById(R.id.data);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connection.send(text.getText().toString());
            }
        });
    }
}
