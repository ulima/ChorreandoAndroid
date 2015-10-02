package pe.edu.ulima.chorreando;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

import pe.edu.ulima.chorreando.model.dao.Momento;
import pe.edu.ulima.chorreando.presenter.ITomarFotoPresenter;
import pe.edu.ulima.chorreando.presenter.TomarFotoPresenter;
import pe.edu.ulima.chorreando.views.TomarFotoView;

public class FotoActivity extends AppCompatActivity implements TomarFotoView {
    ImageView iviFoto;
    EditText eteFotoLugar;
    Toolbar toolbar;
    ProgressDialog pd;

    private String mCurrentPhotoPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        iviFoto = (ImageView) findViewById(R.id.iviFoto);
        eteFotoLugar = (EditText) findViewById(R.id.eteFotoLugar);

        //iviFoto.setImageBitmap(
        //        (Bitmap)getIntent().getExtras().get(ContenedorActivity.IMAGE_CAPTURE_THUMBNAIL));
        mCurrentPhotoPath = getIntent().getStringExtra(ContenedorActivity.IMAGE_CAPTURE_PATH);

        /*iviFoto.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (mCurrentPhotoPath != null){
                    setPic();
                }
            }
        });*/

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tomar Momento");


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int targetW = iviFoto.getWidth();
        int targetH = iviFoto.getHeight();

        Picasso.with(this).load(mCurrentPhotoPath).resize(targetW, targetH).centerCrop().into(iviFoto);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_foto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menEnviarFoto) {
            // Codigo para guardar Momento
            Momento momento = new Momento(
                    0l,
                    eteFotoLugar.getText().toString(),
                    new SimpleDateFormat("dd/MM/yyyy").format(new Date()),
                    mCurrentPhotoPath,
                    0,
                    0,
                    getApplicationController().getUsuario()
            );
            pd = ProgressDialog.show(this,
                    getString(R.string.titulo_progress),
                    getString(R.string.mensaje_progress));
            ITomarFotoPresenter tomarFotoPresenter = new TomarFotoPresenter(this);
            tomarFotoPresenter.guardarMomento(momento);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMomentoSaved() {
        if (pd.isShowing()) {
            pd.dismiss();
        }
        finish();
    }

    @Override
    public void onError(String msg) {
        if (pd.isShowing()) {
            pd.dismiss();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public ApplicationController getApplicationController() {
        return (ApplicationController) getApplication();
    }
}
