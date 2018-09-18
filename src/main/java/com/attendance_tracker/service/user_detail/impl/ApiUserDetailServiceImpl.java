package com.attendance_tracker.service.user_detail.impl;

import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.entity.User;
import com.attendance_tracker.repository.APIUserDetailRepository;
import com.attendance_tracker.service.user_detail.ApiUserDetailService;
import com.attendance_tracker.service.user_detail.model.ChangePasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("api_user_detail_service")
public class ApiUserDetailServiceImpl implements ApiUserDetailService {

    @Autowired
    private APIUserDetailRepository apiUserDetailRepository;

    @Override
    public APIUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        return apiUserDetailRepository.findByUsernameAndDeletedFalse(username);
    }

    @Override
    public APIUserDetail changePassword(ChangePasswordRequest changePasswordRequest) {
        return null;
    }

    @Override
    public APIUserDetail changePassword(String userId, String newPassword) {
        return null;
    }

    @Override
    public APIUserDetail changeEmail(String userId, String newEmail) {
        return null;
    }

    @Override
    public boolean isEmailUsed(String email) {
        return false;
    }

    @Override
    public boolean isCorrectPassword(String userId, String password) {
        return false;
    }

    @Override
    public boolean isUserActive(User user) {
        return false;
    }
}
