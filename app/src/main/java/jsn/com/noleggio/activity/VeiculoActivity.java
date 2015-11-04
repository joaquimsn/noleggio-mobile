package jsn.com.noleggio.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jsn.com.noleggio.R;
import jsn.com.noleggio.adapter.ListaVeiculoAdapter;
import jsn.com.noleggio.model.Veiculo;

public class VeiculoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;

    private ListaVeiculoAdapter listaVeiculoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculo);

        listView = (ListView) findViewById(R.id.listViewVeiculo);

        List<Veiculo> listaVeiculo = new ArrayList<>();
        listaVeiculo.add(new Veiculo());

        listaVeiculoAdapter = new ListaVeiculoAdapter(getApplicationContext(), R.layout.veiculo_row, listaVeiculo);
        listView.setAdapter(listaVeiculoAdapter);
        listView.setOnItemClickListener(this);

        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setIndeterminate(true);
        listView.setEmptyView(progressBar);

    }

    public void rastrear(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Veiculo veiculo = (Veiculo) listView.getAdapter().getItem(position);
        Toast.makeText(VeiculoActivity.this, "Clicou no documento " + veiculo.getModelo(), Toast.LENGTH_SHORT).show();

    }
}
