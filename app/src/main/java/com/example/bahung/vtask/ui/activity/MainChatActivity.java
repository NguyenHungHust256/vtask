package com.example.bahung.vtask.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.bean.Group;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

import java.util.ArrayList;

public class MainChatActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    Toolbar toolbar;
    ImageView backHome;
    EditText edtChat;
    ArrayList<Group> dataGroup;
    ImageView chatIcon, timeChatIcon, bankingChatIcon, documentChatIcon, memberChatIcon, backChatIcon, sendChatIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);
        anhXa();
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        backHome.setOnClickListener(this);
        edtChat.setOnFocusChangeListener(this);
    }

    private void anhXa() {
        toolbar = findViewById(R.id.toolbar_main_chat);
        backHome = findViewById(R.id.back_home_id);
        edtChat =  findViewById(R.id.edtInput);
        chatIcon = findViewById(R.id.chat_id);
        timeChatIcon = findViewById(R.id.time_id);
        bankingChatIcon = findViewById(R.id.banking_id);
        documentChatIcon = findViewById(R.id.document_id);
        memberChatIcon = findViewById(R.id.member_chat_id);
        backChatIcon = findViewById(R.id.back_chat_id);
        sendChatIcon = findViewById(R.id.send_chat_id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_main_chat, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.back_home_id){
            view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.animate_imageview));
            Intent intent = new Intent(MainChatActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(v.getId() == R.id.edtInput){
            KeyboardVisibilityEvent.setEventListener(
                    MainChatActivity.this,
                    new KeyboardVisibilityEventListener() {
                        @Override
                        public void onVisibilityChanged(boolean isOpen) {
                            if(isOpen){
                                LinearLayout layout = (LinearLayout)findViewById(R.id.layout_chat_id);
//                                layout.setWeightSum(5f);
                                LinearLayout.LayoutParams lParams = (LinearLayout.LayoutParams) layout.getLayoutParams(); //or create new LayoutParams...

                                lParams.weight = 6.5f;
                                layout.setLayoutParams(lParams);


                                backChatIcon.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT,0.75f));
                                sendChatIcon.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT,0.75f));
                                setVisibleOrGoneIcon(View.GONE, View.VISIBLE);
                                backChatIcon.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        returnDefautMainChat();
                                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                                    }
                                });
                            } else {
                                edtChat.clearFocus();
                                returnDefautMainChat();
                            }
                        }

                        private void returnDefautMainChat() {

                            LinearLayout layout = (LinearLayout)findViewById(R.id.layout_chat_id);
//                                layout.setWeightSum(5f);
                            LinearLayout.LayoutParams lParams = (LinearLayout.LayoutParams) layout.getLayoutParams(); //or create new LayoutParams...
                            lParams.weight = 3f;
                            layout.setLayoutParams(lParams);
                            setVisibleOrGoneIcon(View.VISIBLE, View.GONE);
                        }
                        private void setVisibleOrGoneIcon(int gone, int visible) {

                            backChatIcon.setVisibility(visible);
                            sendChatIcon.setVisibility(visible);
                            chatIcon.setVisibility(gone);
                            timeChatIcon.setVisibility(gone);
                            bankingChatIcon.setVisibility(gone);
                            documentChatIcon.setVisibility(gone);
                            memberChatIcon.setVisibility(gone);
                        }


                    });
        }
    }


}
