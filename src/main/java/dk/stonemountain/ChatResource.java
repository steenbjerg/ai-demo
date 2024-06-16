package dk.stonemountain;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/chats")
public class ChatResource {
    private static final Logger LOG = LoggerFactory.getLogger(ChatResource.class);
    
    @RestClient
    @Inject
    CompletionsGptService completionsService;
    @ConfigProperty(name = "openai.model")
    String openaiModel;
    @ConfigProperty(name = "openai.key")
    String openaiKey;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String chat(@NotNull @QueryParam("prompt") String prompt) {
        LOG.info("Received prompt: {}", prompt);
        return completionsService.completion(getBearer(),ChatGptRequest.newRequest(openaiModel, prompt)).choices().toString();
    }

    private String getBearer() {
        return "Bearer " + openaiKey;
    }
}
