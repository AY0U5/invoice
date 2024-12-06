package ma.zyn.app.service.impl.admin.render;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.zyn.app.bean.core.render.ServiceRequest;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class RenderDeploy {
        private static final String RENDER_API_URL = "https://api.render.com/v1/services";
        private static final String RENDER_API_KEY = "rnd_tyIJpYW1vT4iHb43sVtI7WKjpVZP"; // Replace with your Render API Key
        private static final ObjectMapper MAPPER = new ObjectMapper();

        public static void main(String[] args) {
            try {
                deployBackend();
                deployFrontend();
            } catch (IOException e) {
                System.err.println("Error during deployment: " + e.getMessage());
            }
        }

        public static void deployBackend() throws IOException {
            String backendPayload = MAPPER.writeValueAsString(new ServiceRequest(
                    "spring-backend",
                    "web",
                    "https://github.com/AY0U5/invoice.git", // Replace with your repo URL
                    "main",
                    "backend-ms1",
                    "java",
                    "./mvnw clean package -DskipTests",
                    "java -Dspring.profiles.active=prod -jar target/your-backend-app.jar",
                    false
            ));

            makeApiCall(backendPayload);
        }

        public static void deployFrontend() throws IOException {
            String frontendPayload = MAPPER.writeValueAsString(new ServiceRequest(
                    "angular-frontend",
                    "static_site",
                    "https://github.com/AY0U5/invoice.git", // Replace with your repo URL
                    "main",
                    "frontend",
                    "node",
                    "npm install && npm run build",
                    "dist/",
                    false
            ));

            makeApiCall(frontendPayload);
        }

        private static void makeApiCall(String payload) throws IOException {
            try (CloseableHttpClient client = HttpClients.createDefault()) {
                HttpPost post = new HttpPost(RENDER_API_URL);
                post.setHeader("Authorization", "Bearer " + RENDER_API_KEY);
                post.setHeader("Content-Type", "application/json");
                post.setEntity(new StringEntity(payload));

                try (CloseableHttpResponse response = client.execute(post)) {
                    int statusCode = response.getCode();
                    System.out.println("Response Code: " + statusCode);
                    System.out.println("Response: " + response.getEntity());
                    if (statusCode >= 400) {
                        throw new RuntimeException("Failed to deploy: " + response.getReasonPhrase());
                    }
                }
            }
        }
}
