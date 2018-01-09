package entity;

public enum EnumRole {
    Client("Client"),
    Manager("Manager");
    
    private String name;
    
    private EnumRole(String name) {
        this.name = name;
    }
    
    public String getRole() {
        return name;
    }
}
