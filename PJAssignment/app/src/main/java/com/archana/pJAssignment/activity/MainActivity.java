package com.archana.pJAssignment.activity;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import com.archana.pJAssignment.adapter.SearchAdapter;
import com.archana.pJAssignment.model.SearchResponse;
import com.archana.pJAssignment.model.SearchType;
import com.archana.pJAssignment.rest.ApiClient;
import com.archana.pJAssignment.rest.ApiInterface;
import info.archana.pJAssignment.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static String SEARCH_KEY = "";

    private RecyclerView recyclerView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        textView = (TextView) findViewById(R.id.please_search);
        if (SEARCH_KEY.isEmpty()) {
            textView.setVisibility(View.VISIBLE);
            return;
        }
        init();
    }

    private void init() {
        textView.setVisibility(View.GONE);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<SearchResponse> call = apiService.getSearchedItems(SEARCH_KEY);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                List<SearchType> searchTypes = response.body().getResults();
                Log.d(TAG, "SearchType" + searchTypes);
                SearchAdapter searchAdapter = new SearchAdapter(searchTypes, R.layout.list_item_search, getApplicationContext());
                recyclerView.setAdapter(searchAdapter);
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_bar, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // use this method when query submitted
                SEARCH_KEY = query;
                Log.d(TAG,"SEARCH_KEY"+SEARCH_KEY);
                init();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // use this method for auto complete search process
                return false;
            }
        });
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }
}
