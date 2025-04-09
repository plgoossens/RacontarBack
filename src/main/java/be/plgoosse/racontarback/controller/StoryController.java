package be.plgoosse.racontarback.controller;

import be.plgoosse.racontarback.dto.StoryCreationDTO;
import be.plgoosse.racontarback.dto.StoryDTO;
import be.plgoosse.racontarback.service.StoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/story")
public class StoryController {

    private static final Logger logger = LoggerFactory.getLogger(StoryController.class.getName());

    @Autowired
    private StoryService storyService;

    @PostMapping
    public ResponseEntity<StoryDTO> createStory(@RequestBody StoryCreationDTO storyCreationDTO){
        logger.info("Creating story...");
        return ResponseEntity.ok(storyService.createStory(storyCreationDTO));
    }
}
