package circuito;

//Um resistor individual
public class Resistor extends Circuit {
 private double resistance;

 public Resistor(double resistance) {
     this.resistance = resistance;
 }

 public double getResistance() {
     return resistance;
 }

 public String toString() {
     return resistance + " Ω";
 }
}
