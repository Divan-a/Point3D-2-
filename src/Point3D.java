public class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double GetX() {
        return this.x;
    }

    public double GetY() {
        return this.y;
    }

    public double GetZ() {
        return this.z;
    }

    public void SetX(double c) {
        this.x = c;
    }

    public void SetY(double c) {
        this.y = c;
    }

    public void SetZ(double c) {
        this.z = c;
    }

    public void displayInfo() {
        System.out.printf("Координаты точки (%.1f, %.1f, %.1f)\n", GetX(), GetY(), GetZ());
    }
}
