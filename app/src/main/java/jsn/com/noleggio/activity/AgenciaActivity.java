package jsn.com.noleggio.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import jsn.com.noleggio.R;

public class AgenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agencia);
    }

    public void pesquisarVeiculo(View view) {
        Intent intent = new Intent(this, VeiculoActivity.class);
        startActivity(intent);
    }
}
