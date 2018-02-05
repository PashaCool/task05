/*
 * Класс клиента, потенциального пассажира
 * для получения или передачи экзампляра таблицы clients
 */

package entity;

public class Client extends User {

    private int sale;
    private int trips;

    public Client(String name, String surname, String phone) {
        this.setName(name);
        this.setSurname(surname);
        this.setPhone(phone);
    }

    public Client(long id, String name, String surname, String phone, int sale) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.sale = sale;
    }

    public Client() {
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getTrips() {
        return trips;
    }

    public void setTrips(int trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return '\n' + "Client id=" + getId() + ", name: " + getName() + ", surname: " + getSurname() + ", phone: "
                + getPhone() + ", sale: " + getSale() + '%' + ", trips: " + getTrips();
    }
}
