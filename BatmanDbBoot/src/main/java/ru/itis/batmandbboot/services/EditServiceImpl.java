package ru.itis.batmandbboot.services;

import org.springframework.stereotype.Service;
import ru.itis.batmandbboot.models.*;
import ru.itis.batmandbboot.repositories.*;

@Service
public class EditServiceImpl implements EditService {
    private SubjectRepository subjectRepository;
    private WeaponRepository weaponRepository;
    private WeaponAmmoRepository weaponAmmoRepository;
    private AmmoRepository ammoRepository;
    private EquipmentRepository equipmentRepository;
    private TransportRepository transportRepository;
    private ExpensesRepository expensesRepository;

    public EditServiceImpl(SubjectRepository subjectRepository, WeaponRepository weaponRepository, AmmoRepository ammoRepository,
                           EquipmentRepository equipmentRepository, TransportRepository transportRepository,
                           ExpensesRepository expensesRepository, WeaponAmmoRepository weaponAmmoRepository) {
        this.subjectRepository = subjectRepository;
        this.weaponRepository = weaponRepository;
        this.weaponAmmoRepository = weaponAmmoRepository;
        this.ammoRepository = ammoRepository;
        this.equipmentRepository = equipmentRepository;
        this.transportRepository = transportRepository;
        this.expensesRepository = expensesRepository;
    }

    @Override
    public boolean deleteEntity(String table, Long id) {
        switch (table) {
            case "subject":
                subjectRepository.deleteById((id));
                return true;
            case "equipment":
                equipmentRepository.delete(equipmentRepository.getOne(id));
            case "weapon":
                weaponRepository.delete(weaponRepository.getOne(id));
            case "transport":
                transportRepository.delete(transportRepository.getOne(id));
            case "expense":
                expensesRepository.delete(expensesRepository.getOne(id));
        }
        return false;
    }

    @Override
    public boolean saveSubject(String[] subjectArr) {
        Subject subject = new Subject();
        if (subjectArr[0] != null) {
            subject.setAlias(subjectArr[0]);
        }
        if (subjectArr[1] != null) {
            subject.setRealName(subjectArr[1]);
        }
        if (!subjectArr[2].equals("")) {
            subject.setWeakness(weaponAmmoRepository.getOne(Long.valueOf(subjectArr[2])));
        }
        if (!subjectArr[3].equals("")) {
            subject.setDefence(equipmentRepository.getOne(Long.valueOf(subjectArr[3])));
        }
        if (subjectArr[4] != null) {
            subject.setType(SubjectType.valueOf(subjectArr[4]));
        }
        subjectRepository.save(subject);
        return true;
    }

    @Override
    public boolean saveEquipment(String[] equipmentArr) {
        Equipment equipment = new Equipment();
        equipment.setName(equipmentArr[0]);

        if (!equipmentArr[1].equals("")) {
            equipment.setBullet(equipmentArr[1].equals("yes"));
        }
        if (!equipmentArr[2].equals("")) {
            equipment.setKnife(equipmentArr[2].equals("yes"));
        }
        if (!equipmentArr[3].equals("")) {
            equipment.setBullet(equipmentArr[3].equals("yes"));
        }
        equipmentRepository.save(equipment);
        return true;
    }

    @Override
    public boolean saveWeapon(String[] weaponArr) {
        Weapon weapon = new Weapon();
        weapon.setName(weaponArr[0]);

        if (!weaponArr[1].equals("")) {
            weapon.setId((Long.valueOf(weaponArr[1])));
        }
        if (!weaponArr[2].equals("")) {
            weapon.setAmmo(ammoRepository.getOne(Long.valueOf(weaponArr[2])));
        }
        weaponRepository.save(weapon);
        return true;
    }

    @Override
    public boolean saveTransport(String[] transportArr) {
        Transport transport = new Transport();
        transport.setName(transportArr[0]);

        if (!transportArr[1].equals("")) {
            transport.setWater(transportArr[1].equals("yes"));
        }
        if (!transportArr[2].equals("")) {
            transport.setAir(transportArr[2].equals("yes"));
        }
        if (!transportArr[3].equals("")) {
            transport.setAir(transportArr[3].equals("yes"));
        }
        transportRepository.save(transport);
        return true;
    }

    @Override
    public boolean saveExpense(String[] expenseArr) {
        Expenses expense = new Expenses();
        if (expenseArr[0] != null) {
            expense.setName(expenseArr[0]);
        }
        if (expenseArr[1] != null) {
            expense.setType(expenseArr[1]);
        }
        if (!expenseArr[2].equals("")) {
            expense.setCost(Integer.parseInt(expenseArr[2]));
        }
        if (!expenseArr[3].equals("")) {
            expense.setAmount(Integer.parseInt(expenseArr[3]));
        }
        if (expenseArr[4] != null) {
            expense.setBudget(Long.valueOf(expenseArr[4]));
        }
        expensesRepository.save(expense);
        return true;
    }
}
