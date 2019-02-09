package org.brough.pretium.Payoff;

public class VanillaPutPayoff implements Payoff {

    private double strike;

    public VanillaPutPayoff(double strike){
        this.strike = strike;
    }

    @Override
    public double payoff(double spot) {
        return max(this.strike - spot, 0.0);
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
