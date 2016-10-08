package generator;

import java.awt.*;

public class RandomDimension {

    public static final Dimension SIZE_MIN = new Dimension(4, 4);
    public static final Dimension SIZE_MAX = new Dimension(7, 7);

    private Dimension size;

    public RandomDimension() {
        this.createRandomDimension(RandomDimension.SIZE_MIN, RandomDimension.SIZE_MAX);
    }

    public RandomDimension(final Dimension min, final Dimension max) {
        this.createRandomDimension(min, max);
    }

    private void createRandomDimension(final Dimension min, final Dimension max) {
        this.size = this.calculateSize(min, max);
    }

    private Dimension calculateSize(final Dimension min, final Dimension max) {
        int width = min.width + (int) (Math.random() * max.width);
        int height = min.height + (int) (Math.random() * max.height);
        return new Dimension(width, height);
    }

    public Dimension getSize() {
        return this.size;
    }
}
