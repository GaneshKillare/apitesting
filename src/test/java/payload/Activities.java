package payload;


/*
{
        "id": 0,
        "title": "string",
        "dueDate": "2024-10-09T06:59:55.160Z",
        "completed": true
        }*/


public class Activities {

    int id;
    String title;
    String dueDate;
    boolean status ;

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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
