package be.plgoosse.racontarback.service;

import be.plgoosse.racontarback.dto.StoryCreationDTO;
import be.plgoosse.racontarback.dto.StoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StoryService {

    @Autowired
    private ChatModel chatModel;

    private static final String template = """
        Create a story for a {age} years old child. The main character of this story is {mainCharacter} and the villain is {villain}. I want this story to take place in {location}. The value transmitted by this story must be {value}. Write this story in {language}.
        {format}
        """;
    private static final BeanOutputConverter<StoryDTO> beanOutputConverter = new BeanOutputConverter<>(StoryDTO.class);


    public StoryDTO createStory(StoryCreationDTO storyCreationDTO) {
        ChatResponse response = chatModel.call(
                new PromptTemplate(template, Map.of(
                        "age", storyCreationDTO.getAge(),
                        "mainCharacter", storyCreationDTO.getMainCharacter(),
                        "villain", storyCreationDTO.getVillain(),
                        "location", storyCreationDTO.getLocation(),
                        "value", storyCreationDTO.getValue(),
                        "language", storyCreationDTO.getLanguage(),
                        "format", beanOutputConverter.getFormat()
                )).create(
                        VertexAiGeminiChatOptions.builder()
                        .temperature(1.0)
                        .model(VertexAiGeminiChatModel.ChatModel.GEMINI_1_5_FLASH)
                        .responseMimeType("application/json")
                        .build()
                )
        );
        return beanOutputConverter.convert(response.getResult().getOutput().getContent());
    }

}
