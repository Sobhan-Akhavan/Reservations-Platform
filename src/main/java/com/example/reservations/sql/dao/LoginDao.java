package com.example.reservations.sql.dao;

import com.example.reservations.mvc.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

    String sql = "select * from t_user where c_username = ? and c_password = ?";
    String url = "jdbc:mysql://localhost:3306/reservations";
    String username = "root";
    String password = "1234";

    public boolean validate (String uname, String pass) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), resultSet.getString("c_firstname"), resultSet.getString("c_lastname"));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
