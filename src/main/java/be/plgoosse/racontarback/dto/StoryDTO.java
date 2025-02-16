package be.plgoosse.racontarback.dto;

import java.util.List;

public class StoryDTO {

    private String title;
    private List<String> paragraphs;

    public StoryDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StoryDTO title(String title) {
        this.title = title;
        return this;
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public StoryDTO paragraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
        return this;
    }
}
