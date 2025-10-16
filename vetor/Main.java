public class Main {
    public static void main(String[] args) {
        Vetor vetor = new Vetor();

        System.out.println("Base Vetor: ");
        System.out.println(vetor);

        Vetor insertionSortVetorTest = vetor.clone();
        Vetor selectionSortVetorTest = vetor.clone();
        Vetor bubbleSortVetorTest = vetor.clone();
        Vetor quickSortVetorTest = vetor.clone();

        System.out.println("Execute sort in base vetor");

        insertionSortVetorTest.insertionSort();
        System.out.println("insertionSortVetorTest: ");
        System.out.println(insertionSortVetorTest);

        selectionSortVetorTest.selectionSort();
        System.out.println("selectionSortVetorTest: ");
        System.out.println(selectionSortVetorTest);

        bubbleSortVetorTest.bubbleSort();
        System.out.println("bubbleSortVetorTest: ");
        System.out.println(bubbleSortVetorTest);

        quickSortVetorTest.quickSort(0, vetor.getVetor().length - 1);
        System.out.println("quickSortVetorTest: ");
        System.out.println(quickSortVetorTest);

    }
}
