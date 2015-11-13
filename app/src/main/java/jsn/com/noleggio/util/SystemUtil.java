package jsn.com.noleggio.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.Locale;

public class SystemUtil {
	public static final Locale LOCALE_BRASIL = new Locale("pt", "BR");

	/**
	 * @return <b>True</b> se existir conexão com a internet
	 */
	public static boolean possuiConexaoInternet() {
		ConnectivityManager connMgr = (ConnectivityManager)
				ApplicationNoleggio.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		} else {
			return false;
		}
	}

}
