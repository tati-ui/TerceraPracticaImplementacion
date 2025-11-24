import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> heap;

    /** Constructor: heap vacío */
    public MinHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Construye un heap desde un arreglo desordenado.
     */
    public MinHeap(int[] arr) {
        heap = new ArrayList<>(arr.length);
        for (int v : arr) heap.add(v);
        heapify();
    }

    /** @return true si está vacío */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /** @return tamaño del heap */
    public int size() {
        return heap.size();
    }

    /**
     * Inserta un valor entero al final del arreglo

     */
    public void insertar(int value) {
        heap.add(value);
        upHeapify(heap.size() - 1);
    }

    /**
     * Retorna sin eliminar el menor valor (raíz).
     */
    public Integer peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    /**
     * Elimina y retorna el valor mínimo del heap.
     * Mueve el último elemento a la raíz,

     */
    public Integer eliminarMin() {
        if (heap.isEmpty()) return null;

        int min = heap.get(0);
        int lastIdx = heap.size() - 1;

        heap.set(0, heap.get(lastIdx));
        heap.remove(lastIdx);

        if (!heap.isEmpty()) downHeapify(0);

        return min;
    }

    /**
     * Convierte el contenido interno en un heap válido.

     */
    public void heapify() {
        int n = heap.size();
        int lastParent = (n - 2) / 2;

        for (int i = lastParent; i >= 0; i--) {
            downHeapify(i);
        }
    }

    /**
     * Sube un nodo mientras sea menor que su padre.

     */
    private void upHeapify(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(index) < heap.get(parent)) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    /**
     * Baja un nodo comparándolo con sus hijos.
     * Siempre intercambia con el hijo más pequeño.

     */
    private void downHeapify(int index) {
        int n = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < n && heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < n && heap.get(right) < heap.get(smallest)) smallest = right;

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    /** Intercambia dos posiciones del arreglo interno */
    private void swap(int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    /** Devuelve el contenido interno como String */
    @Override
    public String toString() {
        return heap.toString();
    }

    /** Convierte el heap a un arreglo primitivo */
    public int[] toArray() {
        int[] arr = new int[heap.size()];
        for (int i = 0; i < heap.size(); i++) arr[i] = heap.get(i);
        return arr;
    }
}

