/*
 * Создавался класс для хранения значений из таблицы trips
 * должен был хранить id группы пассажиров и карту клиент-тур
 */

package entity;

import java.util.Map;

public class Trip extends Entity {

    private Map<Client, Tour> passangers;
    private int group;

    public void setGroup(int group) {
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    public Map<Client, Tour> getPassangers() {
        return passangers;
    }
}