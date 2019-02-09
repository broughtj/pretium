package org.brough.pretium.PricingEngine;

import org.brough.pretium.MarketData;
import org.brough.pretium.Option;
import org.brough.pretium.Pricer.Pricer;

public class BinomialPricingEngine implements PricingEngine {

    int numSteps;

    public BinomialPricingEngine(int nsteps, Pricer pricer){
        this.numSteps = nsteps;
    }

    public double calculate(Option option, Pricer pricer, MarketData data){
        return pricer.price(option, data);
    }

    public long getNumSteps() {
        return this.numSteps;
    }

    public void setNumSteps(int nsteps) {
        this.numSteps = nsteps;
    }
}