import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa principal con menú para interactuar con MinHeap.
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MinHeap heap = new MinHeap();

        while (true) {

            System.out.println("\n----- MENÚ MIN-HEAP -----");
            System.out.println("1. Insertar un valor");
            System.out.println("2. Ver valor mínimo (peek)");
            System.out.println("3. Eliminar mínimo");
            System.out.println("4. Construir heap desde arreglo (heapify)");
            System.out.println("5. Imprimir heap interno");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opt;
            try {
                opt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                sc.nextLine();
                continue;
            }

            switch (opt) {

                case 1:
                    System.out.print("Ingrese el valor a insertar: ");
                    try {
                        int v = sc.nextInt();
                        heap.insertar(v);
                        System.out.println("Insertado: " + v);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida.");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    Integer min = heap.peek();
                    if (min == null) System.out.println("Heap vacío.");
                    else System.out.println("Valor mínimo: " + min);
                    break;

                case 3:
                    Integer removed = heap.eliminarMin();
                    if (removed == null) System.out.println("Heap vacío.");
                    else System.out.println("Se eliminó: " + removed);
                    break;

                case 4:
                    System.out.print("Cantidad de elementos del arreglo: ");
                    int n;

                    try {
                        n = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida.");
                        sc.nextLine();
                        break;
                    }

                    if (n <= 0) {
                        System.out.println("Debe ser > 0");
                        break;
                    }

                    int[] arr = new int[n];
                    System.out.println("Ingrese los valores:");
                    for (int i = 0; i < n; i++) {
                        try {
                            arr[i] = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Repita.");
                            sc.nextLine();
                            i--;
                        }
                    }

                    heap = new MinHeap(arr);
                    System.out.println("Heap construido.");
                    break;

                case 5:
                    System.out.println("Heap: " + heap);
                    System.out.println("Tamaño: " + heap.size());
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

