package com.example.pratik.postdatatoserver.Model;

/**
 * Created by Pratik on 10-Dec-16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AddPostResponse {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("userId")
    @Expose
    private Long userId;
    @SerializedName("id")
    @Expose
    private Long id;

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The body
     */
    public String getBody() {
        return body;
    }

    /**
     *
     * @param body
     * The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     *
     * @return
     * The userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Long id) {
        this.id = id;
    }

}
