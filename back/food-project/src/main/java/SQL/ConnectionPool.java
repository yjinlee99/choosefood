package SQL;

import java.sql.*;
import java.util.*;

public final class ConnectionPool {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cp = ConnectionPool.getInstance("jdbc:mysql://capstone.cs6kilq1qdog.us-west-1.rds.amazonaws.com:3306/capstone",
                    "admin", "capstone", 5, 10);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    private ArrayList<Connection> free;
    private ArrayList<Connection> used;

    private String url;
    private String user;
    private String password;

    private int initialCons = 0;

    private int maxCons = 0;

    private int numCons = 0;
    static ConnectionPool cp;

    // ConnectionPool 객체 리턴
    public static ConnectionPool getInstance(String url, String user, String password, int initialCons, int maxCons) {
        try {
            if (cp == null) {
                synchronized (ConnectionPool.class) {
                    cp = new ConnectionPool(url, user,
                            password, initialCons, maxCons);
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return cp;
    }

    private ConnectionPool(String url, String user, String password, int initialCons, int maxCons) throws SQLException {

        this.url = url;
        this.user = user;
        this.password = password;
        this.initialCons = initialCons;
        this.maxCons = maxCons;

        if (initialCons < 0)
            initialCons = 5;
        if (maxCons < 0)
            maxCons = 10;

        free = new ArrayList<Connection>(initialCons);
        used = new ArrayList<Connection>(initialCons);

        while (numCons < initialCons) {

            addConnection();
        }
    }

    private void addConnection() throws SQLException {
        free.add(getNewConnection());
    }

    private Connection getNewConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ++numCons;
        return con;
    }

    public synchronized Connection getConnection() throws SQLException {

        if (free.isEmpty()) {

            while (numCons < maxCons) {
                addConnection();
            }
        }
        Connection _con = free.get(free.size() - 1);
        free.remove(_con);
        used.add(_con);
        return _con;
    }

    public synchronized void releaseConnection(Connection _con) throws SQLException {
        boolean flag = false;
        if (used.contains(_con)) {
            used.remove(_con);
            numCons--;
            flag = true;
        } else {
            throw new SQLException();
        }
        try {
            if (flag) {
                free.add(_con);
                numCons++;
            } else {
                _con.close();
            }

        } catch (SQLException e) {

            try {
                _con.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void closeAll() {
        for (int i = 0; i < used.size(); i++) {
            Connection _con = (Connection) used.get(i);
            used.remove(i--);
            try {
                _con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }

        for (int i = 0; i < free.size(); i++) {
            Connection _con = (Connection) free.get(i);
            free.remove(i--);
            try {
                _con.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }

    public int getMaxCons() {
        return maxCons;
    }

    public int getNumCons() {

        return numCons;
    }
}