package org.brough.pretium.Payoff;

public class VanillaCallPayoff implements Payoff{

    private double strike;

    public VanillaCallPayoff(double strike){
        this.strike = strike;
    }

    @Override
    public double payoff(double spot) {
        return max(spot - this.strike, 0.0);
    }

    private double max(double x, double y){
        if(x >= y){
            return x;
        }
        else {
            return y;
        }
    }
}
