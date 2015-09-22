package pe.edu.ulima.chorreando.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import pe.edu.ulima.chorreando.R;
import pe.edu.ulima.chorreando.adapters.QueHaciendoAdapter;
import pe.edu.ulima.chorreando.model.dao.Momento;

public class QueHaciendoFragment extends Fragment {
    RecyclerView rviQueHaciendo;
    QueHaciendoAdapter queHaciendoAdapter;

    public static QueHaciendoFragment newInstance() {
        QueHaciendoFragment fragment = new QueHaciendoFragment();
        return fragment;
    }

    public QueHaciendoFragment() {
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
        View view = inflater.inflate(R.layout.fragment_que_haciendo, container, false);

        rviQueHaciendo = (RecyclerView) view.findViewById(R.id.rviQueHaciendo);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_activity_que_haciendo);

        queHaciendoAdapter = new QueHaciendoAdapter(getActivity());

        List<Momento> momentos;

        String json = "[\n" +
                "  {\n" +
                "    \"usuario\": \"User1\",\n" +
                "    \"lugar\": \"Lugar1\",\n" +
                "    \"fecha\": \"21/10/2015\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"usuario\": \"User2\",\n" +
                "    \"lugar\": \"Lugar1\",\n" +
                "    \"fecha\": \"20/10/2015\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"usuario\": \"User3\",\n" +
                "    \"lugar\": \"Lugar2\",\n" +
                "    \"fecha\": \"17/9/2015\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"usuario\": \"User1\",\n" +
                "    \"lugar\": \"Lugar3\",\n" +
                "    \"fecha\": \"11/9/2015\"\n" +
                "  }\n" +
                "]";

        Gson gson = new Gson();
        Type token = new TypeToken<List<Momento>>() {}.getType();
        momentos = gson.fromJson(json, token);

        queHaciendoAdapter.updateData(momentos);
        rviQueHaciendo.setAdapter(queHaciendoAdapter);
        rviQueHaciendo.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
