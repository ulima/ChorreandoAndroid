package pe.edu.ulima.chorreando;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class QueHaciendoFragment extends Fragment {

    public static QueHaciendoFragment newInstance(){
        return new QueHaciendoFragment();
    }


    public QueHaciendoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_que_haciendo, container, false);
    }


}
