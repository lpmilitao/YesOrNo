package br.com.ifsul.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YesOrNoResponse {
    @SerializedName("answer") @Expose
    private String answer;

    @SerializedName("forced") @Expose
    private String forced;

    @SerializedName("image") @Expose
    private String image;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getForced() {
        return forced;
    }

    public void setForced(String forced) {
        this.forced = forced;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
