package org.example.awbtrackerproject.Model.Size;

public class Size {
    private Double length;
    private Double width;
    private Double height;

    public Size(Double length, Double width, Double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getVolume() {
        return length * width * height;
    }
}
