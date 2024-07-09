package com.celuma.webapi.persistence;
import com.celuma.webapi.domain.UserDTO;
import com.celuma.webapi.domain.repository.UserDTORepository;
import com.celuma.webapi.persistence.crud.UserCrudRepository;
import com.celuma.webapi.persistence.entity.User;
import com.celuma.webapi.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserDTORepository {

    @Autowired
    public UserCrudRepository userCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserDTO> getAll() {
        List<User> users = (List<User>) userCrudRepository.findAll();
        return mapper.toUsersDTO(users);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        return mapper.toUserDTO(userCrudRepository.save(user));
    }

    // TODO: Remove password from response model
    public UserDTO getUserByUsername(String username) {
        User user = userCrudRepository.getByUsername(username);
        return mapper.toUserDTO(user);
    }
}
