package net.campus.connect.service;

import net.campus.connect.model.GroupeType;

import java.util.List;

public interface GroupeTypeService {
    GroupeType create(GroupeType groupeType);

    GroupeType update(Integer id, GroupeType groupeType);

    void delete(Integer id);

    GroupeType getById(Integer id);

    List<GroupeType> getAll();
}
