/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ash
 */

public class Order {
    private int numHamburgers = 0;
    private int numCheeseburgers = 0;
    private int numVeggieburgers = 0;
    private int numSodas = 0;
    private boolean orderToGo = false;
    private int orderNum;

    public Order(int numHamburgers, int numCheeseburgers, int numVeggieburgers, int numSodas, boolean orderToGo, int orderNum) {
        this.numHamburgers = numHamburgers;
        this.numCheeseburgers = numCheeseburgers;
        this.numVeggieburgers = numVeggieburgers;
        this.numSodas = numSodas;
        this.orderToGo = orderToGo;
        this.orderNum = orderNum;
    }

    public int getNumHamburgers() {
        return numHamburgers;
    }

    public void setNumHamburgers(int numHamburgers) {
        if (numHamburgers < 0) {
            System.out.println("Error: the number of hamburgers cannot be less than zero.");
        } else {
            this.numHamburgers = numHamburgers;
        }
    }

    public int getNumCheeseburgers() {
        return numCheeseburgers;
    }

    public void setNumCheeseburgers(int numCheeseburgers) {
        if (numCheeseburgers < 0) {
            System.out.println("Error: the number of cheeseburgers cannot be less than zero.");
        } else {
            this.numCheeseburgers = numCheeseburgers;
        }
    }

    public int getNumVeggieburgers() {
        return numVeggieburgers;
    }

    public void setNumVeggieburgers(int numVeggieburgers) {
        if (numVeggieburgers < 0) {
            System.out.println("Error: the number of veggie burgers cannot be less than zero.");
        } else {
            this.numVeggieburgers = numVeggieburgers;
        }
    }

    public int getNumSodas() {
        return numSodas;
    }

    public void setNumSodas(int numSodas) {
        if (numSodas < 0) {
            System.out.println("Error: the number of sodas cannot be less than zero.");
        } else {
            this.numSodas = numSodas;
        }
    }

    public boolean isOrderToGo() {
        return orderToGo;
    }

    public void setOrderToGo(boolean orderToGo) {
        this.orderToGo = orderToGo;
    }

    public int getOrderNum() {
        return orderNum;
    }
}
