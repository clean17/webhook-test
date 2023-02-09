package shop.mtcoding.blog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog2.dto.user.UserReq.UserJoinDto;
import shop.mtcoding.blog2.dto.user.UserReq.UserLoginDto;
import shop.mtcoding.blog2.exception.CustomException;
import shop.mtcoding.blog2.model.User;
import shop.mtcoding.blog2.model.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 회원가입(UserJoinDto userDto){
        User sameUser = userRepository.findByUsername(userDto.getUsername());
        if (sameUser != null) {
            throw new CustomException("동일한 username이 존재합니다");
        }
        int result = userRepository.insertUser(userDto.getUsername(), userDto.getPassword(), userDto.getEmail());        
        if (result !=1) {
            throw new CustomException("회원가입에 실패 했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);   
        }
    }

    @Transactional
    public User 로그인(UserLoginDto userDto){
        User principal = userRepository.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
        if ( principal == null ){
            throw new CustomException("존재 하지 않는 계정입니다.");  
        }
        return principal;
    }
}
