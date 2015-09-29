package pe.edu.ulima.chorreando.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pe.edu.ulima.chorreando.R;

public class PerfilFragment extends Fragment {
    ImageView iviPerfil;
    TextView tviUsername;
    Spinner spiPais;
    Button butGuardar;

    public static PerfilFragment newInstance() {
        PerfilFragment fragment = new PerfilFragment();
        return fragment;
    }

    public PerfilFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.title_activity_perfil);

        tviUsername = (TextView) view.findViewById(R.id.etUsername);
        spiPais = (Spinner) view.findViewById(R.id.spiPais);
        iviPerfil = (ImageView) view.findViewById(R.id.iviPerfil);

        //Picasso.with(getActivity()).load("https://avatars3.githubusercontent.com/u/4576991?v=3&s=400").into(iviPerfil);
        Picasso.with(getActivity()).load("https://avatars3.githubusercontent.com/u/4576991?v=3&s=400").into(iviPerfil);

        Bundle extras = getActivity().getIntent().getExtras();

        tviUsername.setText(extras.getString("username"));

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.pais_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spiPais.setAdapter(adapter);

        return view;
    }

}
