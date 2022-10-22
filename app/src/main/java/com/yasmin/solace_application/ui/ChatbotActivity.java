package com.yasmin.solace_application.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.yasmin.solace_application.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChatbotActivity extends AppCompatActivity {


    private RecyclerView chatsRV;
    private ImageButton sendMsgIB;
    private EditText userMsgEdt;
    private final String USER_KEY = "user";
    private final String BOT_KEY = "bot";


    private RequestQueue RequestQueue;

    private ArrayList<MsgModal> chatModalArrayList;
    private ChatbotRVAdapter chatsRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        chatsRV = findViewById(R.id.idRVChats);
        sendMsgIB = findViewById(R.id.idIBSend);
        userMsgEdt = findViewById(R.id.idEdtMessage);

        RequestQueue = Volley.newRequestQueue(ChatbotActivity.this);
        RequestQueue.getCache().clear();

        chatModalArrayList = new ArrayList<>();

        sendMsgIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userMsgEdt.getText().toString().isEmpty()) {
                    Toast.makeText(ChatbotActivity.this, "Please enter your message..", Toast.LENGTH_SHORT).show();
                    return;
                }


                sendMessage(userMsgEdt.getText().toString());

                userMsgEdt.setText("");
            }
        });

        chatsRVAdapter = new ChatbotRVAdapter(chatModalArrayList, this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChatbotActivity.this, RecyclerView.VERTICAL, false);


        chatsRV.setLayoutManager(linearLayoutManager);


        chatsRV.setAdapter(chatsRVAdapter);
    }

    private void sendMessage(String userMsg) {

        chatModalArrayList.add(new MsgModal(userMsg, USER_KEY));
        chatsRVAdapter.notifyDataSetChanged();


        String url = "http://api.brainshop.ai/get?bid=169801&key=gOpx38XQRwRCt8F4&uid=[uid]&msg=" + userMsg;

        RequestQueue queue = Volley.newRequestQueue(ChatbotActivity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    String botResponse = response.getString("cnt");
                    chatModalArrayList.add(new MsgModal(botResponse, BOT_KEY));


                    chatsRVAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();


                    chatModalArrayList.add(new MsgModal("No response", BOT_KEY));
                    chatsRVAdapter.notifyDataSetChanged();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error handling.
                chatModalArrayList.add(new MsgModal("Sorry no response found", BOT_KEY));
                Toast.makeText(ChatbotActivity.this, "No response from the bot..", Toast.LENGTH_SHORT).show();
            }
        });


        queue.add(jsonObjectRequest);
    }
}
