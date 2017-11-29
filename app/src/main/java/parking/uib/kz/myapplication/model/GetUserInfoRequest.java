package parking.uib.kz.myapplication.model;

/**
 * Created by c0rp on 29.11.17.
 */

public class GetUserInfoRequest {
    private String phoneNumber;
    private String token;

    public GetUserInfoRequest(String phoneNumber, String token) {
        this.phoneNumber = phoneNumber;
        this.token = token;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
