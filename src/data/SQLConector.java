package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConector
{
    private static SQLConector instance;
    private Connection dbConn;
    private String URL = "jdbc:sqlserver://localhost:1433;dataBaseName=CURSO";//"jdbc:sqlserver://localhost:1433; databaseName=CURSO;";

    private SQLConector(String user, String password)
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dbConn = DriverManager.getConnection(URL, user, password);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return dbConn;
    }

    public static SQLConector getInstance(String user, String password)throws SQLException//Debe ser publico paara que nos retorne el Singleton
    {
        if(instance == null)
        {
            instance = new SQLConector(user, password);
        }
        else
            if (instance.getConnection().isClosed())
            {
                instance = new SQLConector(user, password);
            }
            return instance;
    }
}
