import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LockService service = new LockService();

        // caso 1: sem informação nenhuma
        List<SpeedReading> vazia = new ArrayList<>();
        System.out.println("lista vazia: " + service.canLock(vazia));   // false

        // caso 2: bike parada
        List<SpeedReading> parada = new ArrayList<>();
        parada.add(new SpeedReading(1, 1, 0.0, LocalDateTime.now()));
        System.out.println("bike parada: " + service.canLock(parada));  // true

        // caso 3: bike andando
        List<SpeedReading> andando = new ArrayList<>();
        andando.add(new SpeedReading(2, 1, 15.0, LocalDateTime.now()));
        System.out.println("bike andando: " + service.canLock(andando)); // false
    }
}