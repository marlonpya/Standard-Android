package pya.marlon.com.friends.util.media;

import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

import pya.marlon.com.friends.util.constant.Constant;

/**
 * Created by marlonpya on 23/07/17.
 */

public class GlideImageLoader implements IImageLoader {
    @Override
    public void load(String url, ImageView imageView) {
        loadDefault(url, imageView, true);
    }

    @Override
    public void load(String url, ImageView imageView, int srcPlaceholder) {
        Glide.with(imageView.getContext()).load(url).placeholder(srcPlaceholder).into(imageView);
    }

    @Override
    public void loadDefault(String url, ImageView imageView, boolean withPlaceholder) {
        DrawableTypeRequest glide = Glide.with(imageView.getContext()).load(url);
        if (withPlaceholder) {
            glide.placeholder(Constant.View.Placeholder.IMAGE_DEFAULT);
        }
        glide.into(imageView);
    }
}
