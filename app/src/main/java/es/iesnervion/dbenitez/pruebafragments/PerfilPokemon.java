package es.iesnervion.dbenitez.pruebafragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfilPokemon extends Fragment
{
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (savedInstanceState != null)
        {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        return inflater.inflate(R.layout.pokemon, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null)
        {
            updatePokemonView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1)
        {
            updatePokemonView(mCurrentPosition);
        }
    }

    public void updatePokemonView(int position)
    {
        TextView nombre = (TextView) getActivity().findViewById(R.id.nombre);
        TextView numeroPokedex = (TextView) getActivity().findViewById(R.id.numeroPokedex);
        TextView descripcion = (TextView) getActivity().findViewById(R.id.descripcion);
        TextView tipos = (TextView) getActivity().findViewById(R.id.tipos);
        TextView habilidades = (TextView) getActivity().findViewById(R.id.habilidades);
        ImageView poke = (ImageView) getActivity().findViewById(R.id.poke);

        nombre.setText("Nombre:\n"+Pokes.pokes[position].getNombre());
        numeroPokedex.setText("\nNº Pokédex: \n"+Pokes.pokes[position].getNumero());
        poke.setImageResource(Pokes.pokes[position].getImagen());
        descripcion.setText("\nDescripción: \n"+Pokes.pokes[position].getDescripcion());
        if(!Pokes.pokes[position].getTipoPrimario().equals(Pokes.pokes[position].getTipoSecundario()))
        {
            tipos.setText("\nTipo: "+Pokes.pokes[position].getTipoPrimario()+"/"+Pokes.pokes[position].getTipoSecundario());
        }
        else
            tipos.setText("\nTipo: "+Pokes.pokes[position].getTipoPrimario());

        String habilidad = "\nHabilidades: \n"+Pokes.pokes[position].getHabilidadPrimaria();
        if(Pokes.pokes[position].getHabilidadSecundaria()!=null)
        {
            habilidad+= "/"+Pokes.pokes[position].getHabilidadSecundaria();
        }

        if(Pokes.pokes[position].getHabilidadOcultaPrimaria()!=null)
        {
            habilidad+= "\n"+Pokes.pokes[position].getHabilidadOcultaPrimaria();
            if(Pokes.pokes[position].getHabilidadOcultaSecundaria()!=null)
            {
                habilidad+= "/"+Pokes.pokes[position].getHabilidadOcultaSecundaria();
            }
        }

        habilidades.setText(habilidad);

        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
