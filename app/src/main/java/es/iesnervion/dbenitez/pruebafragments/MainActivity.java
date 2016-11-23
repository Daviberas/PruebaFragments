package es.iesnervion.dbenitez.pruebafragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements OnListadoPokemonSelectedListener
{
    //static final String STATE_POSITION = "position";

    //Integer position;

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
            else
            {
                ListadoPokemon firstFragment = new ListadoPokemon();

                firstFragment.setArguments(getIntent().getExtras());

                getFragmentManager().beginTransaction().add(R.id.listadoPokemon, firstFragment).commit();
            }
        }
    }

    @Override
    public void onPokemonSelected(int position)
    {
        PerfilPokemon pokemonFrag = (PerfilPokemon) getFragmentManager().findFragmentById(R.id.perfilPokemon);

        //this.position = position;

        if (pokemonFrag != null)
        {
            pokemonFrag.updatePokemonView(position);

        }
        else
        {

            PerfilPokemon newFragment = PerfilPokemon.newInstance(position);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(R.id.listadoPokemon, newFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

     //   outState.putInt(STATE_POSITION,position);
    }

}