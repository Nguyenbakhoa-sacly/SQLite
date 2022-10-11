package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.Sqlite.EmployeeDao;
import com.example.sqlite.model.Employee;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
private EditText edt_Salary,edt_name,edt_EmployeeID;
private Button btn_list_employee,btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edt_EmployeeID = findViewById(R.id.edt_EmployeeID);
        edt_name = findViewById(R.id.edt_name);
        edt_Salary = findViewById(R.id.edt_Salary);
         findViewById(R.id.btn_list_employee).setOnClickListener(this);
         findViewById(R.id.btn_save).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save:
                EmployeeDao dao = new EmployeeDao(this);
                Employee emp = new Employee();

                emp.setId(edt_EmployeeID.getText().toString());
                emp.setName(edt_name.getText().toString());
                emp.setSalary(Float.parseFloat(edt_Salary.getText().toString()));

                dao.insert(emp);
                Toast.makeText(this,"New employee has been saved",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}