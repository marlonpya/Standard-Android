package pya.marlon.com.friends.util.media;

/**
 * Created by marlonpya on 23/07/17.
 */

public class ImageLoader {
    private IImageLoader imageLoader;
    /*private ImageLoaderType type;*/

    public ImageLoader(ImageLoaderType type) {
        switch (type) {
            case GLIDE: imageLoader = new GlideImageLoader();
            case PICASSO: throw new RuntimeException("Piccaso no ha sido implementado");
            default: throw new RuntimeException("No implementado");
        }
    }

    public IImageLoader getImageLoader() {
        return imageLoader;
    }
}
