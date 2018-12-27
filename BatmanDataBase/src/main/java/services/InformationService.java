package services;

import models.*;

import java.util.List;

public interface InformationService {
    List<Subject> getHeroes();

    List<Subject> getVillains();

    List<Subject> getAllSubjects();

    List<Weapon> getAllWeapon();

    List<Ammo> getAllAmmo();

    List<Equipment> getAllEquipment();

    List<Transport> getAllTransport();

    List<Expenses> getAllExpenses();

    Subject getSubject(Long id);

    Weapon getWeapon(Long id);

    Ammo getAmmo(Long id);

    Equipment getEquipment(Long id);

    Transport getTransport(Long id);

    void addSubject(Subject subject);

    void deleteSubject(Subject subject);
}
