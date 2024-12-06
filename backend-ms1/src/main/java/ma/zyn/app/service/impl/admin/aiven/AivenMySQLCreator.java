package ma.zyn.app.service.impl.admin.aiven;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.zyn.app.bean.core.aiven.AivenServiceRequest;
import ma.zyn.app.bean.core.aiven.MySQLUserConfig;
import ma.zyn.app.bean.core.aiven.PublicAccess;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class AivenMySQLCreator {
        private static final String AIVEN_API_URL = "https://api.aiven.io/v1/project/YOUR_PROJECT_NAME/service";
        private static final String AIVEN_API_TOKEN = "AIYC8PgUKGwzHnlQ2KSReVL1u33MFg+vvtjrL9jXqsF+hKkSezSwWUqt8sLWhQXyodYkbF7l82+ITUTlmH4X1An6rfxLFrh6v+Jyb6luGG31a1pIZivYjMNnfuYiQC4/w+50iLyBMDyiZqqm7Z7tIEk6d7WRY3UfJzs92/uf0IogighRLJuSNXp7bxGxq7VNZusLA+LA7x6g5O8FyxDKPl72T9yX2jDBvCL/HecPjUOvS6E/nXda0seGUlhe0c8ysujsL7SAlyIcem1Rko57j7h0j/2/9IMzRxbDrM9ZmSo7U/Sp+HBbT/Usf1ijjHjvI5r6D1i6A+GR1vjrMMKCWDc7t7nhl/ClSpz3rK/KlQyk1U4ApRgAd0o=";
        private static final ObjectMapper MAPPER = new ObjectMapper();

        public static void main(String[] args) {
            try {
                createMySQLDatabase();
            } catch (IOException e) {
                System.err.println("Error creating MySQL database: " + e.getMessage());
            }
        }

        public static void createMySQLDatabase() throws IOException {
            // Payload for the API request
            String payload = MAPPER.writeValueAsString(new AivenServiceRequest(
                    "google-europe-west1",
                    "hobbyist",
                    "my-mysql-service",
                    "mysql",
                    new MySQLUserConfig(new PublicAccess(true))
            ));

            // Make the API call
            try (CloseableHttpClient client = HttpClients.createDefault()) {
                HttpPost post = new HttpPost(AIVEN_API_URL);
                post.setHeader("Authorization", "Bearer " + AIVEN_API_TOKEN);
                post.setHeader("Content-Type", "application/json");
                post.setEntity(new StringEntity(payload));

                try (CloseableHttpResponse response = client.execute(post)) {
                    int statusCode = response.getCode();
                    String responseBody = new String(response.getEntity().getContent().readAllBytes());
                    System.out.println("Response Code: " + statusCode);
                    System.out.println("Response Body: " + responseBody);
                }
            }
        }
}
