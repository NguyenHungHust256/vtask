package com.example.bahung.vtask.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.bahung.vtask.R;

/**
 * Created by bahung on 07/04/2018.
 **/

public class PresistentSingleChoiceSort extends DialogFragment {

    private String[] items = {"Mặc định", "Đã bị khoá", "Đã bị ẩn", "Bắt đầu sớm nhất", "Kết thúc sớm nhất", "Bắt đầu muộn nhất","Kết thúc muộn nhất"};
    private String selectedItem = "";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.ic_person_add_black_24dp);
        builder.setTitle("Sắp xếp công việc");
        selectedItem = items[0];
        //Gía trị được chọn mặc định là giá trị đầu tiên thứ 0.
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedItem = items[which]; // truyền giá trị vào selectedItem
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getActivity(), "Đã Chọn : " + selectedItem, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        return builder.create();
    }
}

