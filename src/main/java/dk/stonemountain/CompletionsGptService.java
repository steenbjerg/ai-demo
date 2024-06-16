package dk.stonemountain;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@RegisterRestClient(configKey = "chat-gpt")
@Path("/v1/chat")
public interface CompletionsGptService {
    @POST
    @Path("/completions")
    public ChatGptResponse completion(@HeaderParam("Authorization") String token, ChatGptRequest request);
}
