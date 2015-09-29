package pe.edu.ulima.chorreando.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pe.edu.ulima.chorreando.R;
import pe.edu.ulima.chorreando.model.dao.Momento;

/**
 * Created by evaldivieso on 15/09/2015.
 */
public class QueHaciendoAdapter extends RecyclerView.Adapter<QueHaciendoAdapter.QueHaciendoViewHolder> {
    private LayoutInflater inflater;
    private List<Momento> momentos;
    Context context;

    public QueHaciendoAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        momentos = new ArrayList<>();
    }

    public void updateData(List<Momento> momentos) {
        this.momentos.clear();
        this.momentos = momentos;
        notifyDataSetChanged();
    }

    @Override
    public QueHaciendoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_que_haciendo, parent, false);
        return new QueHaciendoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QueHaciendoViewHolder holder, int position) {
        Momento momento = this.momentos.get(position);
        Picasso.with(context).load(momento.getUrlImagen()).into(holder.iviQueHaciendo);
        holder.tviUsuario.setText(momento.getUsuario().getNombre());
        holder.tviLugar.setText(momento.getLugar());
        holder.tviFecha.setText(momento.getFecha());
    }

    @Override
    public int getItemCount() {
        return this.momentos.size();
    }

    class QueHaciendoViewHolder extends RecyclerView.ViewHolder {
        ImageView iviQueHaciendo;
        TextView tviUsuario;
        TextView tviLugar;
        TextView tviFecha;

        public QueHaciendoViewHolder(View itemView) {
            super(itemView);
            iviQueHaciendo = (ImageView) itemView.findViewById(R.id.iviQueHaciendo);
            tviUsuario = (TextView) itemView.findViewById(R.id.tviUsuario);
            tviLugar = (TextView) itemView.findViewById(R.id.tviLugar);
            tviFecha = (TextView) itemView.findViewById(R.id.tviFecha);
        }
    }

    class DataRequired {
        String iv_que_haciendo, tv_usuario, tv_lugar, tv_fecha;

        public DataRequired(String iv_que_haciendo, String tv_usuario, String tv_lugar, String tv_fecha) {
            this.iv_que_haciendo = iv_que_haciendo;
            this.tv_usuario = tv_usuario;
            this.tv_lugar = tv_lugar;
            this.tv_fecha = tv_fecha;
        }

        public String getIv_que_haciendo() {
            return iv_que_haciendo;
        }

        public void setIv_que_haciendo(String iv_que_haciendo) {
            this.iv_que_haciendo = iv_que_haciendo;
        }

        public String getTv_usuario() {
            return tv_usuario;
        }

        public void setTv_usuario(String tv_usuario) {
            this.tv_usuario = tv_usuario;
        }

        public String getTv_lugar() {
            return tv_lugar;
        }

        public void setTv_lugar(String tv_lugar) {
            this.tv_lugar = tv_lugar;
        }

        public String getTv_fecha() {
            return tv_fecha;
        }

        public void setTv_fecha(String tv_fecha) {
            this.tv_fecha = tv_fecha;
        }
    }
}
