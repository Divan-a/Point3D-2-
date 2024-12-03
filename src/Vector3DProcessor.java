public class Vector3DProcessor {
    public static void Vector_sum(Vector3D vector1, Vector3D vector2) {
        double newx = vector1.GetX() + vector2.GetX();
        double newy = vector1.GetY() + vector2.GetY();
        double newz = vector1.GetZ() + vector2.GetZ();
        vector1.SetX(newx);
        vector1.SetY(newy);
        vector1.SetZ(newz);
        vector1.Vector_len();
    }

    public static void Vector_dif(Vector3D vector1, Vector3D vector2) {
        double newx = vector1.GetX() - vector2.GetX();
        double newy = vector1.GetY() - vector2.GetY();
        double newz = vector1.GetZ() - vector2.GetZ();
        vector1.SetX(newx);
        vector1.SetY(newy);
        vector1.SetZ(newz);
        vector1.Vector_len();
    }

    public static double Vector_dot_product(Vector3D vector1, Vector3D vector2) {
        return vector1.GetX() * vector2.GetX() + vector1.GetY() * vector2.GetY() + vector1.GetZ() * vector2.GetZ();
    }

    public static void Vector_product(Vector3D vector1, Vector3D vector2) {
        double newx = vector1.GetY() * vector2.GetZ() - vector2.GetY() * vector1.GetZ();
        double newy = vector1.GetX() * vector2.GetZ() - vector2.GetX() * vector1.GetZ();
        double newz = vector1.GetY() * vector2.GetX() - vector2.GetY() * vector1.GetX();
        vector1.SetX(newx);
        vector1.SetY(newy);
        vector1.SetZ(newz);
        vector1.Vector_len();
    }

    public static void Vector_collinearity_check(Vector3D vector1, Vector3D vector2) {
        double x = vector1.GetX(), y = vector1.GetY(), z = vector1.GetZ();
        Vector_product(vector1, vector2);
        if (vector1.GetX() == 0 && vector1.GetY() == 0 && vector1.GetX() == 0) {
            System.out.println("Векторы колинеарны");
        } else {
            System.out.println("Векторы коллинеарны");
        }

        vector1.SetX(x);
        vector1.SetY(y);
        vector1.SetZ(z);
        vector1.Vector_len();
    }
}