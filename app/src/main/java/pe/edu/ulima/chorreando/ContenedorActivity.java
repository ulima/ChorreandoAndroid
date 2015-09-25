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

public class ContenedorActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    NavigationView nviContenedor;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);

        nviContenedor = (NavigationView) findViewById(R.id.nviContenedor);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });



        Fragment fragment = QueHaciendoFragment.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.flaContenido, fragment);
        ft.commit();

        nviContenedor.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contenedor, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        FragmentTransaction ft;
        switch(menuItem.getItemId()){
            case R.id.menQueHaciendo:
                Fragment fragment = QueHaciendoFragment.newInstance();
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flaContenido, fragment);
                ft.commit();
                drawerLayout.closeDrawers();

                return true;
            case R.id.menPerfil:
                Fragment fragmentPerfil = ProfileFragment.newInstance();
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flaContenido, fragmentPerfil);
                ft.commit();
                drawerLayout.closeDrawers();

                return true;
        }
        return false;
    }
}
