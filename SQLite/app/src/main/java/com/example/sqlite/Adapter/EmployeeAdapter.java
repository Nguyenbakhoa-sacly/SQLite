package com.example.sqlite.Adapter;

import android.content.Context;
import android.media.MediaDrm;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sqlite.R;
import com.example.sqlite.model.Employee;

import java.util.List;

public class EmployeeAdapter extends BaseAdapter {
    private Context context;
    private List<Employee> list;

    public EmployeeAdapter(Context context, List<Employee> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int iPosition) {
        return list.get(iPosition);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view != null){
            view = LayoutInflater.from(context).inflate(R.layout.item_employee,null);

        }
        TextView tvsalary_item = view.findViewById(R.id.tvsalary_item);
        TextView tvname_item = view.findViewById(R.id.tvname_item);
        Employee emp = list.get(i);
        tvname_item.setText(emp.getName());
        tvsalary_item.setText("" + emp.getSalary());
        return null;
    }


}
