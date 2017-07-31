package pya.marlon.com.friends.util.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import pya.marlon.com.friends.R;

/**
 * Created by marlonpya on 24/07/17.
 */

public class MarginDecorator extends RecyclerView.ItemDecoration {
    private int margin;

    public MarginDecorator(Context context) {
        margin = context.getResources().getDimensionPixelSize(R.dimen.item_margin);
    }

    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(margin, margin, margin, margin);
    }
}
