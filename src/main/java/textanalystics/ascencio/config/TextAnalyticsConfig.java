package textanalystics.ascencio.config;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.TextAnalyticsClient;

public class TextAnalyticsConfig {

    private static String KEY = "1e839b176fd54b138a33132e4c27f07c";
    private static String ENDPOINT = "https://sctextanalytics.cognitiveservices.azure.com/";

    public TextAnalyticsClient authenticateClient() {
        return new TextAnalyticsClientBuilder()
                .credential(new AzureKeyCredential(KEY))
                .endpoint(ENDPOINT)
                .buildClient();
    }
}
