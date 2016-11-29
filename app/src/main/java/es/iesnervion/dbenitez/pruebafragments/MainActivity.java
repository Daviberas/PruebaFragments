package es.iesnervion.dbenitez.pruebafragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements OnListadoPokemonSelectedListener
{
    public static final String TAG_PERFIL_POKEMON = "perfil";
    private PerfilPokemon fragmentPokemon;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.contenedor) != null)
        {

            if (savedInstanceState != null)
            {
                fragmentPokemon = (PerfilPokemon) getSupportFragmentManager().findFragmentByTag(TAG_PERFIL_POKEMON);
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

        if (fragmentPokemon != null)
        {
            fragmentPokemon.updatePokemonView(position);

        }
        else
        {

            fragmentPokemon = PerfilPokemon.newInstance(position);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.contenedor, fragmentPokemon, TAG_PERFIL_POKEMON);
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