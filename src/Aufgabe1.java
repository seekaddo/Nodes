/**
 * Created by addodennis on 6/9/16.
 */
/*
    Aufgabe4) Interfaces

    Gegeben sind die Schnittstellen Movable, Copyable und ShapeOnPlane.
    ShapeOnPlane und Movable beziehen sich auf geometrische Objekte in einem
    2D-Koordinatensystem. Point ist großteils gegeben und repräsentiert einen
    2D-Punkt mit x- und y-Koordinaten. Ergänzen Sie die fehlenden Teile zu
    Point. Zusätzlich sind folgende Klassen gefragt:

    - Point ist ein Punkt in der Ebene und implementiert Movable.

    - Triangle repräsentiert ein Dreieck bestehend aus 3 Eckpunkten (Point).
      Ein Triangle-Objekt wird mit der Angabe von drei Point-Objekten erzeugt.
      Schreiben Sie einen entsprechenden Konstruktor.

    - Circle repräsentiert einen Kreis mit Mittelpunkt (Point) und radius
      (double). Ein Circle-Objekt wird mit der Angabe von einem Mittelpunkt
      (Point) und dem Radius (double) erzeugt. Schreiben Sie einen
      entsprechenden Konstruktor.

    - Triangle und Circle sollen ShapeOnPlane implementieren. Dies ist die
      gemeinsame Schnittstelle für geometrische Formen in der 2D-Ebene.
      Solche Objekte können verschoben werden (move) und haben einen Umfang
      (perimeter). Weiters können von diesen Objekten mit der parameterlosen
      Methode copy() unabhängige Kopien erzeugt werden. Nachfolgende Änderungen
      (z.B. durch move) des Originals haben keine Auswirkungen auf die Kopie
      und umgekehrt.

    - Triangle und Circle sollen über eine öffentliche parameterlose Methode
      toString() verfügen, die eine lesbare Repräsentation (als String) des
      Objekts zurückliefert. Zahlen sollen dabei mit zwei Nachkommastellen
      dargestellt werden. Siehe toString()-Methode in Point sowie die Testfälle
      in Aufgabe4.main(). Hinweis: toString() wird implizit aufgerufen, wenn
      ein Objekt vom Typ Triange, Circle, Point, ShapeOnPlane, etc. mit
      System.out.println() ausgegeben wird. Daher wird der Aufruf in den
      Beispielen in Aufgabe4.main() teilweise nicht explizit angegeben.

    [fortgeschritten]
    Definieren Sie ein Interface DoubleMatrix. Alle Objekte die DoubleMatrix
    sind, verfügen über eine parameterlose Methode toArray() die ein
    zwei-dimensionales Array mit double-Werten liefert. In jeder Zeile des
    Arrays stehen die Koordinaten eines Punktes, oder ein Array mit nur einem
    Element im Fall eines Skalars (zB. Radius). Point, Circle und Triangle
    sollen DoubleMatrix implementieren. Schreiben Sie weiters eine
    static-Methode print, die einen Parameter vom Typ DoubleMatrix hat und den
    Inhalt des double[][]-Arrays ausgibt. Die Form des Arrays und das Format
    der Ausgabe erkennen Sie an den Testfällen unter Aufgabe4.main().

    Sie können in dieser Aufgabe auch Methoden aus java.util.Arrays nutzen.

    Zusatzfragen:
    1. Wozu benötigt man Interfaces?

    2. Was bedeutet es, wenn ein Interface ein anderes Interface erweitert
       (extends)?

    3. Welche der folgenden Ausdrücke sind nach der Anweisung

            Movable point = new Point(1d,2d);

       gültig? Warum?

            point.distanceTo(new Point(0d,0d))
            point.move(0.5,1d)
            point.copy()
            point.toString()
*/




import java.util.Locale;

interface Movable {

    // Verschiebt das Objekt um den Vektor (deltaX, deltaY).
    void move(double deltaX, double deltaY);

}

interface Copyable {

    // Gibt eine unabhängige Kopie eines Objekts zurück.
    // Sollte von jedem Subtyp (inkl. abstrakter Subklassen)
    // deklariert/überschrieben werden.
    Copyable copy();

}

interface ShapeOnPlane extends Movable, Copyable {

    // Gibt den Umfang des Objekts zurück.
    double perimeter();
    ShapeOnPlane copy();

}

interface DoubleMatrix{
    void toArray();
}

