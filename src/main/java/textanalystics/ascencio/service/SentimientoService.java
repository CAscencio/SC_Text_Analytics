package textanalystics.ascencio.service;

import com.azure.ai.textanalytics.models.*;
import com.azure.ai.textanalytics.TextAnalyticsClient;
import org.springframework.stereotype.Service;
import textanalystics.ascencio.config.TextAnalyticsConfig;
import textanalystics.ascencio.model.Sentimiento;

@Service
public class SentimientoService extends TextAnalyticsConfig {

    TextAnalyticsClient client = this.authenticateClient();

    public String analizarSentimiento(Sentimiento sentimiento){
        DocumentSentiment documentSentiment = client.analyzeSentiment(sentimiento.getTexto(), "es");
        return documentSentiment.getSentiment().toString();
    }

    public String detectarLenguaje(Sentimiento sentimiento) {
        DetectedLanguage detectedLanguage = client.detectLanguage(sentimiento.getTexto());
        return detectedLanguage.getName();
    }
}
