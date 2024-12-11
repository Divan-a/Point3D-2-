import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Point3D point1 = new Point3D(7, 7, 7);
        Point3D point11 = new Point3D(7, 7, 7);
        Point3D point2 = new Point3D(5, 5, 5);

        Point3D point3 = new Point3D(1, 1, 1);
        Point3D point4 = new Point3D(3, 3, 3);

        Point3D point5 = new Point3D(1, 4, 6);
        Point3D point6 = new Point3D(10, 8, 12);

        point1.displayInfoAboutPoint();
        //point1.SetX(2);
        point1.displayInfoAboutPoint();

        point2.displayInfoAboutPoint();
        //point2.GetX();



        if (point2.getX() == point1.getX() && point1.getY() == point2.getY() && point1.getZ() == point2.getZ()) { // пробуем сравнить две точки
            System.out.println("YEA");
        } else {
            System.out.println("NO");
        }
        if (point1.equals(point11)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }



        // Тут работаем с векторами (и процессор)
        Vector3D vector1 = new Vector3D(point1, point2);
        Vector3D vector2 = new Vector3D(point3, point4);


        double b = vector1.Vector_len();
        System.out.println(b);

        if(vector1.equals(vector2)){System.out.println("Векторы равны");}
        else{System.out.println("Векторы не равны");}

        Vector3DProcessor.Vector_dif(vector2, vector1); // если менять местами то будет ноль, если сумма, то наоборот
        System.out.println(vector2.Vector_len());

        if(vector1.equals(vector2)){System.out.println("Векторы равны");}
        else{System.out.println("Векторы не равны");}

        Vector3D vector3 = new Vector3D(point1, point2);
        Vector3D vector4 = new Vector3D(point3, point4);

        vector3.Info();
        vector4.Info();

        double res;
        res = Vector3DProcessor.Vector_dot_product(vector3, vector4);
        System.out.println("Скалярное произведение векторов: " + res);

        if(Vector3DProcessor.Vector_collinearity_check(vector3, vector4)){System.out.println("Векторы колинеарны");}
        else{System.out.println("Векторы коллинеарны");}

        Vector3DProcessor.Vector_product(vector3, vector4);  //показали работает ли колинеарность и заодно произведение векторов
        vector3.Info();



        VectorArray vectorArray = new VectorArray(5);

        Scanner in = new Scanner(System.in);
        int size = 5;
        double arr[];
        arr = new double[size];
        arr[0] = -10.0; arr[1] = 5.0; arr[2] = 4.36; arr[3] = 6.2; arr[4] = -9.0;


        vectorArray.SetVector(1, vector4);
        System.out.println(vectorArray.search_vector(vector4));
        Vector3D v1 = vectorArray.vector_sum();

        System.out.printf("Результат суммы векторов массива: (%.1f, %.1f, %.1f)\n", v1.GetX(), v1.GetY(), v1.GetZ());

        vectorArray.Array_show();

        Vector3D v2 = vectorArray.lineal_comb(arr, 5);
        System.out.printf("Результат линейной комбинации векторов массива: (%.1f, %.1f, %.1f)\n", v2.GetX(), v2.GetY(), v2.GetZ());

        vectorArray.replace(point5);
        vectorArray.Array_show();

        System.out.println(vectorArray.max_vector_len());


    }
}