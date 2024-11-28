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

class Point3D {
    private double x;
    private double y;
    private double z;

    Point3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    Point3D(double x, double y, double z) {
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

class Vector3D {
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
            System.out.println("Векторы равны");
            bul = true;

        }
        else{System.out.println("Векторы не равны");}
        return bul;
    }

    public void Info(){
        System.out.printf("Координаты вектора (%.1f, %.1f, %.1f), длина: %.1f\n", this.GetX(), this.GetY(), this.GetZ(), this.len);
    }

}

class Vector3DProcessor {
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

class VectorArray {
    private double array[][];
    private int size;

    VectorArray(int size) { //конструктор по размеру
        this.size = size;
        this.array = new double[size + 1][3];

    }

    public int GetLen() { // длина (размер) массива
        return this.size;
    }

    public void SetVector(int i, Vector3D vector1) { //замена i-го элемента на вектор
        this.array[i-1][0] = vector1.GetX();
        this.array[i-1][1] = vector1.GetY();
        this.array[i-1][2] = vector1.GetZ();
    }

    public double max_vector_len() {
        double max_len = 0;
        for (int i = 0; i < this.size; i++) {
            double x = this.array[i][0];
            double y = this.array[i][1];
            double z = this.array[i][2];

            double i_len = Math.pow(x * x + y * y + z * z, 0.5);

            if (i_len > max_len) {
                max_len = i_len;
            }
        }
        return max_len;
    }

    public int search_vector(Vector3D vector1) {
        int number = -1;
        for (int i = 0; i < this.size; i++) {
            double x = vector1.GetX();
            double y = vector1.GetY();
            double z = vector1.GetZ();
            if (this.array[i][0] == x && this.array[i][1] == y && this.array[i][2] == z) {
                number = i;
                i = size;
            }
        }
        return number + 1;
    }

    public void vector_sum() {
        for (int i = 0; i < this.size ; i++) {
            this.array[this.size][0] += this.array[i][0];
            this.array[this.size][1] += this.array[i][1];
            this.array[this.size][2] += this.array[i][2];

        }
        System.out.printf("Результат: (%.1f, %.1f, %.1f)\n", this.array[this.size][0], this.array[this.size][1], this.array[this.size][2]);
    }

    public void lineal_comb(double array[], int size) {
        if (size == this.size) {
            for (int i = 0; i < size; i++) {
                this.array[i][0] *= array[i];
                this.array[i][1] *= array[i];
                this.array[i][2] *= array[i];
            }
            vector_sum();
        } else {
            System.out.printf("Результат: (0,0 0,0 0,0)");
        }
    }

    public void replace(Point3D point1) {
        for (int i = 0; i < this.size; i++) {
            this.array[i][0] += point1.GetX();
            this.array[i][1] += point1.GetY();
            this.array[i][2] += point1.GetZ();
        }
    }

    public void Array_show() {
        int i;
        for (i = 0; i < 5; i++) {
            System.out.printf("%.1f, %.1f, %.1f \n", array[i][0], array[i][1], array[i][2]);
        }
    }
}