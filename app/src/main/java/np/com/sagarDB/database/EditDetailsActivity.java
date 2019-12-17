package np.com.sagarDB.database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditDetailsActivity extends AppCompatActivity {
    EditText etName, etEmail, etPhone;
    Button btnUpdate, btnGoBack;
    String id, name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnGoBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        phone = intent.getStringExtra("phone");

        etName.setText(name);
        etEmail.setText(email);
        etPhone.setText(phone);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(EditDetailsActivity.this);
                boolean status = db.updateStudentDetails(id, etName.getText().toString(), etEmail.getText().toString(), etPhone.getText().toString());

                if(status){
                    Toast.makeText(EditDetailsActivity.this, "Student Details Changed!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditDetailsActivity.this, "Error! Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(EditDetailsActivity.this, DisplayStudentsActivity.class);
                startActivity(intent_back);
            }
        });


    }
}
