package cc.brainbook.android.emptysubmitsearchview;

import android.content.Context;
import android.content.res.Resources;
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

        int autoCompleteTextViewID = Resources.getSystem().getIdentifier("search_src_text",
                "id", "android");
//        int autoCompleteTextViewID = getResources().getIdentifier("android:id/search_src_text", null, null);
        ((SearchAutoComplete) findViewById(autoCompleteTextViewID))
                .setOnEditorActionListener((textView, i, keyEvent) -> {
                    if (listener != null) {
                        listener.onQueryTextSubmit(getQuery().toString());
                    }

                    return true;
                });
    }
}

