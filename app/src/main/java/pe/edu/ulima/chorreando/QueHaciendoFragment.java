package pe.edu.ulima.chorreando;


import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import pe.edu.ulima.chorreando.adapters.ListaMomentosAdapter;
import pe.edu.ulima.chorreando.model.dao.Momento;
import pe.edu.ulima.chorreando.presenter.QueHaciendoPresenter;
import pe.edu.ulima.chorreando.views.QueHaciendoView;


public class QueHaciendoFragment extends Fragment implements QueHaciendoView, AdapterView.OnItemClickListener{
    private ListView lviMomentos;
    private ProgressDialog pd;
    private QueHaciendoActions listener;


    public static QueHaciendoFragment newInstance(){
        return new QueHaciendoFragment();
    }


    public QueHaciendoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (QueHaciendoActions) getActivity();
        }catch(ClassCastException cce){
            new RuntimeException("El activity debe de implementar QueHaciendoActions");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (QueHaciendoActions) getActivity();
        }catch(ClassCastException cce){
            new RuntimeException("El activity debe de implementar QueHaciendoActions");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        pd = ProgressDialog.show(
                getActivity(),
                getString(R.string.titulo_progress),
                getString(R.string.mensaje_progress));
        new QueHaciendoPresenter(this).listarMomentos(1l);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        listener.setTitle(getString(R.string.fragment_que_haciendo_titulo));
        View view = inflater.inflate(R.layout.fragment_que_haciendo, container, false);
        lviMomentos = (ListView) view.findViewById(R.id.lviMomentos);
        return view;
    }


    @Override
    public void onListaMomentosLoaded(List<Momento> momentos) {
        if (pd.isShowing()){
            pd.dismiss();
        }
        ListaMomentosAdapter adapter = new ListaMomentosAdapter(momentos, getActivity());
        lviMomentos.setAdapter(adapter);
        lviMomentos.setOnItemClickListener(this);
    }

    @Override
    public void onError(String error) {
        if (pd.isShowing()){
            pd.dismiss();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        listener.onMomentoSelected((Momento) adapterView.getItemAtPosition(i));
    }

    public interface QueHaciendoActions{
        public void setTitle(String titulo);
        public void onMomentoSelected(Momento momento);
    }
}
