/*
 * первоначальный класс-сущность
 */

package entity;

abstract public class Entity {

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null) {
            if (object != this) {
                if (object.getClass() == getClass() && id != null) {
                    return id.equals(((Entity) object).id);
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
