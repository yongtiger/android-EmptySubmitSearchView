package cc.brainbook.android.emptysubmitsearchview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;

public class EmptySubmitSearchView extends SearchView {
    public EmptySubmitSearchView(@NonNull Context context) {
        super(context);
    }

    public EmptySubmitSearchView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptySubmitSearchView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setOnQueryTextListener(OnQueryTextListener listener) {
        super.setOnQueryTextListener(listener);

        ((SearchAutoComplete) findViewById(R.id.search_src_text))
                .setOnEditorActionListener((textView, i, keyEvent) -> {
                    if (listener != null) {
                        listener.onQueryTextSubmit(getQuery().toString());
                    }

                    return true;
                });
    }
}

