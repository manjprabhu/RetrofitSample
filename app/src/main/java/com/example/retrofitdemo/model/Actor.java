package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Actor {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("realname")
    @Expose
    private String realName;

    @SerializedName("team")
    @Expose
    private String team;

    @SerializedName("firstappearance")
    @Expose
    private String firstappearance;

    @SerializedName("createdby")
    @Expose
    private String createdBy;

    @SerializedName("publisher")
    @Expose
    private String publisher;

    @SerializedName("imageurl")
    @Expose
    private String imageurl;

    @SerializedName("bio")
    @Expose
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public void setFirstappearance(String firstappearance) {
        this.firstappearance = firstappearance;
    }
}
