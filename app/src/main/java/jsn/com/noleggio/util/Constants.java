package jsn.com.noleggio.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Joaquim Neto on 9/6/15.
 */
public class Constants {

  public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
  public static final String VEICULO_SELECIONADO = "VEICULO_SELECIONADO";

  /**
   * Padrão MM/yyyy
   */
  public static final String PATTERN_YYYY_MM = "MM-yyyy";

  /**
   * Padrão dd/MM/yyyy
   */
  public static final String PATTERN_DD_MM_YYYY = "dd/MM/yyyy";

  /**
   * Padrão yyyy-MM-dd
   */
  public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";

  /**
   * Padrão HH:mm
   */
  public static final String PATTERN_HH_MM = "HH:mm";

  /**
   * Padrão dd-MM-yyyy_hh'h'mm'm'ss's' para nome de arquivos
   */
  public static final String PATTERN_DATETIME_BRASIL_NOME_ARQUIVO = "dd-MM-yyyy_HH'h'mm'm'ss's'";

  /**
   * DateFormat no padrão dd/MM/yyyy
   */
  public static final DateFormat DATE_FORMAT_BRASIL = new SimpleDateFormat(PATTERN_DD_MM_YYYY);

  /**
   * DateFormat no padrão yyyy-MM-dd
   */
  public static final DateFormat DATE_FORMAT_INTERNACIONAL = new SimpleDateFormat(PATTERN_YYYY_MM_DD);

  /**
   * DateFormat no padrão dd/MM/yyyy HH:mm
   */
  public static final DateFormat DATETIME_FORMAT_BRASIL = new SimpleDateFormat(PATTERN_DD_MM_YYYY + " " + PATTERN_HH_MM);

  /**
   * DateFormat no padrão dd/MM/yyyy HH:mm
   */
  public static final DateFormat DATETIME_FORMAT_INTERNACIONAL = new SimpleDateFormat(PATTERN_YYYY_MM_DD + " " + PATTERN_HH_MM);

  /**
   * DateFormat no padrão dd-MM-yyyy_hh'h'mm'm'ss's'
   */
  public static final DateFormat DATETIME_FORMAT_BRASIL_ARQUIVO = new SimpleDateFormat(PATTERN_DATETIME_BRASIL_NOME_ARQUIVO);
}
