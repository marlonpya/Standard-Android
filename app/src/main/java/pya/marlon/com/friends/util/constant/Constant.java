package pya.marlon.com.friends.util.constant;

/**
 * Created by marlonpya on 23/07/17.
 */

public class Constant {

    public static class View {

        public static class Placeholder {
            public static final int IMAGE_DEFAULT = android.R.mipmap.sym_def_app_icon;
        }
    }

    public static class Connection {
        public static final int TIME_OUT = 5000;
        public static final String BASE_URL = "http://192.168.1.41/Friends/api-rest/";

        public static class Error {
            public static final String NOT_CONNECTION = "Sin conexión a internet";
            public static final String ERROR_CONNECTION = "Error al conectarse al servidor";
        }
    }

    public static class SQLite {
        public static final String NAME = "friends.bd";
        //agregar las demás versiones
        public static final int VERSION = 0;

    }
}
