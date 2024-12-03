public class Vector3D {
    private double x, y, z;
    private double len;

    Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.len = Vector_len();
    }

    Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.len = Vector_len();
    }

    Vector3D(Point3D point1, Point3D point2) {
        this.x = point1.GetX() - point2.GetX();
        this.y = point1.GetY() - point2.GetY();
        this.z = point1.GetZ() - point2.GetZ();
        this.len = Vector_len();
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

    public double Vector_len() {
        double len = Math.pow(x * x + y * y + z * z, 0.5);
        this.len = len;
        return len;
    }

    public boolean Vector_eq(Vector3D vector2) {
        boolean bul = false;
        if (this.len == vector2.Vector_len() && (this.x / vector2.x == this.y / vector2.y && this.y / vector2.y == this.z / vector2.z)) {
            bul = true;

        }
        return bul;
    }

    public void Info(){
        System.out.printf("Координаты вектора (%.1f, %.1f, %.1f), длина: %.1f\n", this.GetX(), this.GetY(), this.GetZ(), this.len);
    }

}