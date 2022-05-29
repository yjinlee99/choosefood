package SQL;

public class POSTS {
    private String email;
    private String name;
    private String intro;
    private String ingredient;
    private String recipe;
    private String thumbnail;
    private String stepimg;
    private String date;
    private int views;
    private int id;

    public POSTS(String email, String name, String intro, String ingredient,
               String recipe, String thumbnail, String stepImg, String date, int views, int id){
        this.email = email;
        this.name = name;
        this.intro = intro;
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.thumbnail = thumbnail;
        this.stepimg = stepImg;
        this.date = date;
        this.views = views;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
