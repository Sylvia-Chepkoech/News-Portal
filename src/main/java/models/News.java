package models;

import java.util.Objects;

public class News {
    private int id;
    private String heading;
    private String context;
    private int departmentId;

    public News(String heading, String context) {
        this.heading = heading;
        this.context = context;
    }

    public News(String heading, String context, int departmentId) {
        this.heading = heading;
        this.context = context;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return getId() == news.getId() && getDepartmentId() == news.getDepartmentId() && getHeading().equals(news.getHeading()) && getContext().equals(news.getContext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHeading(), getContext(), getDepartmentId());
    }
}
