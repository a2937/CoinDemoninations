package com.example.acottri9.vending;

import java.util.Objects;


/**
 * An item coming from a vending machine.
 *
 * Note: this class has a natural ordering that is
 *  inconsistent with equals. All items are ordered by
 *  price, lowest to highest.
 */
public class VendedItem implements Comparable<VendedItem>
{
    /**
     * Instantiates a new Vended item.
     */
    public VendedItem()
    {
        setItemName("");
        setPrice(0.0);
    }

    /**
     * Instantiates a new Vended item.
     *
     * @param itemName the item name
     * @param price    the price
     */
    public VendedItem(String itemName, double price)
    {
        this.itemName = itemName;
        this.price = price;
    }

    private String itemName;

    private double price;


    /**
     * Gets item name.
     *
     * @return the item name
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * Sets item name.
     *
     * @param itemName the item name
     */
    public void setItemName(String itemName)
    {
        if(itemName != null && !itemName.isEmpty())
        {
            this.itemName = itemName;
        }
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price)
    {
        if(price > 0 && price < Double.MAX_VALUE)
        {
            this.price = price;
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof VendedItem)) return false;
        VendedItem that = (VendedItem) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 &&
                Objects.equals(getItemName(), that.getItemName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getItemName(), getPrice());
    }

    /**
     *
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(VendedItem o)
    {
        if(this.price - o.price == 0)
        {
            return 0;
        }
        else if(this.price - o.price > 0)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
