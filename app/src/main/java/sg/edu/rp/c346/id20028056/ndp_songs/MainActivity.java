package sg.edu.rp.c346.id20028056.ndp_songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button btnInsert,btnShow;
    EditText etTitle,etSingers,etYear;
    RadioGroup rgStars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert=findViewById(R.id.btnInsert);
        btnShow=findViewById(R.id.btnShow);
        etSingers=findViewById(R.id.etSingers);
        etTitle=findViewById(R.id.etTitle);
        etYear=findViewById(R.id.etYear);
        rgStars=findViewById(R.id.rgStars);


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,
                        Display.class);
                startActivity(i);
            }
        });


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            DBHelper db=new DBHelper(MainActivity.this);
            long inserted_id=db.insertSong(etTitle.getText().toString(),etSingers.getText().toString(),
                    Integer.parseInt(etYear.getText().toString()),rgStars.getCheckedRadioButtonId());

            if(inserted_id!=-1)
                {
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }

            }
        });


    }

    public int getStars(RadioGroup rg)
    {
        int star=0;
        switch (rg.getCheckedRadioButtonId())
        {
            case R.id.rb1:
                star=1;
                break;
            case R.id.rb2:
                star=2;
                break;
            case R.id.rb3:
                star=3;
                break;
            case R.id.rb4:
                star=4;
                break;
            case R.id.rb5:
                star=5;
                break;

        }

        return star;
    }

    @Override
    protected void onResume() {
        super.onResume();
        clear();
    }

    private void clear()
    {
        etSingers.setText("");
        etTitle.setText("");
        etYear.setText("");
        rgStars.clearCheck();
    }
}