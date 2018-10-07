package com.hod.fahim.studentinfo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hod.fahim.studentinfo.R;
import com.hod.fahim.studentinfo.model.User;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Activity activity;
    private List<User> userList;
    LayoutInflater inflater;

    public ListViewAdapter(Activity activity, List<User> userList){
        this.activity = activity;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_row,null);

        TextView textView = view.findViewById(R.id.textView);
        TextView textView1 = view.findViewById(R.id.textView2);

        textView.setText(userList.get(position).getPname());
        textView1.setText(userList.get(position).getP_price());
        return view;
    }
}
