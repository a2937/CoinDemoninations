package com.example.acottri9.vending;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vending machine.
 */
public class VendingMachine
{
    private List<VendedItem> itemList = new ArrayList<>();

    private List<CoinDomination> coinDominations = new ArrayList<>();

    /**
     * Instantiates a new Vending machine.
     */
    public VendingMachine()
    {
        initialize();
    }

    private void initialize()
    {
        coinDominations.add(new CoinDomination(0.01, "Penny"));
        coinDominations.add(new CoinDomination(0.05, "Nickel"));
        coinDominations.add(new CoinDomination(0.10, "Dime"));
        coinDominations.add(new CoinDomination(0.25, "Quarter"));


        itemList.add(new VendedItem("BSoda",0.75));
        itemList.add(new VendedItem("Chocolate Bar", 1.00));
    }

    private List<CoinDomination> makeChange(double money)
    {
        List<CoinDomination> coins = new ArrayList<>();
        double moneyRemaining = money;
        while(moneyRemaining != 0)
        {
            for (CoinDomination coin: coinDominations)
            {
                if(moneyRemaining % coin.getValue() == 0)
                {
                    coins.add(coin);
                    return coins;
                }
                else if(moneyRemaining > coin.getValue())
                {
                    moneyRemaining -= coin.getValue();
                    coins.add(coin);
                }
            }
        }
        return coins;
    }

    /**
     * Add item to vending machine.
     *
     * @param item the item
     */
    public void addItemToVendingMachine(VendedItem item)
    {
       if(item != null)
       {
           itemList.add(item);
       }
    }

    /**
     * Remove item from machine list.
     *
     * @param moneyInserted the money inserted
     * @param item          the item
     * @return the list
     * @throws IllegalAccessException the illegal access exception
     */
    public List<CoinDomination> removeItemFromMachine(List<CoinDomination> moneyInserted, VendedItem item) throws IllegalAccessException
    {
        if(item == null)
        {
            return moneyInserted;
        }
        else
        {
            if(!itemList.contains(item))
            {
                throw new IllegalAccessException("IllegalAccessException on VendingMachine.removeItemFromMachine: " + "item not in machine");
            }
            else
            {
                double combinedMoney = 0;
                for (CoinDomination coin: moneyInserted)
                {
                    combinedMoney += coin.getValue();
                }

                if(combinedMoney < item.getPrice())
                {
                    throw new IllegalAccessException("IllegalAccessException on VendingMachine.removeItemFromMachine: " + "not enough money inserted");
                }
                else if(combinedMoney == item.getPrice())
                {
                    itemList.remove(item);
                    return new ArrayList<CoinDomination>();
                }
                else
                {
                    itemList.remove(item);

                    return makeChange(item.getPrice() - combinedMoney);
                }
            }
        }
    }
}
