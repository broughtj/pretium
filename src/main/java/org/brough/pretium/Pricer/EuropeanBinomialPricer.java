package org.brough.pretium.Pricer;

import org.brough.pretium.MarketData;
import org.brough.pretium.Option;
import org.brough.pretium.Util.Util;

public class EuropeanBinomialPricer implements  Pricer {
    private int nsteps;

    public EuropeanBinomialPricer(int steps) {
        this.nsteps = steps;
    }

    @Override
    public double price(Option theOption, MarketData theData) {
        double expiry = theOption.getExpiry();
        double strike = theOption.getStrike();
        double spot = theData.getSpot();
        double rate = theData.getRate();
        double volatility = theData.getVolatility();
        double dividend = theData.getDividend();
        int nsteps = this.nsteps;
        int nodes = this.nsteps + 1;
        double dt = expiry/nsteps;
        double u = Math.exp(((rate - dividend) * dt) + volatility * Math.sqrt(dt));
        double d = Math.exp(((rate - dividend) * dt) - volatility * Math.sqrt(dt));
        double pu = (Math.exp((rate - dividend) * dt) - d) / (u - d);
        double pd = 1 - pu;
        double disc = Math.exp(-rate * expiry);
        double spotT = 0.0;
        double payoffT = 0.0;

        for(int i = 0; i < nodes; ++i){
            spotT = spot * Math.pow(u, (nsteps - i)) * Math.pow(d, i);
            payoffT += theOption.getPayoffAmount(spotT) * Util.dbinom(nsteps-i, nsteps, pu);
        }

        double price = disc * payoffT;

        return price;
    }
}