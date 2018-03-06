package entities;

public class Client {
    private String name;
    private String email;
    private String id;
    private double balance;
    private String issue;
    private String transactionValue;

    public Client(String name, String id, double balance, String issue,String email) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        this.issue = issue;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getTransactionValue() { return transactionValue; }

    public void setTransactionValue(String transactionValue) { this.transactionValue = transactionValue; }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
