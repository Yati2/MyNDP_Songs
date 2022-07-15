package sg.edu.rp.c346.id20028056.ndp_songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Display extends AppCompatActivity {
    Button btnFilter;
    ArrayList<Song> al;

    ListView lv;
    ArrayAdapter<Song> aa;
    DBHelper db=new DBHelper(Display.this);
    boolean clicked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        lv=findViewById(R.id.lv);
        btnFilter=findViewById(R.id.btnFilter);

        load();
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!clicked)
                {
                    al.clear();
                    al.addAll(db.get5Stars());
                    btnFilter.setText("SHOW ALL SONGS");
                    aa.notifyDataSetChanged();
                    clicked=true;
                }
                else
                {
                    al.clear();
                    al.addAll(db.getAllSongs());
                    clicked=false;
                    aa.notifyDataSetChanged();
                    btnFilter.setText("SHOW ALL SONGS WITH 5 STARS");

                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song selected = al.get(position);
                Intent i = new Intent(Display.this,
                        Edit.class);
               i.putExtra("Selected", selected);
                startActivity(i);
            }
        });

    }
    private void load()
    {
        al = db.getAllSongs();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);
    }

    @Override
    protected void onResume() {
        super.onResume();
       load();
    }
}