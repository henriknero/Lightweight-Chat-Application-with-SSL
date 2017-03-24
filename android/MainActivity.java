package com.henriknero.chatapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            socketClient();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final List<ChatMessage> listItems = new ArrayList<>();
        final ListView chatWindow = (ListView)findViewById(R.id.chatWindow);
        final MyListAdapter adapter = new MyListAdapter(this, listItems);
        chatWindow.setAdapter(adapter);
        final EditText editText = (EditText)findViewById(R.id.editText);
        Button sendButton = (Button)findViewById(R.id.sendButton);

        sendButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tempString = String.valueOf(editText.getText());
                        if(!tempString.isEmpty()) {
                            adapter.addListItem(new ChatMessage(tempString, "Henrik Nero"));
                            editText.setText("");
                        }
                    }
                }
        );

    }
    private void socketClient() throws IOException {
        Socket test = new Socket("192.168.1.218", 6789);
        test.close();
    }
}
/**
 * Links that were used during process
 * -----------------------------------
 *https://www.youtube.com/watch?v=Xn0tQHpMDnM&t=1532s
 */
