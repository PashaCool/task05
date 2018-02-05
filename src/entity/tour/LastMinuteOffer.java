package entity.tour;

public class LastMinuteOffer extends Decorator {
    private double sale = 10;

    public LastMinuteOffer(Order order) {
        super(order);
    }

    public LastMinuteOffer(Order order, double sale) {
        super(order);
        this.sale = sale;
    }

    public double getOffer() {
        return sale;
    }

    @Override
    public double getPrice() {
        return order.getPrice() * ((100 - sale) / 100);
    }
}
