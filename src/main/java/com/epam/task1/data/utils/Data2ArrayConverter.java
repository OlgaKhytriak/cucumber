package com.epam.task1.data.utils;

import com.epam.task1.data.model.Letters;
import com.epam.task1.data.model.Users;

public class Data2ArrayConverter {

    public static Object[][] getData(Users users, Letters letters) {
        Object[][] resArray = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
            resArray[i][0] = users.getUser(i);
            resArray[i][1] = letters.getLetter(i);
        }
        System.out.println(resArray.toString());
        return resArray;
    }

}
