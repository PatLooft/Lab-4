/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation;

/**
 *
 * @author johnn
 */
public class LinearStrategy extends RateStrategy {

    @Override
    public int getMoneyInserted() {
        return moneyInserted;
    }

    @Override
    public void setMoneyInserted(int moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    //    Time= (amount *2)/5
    private int moneyInserted;
    private int timePurchased;

    //defualt constructor
    public LinearStrategy(){
        moneyInserted = 0;
        timePurchased = 0;
    }

    public LinearStrategy(int monIns){
        moneyInserted = monIns;
        timePurchased = calculateTimePurchased();
    }


    //    Linear rate: Time= (amount *2)/5
    @Override
    protected int calculateTimePurchased() {
        timePurchased = (moneyInserted * 2) / 5;
        return timePurchased;
    }
}
