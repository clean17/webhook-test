package shop.mtcoding.blog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog2.dto.user.UserReq.UserJoinDto;
import shop.mtcoding.blog2.exception.CustomException;
import shop.mtcoding.blog2.model.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 회원가입(UserJoinDto userDto){
        int result = userRepository.insertUser(userDto.getUsername(), userDto.getPassword(), userDto.getEmail());        
        if (result !=1) {
            throw new CustomException("회원가입에 실패 했습니다.");   
        }
    }
}
