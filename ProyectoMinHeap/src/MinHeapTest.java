public class MinHeapTest {

    public static void main(String[] args) {

        System.out.println("Iniciando pruebas de MinHeap...");

        MinHeap heap = new MinHeap();
        int[] valores = {5, 3, 8, 1, 9, 2};

        System.out.print("Insertando: ");
        for (int v : valores) {
            heap.insertar(v);
            System.out.print(v + " ");
        }
        System.out.println();

        System.out.println("Heap interno: " + heap);
        System.out.println("Peek debe ser 1: " + heap.peek());

        System.out.print("Eliminando en orden (ascendente): ");
        while (!heap.isEmpty()) {
            System.out.print(heap.eliminarMin() + " ");
        }
        System.out.println();

        int[] arr = {7, 4, 6, 0, 10, 3};
        MinHeap heap2 = new MinHeap(arr);
        System.out.println("Heap desde arreglo: " + heap2);

        System.out.println("Pruebas finalizadas.");
    }
}

