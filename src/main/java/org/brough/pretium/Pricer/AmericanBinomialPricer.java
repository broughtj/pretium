package org.brough.pretium.Pricer;

import org.brough.pretium.MarketData;
import org.brough.pretium.Option;

public class AmericanBinomialPricer implements Pricer {

    private double nsteps;

    public AmericanBinomialPricer(int nsteps) {
        this.nsteps = nsteps;
    }

    @Override
    public double price(Option theOption, MarketData theData) {
        // Fill in the real algorithm here

        // Returning just a constant to test
        return 3.14;
    }
}
