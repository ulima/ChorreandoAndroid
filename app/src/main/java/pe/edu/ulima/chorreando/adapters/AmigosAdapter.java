package pe.edu.ulima.chorreando.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.ulima.chorreando.R;
import pe.edu.ulima.chorreando.model.dao.Usuario;

/**
 * Created by evaldivieso on 21/09/2015.
 */
public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.AmigosViewHolder> implements View.OnClickListener {
    private LayoutInflater inflater;
    List<Usuario> amigos;

    public AmigosAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        amigos = new ArrayList<>();
    }

    public void updateData(List<Usuario> newAmigos) {
        this.amigos.clear();
        this.amigos = newAmigos;

        notifyDataSetChanged();
    }

    @Override
    public AmigosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_amigos, parent, false);
        AmigosViewHolder holder = new AmigosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AmigosViewHolder holder, int position) {
        Usuario usuario = amigos.get(position);
        holder.tviUsuarioNombre.setText(usuario.getNombre());
    }

    @Override
    public int getItemCount() {
        return amigos.size();
    }

    @Override
    public void onClick(View view) {

    }

    class AmigosViewHolder extends RecyclerView.ViewHolder {
        ImageView iviUsuario;
        TextView tviUsuarioNombre;

        public AmigosViewHolder(View itemView) {
            super(itemView);
            iviUsuario = (ImageView) itemView.findViewById(R.id.iviUsuario);
            tviUsuarioNombre = (TextView) itemView.findViewById(R.id.tviUsuarioNombre);
        }
    }
}
