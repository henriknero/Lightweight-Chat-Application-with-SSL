package com.henriknero.chatapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Skapa lista och lägg in den in listadaptern
        final List<ChatMessage> listItems = new ArrayList<>();
        final MyListAdapter adapter = new MyListAdapter(this, listItems);

        //Koppla listView i activity_main till variabeln ListView och applicera adaptern
        final ListView chatWindow = (ListView)findViewById(R.id.chatWindow);
        chatWindow.setAdapter(adapter);

        //Create EditText and Button variable and connect it to the editText and sendButton in activity_main
        final EditText editText = (EditText)findViewById(R.id.editText);
        Button sendButton = (Button)findViewById(R.id.sendButton);

        //Create sendButton Listener that sends messages.
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
    class Thread extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params){
            String temp = "";
            try {
                Socket socket = new Socket("10.0.2.2", 6789);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return temp;
        }
        @Override
        protected void onPostExecute(String result){
            EditText editText = (EditText)findViewById(R.id.editText);
            editText.setText(result);
        }
    }
}
