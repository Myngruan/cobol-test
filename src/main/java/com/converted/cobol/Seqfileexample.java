package com.converted.cobol;

import java.io.*;
import java.util.Scanner;

public class Seqfileexample {

    private static final String FILENAME = "USERS.DATA";
    private final Scanner consoleReader = new Scanner(System.in);

    static class UserRecord {
        String userId;
        UserNames userNames = new UserNames();
        Password password = new Password();
        String countryCode;

        static class UserNames {
            String userName;
            String realName;
        }

        static