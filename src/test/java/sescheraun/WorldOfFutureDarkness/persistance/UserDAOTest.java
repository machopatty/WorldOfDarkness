package sescheraun.WorldOfFutureDarkness.persistance;


import sescheraun.WorldOfFutureDarkness.generator.User;
import sescheraun.WorldOfFutureDarkness.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        newUser.setPhoneNumber("608-555-1234");
        newUser.setIsDeleted(false);

        int id = dao.createUser(newUser);

        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("Captain", insertedUser.getFirstName());

        List<User> users = dao.getAllUsers();

        assertEquals(6, users.size());



    }

    @Test
    void updateUser() {

        String newName = "Super";

        User user = dao.getById(1);

        user.setFirstName(newName);

        dao.updateUser(user);

        dao.getById(1);

        assertEquals("Super", user.getFirstName());


    }

    @Test
    void deleteUser() {
        User user = dao.deleteUser(1);

        assertEquals(true, user.getIsDeleted());

//        List<User> users = dao.getAllUsers();
//
//        assertEquals(4, users.size());
    }
}