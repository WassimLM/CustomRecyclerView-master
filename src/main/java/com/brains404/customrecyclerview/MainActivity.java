package com.brains404.customrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<HashMap<String,String>> productList = new ArrayList<>();
        // prod 1
        HashMap<String,String> prod1 = new HashMap<>() ;
        prod1.put("titre","Word");
        prod1.put("description","Traitement de texte");
        prod1.put("image",String.valueOf(R.drawable.word));
        productList.add(prod1);
        //prod 2
        HashMap<String,String> prod2 = new HashMap<>() ;
        prod2.put("titre","Excel");
        prod2.put("description","Tableur");
        prod2.put("image",String.valueOf(R.drawable.excel));
        productList.add(prod2);
        //prod 3
        HashMap<String,String> prod3 = new HashMap<>() ;
        prod3.put("titre","PowerPoint");
        prod3.put("description","Logiciel de présentation");
        prod3.put("image",String.valueOf(R.drawable.powerpoint));
        productList.add(prod3);
        //prod 4
        HashMap<String,String> prod4 = new HashMap<>() ;
        prod4.put("titre","Outlook");
        prod4.put("description","Client de courrier électronique");
        prod4.put("image",String.valueOf(R.drawable.outlook));
        productList.add(prod4);
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(productList);
        recyclerView.setAdapter(adapter);

    }
}
