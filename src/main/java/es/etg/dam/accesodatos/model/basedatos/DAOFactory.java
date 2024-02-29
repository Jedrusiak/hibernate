package es.etg.dam.accesodatos.model.basedatos;
//clase para cambiar de modo sqlite a mysql
public class DAOFactory {
    public static final int MODO_SQLITE = 0;
    public static final int MODO_MYSQL = 1;
    public static final int MODO_HIBERNATE = 2;

    public static BancoDAO getDAO(int modo) {
        switch (modo) {
            case MODO_SQLITE:
                // return new SQLiteDAO();
            case MODO_MYSQL:
                // return new MySQLDAO();
            case MODO_HIBERNATE:
                return new HibernateDAO();
            default:
        }
        return null;
    }
}
