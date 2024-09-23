package e3P1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    /* Tracks. */

    // SFF/PL original double A-Side.
    private static Track beatlesSFFPennyLane01;
    private static Track beatlesSFFPennyLane02;

    // PL promotional release.
    private static Track beatlesPennyLanePromo01;
    private static Track beatlesPennyLanePromo02;

    // SFF digital one-track version.
    private static Track beatlesSFFDigital01;

    @BeforeAll
    static void setUp() {
        /* Recordings. */
        String recBeatlesSFF = "6f5f27e2-fe6d-4c98-be0b-1e58d569909c";
        String recBeatlesPennyLane = "5a6becfb-07e3-4286-8de0-5b4fa826f3f2";

        /* Tracks.
         * Note that some are credited to "Beatles" and some to "The Beatles".
         * Lengths may also vary slightly. */

        // https://musicbrainz.org/release/eadb40cc-9394-3787-80c3-644ed4a167c0
        beatlesSFFPennyLane01 = new Track("A", recBeatlesSFF, "The Beatles","Strawberry Fields Forever", 251);
        beatlesSFFPennyLane02 = new Track("AA", recBeatlesPennyLane,"The Beatles","Penny Lane", 178);

        // https://musicbrainz.org/release/0173d355-016f-4d28-8c57-cdb0b6fd30a0
        beatlesPennyLanePromo01 = new Track("A", recBeatlesPennyLane, "Beatles", "Penny Lane", 180);
        beatlesPennyLanePromo02 = new Track("B", recBeatlesSFF, "Beatles","Strawberry Fields Forever", 245);

        // https://musicbrainz.org/release/af20e7d5-8ab2-4967-8608-c508213b821d
        beatlesSFFDigital01 = new Track("1", recBeatlesSFF,"The Beatles","Strawberry Fields Forever (Remastered 2009)", 238);
    }

    @Test
    void testEquals() {
        assertEquals(beatlesSFFPennyLane01, beatlesPennyLanePromo02);
        assertEquals(beatlesSFFPennyLane02, beatlesPennyLanePromo01);
        assertEquals(beatlesSFFPennyLane01, beatlesSFFDigital01);
        //Test añadidos por nosotros:
        assertEquals(beatlesPennyLanePromo02, beatlesSFFDigital01);
        assertEquals(beatlesPennyLanePromo02, beatlesPennyLanePromo02);

    }

    @Test
    void testNotEquals() {
        assertNotEquals(beatlesSFFPennyLane01, beatlesPennyLanePromo01); // Completely different songs.
        //test añadidos por nosotros:
        Track ejemploTest = null;
        assertNotEquals(beatlesSFFPennyLane01, beatlesSFFPennyLane02);
        assertNotEquals(beatlesPennyLanePromo02, beatlesSFFPennyLane02);
        assertNotEquals(beatlesPennyLanePromo02, beatlesPennyLanePromo01);
        assertNotEquals(beatlesSFFDigital01, beatlesSFFPennyLane02);
        assertNotEquals(beatlesSFFDigital01, beatlesPennyLanePromo01);
        assertNotEquals(beatlesSFFDigital01, ejemploTest);

    }

    @Test
    void testHashCode() {
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesPennyLanePromo02.hashCode());
        //Test añadidos por nosotros:
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesPennyLanePromo02.hashCode());
        assertEquals(beatlesSFFPennyLane02.hashCode(), beatlesPennyLanePromo01.hashCode());
        assertEquals(beatlesSFFPennyLane01.hashCode(), beatlesSFFDigital01.hashCode());
        assertEquals(beatlesPennyLanePromo02.hashCode(), beatlesSFFDigital01.hashCode());

        assertNotEquals(beatlesSFFPennyLane01.hashCode(), beatlesPennyLanePromo01.hashCode());
        assertNotEquals(beatlesSFFPennyLane01.hashCode(), beatlesSFFPennyLane02.hashCode());
        assertNotEquals(beatlesPennyLanePromo02.hashCode(), beatlesSFFPennyLane02.hashCode());
        assertNotEquals(beatlesPennyLanePromo02.hashCode(), beatlesPennyLanePromo01.hashCode());
        assertNotEquals(beatlesSFFDigital01.hashCode(), beatlesSFFPennyLane02.hashCode());
        assertNotEquals(beatlesSFFDigital01.hashCode(), beatlesPennyLanePromo01.hashCode());
    }

    //Test añadidos por nosotros
    @Test
    public void testGetRecordingId() {
        String recordingId = Track.getRecordingId(beatlesSFFPennyLane01);
        assertEquals("6f5f27e2-fe6d-4c98-be0b-1e58d569909c", recordingId);
    }

    @Test
    public void testConstructorAndGetters() {

        assertEquals("A", beatlesSFFPennyLane01.getNumeroPista());
        assertEquals("6f5f27e2-fe6d-4c98-be0b-1e58d569909c", beatlesSFFPennyLane01.getId());
        assertEquals("The Beatles", beatlesSFFPennyLane01.getArtista());
        assertEquals("Strawberry Fields Forever", beatlesSFFPennyLane01.getTitulo());
        assertEquals(251, beatlesSFFPennyLane01.getDuracion());
    }
}
