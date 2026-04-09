/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project.part1;

import org.junit.Test;
import static org.junit.Assert.*;

public class PROJECTPART1Test {
//test
    public PROJECTPART1Test() {
    }

    @Test
    public void testCheckUserName_Valid() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(user.checkUserName());
    }

    @Test
    public void testCheckUserName_Invalid() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(user.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumber_Valid() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertFalse(user.checkCellPhoneNumber());
    }

    @Test
    public void testLoginUser_Successful() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUser_Failed() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(user.loginUser("wrong_1", "wrongpass"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String expected = "Welcome Kyle, Smith it is great to see you again.";
        String actual = user.returnLoginStatus(true);
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnLoginStatus_Failed() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String expected = "Username or password incorrect, please try again.";
        String actual = user.returnLoginStatus(false);
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_Success() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String expected = "User has been registered successfully.";
        String actual = user.registerUser();
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = user.registerUser();
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        String actual = user.registerUser();
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_InvalidCellPhone() {
        PROJECTPART1 user = new PROJECTPART1("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        String expected = "Cell phone number incorrectly formatted or does not contain international code; please correct the number and try again.";
        String actual = user.registerUser();
        assertEquals(expected, actual);
    }
}