package com.SpringIntro.ConstructorInjection.collection;

import com.SpringIntro.ConstructorInjection.collection.leetCode.Leetcode;
import com.SpringIntro.ConstructorInjection.collection.leetCode.LeetcodeImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LeetcodeTest {

    Leetcode leetcode = new LeetcodeImpl();
    @Test
    void testExpectedException() {
        leetcode.isValid("]");
    }



}
