package es.iesnervion.dbenitez.pruebafragments;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder
{
    TextView tv;
    ImageView iv;

    public ViewHolder (TextView tv, ImageView iv)
    {
        this.tv = tv;
        this.iv = iv;
    }

    public TextView getTv (){
        return this.tv;
    }

    public ImageView getIv (){
        return this.iv;
    }
}
