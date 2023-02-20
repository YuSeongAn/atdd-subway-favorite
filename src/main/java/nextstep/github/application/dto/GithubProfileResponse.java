package nextstep.github.application.dto;

public class GithubProfileResponse {
    private String email;
    private int age;

    private GithubProfileResponse() {
    }

    public GithubProfileResponse(String email, int age) {
        this.email = email;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
