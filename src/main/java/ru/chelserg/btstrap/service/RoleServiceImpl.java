package ru.chelserg.btstrap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chelserg.btstrap.models.Role;
import ru.chelserg.btstrap.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService  {

    private final RoleRepository roleRepository;


    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

}
