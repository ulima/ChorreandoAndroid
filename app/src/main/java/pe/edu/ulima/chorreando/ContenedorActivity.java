package pe.edu.ulima.chorreando;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import pe.edu.ulima.chorreando.model.dao.Momento;

public class ContenedorActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, QueHaciendoFragment.QueHaciendoActions {
    NavigationView navigation;
    DrawerLayout dlaContenedor;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);

        navigation = (NavigationView)findViewById(R.id.navigation);
        dlaContenedor = (DrawerLayout) findViewById(R.id.dlaContenedor);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlaContenedor.openDrawer(GravityCompat.START);
            }
        });

        Fragment queHaciendoFragment = QueHaciendoFragment.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.flaContenido, queHaciendoFragment);
        ft.commit();

        navigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contenedor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menTomarFoto) {
            
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch(menuItem.getItemId()){
            case R.id.menQueHaciendo:
                Fragment queHaciendoFragment =
                        QueHaciendoFragment.newInstance();

                ft.replace(R.id.flaContenido, queHaciendoFragment);
                ft.commit();
                dlaContenedor.closeDrawers();
                return true;
            case R.id.menPerfil:
                Fragment perfilFragment =
                        PerfilFragment.newInstance();

                ft.replace(R.id.flaContenido, perfilFragment);
                ft.commit();
                dlaContenedor.closeDrawers();
                return true;
            case R.id.menAmigos:
                Fragment amigosFragment =
                        AmigosFragment.newInstance();

                ft.replace(R.id.flaContenido, amigosFragment);
                ft.commit();
                dlaContenedor.closeDrawers();
                return true;
        }

        return false;
    }

    @Override
    public void setTitle(String titulo) {
        getSupportActionBar().setTitle(titulo);
    }

    @Override
    public void onMomentoSelected(Momento momento) {
        Toast.makeText(this, "Proximamente...", Toast.LENGTH_SHORT).show();
    }
}
