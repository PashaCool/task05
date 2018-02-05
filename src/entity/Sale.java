/*
 * Класс для отображения и чтения из таблицы sales
 */

package entity;

public class Sale extends Entity {

    private String name;
    private byte size;

    public Sale() {

    }

    public Sale(String name, byte size) {
        this.setName(name);
        this.setSize(size);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSize() {
        return size;
    }

    public void setSize(byte size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return '\n' + "Sale id=" + getId() + ", title: " + getName() + ", size: " + getSize() + '%';
    }
}
