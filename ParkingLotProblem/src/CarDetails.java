
public class CarDetails implements IVehicleDetails {

    private String registration;

    private String color;

    private int slot;

    public CarDetails(String registration, String color) {
        this.color = color;
        this.registration = registration;
    }

    @Override
    public String getRegistration() {
        return registration;
    }

    @Override
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    @Override
    public void setSlot(int slot) {
        this.slot = slot;
    }


}
