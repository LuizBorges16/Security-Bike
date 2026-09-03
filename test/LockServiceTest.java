import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LockServiceTest {
    // caso 1: sem informação nenhuma
    @Test
    void listaVaziaDeveNegar() {

        LockService service = new LockService();
        List<SpeedReading> vazia = new ArrayList<>();

        assertFalse(service.canLock(vazia));
    }
    // caso 2: bike parada agora
    @Test
    void bikeParadaAgora(){
        LockService service = new LockService();
        List<SpeedReading> parada = new ArrayList<>();
        parada.add(new SpeedReading(1, 1, 0.0, LocalDateTime.now()));
        assertTrue(service.canLock(parada));

    }
    // caso 3: bike andando agora → parte A
    @Test
    void bikeAndando(){
        LockService service = new LockService();
        List<SpeedReading> andando = new ArrayList<>();
        andando.add(new SpeedReading(2, 1, 15.0, LocalDateTime.now()));
        assertFalse(service.canLock(andando));
    }
    // caso 4: parada, mas a informação tem 30 segundos
    @Test
    void informacaoAntiga(){
        LockService service = new LockService();
        List<SpeedReading> velha = new ArrayList<>();
        velha.add(new SpeedReading(3, 1, 0.0, LocalDateTime.now().minusSeconds(30)));
        assertFalse(service.canLock(velha));
    }
    // caso 5: devagar há 8 segundos
    @Test
    void bikeDevagar(){
        LockService service = new LockService();
        List<SpeedReading> devagar = new ArrayList<>();
        devagar.add(new SpeedReading(10, 1, 2.8, LocalDateTime.now().minusSeconds(8)));
        devagar.add(new SpeedReading(11, 1, 2.1, LocalDateTime.now().minusSeconds(4)));
        devagar.add(new SpeedReading(12, 1, 2.4, LocalDateTime.now().minusSeconds(1)));
        assertTrue(service.canLock(devagar));
    }
    // caso 6: acelerou dentro da janela de tempo
    @Test
    void acelerou(){
        LockService service = new LockService();
        List<SpeedReading> acelerou = new ArrayList<>();
        acelerou.add(new SpeedReading(13, 1, 25.0, LocalDateTime.now().minusSeconds(9)));
        acelerou.add(new SpeedReading(21, 1, 2.1, LocalDateTime.now().minusSeconds(4)));
        acelerou.add(new SpeedReading(22, 1, 9.0, LocalDateTime.now().minusSeconds(2)));
        assertFalse(service.canLock(acelerou));
    }
    // caso 7: devagar, mas só 2 segundos de histórico
    @Test
    void informacaoCurta(){
        LockService service = new LockService();
        List<SpeedReading> historico = new ArrayList<>();
        historico.add(new SpeedReading(14, 1, 2.5, LocalDateTime.now().minusSeconds(2)));
        assertFalse(service.canLock(historico));
    }
}