/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesbinariosdebusqueda;
import java.util.Scanner;


public class ListaEnlazada {
   
    Nodo cabeza;
    
    public ListaEnlazada() {
        cabeza = null;
    }
    
    public void insertarNodo(int dato) {
        Nodo nuevo = new Nodo(dato);
        if(cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temporal = cabeza;
            while(temporal.siguiente != null) {
                temporal = temporal.siguiente;
            }
            temporal.siguiente = nuevo;
        }
        System.out.println("Nodo insertado correctamente.");
    }
    
    public void buscarNodo(int dato) {
        if(cabeza == null) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo temporal = cabeza;
            boolean encontrado = false;
            while(temporal != null && !encontrado) {
                if(temporal.dato == dato) {
                    encontrado = true;
                } else {
                    temporal = temporal.siguiente;
                }
            }
            if(encontrado) {
                System.out.println("Se ha encontrado el nodo con el valor " + dato + ".");
            } else {
                System.out.println("No se ha encontrado el nodo con el valor " + dato + ".");
            }
        }
    }
    
    public void eliminarNodo(int dato) {
        if(cabeza == null) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo temporal = cabeza;
            Nodo anterior = null;
            boolean encontrado = false;
            while(temporal != null && !encontrado) {
                if(temporal.dato == dato) {
                    encontrado = true;
                } else {
                    anterior = temporal;
                    temporal = temporal.siguiente;
                }
            }
            if(encontrado) {
                if(anterior == null) {
                    cabeza = cabeza.siguiente;
                } else {
                    anterior.siguiente = temporal.siguiente;
                }
                System.out.println("Nodo eliminado correctamente.");
            } else {
                System.out.println("No se ha encontrado el nodo con el valor " + dato + ".");
            }
        }
    }
    
    public void listarNodos() {
        if(cabeza == null) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo temporal = cabeza;
            while(temporal != null) {
                System.out.println(temporal.dato);
                temporal = temporal.siguiente;
            }
        }
    }
    
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        int dato = 0;
        
        do {
            System.out.println("1. Insertar nodo");
            System.out.println("2. Buscar nodo");
            System.out.println("3. Eliminar nodo");
            System.out.println("4. Listar nodos");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    System.out.print("Ingrese el valor del nodo: ");
                    dato = scanner.nextInt();
                    lista.insertarNodo(dato);
                    break;
                case 2:
                    System.out.print("Ingrese el valor del nodo a buscar: ");
                    dato = scanner.nextInt();
                    lista.buscarNodo(dato);
                    break;
                case 3:
                    System.out.print("Ingrese el valor del nodo a eliminar: ");
                    dato = scanner.nextInt();
                    lista.eliminarNodo(dato);
                    break;
                case 4:
                    lista.listarNodos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            
            System.out.println();
            
        } while(opcion != 5);
        
        scanner.close();
    }
}
}
