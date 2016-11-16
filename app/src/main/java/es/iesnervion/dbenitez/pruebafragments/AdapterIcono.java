package es.iesnervion.dbenitez.pruebafragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterIcono<T> extends ArrayAdapter<T>
{
    public AdapterIcono(Context c, int resourceId, int textId, T[] objects)
    {
        super(c, resourceId, textId, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        ViewHolder holder;

        if (row==null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );

            row = inflater.inflate(R.layout.row, parent, false);

            TextView tv = (TextView) row.findViewById(R.id.texto);
            ImageView iv = (ImageView) row.findViewById(R.id.img);

            holder = new ViewHolder (tv,iv);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }

        holder.getTv().setText(Pokes.pokes[position].getNombre());
        holder.getIv().setImageResource(Pokes.pokes[position].getImagen());

        return (row);
    }
}
