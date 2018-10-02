package sescheraun.WorldOfFutureDarkness.persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sescheraun.WorldOfFutureDarkness.generator.User;
import sescheraun.WorldOfFutureDarkness.test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    UserDAO dao;

    @BeforeEach
    void setUp() {
        dao = new UserDAO();

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }


    @Test
    void getAllUsers(){
        List<User> users = dao.getAllUsers();
        assertEquals(5, users.size());

    }

    @Test
    void getUserBy() {
        List<User> users = dao.getUserBy("lastName", "a");
        assertEquals(3, users.size());
    }

    @Test
    void createUser() {


    }

    @Test
    void updateUser() {


    }

    @Test
    void deleteUser() {

    }
}