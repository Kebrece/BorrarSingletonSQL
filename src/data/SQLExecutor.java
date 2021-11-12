package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLExecutor
{
    SQLConector dbConnector;
    PreparedStatement stmt;
    ResultSet rs;

    public SQLExecutor(String user, String password)
    {
        try {
            dbConnector = SQLConector.getInstance(user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void prepareStatement(String[] parametros)
    {
        try{
            stmt = dbConnector.getConnection().prepareStatement(parametros[0]);
            for(int i=1; i<parametros.length; i++)
            {
                stmt.setString(i,parametros[i]);
            }
            stmt.executeUpdate();//INSERT DELETE UPDATE
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet ejecutaQuery(String sql)
    {
        try {
            stmt = dbConnector.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery(); //SELECT
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }

}
