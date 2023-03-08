package hospital.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Context {

	static {
		
		try {
		Class.forName("com.mysql.cj.Hopital.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		}
		private static PatientDao patientDao = new patientDaoImpl();
		private static VisiteDao visiteDao = new visiteDaoImpl();
		private static CompteDao CompteDao = new compteDaoImpl();
		
//		public static PersonneDao getPersonneDao() {
//		return personneDao;
//		}
		private static Context singleton = null;

		public static Context getContext() {
			if (singleton == null) {
				singleton = new Context();
			}
			return singleton;
		}

		private Connection connection;

		private Context() {
			try {
				connection = DriverManager.getConnection("Hopital:mysql://localhost:3306/hopital", "root", "root123@");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public Connection getConnection() {
			return connection;
		}

		public static void destroy() {
			if (singleton != null) {
				singleton.close();
				singleton = null;
			}
		}

		static void close() {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
