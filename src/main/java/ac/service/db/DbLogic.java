/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.db;

import ac.service.pojo.Login;
import ac.service.pojo.UserDetail;
import java.util.List;

/**
 *
 * @author amittal
 */
public interface DbLogic {

    public boolean loginCheck(Login login);

    public String addUser(UserDetail userDetail, Login login);

    public boolean isExist(UserDetail detail);

    public List<UserDetail> userDetailList(UserDetail detail);

}
