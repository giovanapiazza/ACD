package circuito;

public class CircuitTest {
    public static void main(String[] args) {
        // Série com resistores de 300, 500 e 1200 Ohms
        Serial serie1 = new Serial();
        serie1.add(new Resistor(300));
        serie1.add(new Resistor(500));
        serie1.add(new Resistor(1200));

        System.out.println("Circuito em Série: " + serie1);
        System.out.println("Resistência equivalente = " + serie1.getResistance() + " Ω\n");

        // Paralelo com resistores de 50, 100 e 300 Ohms
        Paralelo paralelo1 = new Paralelo();
        paralelo1.add(new Resistor(50));
        paralelo1.add(new Resistor(100));
        paralelo1.add(new Resistor(300));

        System.out.println("Circuito em Paralelo: " + paralelo1);
        System.out.println("Resistência equivalente = " + paralelo1.getResistance() + " Ω\n");


        // Paralelo de (um resistor de 100 e um circuito em série de (200 + 300))
        Serial serie2 = new Serial();
        serie2.add(new Resistor(200));
        serie2.add(new Resistor(300));

        Paralelo paralelo2 = new Paralelo();
        paralelo2.add(new Resistor(100));
        paralelo2.add(serie2);

        System.out.println("Circuito Complexo: " + paralelo2);
        System.out.println("Resistência equivalente = " + paralelo2.getResistance() + " Ω\n");
    }
}
