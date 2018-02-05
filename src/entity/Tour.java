/*
 * Класс для отображения и чтения из таблицы tours_list
 */

package entity;

import entity.tour.Order;

public class Tour extends Entity implements Order {

    private String city;
    private String type;// тип поездки: tour, shopping, sanative
    private int days;
    private double price;
    private double offer;// величина скдки, если включена опция "горящего предложения"
    private boolean eat;
    private boolean hotel;
    private boolean visa;
    private String transBus;
    private boolean burning; // булевое значение. если true, значит тур со скидкой, сделать еще скидку нельзя

    public Tour() {
    }

    public Tour(long id, String city, String type) {
        this.id = id;
        this.city = city;
        this.type = type;
    }

    public Tour(String city, String type, int days, double price, boolean eat, boolean hotel, boolean visa, String tr) {
        this.setCity(city);
        this.setType(type);
        this.setPrice(price);
        this.setDays(days);
        this.setEat(eat);
        this.setHotel(hotel);
        this.setVisa(visa);
        transBus = tr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isEat() {
        return eat;
    }

    public void setEat(boolean eat) {
        this.eat = eat;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isVisa() {
        return visa;
    }

    public void setVisa(boolean visa) {
        this.visa = visa;
    }

    public String getTransBus() {
        return this.transBus;
    }

    public void setTransBus(String transBus) {
        this.transBus = transBus;
    }

    public boolean isSale() {
        return burning;
    }

    public void setSale(boolean c) {
        burning = c;
    }

    @Override
    public String toString() {
        String sl = "";
        if (isSale())
            sl = " " + getOffer() + "% sale!";
        return '\n' + "Tour id=" + getId() + ", city: " + getCity() + ", type: " + getType() + ", days: " + getDays()
                + ", price: " + getPrice() + sl + ", eat: " + isEat() + ", hotel: " + isHotel() + ", visa: " + isVisa()
                + ", transport: " + getTransBus();
    }
}
