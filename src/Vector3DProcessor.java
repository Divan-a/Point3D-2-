public class Vector3DProcessor {//
    public static Vector3D Vector_sum(Vector3D vector1, Vector3D vector2) {
        Vector3D v3 = new Vector3D();
        v3.SetX(vector1.GetX() + vector2.GetX());
        v3.SetY(vector1.GetY() + vector2.GetY());
        v3.SetZ(vector1.GetZ() + vector2.GetZ());
        return v3;
    }

    public static Vector3D Vector_dif(Vector3D vector1, Vector3D vector2) {
        return new Vector3D(
                vector1.GetX() - vector2.GetX(),
                vector1.GetY() - vector2.GetY(),
                vector1.GetZ() - vector2.GetZ()
        );
    }

    public static double Vector_dot_product(Vector3D vector1, Vector3D vector2) {
        return vector1.GetX() * vector2.GetX() + vector1.GetY() * vector2.GetY() + vector1.GetZ() * vector2.GetZ();
    }

    public static Vector3D Vector_product(Vector3D vector1, Vector3D vector2) {
        return new Vector3D(
                vector1.GetY() * vector2.GetZ() - vector2.GetY() * vector1.GetZ(),
                -1 * (vector1.GetX() * vector2.GetZ() - vector2.GetX() * vector1.GetZ()),
                vector1.GetY() * vector2.GetX() - vector2.GetY() * vector1.GetX());
    }

    public static boolean Vector_collinearity_check(Vector3D vector1, Vector3D vector2) { //вопросы имеются
        Vector3D vector3D = Vector_product(vector1, vector2);
        return vector3D.GetX() == 0 && vector3D.GetY() == 0 && vector3D.GetZ() == 0;
    }
}