package jsn.com.noleggio.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import jsn.com.noleggio.R;
import jsn.com.noleggio.model.Veiculo;
import jsn.com.noleggio.util.Constants;

public class DetalheVeiculoActivity extends Activity {

    private Veiculo veiculoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_veiculo);

        preencherFormulario();
    }

    private void preencherFormulario() {
        Intent intent = getIntent();
        veiculoSelecionado = (Veiculo) intent.getSerializableExtra(Constants.VEICULO_SELECIONADO);

        if (veiculoSelecionado != null) {
            TextView valueModelo = (TextView) findViewById(R.id.dtModelo);
            TextView valueFabricante = (TextView) findViewById(R.id.dtFabricante);
            TextView valueGrupo = (TextView) findViewById(R.id.dtGrupo);
            TextView valuePrecoControlado = (TextView) findViewById(R.id.dtPrecoKmControlado);
            TextView valuePrecoLivre = (TextView) findViewById(R.id.dtPrecoKmLivre);
            TextView valueAcessorio = (TextView) findViewById(R.id.dtAcessorio);

            valueModelo.setText(veiculoSelecionado.getModelo());
            valueFabricante.setText(veiculoSelecionado.getFabricante());
            valueGrupo.setText(veiculoSelecionado.getGrupo().getDisplay());
            valuePrecoControlado.setText(veiculoSelecionado.getPrecoKmControladoDisplay());
            valuePrecoLivre.setText(veiculoSelecionado.getPrecoKmLivreDisplay());
            valueAcessorio.setText(veiculoSelecionado.getAcessorio());
        }
    }

}
