package SQL;

public class DTO {
    private String title;
    private String intro;
    private String ingredient;
    private String step;
    private String thumbnail;
    private String stepimg;
    private String thema;
    private String taste;
    private String situation;

    public DTO(String title, String intro, String ingredient, String step, String thumbnail,
               String stepimg, String thema, String taste, String situation){
        this.title = title;
        this.intro = intro;
        this.ingredient = ingredient;
        this.step = step;
        this.thumbnail = thumbnail;
        this.stepimg = stepimg;
        this.thema = thema;
        this.taste = taste;
        this.situation = situation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStepimg() {
        return stepimg;
    }

    public void setStepimg(String stepimg) {
        this.stepimg = stepimg;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
