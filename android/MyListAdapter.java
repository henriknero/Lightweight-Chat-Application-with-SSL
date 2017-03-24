package com.henriknero.chatapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.text.format.DateFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henri on 2017-03-21.
 */

public class MyListAdapter extends BaseAdapter {

    Context context;
    List<ChatMessage> messages;
    private static LayoutInflater inflater = null;

    public MyListAdapter(Context context, List<ChatMessage> messages)
    {
        this.context = context;
        this.messages = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++){
            this.messages.add(new ChatMessage(messages.get(i).getMessageText(),messages.get(i).getMessageUser(),messages.get(i).getMessageTime()));
        }
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount(){
        return messages.size();
    }

    @Override
    public Object getItem(int position){
        return messages.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;
        if(vi == null) {
            vi = inflater.inflate(R.layout.list_item, null);
        }
        TextView messageText = (TextView)vi.findViewById(R.id.message_text);
        TextView messageUser = (TextView)vi.findViewById(R.id.message_user);
        TextView messageTime = (TextView)vi.findViewById(R.id.message_time);
        messageText.setText(messages.get(position).getMessageText());
        messageUser.setText(messages.get(position).getMessageUser());
        messageTime.setText(DateFormat.format("dd/MM-yy (HH:mm)" ,messages.get(position).getMessageTime()));

        return vi;
    }

    public void addListItem(ChatMessage message) {
        this.messages.add(message);
        this.notifyDataSetChanged();
    }

}
/**
 * Links that were used during process
 * -----------------------------------
 *http://stackoverflow.com/questions/15832335/android-custom-row-item-for-listview
 */
