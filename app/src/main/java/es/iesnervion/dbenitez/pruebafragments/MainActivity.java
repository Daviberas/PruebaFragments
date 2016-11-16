package es.iesnervion.dbenitez.pruebafragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements OnListadoPokemonSelectedListener
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.listadoPokemon) != null)
        {

            if (savedInstanceState != null)
            {
                return;
            }

            ListadoPokemon firstFragment = new ListadoPokemon();

            firstFragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction().add(R.id.listadoPokemon, firstFragment).commit();
        }
    }

    @Override
    public void onPokemonSelected(int position)
    {
        PerfilPokemon articleFrag = (PerfilPokemon) getFragmentManager().findFragmentById(R.id.perfilPokemon);

        if (articleFrag != null)
        {
            articleFrag.updatePokemonView(position);

        } else {

            PerfilPokemon newFragment = new PerfilPokemon();
            Bundle args = new Bundle();
            args.putInt(PerfilPokemon.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(R.id.listadoPokemon, newFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }
    }

}