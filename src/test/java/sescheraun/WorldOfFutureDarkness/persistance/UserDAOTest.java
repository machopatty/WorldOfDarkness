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
    void getByID() {
        User user = dao.getById(4);
        assertEquals("Allard", user.getLastName());
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

        User newUser = new User();
        newUser.setFirstName("Captain");
        newUser.setLastName("Caveman");
        newUser.setUserName("CaveyWavey");
        newUser.setAuthenticator("cowabunga");
        newUser.setEmailAddress("TalkToTheClub@OneMillion.BC");
        newUser.setIsDeleted(false);

        int id = dao.createUser(newUser);

        assertNotEquals(0, id);

        User user = dao.getById(id);

        assertEquals("Captain", user.getFirstName());


    }

    @Test
    void updateUser() {


    }

    @Test
    void deleteUser() {

    }
}