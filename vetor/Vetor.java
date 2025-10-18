import java.util.Random;

public class Vetor {
    private int[] vetor;
    private int occupation;

    public Vetor() {
        this.occupation = 0;
        this.vetor = new int[this.occupation];
        int randomInt = new Random().nextInt(this.occupation);

        for (int i = 0; i < 10; i++) {
            this.vetor[i] = randomInt;
        }
    };

    public Vetor(int size) {
        this.vetor = new int[size];
        this.occupation = 0;
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            this.vetor[i] = random.nextInt(size);
        }
    }

    public boolean isEmpty() {
        return this.occupation == 0;
    }

    public boolean isFull() {
        return this.occupation == this.vetor.length;
    }

    private void duplicateVetorSize() {
        this.resizeVetor(this.vetor.length * 2);
    }

    private void resizeVetor(int size) {
        System.out.println(size);
        int[] newVetor = new int[size];

        for (int i = 0; i < this.occupation; i++) {
            newVetor[i] = this.vetor[i];
        }

        this.vetor = newVetor;
    }

    public Vetor clone() {
        Vetor clonedVetor = new Vetor(this.occupation);
        for (int i = 0; i < this.occupation; i++) {
            clonedVetor.insert(this.vetor[i]);
        }

        return clonedVetor;
    }

    public void insert(int item) {
        if (this.isFull()) {
            this.duplicateVetorSize();
        }

        this.vetor[this.occupation] = item;
        this.occupation++;
    }

    public void selectionSort() {
        for (int i = 0; i < this.vetor.length - 1; i++) {
            int position = i;
            for (int j = i + 1; j < this.vetor.length; j++) {
                if (this.vetor[j] < this.vetor[position]) {
                    position = j;
                }
            }

            if (position != i) {
                int aux = this.vetor[position];
                this.vetor[position] = this.vetor[i];
                this.vetor[i] = aux;
            }
        }
    }

    public void bubbleSort() {
        for (int i = 1; i < this.vetor.length; i++) {
            for (int j = 0; j < this.vetor.length - i; j++) {
                if (this.vetor[j] > this.vetor[j + 1]) {
                    int aux = this.vetor[j];
                    this.vetor[j] = this.vetor[j + 1];
                    this.vetor[j + 1] = aux;
                }
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < this.vetor.length; ++i) {
            int x = this.vetor[i];
            int j;
            for (j = i - 1; j >= 0 && this.vetor[j] > x; --j) {
                this.vetor[j + 1] = this.vetor[j];
            }
            this.vetor[j + 1] = x;
        }
    }

    public void quickSort(int p, int r) {
        if (p < r) {
            int q = this.partition(p, r);

            this.quickSort(p, q - 1);
            this.quickSort(q + 1, r);
        }
    }

    private int partition(int p, int r) {
        int x = this.vetor[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (this.vetor[j] <= x) {
                i = i + 1;
                int aux = this.vetor[i];
                this.vetor[i] = this.vetor[j];
                this.vetor[j] = aux;
            }
        }
        i = i + 1;
        int aux = this.vetor[r];
        this.vetor[r] = this.vetor[i];
        this.vetor[i] = aux;
        return i;
    }

    public int[] getVetor() {
        return this.vetor;
    }

    @Override
    public String toString() {
        String vetorToString = "";
        for (int i = 0; i < this.vetor.length; i++) {
            vetorToString += this.vetor[i] + " ";
        }
        return vetorToString;
    }
}