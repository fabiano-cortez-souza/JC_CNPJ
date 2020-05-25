package br.com.fabiano.infra;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class GetProperties {

    private static String local_db;
    private static String local_db_driver;
    private static String local_db_conn;
    private static String local_db_user;
    private static String local_db_pass;
    private static String local_db_aspas;
    private static String local_path_CNPJ;
    private static String local_path_DB;

    public GetProperties(int tipo) {
        Properties properties = new Properties();
        InputStream input = null;

        try {
            String propFilename = "infra.properties";
            input = getClass().getClassLoader().getResourceAsStream(propFilename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + propFilename);
            }
            properties.load(input);
            GetProperties.local_db = properties.getProperty("dbtipo");

            switch (tipo) {
            case 1:
                GetProperties.local_db_driver = properties.getProperty(local_db + "_db_driver");
                break;
            case 2:
                GetProperties.local_db_conn   = properties.getProperty(local_db + "_db_conn");
                break;
            case 3:
                GetProperties.local_db_user   = properties.getProperty(local_db + "_db_user");
                break;
            case 4:
                GetProperties.local_db_pass   = properties.getProperty(local_db + "_db_pass");
                break;
            case 5:
                GetProperties.local_db_aspas  = properties.getProperty(local_db + "_db_aspas");
                break;
            case 6:
                GetProperties.local_path_CNPJ = properties.getProperty("pathCNPJ");
                break;
            case 7:
                GetProperties.local_path_DB   = properties.getProperty("pathDB");
                break;

            default:
                break;
            }

        } catch (NullPointerException npex) {
            npex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static final String db()        { new GetProperties(0); return local_db;       }
    public static final String db_driver() { new GetProperties(1); return local_db_driver;}
    public static final String db_conn()   { new GetProperties(2); return local_db_conn;  }
    public static final String db_user()   { new GetProperties(3); return local_db_user;  }
    public static final String db_pass()   { new GetProperties(4); return local_db_pass;  }
    public static final String db_aspas()  { new GetProperties(5); return local_db_aspas; }
    public static final String path_CNPJ() { new GetProperties(6); return local_path_CNPJ;}
    public static final String path_DB()   { new GetProperties(7); return local_path_DB;  }
}
