/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Mikhail Plekunov
 */

package ex24;

import ex24.Base.Anagram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    @DisplayName("IsAnagram method should return true")
    public void test_IsAnagram_returns_true() {
        assertTrue(new Anagram("note", "tone").isAnagram(), "Those are anagrams");
    }

    @Test
    @DisplayName("IsAnagram method should return false")
    public void test_IsAnagram_returns_false() {
        assertFalse(new Anagram("not", "anagram").isAnagram(), "Those aren't anagrams");
    }
}
