package be.plgoosse.racontarback.dto;

public class StoryCreationDTO {

    private String mainCharacter;
    private String villain;
    private String location;
    private String value;
    private Integer age;
    private String language;

    public StoryCreationDTO() {
    }

    public String getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(String mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public String getVillain() {
        return villain;
    }

    public void setVillain(String villain) {
        this.villain = villain;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
