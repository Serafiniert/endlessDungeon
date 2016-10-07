package math.geometry;

class Rectangle extends java.awt.Rectangle {

    public Rectangle(final math.geometry.Rectangle rect) {
        super(rect.x, rect.y, rect.width, rect.height);
    }

    public Rectangle(final math.geometry.Point p) {
        super(new java.awt.Point(p.x, p.y));
    }

}
