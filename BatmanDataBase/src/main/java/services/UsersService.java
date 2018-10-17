package services;

import forms.UserForm;

public interface UsersService {
    void signUp(UserForm userForm);

    void signIn(UserForm userForm);

    boolean registered(UserForm userForm);
}
