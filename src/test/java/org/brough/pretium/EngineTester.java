package org.brough.pretium;

import org.brough.pretium.Payoff.VanillaCallPayoff;
import org.brough.pretium.Payoff.VanillaPutPayoff;
import org.brough.pretium.Pricer.AmericanBinomialPricer;
import org.brough.pretium.Pricer.EuropeanBinomialPricer;
import org.brough.pretium.PricingEngine.BinomialPricingEngine;
import org.brough.pretium.Util.Util;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/*
this is to test the different functionality of the Pricing Engine
 */

public class EngineTester {

    //example of a basic unit test
    @Test
    public void testUtilChoose(){
        double d1 = Util.choose(5, 3);
        double d2 = Util.choose(10, 8);
        assertEquals(d1, (double) 10, .00001);
        assertEquals(d2, (double) 45, .00001);
    }

    @Test
    public void testUtilDBinom() {
        double pu = .5;
        double n = 50;
        double x = 25;
        double prob = Util.dbinom(x, n, pu);
        assertEquals(prob, .11227517, .00001);
    }

    @Test
    public void testEuropeanPricer() {
        double strike = 40.0;
        double expiry = 1.0;
        VanillaCallPayoff theCall = new VanillaCallPayoff(strike);
        VanillaPutPayoff thePut = new VanillaPutPayoff(strike);
        Option callOption = new Option(expiry, strike, theCall);
        Option putOption = new Option(expiry, strike, thePut);

        // MarketData
        double spot = 41.0;
        double rate = 0.08;
        double vol = 0.3;
        double div = 0.0;
        MarketData data = new MarketData(rate, spot, vol, div);

        // PricingEngine
        int steps = 1000;
        EuropeanBinomialPricer euroBinom = new EuropeanBinomialPricer(steps);
        BinomialPricingEngine engine = new BinomialPricingEngine(steps, euroBinom);

        OptionFacade facadeCall = new OptionFacade(callOption, engine, data);
        assertEquals(facadeCall.price(euroBinom), 6.962027962879, .0001);

        OptionFacade facadPut = new OptionFacade(putOption, engine, data);
        assertEquals(facadPut.price(euroBinom), 2.8866818183425997, .00001);
    }

    @Test
    public void testAmericanPricer() {
        double strike = 40.0;
        double expiry = 1.0;
        VanillaCallPayoff theCall = new VanillaCallPayoff(strike);
        VanillaPutPayoff thePut = new VanillaPutPayoff(strike);
        Option callOption = new Option(expiry, strike, theCall);
        Option putOption = new Option(expiry, strike, thePut);

        // MarketData
        double spot = 41.0;
        double rate = 0.08;
        double vol = 0.3;
        double div = 0.0;
        MarketData data = new MarketData(rate, spot, vol, div);

        // PricingEngine
        int steps = 1000;
        AmericanBinomialPricer amerBinom = new AmericanBinomialPricer(steps);
        BinomialPricingEngine engine = new BinomialPricingEngine(steps, amerBinom);

        OptionFacade facadeCall = new OptionFacade(callOption, engine, data);
        assertEquals(facadeCall.price(amerBinom), 6.962027962879, .0001);

        OptionFacade facadPut = new OptionFacade(putOption, engine, data);
        assertEquals(facadPut.price(amerBinom), 3.188768817646037, .00001);
    }
}
