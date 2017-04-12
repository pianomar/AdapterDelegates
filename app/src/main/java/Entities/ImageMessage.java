package Entities;

import android.graphics.Bitmap;

/**
 * Created by Omar Hezi on 12/04/17.
 */

public class ImageMessage implements BaseMessage {
    String url;

    public ImageMessage(String url) {
        this.url = url;
    }

    public String getImage() {
        return url;
    }

    public void setImage(String url) {
        this.url = url;
    }
}
