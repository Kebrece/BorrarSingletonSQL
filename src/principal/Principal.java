package principal;

import data.SQLExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) {
        try {
            SQLExecutor executor = new SQLExecutor("sa", "password");
            ResultSet rs = executor.ejecutaQuery("SELECT * FROM CURSO.dbo.PERSONA");
            while (rs.next()) {
                System.out.println(rs.getString("CEDULA")+ " ");
                System.out.println(rs.getString("NOMBRE")+ " ");
                System.out.println(rs.getString("APELLIDO")+ " ");
                System.out.println(rs.getString("EDAD"));
            }
            String valores[] = new String[5];
            valores[0] = "INSERT INTO CURSO.dbo.PERSONA(CEDULA, NOMBRE, APELLIDO, EDAD) values"+
                    "(?,?,?,?)";
            valores[1] = Integer.toString(110840332);
            valores[2] = "Pablo";
            valores[3] = "Chavarria";
            valores[4] = Integer.toString(24);
            executor.prepareStatement(valores);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
