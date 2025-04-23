package hust.soict.hedspi.aims.media;

public abstract class Media {
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    public Media(String title){
        nbMedia++;
        this.id = nbMedia;
        this.title = title;
    }
    public Media(String title, String category, float cost){
        nbMedia++;
        this.id = nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public String toString(){
        return null;
    }
    public boolean isMatch(int id){
        if(this.getId() == id) return true;
        return false;
    }
    public boolean isMatch(String title){
        if(this.title.equals(title)) return true;
        return false;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Media other = (Media) obj;
        return this.title != null && this.title.equals(other.title)
            && ((this.getCategory() == null && other.getCategory() == null) || (this.getCategory() != null && this.getCategory().equals(other.getCategory())))
            && Float.compare(other.getCost(), this.getCost()) == 0;
    }
}