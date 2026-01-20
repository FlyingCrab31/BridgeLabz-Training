package TrafficManager;

class Vehicle {

    private String number;
    private String type;

    public Vehicle(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + "(" + type + ")";
    }
}
