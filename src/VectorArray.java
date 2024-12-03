public class VectorArray {
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