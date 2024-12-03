import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Point3D point1 = new Point3D(7, 7, 7);
        Point3D point2 = new Point3D(5, 5, 5);

        Point3D point3 = new Point3D(1, 1, 1);
        Point3D point4 = new Point3D(3, 3, 3);

        Point3D point5 = new Point3D(1, 4, 6);
        Point3D point6 = new Point3D(10, 8, 12);

        point1.displayInfo();
        //point1.SetX(2);
        point1.displayInfo();

        point2.displayInfo();
        point2.GetX();



        if (point2.GetX() == point1.GetX() && point1.GetY() == point2.GetY() && point1.GetZ() == point2.GetZ()) { // пробуем сравнить две точки
            System.out.println("YEA");
        } else {
            System.out.println("NO");
        }
        if (point1 == point1) {
            System.out.println("YEA");
        } else {
            System.out.println("NO");
        }



        // Тут работаем с векторами (и процессор)
        Vector3D vector1 = new Vector3D(point1, point2);
        Vector3D vector2 = new Vector3D(point3, point4);


        double b = vector1.Vector_len();
        System.out.println(b);

        vector1.Vector_eq(vector2);
        Vector3DProcessor.Vector_dif(vector2, vector1); // если менять местами то будет ноль, если сумма, то наоборот
        System.out.println(vector2.Vector_len());
        vector1.Vector_eq(vector2);

        Vector3D vector3 = new Vector3D(point1, point2);
        Vector3D vector4 = new Vector3D(point3, point4);

        vector3.Info();
        vector4.Info();

        double res;
        res = Vector3DProcessor.Vector_dot_product(vector3, vector4);
        System.out.println("Скалярное произведение векторов: " + res);

        Vector3DProcessor.Vector_collinearity_check(vector3, vector4);

        Vector3DProcessor.Vector_product(vector3, vector4);  //показали работает ли колинеарность и заодно произведение векторов
        vector3.Info();



        VectorArray array = new VectorArray(5);
        array.Array_show();

        Scanner in = new Scanner(System.in);
        int size = 5;
        double arr[];
        arr = new double[size];
        arr[0] = -10.0; arr[1] = 5.0; arr[2] = 4.36; arr[3] = 6.2; arr[4] = -9.0;


        array.SetVector(1, vector4);
        System.out.println(array.search_vector(vector4));
        array.vector_sum();
        array.Array_show();

        array.lineal_comb(arr, size);

        array.replace(point5);
        array.Array_show();

        System.out.println(array.max_vector_len());


    }
}