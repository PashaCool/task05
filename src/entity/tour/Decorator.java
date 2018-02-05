package entity.tour;

public abstract class Decorator implements Order {
    protected Order order;

    public Decorator(Order order) {
        this.order = order;
    }

    public double getPice() {
        return order.getPrice();
    }
}
