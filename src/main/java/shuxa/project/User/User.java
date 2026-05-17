package shuxa.project.User;

public class User {
    private final Long id;
    private String name;
    private String email;

    public User(Long id, String name, String email) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("name connot be empty");
        }
        if (email == null || !email.contains("@")){
            throw new IllegalArgumentException("invalid email");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("User can not be null");
        }else {
            this.name = name;
        }
    }
    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if(!email.contains("@")) {
            throw new IllegalArgumentException("Email address is invalid");
        }
        this.email = email;

    }


}


