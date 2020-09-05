package textanalystics.ascencio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//ADD
import com.azure.core.credential.AzureKeyCredential;
import com.azure.ai.textanalytics.models.*;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.TextAnalyticsClient;

@SpringBootApplication
public class AscencioApplication {

    private static String KEY = "1e839b176fd54b138a33132e4c27f07c";
    private static String ENDPOINT = "https://sctextanalytics.cognitiveservices.azure.com/";

    public static void main(String[] args) {
        SpringApplication.run(AscencioApplication.class, args);

        AscencioApplication app = new AscencioApplication();
        //You will create these methods later in the quickstart.
        TextAnalyticsClient client = app.authenticateClient(KEY, ENDPOINT);

        sentimentAnalysisExample(client);
//        detectLanguageExample(client);
//        recognizeEntitiesExample(client);
//        recognizeLinkedEntitiesExample(client);
//        extractKeyPhrasesExample(client);
    }

    static TextAnalyticsClient authenticateClient(String key, String endpoint) {
        return new TextAnalyticsClientBuilder()
                .credential(new AzureKeyCredential(key))
                .endpoint(endpoint)
                .buildClient();
    }

    static void sentimentAnalysisExample(TextAnalyticsClient client)
    {
        // The text that need be analyzed.
        String text = "Te deseo un año lleno de minutos de amor, felicidad y alegría. Feliz Cumpleaños";

        DocumentSentiment documentSentiment = client.analyzeSentiment(text, "es");
        System.out.printf(
                "Sentimiento reconocido del documento: %s, positive score: %s, neutral score: %s, negative score: %s.%n",
                documentSentiment.getSentiment(),
                documentSentiment.getConfidenceScores().getPositive(),
                documentSentiment.getConfidenceScores().getNeutral(),
                documentSentiment.getConfidenceScores().getNegative());

//        for (SentenceSentiment sentenceSentiment : documentSentiment.getSentences()) {
//            System.out.printf(
//                    "Sentimiento reconocido del documento: %s, positive score: %s, neutral score: %s, negative score: %s.%n",
//                    sentenceSentiment.getSentiment(),
//                    sentenceSentiment.getConfidenceScores().getPositive(),
//                    sentenceSentiment.getConfidenceScores().getNeutral(),
//                    sentenceSentiment.getConfidenceScores().getNegative());
//        }
    }

}
