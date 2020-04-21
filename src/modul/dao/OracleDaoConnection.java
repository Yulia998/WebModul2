package modul.dao;

import modul.model.Questions;
import modul.model.Users;
import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleDaoConnection implements DaoConnection {
    private static OracleDaoConnection oracleDaoConnection;
    private Connection connection;
    private PreparedStatement prstatement;
    private ResultSet resultSet;
    private Driver driver;

    private OracleDaoConnection (){}

    public static OracleDaoConnection getInstance(){
        if(oracleDaoConnection == null){
            return new OracleDaoConnection();
        }
        return oracleDaoConnection;
    }

    @Override
    public void connect() {
        driver = new OracleDriver();
        try {
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "STUDENT", "oracle");
            if(!connection.isClosed()) {
                System.out.println("Success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
            resultSet.close();
            prstatement.close();
            System.out.println("Disconect");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Questions> getQuestions() {
        List<Questions> questions = new ArrayList<>();
        try {
            prstatement = connection.prepareStatement("SELECT * FROM QUESTIONS WHERE rownum<5");
            resultSet = prstatement.executeQuery();
            while (resultSet.next()) {
                questions.add(parseQuset(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    private Questions parseQuset (ResultSet resultSet) {
        Questions question = null;
        connect();
        try {
            int id = resultSet.getInt("ID");
            String quest = resultSet.getString("QUESTION");
            String answ = resultSet.getString("ANSWER");
            int points = resultSet.getInt("POINTS");
            question = new Questions(id, quest, answ, points);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return question;
    }

    public void insertUser(Users user) {
            connect();
            try {
                prstatement = connection.prepareStatement("INSERT INTO USERS " +
                        "VALUES (NULL , ?, ?)");
                prstatement.setString(1, user.getName());
                prstatement.setInt(2, user.getTotal());
                prstatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            disconnect();
        }
}
