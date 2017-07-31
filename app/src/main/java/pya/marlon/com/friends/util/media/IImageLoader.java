package pya.marlon.com.friends.util.media;

import android.widget.ImageView;

/**
 * Created by marlonpya on 23/07/17.
 */

public interface IImageLoader {
    /**
     * Setea un String URL, que contenga una imagen.
     * Por defecto coge el place holder declarado en método.
     * @param url URL de la imagen.
     * @param imageView ImageView a usar.
     */
    void load(String url, ImageView imageView);

    /**
     * Setea un String URL, que contega una imagen.
     * Con el PlaceHolder declarado.
     * @param url URL de la imagen.
     * @param imageView ImageView a usar.
     * @param srcPlaceholder int del PlaceHolder.
     */
    void load(String url, ImageView imageView, int srcPlaceholder);

    /**
     * Setea un String URL, que contega una imagen.
     * Por defecto coge el place holder declarado en método
     * @param url URL de la imagen.
     * @param imageView ImageView a usar.
     * @param withPlaceholder
     */
    void loadDefault(String url, ImageView imageView, boolean withPlaceholder);
}
