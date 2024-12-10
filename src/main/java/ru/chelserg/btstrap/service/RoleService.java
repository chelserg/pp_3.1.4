package ru.chelserg.btstrap.service;

import ru.chelserg.btstrap.models.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    List<Role> getRolesById(List<Long> roleId);
}
