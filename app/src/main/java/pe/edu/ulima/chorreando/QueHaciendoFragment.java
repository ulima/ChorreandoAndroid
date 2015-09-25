package pe.edu.ulima.chorreando;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class QueHaciendoFragment extends Fragment {


    public static QueHaciendoFragment newInstance() {
        QueHaciendoFragment fragment = new QueHaciendoFragment();


        return fragment;
    }

    public QueHaciendoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quehaciendo, container, false);
    }
}
