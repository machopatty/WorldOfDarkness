package sescheraun.WorldOfFutureDarkness.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Sub critter.
 */
public class SubCritter {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int subCritterId;

    @Column(name = "subCritterLabel")
    private String subCritterLabel;

    @ManyToOne
    private Critter critter;

    @Column(name = "critterSubName")
    private String critterSubName;

    @Column(name = "first_Advantage")
    private String first_Advantage;

    @Column(name = "second_Advantage")
    private String second_Advantage;

    @Column(name = "flaw")
    private String flaw;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    /**
     * Instantiates a new Sub critter.
     */
    public SubCritter() {
    }

    /**
     * Instantiates a new Sub critter.
     *
     * @param critter          the critter
     * @param subCritterLabel  the sub critter label
     * @param critterSubName   the critter sub name
     * @param first_Advantage  the first advantage
     * @param second_Advantage the second advantage
     * @param flaw             the flaw
     */
    public SubCritter(Critter critter, String subCritterLabel, String critterSubName, String first_Advantage, String second_Advantage, String flaw) {
        this.subCritterLabel = subCritterLabel;
        this.critter = critter;
        this.critterSubName = critterSubName;
        this.first_Advantage = first_Advantage;
        this.second_Advantage = second_Advantage;
        this.flaw = flaw;
        this.isDeleted = false;
    }

    /**
     * Gets sub critter id.
     *
     * @return the sub critter id
     */
    public int getSubCritterId() {
        return subCritterId;
    }

    /**
     * Sets sub critter id.
     *
     * @param subCritterId the sub critter id
     */
    public void setSubCritterId(int subCritterId) {
        this.subCritterId = subCritterId;
    }

    /**
     * Gets sub critter label.
     *
     * @return the sub critter label
     */
    public String getSubCritterLabel() {
        return subCritterLabel;
    }

    /**
     * Sets sub critter label.
     *
     * @param subCritterLabel the sub critter label
     */
    public void setSubCritterLabel(String subCritterLabel) {
        this.subCritterLabel = subCritterLabel;
    }

    /**
     * Gets critter.
     *
     * @return the critter
     */
    public Critter getCritter() {
        return critter;
    }

    /**
     * Sets critter.
     *
     * @param critter the critter
     */
    public void setCritter(Critter critter) {
        this.critter = critter;
    }

    /**
     * Gets critter sub name.
     *
     * @return the critter sub name
     */
    public String getCritterSubName() {
        return critterSubName;
    }

    /**
     * Sets critter sub name.
     *
     * @param critterSubName the critter sub name
     */
    public void setCritterSubName(String critterSubName) {
        this.critterSubName = critterSubName;
    }

    /**
     * Gets first advantage.
     *
     * @return the first advantage
     */
    public String getFirst_Advantage() {
        return first_Advantage;
    }

    /**
     * Sets first advantage.
     *
     * @param first_Advantage the first advantage
     */
    public void setFirst_Advantage(String first_Advantage) {
        this.first_Advantage = first_Advantage;
    }

    /**
     * Gets second advantage.
     *
     * @return the second advantage
     */
    public String getSecond_Advantage() {
        return second_Advantage;
    }

    /**
     * Sets second advantage.
     *
     * @param second_Advantage the second advantage
     */
    public void setSecond_Advantage(String second_Advantage) {
        this.second_Advantage = second_Advantage;
    }

    /**
     * Gets flaw.
     *
     * @return the flaw
     */
    public String getFlaw() {
        return flaw;
    }

    /**
     * Sets flaw.
     *
     * @param flaw the flaw
     */
    public void setFlaw(String flaw) {
        this.flaw = flaw;
    }

    /**
     * Gets is deleted.
     *
     * @return the is deleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * Sets is deleted.
     *
     * @param deleted the deleted
     */
    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "SubCritter{" +
                "subCritterId=" + subCritterId +
                ", subCritterLabel='" + subCritterLabel + '\'' +
                ", critter=" + critter +
                ", critterSubName='" + critterSubName + '\'' +
                ", first_Advantage='" + first_Advantage + '\'' +
                ", second_Advantage='" + second_Advantage + '\'' +
                ", flaw='" + flaw + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
