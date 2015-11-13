package jsn.com.noleggio.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import jsn.com.noleggio.R;
import jsn.com.noleggio.model.Mensagem;
import jsn.com.noleggio.util.ApplicationNoleggio;
import jsn.com.noleggio.util.Constants;

public class InformacaoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao);

        Intent intent = getIntent();
        Mensagem mensagem = (Mensagem) intent.getSerializableExtra(Constants.EXTRA_MESSAGE);

        TextView textViewTitulo = (TextView) findViewById(R.id.textTitulo);
        textViewTitulo.setText(mensagem.getTitulo());

        TextView textViewDetalhe = (TextView) findViewById(R.id.textDetalhe);
        textViewDetalhe.setText(mensagem.getDetalhe());
    }

    /**
     * Tenta realizar novamente a última ação
     */
    public void tentarNovamente(View view) {
        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            private ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                progressDialog = new ProgressDialog(InformacaoActivity.this);
                progressDialog.setMessage("Por favor aguarde.");
                progressDialog.setTitle("Atualizando");
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                progressDialog.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                startActivity(new Intent(ApplicationNoleggio.getAppContext(), AgenciaActivity.class));
                return null;
            }

            @Override
            protected void onPostExecute(Void params) {
                progressDialog.dismiss();
            }
        };

        asyncTask.execute();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        finish();
    }
}
