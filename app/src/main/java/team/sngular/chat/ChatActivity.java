package team.sngular.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdiazmo on 18/1/17.
 */

public class ChatActivity extends AppCompatActivity {

    private Button sendButton;
    private ListView listView;
    private EditText editText;
    private ChatAdapter chatAdapter;
    private List<String> messagesArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);
        linkViews();
        loadViews();
        setListeners();

    }

    private void linkViews(){
        editText = (EditText) findViewById(R.id.editText);
        sendButton = (Button) findViewById(R.id.sendButton);
        listView = (ListView) findViewById(R.id.listView);
    }

    private void loadViews(){
        messagesArray = new ArrayList<String>();
        messagesArray.add("Hola");
        messagesArray.add("¿Qué tal?");
        chatAdapter = new ChatAdapter(this, messagesArray);
        listView.setAdapter(chatAdapter);
    }

    private void setListeners(){
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messagesArray.add(editText.getText().toString());
                chatAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

    }
}
