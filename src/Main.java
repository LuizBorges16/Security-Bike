import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LockService service = new LockService();
        // caso 1: sem informação nenhuma → passo ①
        List<SpeedReading> vazia = new ArrayList<>();
        System.out.println("lista vazia:     " + service.canLock(vazia));

        // caso 2: bike parada agora → passo ④
        List<SpeedReading> parada = new ArrayList<>();
        parada.add(new SpeedReading(1, 1, 0.0, LocalDateTime.now()));
        System.out.println("bike parada:     " + service.canLock(parada));

        // caso 3: bike andando agora → parte A
        List<SpeedReading> andando = new ArrayList<>();
        andando.add(new SpeedReading(2, 1, 15.0, LocalDateTime.now()));
        System.out.println("bike andando:    " + service.canLock(andando));

        // caso 4: parada, mas a informação tem 30 segundos → passo ③
        List<SpeedReading> velha = new ArrayList<>();
        velha.add(new SpeedReading(3, 1, 0.0, LocalDateTime.now().minusSeconds(30)));
        System.out.println("leitura velha:   " + service.canLock(velha));

        // caso 5: devagar há 8 segundos → passo ⑤ autoriza
        List<SpeedReading> devagar = new ArrayList<>();
        devagar.add(new SpeedReading(10, 1, 2.8, LocalDateTime.now().minusSeconds(8)));
        devagar.add(new SpeedReading(11, 1, 2.1, LocalDateTime.now().minusSeconds(4)));
        devagar.add(new SpeedReading(12, 1, 2.4, LocalDateTime.now().minusSeconds(1)));
        System.out.println("devagar 8s:      " + service.canLock(devagar));

        // caso 6: acelerou dentro da janela → passo ⑤ nega
        List<SpeedReading> acelerou = new ArrayList<>();
        acelerou.add(new SpeedReading(13, 1, 25.0, LocalDateTime.now().minusSeconds(9)));
        acelerou.add(new SpeedReading(21, 1, 2.1, LocalDateTime.now().minusSeconds(4)));
        acelerou.add(new SpeedReading(22, 1, 9.0, LocalDateTime.now().minusSeconds(2)));
        System.out.println("acelerou:        " + service.canLock(acelerou));

        // caso 7: devagar, mas só 2 segundos de histórico → parte A nega
        List<SpeedReading> historico = new ArrayList<>();
        historico.add(new SpeedReading(14, 1, 2.5, LocalDateTime.now().minusSeconds(2)));
        System.out.println("historico curto: " + service.canLock(historico));
    }

}