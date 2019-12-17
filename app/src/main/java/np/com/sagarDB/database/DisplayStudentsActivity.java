package np.com.sagarDB.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import np.com.sagarDB.database.adapters.StudentAdapter;
import np.com.sagarDB.database.models.Student;

public class DisplayStudentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnBackToAddStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_students);
        recyclerView = findViewById(R.id.recyclerViewStudents);
        btnBackToAddStudents = findViewById(R.id.btnBackToAdd);

        DatabaseHelper dbHelper = new DatabaseHelper(DisplayStudentsActivity.this);
        List<Student> studentList = dbHelper.displayStudents();

        StudentAdapter studentAdapter = new StudentAdapter(DisplayStudentsActivity.this, studentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);

        btnBackToAddStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayStudentsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
