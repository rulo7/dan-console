package es.raul.app.presentation.tools;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by raulcobos on 5/4/16.
 */
public class ImageUtils {

    public static void print(ImageView imageView, String src) {
        imageView.post(() -> {
            if (imageView != null && imageView.getContext() != null) {
                Glide.with(imageView.getContext())
                        .load(src)
                        .override(imageView.getWidth(), imageView.getHeight())
                        .centerCrop()
                        .into(imageView);
            }
        });
    }
}
