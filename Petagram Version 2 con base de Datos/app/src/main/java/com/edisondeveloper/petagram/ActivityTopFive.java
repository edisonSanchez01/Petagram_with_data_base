package com.edisondeveloper.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.edisondeveloper.petagram.Adapters.TopFiveAdapter;
import com.edisondeveloper.petagram.Model.ContratoTopFive.TablaTopFive;

public class ActivityTopFive extends AppCompatActivity {

    private TopFiveAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_five);
        Toolbar appBar = findViewById(R.id.appBar);
        setSupportActionBar(appBar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.button_back);
        }
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new TopFiveAdapter(this, null);
        recyclerView.setAdapter(adapter);
        AsynckTaskTop asynckTaskTop = new AsynckTaskTop();
        asynckTaskTop.execute(TablaTopFive.URI_TABLA_TOP_FIVE);
    }

    public class AsynckTaskTop extends AsyncTask<Uri, Void, Cursor>{

        @Override
        protected Cursor doInBackground(Uri... uris) {
            Cursor cursor = getContentResolver().query(uris[0],new String[]{TablaTopFive.COLUMN_ID, TablaTopFive.COLUMN_NAME, TablaTopFive.COLUMN_IMAGE,
            TablaTopFive.COLUMN_RATING}, null, null, null);
            return cursor;
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            adapter.changeCursor(cursor);
            recyclerView.setAdapter(adapter);
        }
    }
}