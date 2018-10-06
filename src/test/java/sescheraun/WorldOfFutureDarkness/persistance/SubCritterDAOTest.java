package sescheraun.WorldOfFutureDarkness.persistance;

import sescheraun.WorldOfFutureDarkness.generator.SubCritter;
import sescheraun.WorldOfFutureDarkness.generator.User;
import sescheraun.WorldOfFutureDarkness.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SubCritterDAOTest {

    /**
     * The Dao.
     */
    SubCritterDAO dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new SubCritterDAO();

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getAllSubCritters(){

        List<SubCritter> subCritters = dao.getAllSubCritters();
        assertEquals(0, subCritters.size());

    }
}
