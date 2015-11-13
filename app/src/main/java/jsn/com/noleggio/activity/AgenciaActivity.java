package jsn.com.noleggio.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jsn.com.noleggio.R;
import jsn.com.noleggio.client.WsClient;
import jsn.com.noleggio.model.Agencia;
import jsn.com.noleggio.model.Mensagem;
import jsn.com.noleggio.util.Action;
import jsn.com.noleggio.util.Constants;
import jsn.com.noleggio.util.SystemUtil;

public class AgenciaActivity extends Activity {

    private WsClient wsClient;
    private List<Agencia> listaAgencia;

    private Agencia agenciaSelecionada;

    private Spinner spinnerAgencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agencia);
        wsClient = new WsClient();

        carregarAgencia();
        redirecionar();

        spinnerAgencia = (Spinner) findViewById(R.id.agenciaSpinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getAgencias().toArray(new String[0]));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAgencia.setAdapter(arrayAdapter);

        spinnerAgencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    agenciaSelecionada = listaAgencia.get(position -1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void carregarAgencia() {
        listaAgencia = wsClient.buscarAgencia();
    }

    public void pesquisarVeiculo(View view) {
        if (agenciaSelecionada != null) {
            Intent intent = new Intent(this, VeiculoActivity.class);
            intent.putExtra("idAgencia", agenciaSelecionada.getIdAgencia());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Selecione uma Agência", Toast.LENGTH_LONG).show();
        }
    }

    private List<String> getAgencias() {
        List<String> lista = new ArrayList<>();
        lista.add("Selecione");
        for (Agencia agencia : listaAgencia) {
            lista.add(agencia.getFantasia());
        }

        return lista;
    }

    private void redirecionar() {
        if (!SystemUtil.possuiConexaoInternet()) {
            Mensagem mensagem = new Mensagem();
            mensagem.setTitulo("Conexão Indisponível");
            mensagem.setDetalhe("Falha ao conectar a internet");

            Intent intent = new Intent(Action.INFORMACAO);
            intent.putExtra(Constants.EXTRA_MESSAGE, mensagem);
            startActivity(intent);
        }

        else if (listaAgencia == null) {
            Mensagem mensagem = new Mensagem();
            mensagem.setTitulo("Servidor não disponível");
            mensagem.setDetalhe("Não foi possível consultar as Agências disponíveis");

            Intent intent = new Intent(Action.INFORMACAO);
            intent.putExtra(Constants.EXTRA_MESSAGE, mensagem);
            startActivity(intent);
        }
    }
}
