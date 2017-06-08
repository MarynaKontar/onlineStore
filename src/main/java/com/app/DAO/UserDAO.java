package com.app.DAO;

import com.app.Exceptions.DAOException;
import com.app.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04.06.2017.
 */
public class UserDAO implements DAO<User>{

    @Override
    public void create(User entity) {

    }

    @Override
    public User read(long id) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        Connection con = ConnectionToDB.getConnection();
        PreparedStatement statement = null;
        String sql = "DELETE FROM users WHERE id=?";
//        try (
//            statement = con.prepareStatement(sql)){
//            statement.setLong(1, id);
//            statement.execute();
//            return true;
//        } catch (SQLException e) {
//            //TODO 4 Как правильно, ловить исключение и кидать исключение более высокого уровня (и какое checked или unchecked)?
//            throw new DAOException("Exception occurred while deleting user from DB", e);
//        }
    }


    @Override
    public List<User> getAll() {
        Connection connection = null;
List<User> result = new ArrayList<>();
try( connection = ConnectionToDB.getConnection();
)

        return null;
    }











    public static void create(String name, String pass, String email) {
        User user = read(email,pass);
        if (user.getEmail() !=null ) return;

        Connection connection = null;
        PreparedStatement statement = null;
        connection = ConnectionToDB.getConnection();
        if (connection == null) return;
        String sql = "INSERT INTO users (name, password, email) VALUES (?, ?, ?)";
//        String sql = "INSERT INTO users (name, password, email) VALUES ('"+name+"', '"+pass+"', "'+email+'")";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, pass);
            statement.setString(3, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateByID(Integer id, String newName, String newPass, String newEmail) {
        //check unique

        Connection connection = null;
        PreparedStatement statement = null;
        connection = ConnectionToDB.getConnection();
        if (connection == null) return;
        String sql = "UPDATE users SET name='" + newName + "', password='" + newPass + "', email='" + newEmail + "' WHERE id=" + id + "";
//        String sql = "INSERT INTO users (name, password, email) VALUES ('"+name+"', '"+pass+"', "'+email+'")";

        try {
            statement = connection.prepareStatement(sql);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateByEmail(String email, String newName, String newPass, String newEmail) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = ConnectionToDB.getConnection();
        if (connection == null) return;
        String sql = "UPDATE users SET name='" + newName + "', password='" + newPass + "', email='" + newEmail + "' WHERE email='" + email + "'";
//        String sql = "INSERT INTO users (name, password, email) VALUES ('"+name+"', '"+pass+"', "'+email+'")";

        try {
            statement = connection.prepareStatement(sql);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static User read(String pass, String email) {
        User user = new User();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rSet = null;

        connection = ConnectionToDB.getConnection();
        if (connection == null) return user;
        String sql = "SELECT * FROM users WHERE email='" + email + "' AND password='" + pass + "'";

        try {
            statement = connection.prepareStatement(sql);
            rSet = statement.executeQuery();

            while (rSet.next()){
                user.setId(rSet.getInt("id"));
                user.setName(rSet.getString(2));
                user.setPassword(rSet.getString(3));
                user.setEmail(rSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (rSet != null) {
                try {
                    rSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    public static void delete(String name, String pass, String email) {

    }





    public static ArrayList<User> readUsers() {
        ArrayList<User> users = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rSet = null;

        connection = ConnectionToDB.getConnection();
        if (connection == null) return users;
        String sql = "SELECT * FROM users";

        try {
            statement = connection.prepareStatement(sql);
            rSet = statement.executeQuery();

            while (rSet.next()){
                User user = new User();
                user.setId(rSet.getInt("id"));
                user.setName(rSet.getString(2));
                user.setPassword(rSet.getString(3));
                user.setEmail(rSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (rSet != null) {
                try {
                    rSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }



}
