package entity;

public class Client extends User {

    private int sale;

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

    @Override
    public String toString() {
        return '\n' + "Client id=" + getId() + ", name: " + getName() + ", surname: " + getSurname() + ", phone: " + getPhone()
                + ", sale: " + getSale() + '%';
    }
}
