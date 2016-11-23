package es.iesnervion.dbenitez.pruebafragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements OnListadoPokemonSelectedListener
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.contenedor) != null)
        {

            if (savedInstanceState != null)
            {
                return;
            }
            else
            {
                ListadoPokemon firstFragment = new ListadoPokemon();

                firstFragment.setArguments(getIntent().getExtras());

                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, firstFragment).commit();
            }
        }
    }

    @Override
    public void onPokemonSelected(int position)
    {
        PerfilPokemon pokemonFrag = (PerfilPokemon) getSupportFragmentManager().findFragmentById(R.id.perfilPokemon);

        if (pokemonFrag != null)
        {
            pokemonFrag.updatePokemonView(position);

        }
        else
        {

            PerfilPokemon newFragment = PerfilPokemon.newInstance(position);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.contenedor, newFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        
    }

}