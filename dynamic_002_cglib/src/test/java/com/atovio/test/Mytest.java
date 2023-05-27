package com.atovio.test;

import com.atovio.SubSuperStarLiu;
import com.atovio.SuperStarLiu;
import org.junit.Test;

/**
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class Mytest {

    @Test
    public void testAgent() {
        SuperStarLiu liu = new SubSuperStarLiu();
        liu.sing();
    }
}