class Point implements Movable {

    private double x, y;

    public Point(double x, double y) {

        this.x = x;
        this.y = y;

    }

    public Point(Point p) {

        this.x = p.x;
        this.y = p.y;

    }

    public String toString() {

        return "(" + String.format("%.2f",x) + "," + String.format("%.2f",y) +
                ")";

    }

    public void move(double deltaX, double deltaY) {

        this.x += deltaX;
        this.y += deltaY;

    }

    public double distanceTo(Point p) {

        return Math.hypot(p.x - this.x, p.y - this.y);

    }

    public Point copy() {

        return new Point(x,y);

    }

}



class Triangle implements ShapeOnPlane {
    private  Point a_vert, b_vert, c_vert;

    public Triangle(Point a_vert, Point b_vert,Point c_vert){
        this.a_vert = a_vert;
        this.b_vert = b_vert;
        this.c_vert = c_vert;
    }
    @Override
    public double perimeter() {
        return a_vert.distanceTo(b_vert) + b_vert.distanceTo(c_vert) + c_vert.distanceTo(a_vert);
    }

    @Override
    public ShapeOnPlane copy() {
        return new Triangle(a_vert.copy(),b_vert.copy(),c_vert.copy());
    }

    @Override
    public void move(double deltaX, double deltaY) {
        a_vert.move(deltaX,deltaY);
        b_vert.move(deltaX,deltaY);
        c_vert.move(deltaX,deltaY);

    }

    @Override
    public String toString(){
        return this.a_vert.toString()+" "+ this.b_vert.toString()+" "+ this.c_vert.toString();
    }

    /* TODO: complete Triangle-class definition */

}

class Circle implements ShapeOnPlane {
    Point midle_p;
    double radius;
    double perimeter;

    public Circle(Point midle_p,double radius){
        this.midle_p = midle_p;
        this.radius = radius;
        this.perimeter = 2 * radius * Math.PI;
    }


    @Override
    public double perimeter() {
        return this.perimeter;
    }

    @Override
    public ShapeOnPlane copy() {
        return new Circle(midle_p.copy(),(this.radius));
    }

    @Override
    public void move(double deltaX, double deltaY) {
        this.midle_p.move(deltaX,deltaY);

    }

    public String toString(){
        return "["+midle_p.toString() +", "+String.format("%.2f",radius)+"]";
    }


    /* TODO: complete Circle-class definition */


    public static void print (DoubleMatrix dm) {
        // TODO: add lines here
    }
}



//just for testing
public class Aufgabe1 {

    public static void main(String[] args) {

        //Inhalt wird nicht bewertet
        Locale.setDefault(Locale.US);

        //entfernen Sie zum Testen die folgenden Kommentarzeichen.

        ShapeOnPlane shape = new Circle(new Point(2.5, -1.0), 1.0);
        System.out.println(shape.toString()); //[(2.50,-1.00),1.00]
        ShapeOnPlane copy = shape.copy();
        shape.move(1.0,1.5);
        System.out.println(shape); //[(3.50,0.50),1.00]
        System.out.println(copy); //[(2.50,-1.00),1.00]
        System.out.println(shape.perimeter()); //6.283185307179586
        System.out.println(copy.perimeter()); //6.283185307179586
        shape.move(1.0,1.5);
        System.out.println(shape); //[(4.50,2.00),1.00]
        shape = new Triangle(new Point(2.5, 1.0), new Point(-1.0,3.0), new Point(0d,0d));
        System.out.println(shape.perimeter()); //9.885988937884907
        System.out.println(shape); //[(2.50,1.00), (-1.00,3.00), (0.00,0.00)]

        //folgende Testfälle funktionieren nur, wenn Sie die Aufgabe für
        //Fortgeschrittene gelöst haben.
        //[fortgeschritten]
        /*DoubleMatrix matrix = new Circle(new Point(2.5, -1.0), 1.0);
        print(matrix); //[[2.5, -1.0][1.0]]
        matrix = new Triangle(new Point(2.5, 1.0), new Point(-1.0,3.0), new Point(0d,0d));
        print(matrix); //[[2.5, 1.0][-1.0, 3.0][0.0, 0.0]]*/

    }

    // [fortgeschritten]
    /*
    public static void print (DoubleMatrix dm) {
        // TODO: add lines here
        I hope this works, I have to implement later
    }
    */

}