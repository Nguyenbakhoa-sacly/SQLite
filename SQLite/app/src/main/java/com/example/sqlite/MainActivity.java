package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Switch;

import com.example.sqlite.Adapter.EmployeeAdapter;
import com.example.sqlite.Sqlite.DBhelper;
import com.example.sqlite.Sqlite.EmployeeDao;
import com.example.sqlite.model.Employee;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EmployeeAdapter employeeAdapter;
    private ListView lvEmployees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DBhelper dBhelper = new DBhelper(this);
//        SQLiteDatabase database = dBhelper.getReadableDatabase();
//        database.close();
        findViewById(R.id.btn_edit).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);

        lvEmployees = findViewById(R.id.lvEmployees);

        EmployeeDao dao = new EmployeeDao(this);
        List<Employee>list = dao.getAll();
        employeeAdapter = new EmployeeAdapter(this, list);
        lvEmployees.setAdapter(employeeAdapter);
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.btn_edit:
               Intent intent = new Intent(this,MainActivity2.class);
               startActivity(intent);
               break;
       }
    }
}