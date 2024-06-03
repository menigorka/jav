public interface Document {
    String getId();
    String getTitle();
    String getContent();
    LocalDate getDate();
    String getType();
}

public abstract class AbstractDocument implements Document {
    protected String id;
    protected String title;
    protected String content;
    protected LocalDate date;
    protected String type;

    public AbstractDocument(String id, String title, String content, LocalDate date, String type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.type = type;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getType() {
        return type;
    }
}
