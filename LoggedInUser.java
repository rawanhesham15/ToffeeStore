public class LoggedInUser {
    private String name;
    private String address;
    private String status;
    private String phoneNum;
    private String email;
    private String password;
    private int loayaltyPoint;

    public LoggedInUser(){}
    public LoggedInUser(String data[]){
        setName(data[0]);
        setAddress(data[1]);
        setPhoneNum(data[2]);
        setEmail(data[3]);
        setPassword(data[4]);
        String status = "Active";
        setStatus(status);
        int loyaltyPoint = 0;
        setLoayaltyPoint(loyaltyPoint);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoayaltyPoint() {
        return loayaltyPoint;
    }

    public void setLoayaltyPoint(int loayaltyPoint) {
        this.loayaltyPoint = loayaltyPoint;
    }
    public void viewCategories() {
        System.out.println("^^^^^VIEW CATEGORIES^^^^^");
    }

    public void searchForItem() {
        System.out.println("^^^^^SEARCH FOR ITEM^^^^^");
    }
}
