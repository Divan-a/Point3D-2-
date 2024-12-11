public class VectorArray {
    private Vector3D vectors[];
    private int size;

    VectorArray(int size) { //конструктор по размеру
        this.size = size;
        this.vectors = new Vector3D[size];
        for (int i = 0; i < size; i++) {
            vectors[i] = new Vector3D();
        }
    }

    public int GetLen() { // длина (размер) массива
        return size;
    }

    public void SetVector(int i, Vector3D vector1) { //замена i-го элемента на вектор
        vectors[i] = vector1;
    }

    public double max_vector_len() {
        double max_len = 0;
        for (int i = 0; i < size; i++) {
            double i_len = vectors[i].Vector_len();
            if (i_len > max_len) {
                max_len = i_len;
            }
        }
        return max_len;
    }

    public int search_vector(Vector3D vector1) {
        int number = -1;
        for (int i = 0; i < size; i++) {
            if (vectors[i].equals(vector1)) {
                number = i;
                break;
            }
        }
        return number;
    }

    public Vector3D vector_sum() {
        double x = 0, y = 0, z = 0;
        for (int i = 0; i < size; i++) {
            x += vectors[i].GetX();
            y += vectors[i].GetY();
            z += vectors[i].GetZ();
        }
        return new Vector3D(x, y, z);
    }

    public Vector3D lineal_comb(double array[], int size) {
        double x = 0, y = 0, z = 0;
        if (size == this.size) {
            for (int i = 0; i < size; i++) {
                x += vectors[i].GetX() * array[i];
                y += vectors[i].GetY() * array[i];
                z += vectors[i].GetZ() * array[i];
            }
        }
        return new Vector3D(x, y, z);
    }

    public void replace(Point3D point1) {
        for (int i = 0; i < this.size; i++) {
            vectors[i].SetX(vectors[i].GetX() + point1.getX());
            vectors[i].SetY(vectors[i].GetY() + point1.getY());
            vectors[i].SetZ(vectors[i].GetZ() + point1.getZ());
        }
    }

    public void Array_show() {
        int i;
        for (i = 0; i < 5; i++) {
            vectors[i].Info();
        }
    }
}