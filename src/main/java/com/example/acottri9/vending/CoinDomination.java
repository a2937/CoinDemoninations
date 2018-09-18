package com.example.acottri9.vending;

import java.util.Objects;

/**
 * The type Coin domination.
 */
public class CoinDomination implements Comparable<CoinDomination>
{
    private double value;

    private String name;


    /**
     * Instantiates a new Coin domination.
     *
     * @param value the value
     * @param name  the name
     */
    public CoinDomination(double value, String name)
    {
        this.value = value;
        this.name = name;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public double getValue()
    {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(double value)
    {
        this.value = value;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoinDomination)) return false;
        CoinDomination that = (CoinDomination) o;
        return Double.compare(that.getValue(), getValue()) == 0 &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getValue(), getName());
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(CoinDomination o)
    {
        if(this.value - o.getValue() == 0)
        {
            return 0;
        }
        else if(this.value - o.getValue() > 0)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
