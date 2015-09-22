package pe.edu.ulima.chorreando.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import pe.edu.ulima.chorreando.R;
import pe.edu.ulima.chorreando.adapters.AmigosAdapter;
import pe.edu.ulima.chorreando.model.dao.Usuario;

public class AmigosFragment extends Fragment {
    RecyclerView rviAmigos;
    AmigosAdapter amigosAdapter;

    public static AmigosFragment newInstance() {
        AmigosFragment fragment = new AmigosFragment();
        return fragment;
    }

    public AmigosFragment() {
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
        View view = inflater.inflate(R.layout.fragment_amigos, container, false);

        rviAmigos = (RecyclerView) view.findViewById(R.id.rviAmigos);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_activity_amigos);

        List<Usuario> usuarios;

        String json = "[\n" +
                "  {\n" +
                "    \"idUsuario\": 1," +
                "    \"nombre\": \"amigo1\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"urlFoto\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"idUsuario\": 2," +
                "    \"nombre\": \"amigo2\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"urlFoto\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"idUsuario\": 3," +
                "    \"nombre\": \"amigo3\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"urlFoto\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"idUsuario\": 4," +
                "    \"nombre\": \"amigo4\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"urlFoto\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"idUsuario\": 5," +
                "    \"nombre\": \"amigo5\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"urlFoto\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"idUsuario\": 6," +
                "    \"nombre\": \"amigo6\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"urlFoto\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"idUsuario\": 7," +
                "    \"nombre\": \"amigo7\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"urlFoto\": \"\"\n" +
                "  }\n" +
                "]";

        Gson gson = new Gson();
        Type token = new TypeToken<List<Usuario>>() {}.getType();
        usuarios = gson.fromJson(json, token);

        amigosAdapter = new AmigosAdapter(getActivity());
        amigosAdapter.updateData(usuarios);
        rviAmigos.setAdapter(amigosAdapter);
        rviAmigos.setLayoutManager(new GridLayoutManager(getActivity(),3));

        return view;
    }

}
