package application.services;

import application.security.Authenticator;
import db.models.User;

public interface ISecurityService {
    String signin(Authenticator authenticator);
    String signup(User user);
}
