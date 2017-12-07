package com.example.cain.reinventist;
//歷程

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main9Activity extends AppCompatActivity {
    private GridView gridView;

    private int[] image = {
            R.drawable.a201711031, R.drawable.a201711032, R.drawable.a201711041,
            R.drawable.a201711042,  R.drawable.a201711031, R.drawable.a201711032, R.drawable.a201711041,
            R.drawable.a201711042
    };
    private String[] imgText = {
            "20171103_1", "20171103_2", "20171104_1", "20171104_2","20171103_1", "20171103_2", "20171104_1", "20171104_2"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        gridView=(GridView)findViewById(R.id.main_page_gridview);
        List<Map<String, Object>> items = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("image", image[i]);
            item.put("text", imgText[i]);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,
                items, R.layout.activity_grid_test, new String[]{"image", "text"},
                new int[]{R.id.image, R.id.text});
        gridView.setNumColumns(2);

        gridView.setAdapter(new Grid_test(this.getLayoutInflater(),image,imgText));
        /*
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main9Activity.this, "你選擇了" + imgText[position], Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}
