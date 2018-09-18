package com.example.acottri9.vending;

import org.junit.Assert;
import org.junit.Test;

public class CoinDominationTest
{
    @Test
    public void testConstructors()
    {
       CoinDomination coinDomination = new CoinDomination(1.00, "Dollar");
       Assert.assertEquals(1.00,coinDomination.getValue(),0.01);
    }
}
