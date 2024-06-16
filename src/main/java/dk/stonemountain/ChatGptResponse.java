package dk.stonemountain;

import java.util.List;

public record ChatGptResponse(List<ChatGptChoice> choices) {}