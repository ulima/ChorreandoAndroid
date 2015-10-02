package pe.edu.ulima.chorreando;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pe.edu.ulima.chorreando.model.dao.Momento;

public class ContenedorActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, QueHaciendoFragment.QueHaciendoActions {
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String IMAGE_CAPTURE_PATH = "IMAGE_CAPTURE_PATH";
    public static final String IMAGE_CAPTURE_THUMBNAIL = "IMAGE_CAPTURE_THUMBNAIL";

    NavigationView navigation;
    DrawerLayout dlaContenedor;
    Toolbar toolbar;

    private String mCurrentPhotoPath = "";

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
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {
                    throw new RuntimeException("Error tomando foto");
                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile));
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Bundle extras = data.getExtras();
            Intent intent = new Intent(this, FotoActivity.class);
            intent.putExtra(IMAGE_CAPTURE_PATH, mCurrentPhotoPath);
            //intent.putExtra(IMAGE_CAPTURE_THUMBNAIL, (Bitmap) extras.get("data"));
            startActivity(intent);
        }
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

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        //mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

}
