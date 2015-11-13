package jsn.com.noleggio.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import jsn.com.noleggio.R;
import jsn.com.noleggio.enums.StatusVeiculoEnum;
import jsn.com.noleggio.model.Veiculo;

/**
 * Created by joaquimsn on 9/13/15.
 */
public class ListaVeiculoAdapter extends ArrayAdapter<Veiculo> {
    private List<Veiculo> listaVeiculo;
    private Context context;

    public ListaVeiculoAdapter(Context context, int resource, List<Veiculo> objects) {
        super(context, resource, objects);
        this.listaVeiculo = objects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaVeiculo.size();
    }

    @Override
    public Veiculo getItem(int position) {
        return listaVeiculo.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.veiculo_row, null);
        }

        // Recupera o Objeto para atribuir informações para tela

        Veiculo veiculo = listaVeiculo.get(position);

        if (veiculo != null) {
            TextView valueModelo = (TextView) convertView.findViewById(R.id.valueModelo);
            TextView valueStatus = (TextView) convertView.findViewById(R.id.valueStatus);
            TextView valueGrupo = (TextView) convertView.findViewById(R.id.valueGrupo);
            TextView valuePrecoKmLivre = (TextView) convertView.findViewById(R.id.valuePrecoKmLivre);
            TextView valuePrecoKmControlado = (TextView) convertView.findViewById(R.id.valuePrecoKmControlado);

            valueModelo.setText(String.valueOf(veiculo.getModelo()));

            valueStatus.setText(veiculo.getStatus().getDisplay());
            if (veiculo.getStatus() == StatusVeiculoEnum.DISPONIVEL) {
                valueStatus.setTextColor(Color.parseColor("#12ad0f"));
            } else {
                valueStatus.setTextColor(Color.parseColor("#bc1414"));
            }
            valueGrupo.setText(veiculo.getGrupo().getDisplay());
            valuePrecoKmLivre.setText(veiculo.getPrecoKmLivreDisplay());
            valuePrecoKmControlado.setText(veiculo.getPrecoKmControladoDisplay());
        }

        return convertView;
    }

}
