package galen.poc.devices;

import org.openqa.selenium.Dimension;

import java.util.List;

public class Device {

    private final String name;
    private final Dimension screenSize;
    private final List<String> tags;

    public Device(String name, Dimension screenSize, List<String> tags) {
        this.name = name;
        this.screenSize = screenSize;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public List<String> getTags() {
        return tags;
    }
}
