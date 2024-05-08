import java.util.Map;

public record OptenerMoneda(String result,
                            Map<String, Double> conversion_rates) {
}
