package org.brough.pretium;

import org.brough.pretium.Payoff.Payoff;

public class Option {

    private double expiry, strike;
    private Payoff payoff;

    Option(double expiry, double strike, Payoff payoff){
        this.expiry = expiry;
        this.strike = strike;
        this.payoff = payoff;
    }

    public void setStrike(double strike) {
        this.strike = strike;
    }

    public double getStrike() {
        return strike;
    }

    public void setExpiry(double expiry) {
        this.expiry = expiry;
    }

    public void setPayoff(Payoff payoff) {
        this.payoff = payoff;
    }

    public double getExpiry() {
        return expiry;
    }

    public Payoff getPayoff() {
        return payoff;
    }

    public double getPayoffAmount(double spot) {
        return payoff.payoff(spot);
    }
}