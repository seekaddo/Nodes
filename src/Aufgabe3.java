/*
    Aufgabe4) Bäume

    In der Klasse IntTree haben Sie eine Baumimplementierung gegeben, die einen
    sortierten Binärbaum abbildet. Jede Veränderung des Baumes durch eine
    Methode muss gewährleisten, dass dieser sortiert bleibt. Dazu sollen Sie
    folgende zusätzliche Methoden implementieren:

    - add:           Fügt einen Knoten in den Baum ein. Werden folgende
                     Elemente {12,4,6,15,1,13,5,14} nacheinander
                     in den Baum eingefügt, wird folgender Baum aufgebaut:
                                                 12
                                              /      \
                                            4         15
                                          /   \      /
                                         1     6   13
                                              /      \
                                             5        14
    - countNodes:    Liefert die Anzahl aller Knoten im Baum zurück. Wird ohne
                     Parameter aufgerufen.
    - countLeaves:   Liefert die Anzahl der Blattknoten zurück. Wird ohne
                     Parameter aufgerufen.
    - height:        Liefert die Höhe des Baumes zurück. Der leere Baum hat die
                     Höhe 0. Hat der Baum nur einen Knoten (Wurzel), dann hat er
                     die Höhe 1. Mit jeder zusätzlichen Stufe von Nachfolgern
                     erhöht sich die Höhe um 1. Der oben gezeigte Baum hat die
                     Höhe 4.

    Zusatzfragen:
    1. Wie könnte man vorgehen, wenn man einen Knoten in den Baum einfügen
       möchte. Reicht es, den Knoten einzuhängen, oder müssen zusätzliche
       Operationen durchgeführt werden?

*/

public class Aufgabe3 {

    public static void main(String[] args) {

        int [] mytestarray = new int[]{12,4,6,15,1,13,5,14};
        IntTree myTree = new IntTree();
        for(int i : mytestarray){
            myTree.add(i);
        }

        System.out.println("Node Count*******");
        System.out.println(myTree);
        System.out.println(myTree.countNodes());
        System.out.println("Leave Count*******");
        System.out.println(myTree.countLeaves());
        System.out.println("Height***********");
        System.out.println(myTree.height());
    }
}
