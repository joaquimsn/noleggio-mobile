package jsn.com.noleggio.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import jsn.com.noleggio.R;
import jsn.com.noleggio.adapter.ListaVeiculoAdapter;
import jsn.com.noleggio.client.WsClient;
import jsn.com.noleggio.model.Mensagem;
import jsn.com.noleggio.model.Veiculo;
import jsn.com.noleggio.util.Action;
import jsn.com.noleggio.util.Constants;

public class VeiculoActivity extends Activity implements AdapterView.OnItemClickListener{

    private WsClient wsClient;

    private ListView listView;
    private List<Veiculo> listaVeiculo;
    private ListaVeiculoAdapter listaVeiculoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculo);

        wsClient = new WsClient();
        carregarVeiculosPorAgencia();

        listView = (ListView) findViewById(R.id.listViewVeiculo);

        listaVeiculoAdapter = new ListaVeiculoAdapter(getApplicationContext(), R.layout.veiculo_row, listaVeiculo);
        listView.setAdapter(listaVeiculoAdapter);
        listView.setOnItemClickListener(this);

        /*ProgressBar progressBar = new ProgressBar(this);
        progressBar.setIndeterminate(true);
        listView.setEmptyView(progressBar);*/

    }

    public void rastrear(View view) {

    }

    private void carregarVeiculosPorAgencia() {
        Intent intentExtra = getIntent();
        int idAgencia = intentExtra.getIntExtra("idAgencia", 0);
        listaVeiculo = wsClient.buscarVeiculo(idAgencia);

        if (listaVeiculo == null) {
            Mensagem mensagem = new Mensagem();
            mensagem.setTitulo("");
            mensagem.setDetalhe("A agência selecionada não possui veículos");

            Intent intent = new Intent(Action.INFORMACAO);
            intent.putExtra(Constants.EXTRA_MESSAGE, mensagem);
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Veiculo veiculo = (Veiculo) listView.getAdapter().getItem(position);

        Intent intent = new Intent(this, DetalheVeiculoActivity.class);
        intent.putExtra(Constants.VEICULO_SELECIONADO, veiculo);
        startActivity(intent);
    }
}
