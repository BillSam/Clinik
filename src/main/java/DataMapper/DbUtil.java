package DataMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Singleton;
import java.sql.*;
@RequestScoped
public class DbUtil implements DbUtilInt{
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/clinic";
    static final String user= "root";
    static final String password = "adminsm";
    static Connection conn = null;
    Statement stmt = null;

    public DbUtil()  {

        connect();
    }
    public void connect(){
        if(conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(URL, user, password);
                //conn.setAutoCommit(false);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet read(String sql){
        ResultSet rs = null;
        try {

            //  System.out.println("Creating a statement");
            this.stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

        return rs;
    }
    public int writePreparedStatement(PreparedStatement ps){
        int k=0;
        try {
            this.stmt = conn.createStatement();
            k = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return k;
    }

    public int write(String sql){
        int k=0;
        try {
            this.stmt = conn.createStatement();
            k = stmt.executeUpdate(sql);
            return k;
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

        return k;
    }

    public void cleanUp(ResultSet rs) {
        try{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                if (stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }

    }
    public void cleanUp()  {
        try{
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                if (stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }

    }

}

