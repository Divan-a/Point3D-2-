public class Vector3D {

    private double x;
    private double y;
    private double z;

    Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Vector3D(Point3D point1, Point3D point2) {
        this.x = point1.GetX() - point2.GetX();
        this.y = point1.GetY() - point2.GetY();
        this.z = point1.GetZ() - point2.GetZ();
    }

    public double GetX() {
        return x;
    }

    public double GetY() {
        return this.y;
    }

    public double GetZ() {
        return this.z;
    }

    public void SetX(double c) {
        x = c;
    }

    public void SetY(double c) {
        y = c;
    }

    public void SetZ(double c) {
        z = c;
    }

    public double Vector_len() {
        return Math.pow(x * x + y * y + z * z, 0.5);
    }

    public void Info(){
        System.out.printf("Координаты вектора (%.1f, %.1f, %.1f), длина: %.1f\n", x, y, z, Vector_len());
    }

}