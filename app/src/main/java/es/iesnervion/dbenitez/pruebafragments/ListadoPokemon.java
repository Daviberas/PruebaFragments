package es.iesnervion.dbenitez.pruebafragments;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.ListFragment;
import android.widget.ListView;

public class ListadoPokemon extends ListFragment
{
    OnListadoPokemonSelectedListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            setListAdapter(new AdapterIcono<Pokemon>(getContext(), R.layout.row, R.id.texto, Pokes.pokes));
        }
    }

    @Override
    public void onStart()
    {
        super.onStart();

        if (getFragmentManager().findFragmentById(R.id.perfilPokemon) != null)
        {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        try
        {
            mCallback = (OnListadoPokemonSelectedListener) activity;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()
                    + " must implement OnListadoPokemonSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        mCallback.onPokemonSelected(position);

        getListView().setItemChecked(position, true);
    }
}