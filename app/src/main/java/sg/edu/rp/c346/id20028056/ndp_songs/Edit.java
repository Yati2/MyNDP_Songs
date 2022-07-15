package sg.edu.rp.c346.id20028056.ndp_songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Edit extends AppCompatActivity {
    Button btnUpdate, btnDelete,btnCancel;
    EditText etTitle,etSingers,etYear,etID;
    RadioGroup rgStars;
    int stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etID=findViewById(R.id.etID);
        btnCancel=findViewById(R.id.btnCancel);
        btnUpdate =findViewById(R.id.btnUpdate);
        btnDelete =findViewById(R.id.btnDelete);
        etSingers=findViewById(R.id.etSingers);
        etTitle=findViewById(R.id.etTitle);
        etYear=findViewById(R.id.etYear);
        rgStars=findViewById(R.id.rgStars);

        Intent i = getIntent();
        Song song = (Song) i.getSerializableExtra("Selected");
        etID.setText(song.get_id()+"");
        etID.setEnabled(false);
        etTitle.setText(song.getTitle());
        etSingers.setText(song.getSingers());
        etYear.setText(song.getYear()+"");
        rgStars.check(song.getStar());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db=new DBHelper(Edit.this);
                song.updateDetails(etTitle.getText().toString(),etSingers.getText().toString(),
                        Integer.parseInt(etYear.getText().toString()),rgStars.getCheckedRadioButtonId());
                db.updateSong(song);
                db.close();
                finish();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db=new DBHelper(Edit.this);
                db.deleteSong(song.get_id());
                finish();
            }
        });

    }

}