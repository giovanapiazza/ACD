package circuito;

import java.util.ArrayList;

public class Paralelo extends Circuit {
 private ArrayList<Circuit> components = new ArrayList<>();

 public void add(Circuit c) {
     components.add(c);
 }

 public double getResistance() {
     double inversoTotal = 0;
     for (Circuit c : components) {
         inversoTotal += 1.0 / c.getResistance();
     }
     return 1.0 / inversoTotal;
 }

 public String toString() {
     return "Paralelo " + components.toString();
 }
}
