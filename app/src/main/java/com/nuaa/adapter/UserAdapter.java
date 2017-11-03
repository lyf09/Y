package com.nuaa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nuaa.testnetwork.R;
import com.nuaa.util.Globals;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/2.
 */

public class UserAdapter extends BaseAdapter {
    private Context ctx;
    private List<Map<String, Object>> allValues;

    public UserAdapter(Context ctx, List<Map<String, Object>> allValues) {
        this.ctx = ctx;
        this.allValues = allValues;
    }

    @Override
    public int getCount() {
        return allValues.size();
    }

    @Override
    public Object getItem(int i) {
        return allValues.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.list_item, null);
            view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, Globals.SCREEN_HEIGHT / 7));
        }

        Map<String, Object> map = allValues.get(i);
        TextView idView = (TextView)view.findViewById(R.id.id_txt);
        TextView pwdView = (TextView)view.findViewById(R.id.pwd_txt);
        TextView emailView = (TextView)view.findViewById(R.id.email_txt);


        idView.setText(map.get("id").toString());
        pwdView.setText(map.get("pwd").toString());
        emailView.setText(map.get("email").toString());
        return view;
    }
}
