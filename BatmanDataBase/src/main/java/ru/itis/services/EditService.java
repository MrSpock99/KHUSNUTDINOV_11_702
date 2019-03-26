package ru.itis.services;

public interface EditService {
    boolean deleteEntity(String table, Long id);

    boolean saveSubject(String[] subjectArr);

    boolean saveEquipment(String[] equipmentArr);

    boolean saveWeapon(String[] weaponArr);

    boolean saveTransport(String[] transportArr);

    boolean saveExpense(String[] entity);
}
