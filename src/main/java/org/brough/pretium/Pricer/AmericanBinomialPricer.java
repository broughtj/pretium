package org.brough.pretium.Pricer;

import org.brough.pretium.MarketData;
import org.brough.pretium.Option;

import java.util.List;

public class AmericanBinomialPricer implements Pricer {

    private int nsteps;

    public AmericanBinomialPricer(int nsteps) {
        this.nsteps = nsteps;
    }

    private double max(double a, double b) {
        return (a > b) ? a: b;
    }

    @Override
    public double price(Option theOption, MarketData theData) {
        double expiry = theOption.getExpiry();
        double strike = theOption.getStrike();
        double spot = theData.getSpot();
        double rate = theData.getRate();
        double volatility = theData.getVolatility();
        double dividend = theData.getDividend();
        int nsteps =  this.nsteps;
        int nodes = this.nsteps + 1;
        double dt = expiry/nsteps;
        double u = Math.exp(((rate - dividend) * dt) + volatility * Math.sqrt(dt));
        double d = Math.exp(((rate - dividend) * dt) - volatility * Math.sqrt(dt));
        double pu = (Math.exp((rate - dividend) * dt) - d) / (u - d);
        double pd = 1 - pu;
        double disc = Math.exp(-rate * dt);
        double dpu = disc * pu;
        double dpd = disc * pd;

        double[] Ct = new double[nodes];
        double[] St = new double[nodes];

        for(int i = 0; i < Ct.length; ++i) {
            St[i] = spot * Math.pow(u, (nsteps - i)) * Math.pow(d, i);
            Ct[i] = theOption.getPayoffAmount(St[i]);
        }

        for(int i = Ct.length-1; i >= 0; --i) {
            for(int j = 0; j < i; ++j) {
                Ct[j] = dpu * Ct[j] + dpd * Ct[j+1];
                St[j] = St[j] / u;
                Ct[j] = max(Ct[j], theOption.getPayoffAmount(St[j]));
            }
        }

        return Ct[0];
    }
}
