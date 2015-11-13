package jsn.com.noleggio.client;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import jsn.com.noleggio.enums.GrupoVeiculoEnum;
import jsn.com.noleggio.enums.StatusVeiculoEnum;
import jsn.com.noleggio.model.Agencia;
import jsn.com.noleggio.model.Veiculo;
import jsn.com.noleggio.util.SystemUtil;

/**
 * Created by joaquimsn on 11/12/15.
 */
public class WsClient {
    private final String URL = "http://noleggio.joaquimsn.com:8080/locadora/api/";

    private JsonObject jsonObject;
    private Gson gson;

    public WsClient() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    public List<Agencia> buscarAgencia() {
        List<Agencia> listaAgencia = new ArrayList<>();

        for (int i = 1; i < 10 ; i++) {
            Agencia agencia = new Agencia();
            agencia.setIdAgencia(i);
            agencia.setFantasia("Agência " + i);
            listaAgencia.add(agencia);
        }

        if (!SystemUtil.possuiConexaoInternet()) {
            return null;
        }

        try {
            java.net.URL url = new URL(URL + "agencias");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Typ'e", "application/json");
            con.setUseCaches(false);

            con.connect();

            String jsonString = "";
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = con.getInputStream();

                listaAgencia = gson.fromJson(readStream(inputStream), new TypeToken<List<Agencia>>(){}.getType());
            }

        } catch (java.io.IOException e) {
            Log.e(getClass().getName(),"Erro na comunicação com o servidor", e);
        } catch (Exception e) {
            Log.e(getClass().getName(),"Erro na comunicação com o servidor", e);
        }

        return listaAgencia;
    }

    public List<Veiculo> buscarVeiculo(int idAgencia) {
        List<Veiculo> listaVeiculo = new ArrayList<>();

        for (int i = 1; i < 10 ; i++) {
            Veiculo veiculo = new Veiculo();
            veiculo.setIdVeiculo(i);
            veiculo.setModelo("Agência " + i);
            veiculo.setAcessorio("");
            veiculo.setFabricante("Fabricante");
            veiculo.setModelo("Veiculo Popular M" + 1);
            veiculo.setFabricante("Hyundai");
            veiculo.setPrecoKmControlado(46.50 * i);

            if (i % 2 == 0) {
                veiculo.setStatus(StatusVeiculoEnum.DISPONIVEL);
            } else {
                veiculo.setStatus(StatusVeiculoEnum.LOCADO);
            }
            veiculo.setGrupo(GrupoVeiculoEnum.C);
            veiculo.setPrecoKmLivre(50 * i);
            listaVeiculo.add(veiculo);
        }

        if (!SystemUtil.possuiConexaoInternet()) {
            return null;
        }

        try {
            URL url = new URL(URL + "/notafiscal/conhecimento/" + idAgencia);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Typ'e", "application/jove.v1+json");
            con.setUseCaches(false);

            con.connect();

            String jsonString = "";
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = con.getInputStream();
                jsonString = readStream(inputStream);

//                JsonArray jsonObject = gson.fromJson(jsonString, JsonArray.class);

                listaVeiculo = gson.fromJson(jsonString, new TypeToken<List<Veiculo>>() {}.getType());
            }

        } catch (java.io.IOException e) {
            Log.e(getClass().getName(),"Erro na comunicação com o servidor", e);
        } catch (Exception e) {
            Log.e(getClass().getName(),"Erro na comunicação com o servidor", e);
        }

        return listaVeiculo;
    }

    private String readStream(InputStream stream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream),1000);
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()){
            stringBuilder.append(line);
        }
        stream.close();
        return stringBuilder.toString();
    }
}
