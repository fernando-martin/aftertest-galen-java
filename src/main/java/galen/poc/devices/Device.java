package galen.poc.devices;

import org.openqa.selenium.Dimension;

import java.util.List;

public class Device {

    private final String name;
    private final Dimension size;
    private final List<String> tags;

    public Device(String name, Dimension size, List<String> tags) {
        this.name = name;
        this.size = size;
        this.tags = tags;
    }

    public Dimension getSize() {
        return size;
    }

    public List<String> getTags() {
        return tags;
    }
}
