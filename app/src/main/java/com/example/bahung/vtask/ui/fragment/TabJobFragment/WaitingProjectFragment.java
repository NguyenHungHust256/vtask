package com.example.bahung.vtask.ui.fragment.TabJobFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bahung.vtask.R;
import com.example.bahung.vtask.ui.activity.MainActivity;
import com.example.bahung.vtask.ui.activity.MainChatActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class WaitingProjectFragment extends Fragment {
    Button btnTestMainChat;

    public WaitingProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_waiting_project, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        btnTestMainChat = view.findViewById(R.id.test_chat_id);
        btnTestMainChat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainChatActivity.class);
                startActivity(intent);

            }
        });
    }
}
