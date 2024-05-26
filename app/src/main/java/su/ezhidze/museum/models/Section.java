package su.ezhidze.museum.models;

import java.io.Serializable;

public class Section implements Serializable {

    private String name;

    private String text;

    private Integer audioResourceId;

    private Integer imageId;

    public Section(String name, String text, Integer audioResourceId, Integer imageId) {
        this.name = name;
        this.text = text;
        this.audioResourceId = audioResourceId;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getAudioResourceId() {
        return audioResourceId;
    }

    public void setAudioResourceId(Integer audioResourceId) {
        this.audioResourceId = audioResourceId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
