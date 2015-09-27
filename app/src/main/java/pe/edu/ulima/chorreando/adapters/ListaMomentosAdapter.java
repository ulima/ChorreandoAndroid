package pe.edu.ulima.chorreando.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.ulima.chorreando.R;
import pe.edu.ulima.chorreando.model.dao.Momento;

/**
 * Created by hquintana on 26/09/15.
 */
public class ListaMomentosAdapter extends BaseAdapter {
    private List<Momento> mMomentos;
    private Context mContext;

    public ListaMomentosAdapter(List<Momento> momentos, Context context){
        mMomentos = momentos;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mMomentos.size();
    }

    @Override
    public Object getItem(int i) {
        return mMomentos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mMomentos.get(i).getIdMomento();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_momentos, null);

            viewHolder = new ViewHolder();
            viewHolder.iviMomentoImagen = (ImageView)view.findViewById(R.id.iviMomentoImagen);
            viewHolder.tviMomentoUsuario = (TextView)view.findViewById(R.id.tviMomentoUsuario);
            viewHolder.tviMomentoLugar = (TextView)view.findViewById(R.id.tviMomentoLugar);
            viewHolder.tviMomentoFecha = (TextView)view.findViewById(R.id.tviMomentoFecha);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }

        Momento momento = mMomentos.get(i);

        viewHolder.iviMomentoImagen.setImageResource(R.drawable.logo);
        viewHolder.tviMomentoUsuario.setText(momento.getUsuario().getNombre());
        viewHolder.tviMomentoLugar.setText(momento.getLugar());
        viewHolder.tviMomentoFecha.setText(momento.getFecha());
        Picasso.with(mContext).load(momento.getUrlImagen()).into(viewHolder.iviMomentoImagen);

        return view;
    }

    class ViewHolder{
        ImageView iviMomentoImagen;
        TextView tviMomentoUsuario;
        TextView tviMomentoLugar;
        TextView tviMomentoFecha;
    }
}
