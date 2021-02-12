package cc.brainbook.android.emptysubmitsearchview.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;

import cc.brainbook.android.emptysubmitsearchview.EmptySubmitSearchView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmptySubmitSearchView searchView = findViewById(R.id.sv_search_view);
        searchView.onActionViewExpanded();

        ///搜索框内容变化事件监听
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            /**
             * 输入文字改变的监听回调
             *
             * @param queryText
             *
             * @return false if the SearchView should perform the default action
             * of showing any suggestions if available, true if the action was
             * handled by the listener.
             */
            @Override
            public boolean onQueryTextChange(String queryText) {
                return true;
            }

            /**
             * 输入完成后，提交时触发的回调
             *
             * @param queryText
             *
             * @return true to indicate that it has handled the submitResult request.
             * Otherwise return false to let the SearchView handleMenuItem the
             * submission by launching any associated intent.
             */
            @Override
            public boolean onQueryTextSubmit(String queryText) {
                return true;
            }
        });

    }
}