import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a capacidade do vetor, digite 0 para sair: ");
        int capacidade = input.nextInt();
        while (capacidade > 0) {
            System.out.printf("capacidade: %d\n", capacidade);
            Vetor vetor = new Vetor(capacidade);

            Vetor insertionSortVetorTest = vetor.clone();
            Vetor selectionSortVetorTest = vetor.clone();
            Vetor bubbleSortVetorTest = vetor.clone();
            Vetor quickSortVetorTest = vetor.clone();

            long timeAtStartInsertionSort = System.nanoTime();
            insertionSortVetorTest.insertionSort();
            long timeAtEndInsertionSort = System.nanoTime();
            System.out.printf("InsertionSort: %d\n", timeAtEndInsertionSort - timeAtStartInsertionSort);

            long timeAtStartSelectionSort = System.nanoTime();
            selectionSortVetorTest.selectionSort();
            long timeAtEndSelectionSort = System.nanoTime();
            System.out.printf("SelectionSort: %d\n", timeAtEndSelectionSort - timeAtStartSelectionSort);

            long timeAtStartBubbleSort = System.nanoTime();
            bubbleSortVetorTest.bubbleSort();
            long timeAtEndBubbleSort = System.nanoTime();
            System.out.printf("BubbleSort: %d\n", timeAtEndBubbleSort - timeAtStartBubbleSort);

            long timeAtStartQuickSort = System.nanoTime();
            quickSortVetorTest.quickSort(0, quickSortVetorTest.getVetor().length - 1);
            long timeAtEndQuickSort = System.nanoTime();
            System.out.printf("QuickSort: %d\n", timeAtEndQuickSort - timeAtStartQuickSort);

            System.out.println("Digite a capacidade do vetor novamente, digite 0 para sair:");
            capacidade = input.nextInt();
        }

        input.close();

    }
}
