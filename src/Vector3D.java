import java.util.Objects;

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
        this.x = point1.getX() - point2.getX();
        this.y = point1.getY() - point2.getY();
        this.z = point1.getZ() - point2.getZ();
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
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return Double.compare(x, vector3D.x) == 0 && Double.compare(y, vector3D.y) == 0 && Double.compare(z, vector3D.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public void Info(){
        System.out.printf("Координаты вектора (%.1f, %.1f, %.1f), длина: %.1f\n", x, y, z, Vector_len());
    }

}