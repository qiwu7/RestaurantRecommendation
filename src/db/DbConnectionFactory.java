package db;

import db.mongodb.MongoDbConnection;
import db.mysql.MySQLConnection;

public class DbConnectionFactory {

	// This should change based on the pipeline.
	private static final String DEFAULT_DB = "mongodb";

	// Create a DBConnection based on given db type.
	public static DbConnection getDBConnection(String db) {
		switch (db) {
		case "mysql":
			return MySQLConnection.getInstance();
		case "mongodb":
			return MongoDbConnection.getInstance();
		default:
			throw new IllegalArgumentException("Invalid db " + db);
		}
	}

	//overload
	public static DbConnection getDBConnection() {
		return getDBConnection(DEFAULT_DB);
	}
}
