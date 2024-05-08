import java.util.Map;
public class ConvirtiendoMoneda {
    // creo meotodo para optener la taza de cambio //

    private OptenerMoneda obtenerDatosTasasDeCambio(String monedaBase) {
        ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();
        return consulta.optenerMoneda(monedaBase);
    }

    public double convertirMoneda(double cantidad, String monedaOrigen, String monedaDestino) {
        // Obtener las tasas de cambio //
        OptenerMoneda datosTasasDeCambio = obtenerDatosTasasDeCambio(monedaOrigen);

        // Verificar si se obtuvieron los datos correctamente //
        if (datosTasasDeCambio != null && datosTasasDeCambio.result().equals("success")) {
            // Obtener la tasa de conversión de monedaOrigen a monedaDestino
            Map<String, Double> tasasDeCambio = datosTasasDeCambio.conversion_rates();
            Double tasaConversion = tasasDeCambio.get(monedaDestino);

            // Verificar si la tasa de conversión es válida para la conversion //
            if (tasaConversion != null) {
                // Realizar la conversión
                double cantidadConvertida = cantidad * tasaConversion;
                return cantidadConvertida;
            } else {
                throw new RuntimeException("No se encontró la tasa de conversión para las monedas especificadas.");
            }
        } else {
            throw new RuntimeException("No se pudo obtener la información de las tasas de cambio.");
        }
    }

}
