package galen.poc.devices;

import java.util.List;

public class Device {

    private final String name;
    private final int width;
    private final int height;
    private final List<String> tags;

    public Device(String name, int width, int height, List<String> tags) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public List<String> getTags() {
        return tags;
    }
}
