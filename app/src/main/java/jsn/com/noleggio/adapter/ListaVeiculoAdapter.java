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

        Veiculo Veiculo = listaVeiculo.get(position);

        if (Veiculo != null) {
            TextView valueModelo = (TextView) convertView.findViewById(R.id.valueModelo);
            TextView valueStatus = (TextView) convertView.findViewById(R.id.valueStatus);
            TextView valueFabricante = (TextView) convertView.findViewById(R.id.valueFabricante);
            TextView valueGrupo = (TextView) convertView.findViewById(R.id.valueGrupo);
            TextView valuePrecoKmLivre = (TextView) convertView.findViewById(R.id.valuePrecoKmLivre);
            TextView valuePrecoKmControlado = (TextView) convertView.findViewById(R.id.valuePrecoKmControlado);

            valueModelo.setText(String.valueOf(Veiculo.getModelo()));
            valueStatus.setText("Disponível");
            valueStatus.setTextColor(Color.parseColor("#000"));
            valueFabricante.setText(Veiculo.getFabricante());
            valueGrupo.setText(Veiculo.getGrupo().getDisplay());
            valuePrecoKmLivre.setText(Veiculo.getPrecoKmLivreDisplay());
            valuePrecoKmControlado.setText(Veiculo.getPrecoKmControladoDisplay());
        }

        return convertView;
    }

}
