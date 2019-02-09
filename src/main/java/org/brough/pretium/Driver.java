package org.brough.pretium;

import org.brough.pretium.Payoff.VanillaCallPayoff;
import org.brough.pretium.Pricer.AmericanBinomialPricer;
import org.brough.pretium.Pricer.EuropeanBinomialPricer;
import org.brough.pretium.PricingEngine.BinomialPricingEngine;

public class Driver {


    public static void main(String[] args) {
        double strike = 40.0;
        double expiry = 1.0;
        VanillaCallPayoff theCall = new VanillaCallPayoff(strike);
        Option option = new Option(expiry, strike, theCall);

        // MarketData
        double spot = 41.0;
        double rate = 0.08;
        double vol = 0.3;
        double div = 0.0;
        MarketData data = new MarketData(rate, spot, vol, div);

        // PricingEngine
        int steps = 1000;
        EuropeanBinomialPricer euroBinom = new EuropeanBinomialPricer(steps);
        AmericanBinomialPricer amerBinom = new AmericanBinomialPricer(steps);
        BinomialPricingEngine engine = new BinomialPricingEngine(steps, amerBinom);

        // OptionFacade
        OptionFacade facade1 = new OptionFacade(option, engine, data);
        System.out.println(facade1.price(euroBinom));

//        engine.setThePricer(euroBinom);
//        OptionFacade facade2 = new OptionFacade(option, engine, data);
//        System.out.println(facade2.price());
    }
}
