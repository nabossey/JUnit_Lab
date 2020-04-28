import static org.junit.Assert.*;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

public class GradebookTester {

      private GradeBook g1;

      @Before

      public void setUp() {

            g1 = new GradeBook(5);

            g1.addScore(50);

            g1.addScore(75);

            g1.addScore(100);

            g1.addScore(90);

      }

      @After

      public void tearDown() {

            g1 = null;

      }

      @Test

      public void testAddScore() {

            // since this method needs to work a bit different, we re initialize

            // gradebook with a capacity of 3

            g1 = new GradeBook(3);

            // ensuring that at tha start, score size is 0, and sum of scores is

            // also 0

            assertEquals(0, g1.getScoreSize());

            assertEquals(0, g1.sum(), 0.0001);

            // adding one score

            g1.addScore(99);

            // size should be 1 and sum should be 99 now

            assertEquals(1, g1.getScoreSize());

            assertEquals(99, g1.sum(), 0.0001);

            // adding one more score

            g1.addScore(25);

            // size should be 2 and sum should be 99+25 now

            assertEquals(2, g1.getScoreSize());

            assertEquals(99 + 25, g1.sum(), 0.0001);

            // adding one more score

            g1.addScore(77);

            // size should be 3 and sum should be 99+25+77 now

            assertEquals(3, g1.getScoreSize());

            assertEquals(99 + 25 + 77, g1.sum(), 0.0001);

            // trying to add one more score, should not cause any changes as max

            // capacity is reached. and addScore should return false

            assertFalse(g1.addScore(87));

            // size and sum should be unchanged

            assertEquals(3, g1.getScoreSize());

            assertEquals(99 + 25 + 77, g1.sum(), 0.0001);

      }

      @Test

      public void testSum() {

            // ensuring that sum of scores should be what we expect (based on scores

            // added in setup method)

            assertEquals(50 + 75 + 100 + 90, g1.sum(), 0.0001);

            // adding one more score and ensuring that the score is added to the sum

            g1.addScore(55);

            assertEquals(50 + 75 + 100 + 90 + 55, g1.sum(), 0.0001);

      }

      @Test

      public void testMinimum() {

            // ensuring that minimum() returns 50 as 50 is the lowest score based on

            // scores added in setup method

            assertEquals(50, g1.minimum(), 0.0001);

            // adding one score lower than 50

            g1.addScore(22);

            // 22 should be the new minimum

            assertEquals(22, g1.minimum(), 0.0001);

      }

      @Test

      public void testFinalScore() {

            // finalScore should return the sum without 50 (lowest score)

            assertEquals(75 + 100 + 90, g1.finalScore(), 0.0001);

            // adding a new minumum score

            g1.addScore(22);

            // finalScore should return the sum without 22 (lowest score)

            assertEquals(50 + 75 + 100 + 90, g1.finalScore(), 0.0001);

            // reinitializing g1

            g1 = new GradeBook(2);

            // ensuring that finalScore returns 0

            assertEquals(0, g1.finalScore(), 0.0001);

      }

      @Test

      public void testGetScoreSize() {

            // initially there should be 4 scores based on scores added in setup

            // method

            assertEquals(4, g1.getScoreSize());

            //adding one score, it should be 5

            g1.addScore(22);

            assertEquals(5, g1.getScoreSize());

            //adding one score, it should still be 5 because 5 is the capacity we set

            g1.addScore(76);

            assertEquals(5, g1.getScoreSize());

      }

      @Test

      public void testToString() {

            //ensuring that toString() return values properly.

            assertTrue(g1.toString().equals("50.0 75.0 100.0 90.0"));

            g1.addScore(22);

            assertTrue(g1.toString().equals("50.0 75.0 100.0 90.0 22.0"));

            g1.addScore(80);

            assertTrue(g1.toString().equals("50.0 75.0 100.0 90.0 22.0"));

      }

}