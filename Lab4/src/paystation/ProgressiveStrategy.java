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
public class ProgressiveStrategy extends RateStrategy {

    private int moneyInserted;
    private int timePurchased;

    //defualt constructor
    public ProgressiveStrategy(){
        moneyInserted = 0;
        timePurchased = 0;
    }

    public ProgressiveStrategy(int monIns){
        moneyInserted = monIns;
        timePurchased = calculateTimePurchased();
    }


    @Override
    protected int calculateTimePurchased() {
        if(){

        }
        return timePurchased;
    }

}
