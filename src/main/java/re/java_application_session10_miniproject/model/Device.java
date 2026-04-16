package re.java_application_session10_miniproject.model;

public class Device {
    private Long id;
    private String name;
    private String description;
    private int totalQuantity;
    private int available;

    public Device() {}

    public Device(Long id, String name, String description, int totalQuantity, int available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.totalQuantity = totalQuantity;
        this.available = available;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
