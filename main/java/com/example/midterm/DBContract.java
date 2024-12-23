package com.example.midterm;

public class DBContract {
    private DBContract() {
    }

    public static class Login {
        public static final String TABLE_NAME = "login";
        public static final String COLUMN_FULLNAME = "fullname";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_MOBILE = "mobile";
    }
}
