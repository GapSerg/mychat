package classes;

public class Message {
    private int id;
    private String userName;
    private String text;
    private String branch;
    private String date;

    @Override
    public String toString() {
        return "Message from user " + userName+ ":    "+ text + "\ndate =" + date;
    }

    public String getUserName() {
        return userName;
    }

    public Message(int id, String userName, String text, String branch, String date) {
        this.id = id;
        this.userName = userName;
        this.text = text;
        this.branch = branch;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userName;
    }

    public String getText() {
        return text;
    }

    public String getBranch() {
        return branch;
    }

    public String getDate() {
        return date;
    }
}
