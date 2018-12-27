package services;

import models.*;
import repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InformationServiceImpl implements InformationService {
    private SubjectRepository subjectRepository;
    private WeaponRepository weaponRepository;
    private AmmoRepository ammoRepository;
    private EquipmentRepository equipmentRepository;
    private TransportRepository transportRepository;
    private ExpensesRepository expensesRepository;

    public InformationServiceImpl(SubjectRepository subjectRepository, WeaponRepository weaponRepository,
                                  AmmoRepository ammoRepository, EquipmentRepository equipmentRepository,
                                  TransportRepository transportRepository, ExpensesRepository expensesRepository) {
        this.subjectRepository = subjectRepository;
        this.weaponRepository = weaponRepository;
        this.ammoRepository = ammoRepository;
        this.equipmentRepository = equipmentRepository;
        this.transportRepository = transportRepository;
        this.expensesRepository = expensesRepository;
    }

    @Override
    public List<Subject> getHeroes() {
        Optional<List<Subject>> subjectList = subjectRepository.getHeroes();
        return subjectList.orElseGet(ArrayList::new);
    }

    @Override
    public List<Subject> getVillains() {
        Optional<List<Subject>> subjectList = subjectRepository.getVillains();
        return subjectList.orElseGet(ArrayList::new);
    }

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjectList = subjectRepository.findAll();
        if (subjectList != null) {
            return subjectList;
        } else return new ArrayList<>();
    }

    @Override
    public List<Weapon> getAllWeapon() {
        List<Weapon> weaponList = weaponRepository.findAll();
        if (weaponList != null) {
            return weaponList;
        } else return new ArrayList<>();
    }

    @Override
    public List<Ammo> getAllAmmo() {
        List<Ammo> ammoList = ammoRepository.findAll();
        if (ammoList != null) {
            return ammoList;
        } else return new ArrayList<>();
    }

    @Override
    public List<Equipment> getAllEquipment() {
        List<Equipment> equipmentList = equipmentRepository.findAll();
        if (equipmentList != null) {
            return equipmentList;
        } else return new ArrayList<>();
    }

    @Override
    public List<Transport> getAllTransport() {
        List<Transport> transportList = transportRepository.findAll();
        if (transportList != null) {
            return transportList;
        } else return new ArrayList<>();
    }

    @Override
    public List<Expenses> getAllExpenses() {
        List<Expenses> expensesList = expensesRepository.findAll();
        if (expensesList != null) {
            return expensesList;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Subject getSubject(Long id) {
        return subjectRepository.findOne(id);
    }

    @Override
    public Weapon getWeapon(Long id) {
        return weaponRepository.findOne(id);
    }

    @Override
    public Ammo getAmmo(Long id) {
        return ammoRepository.findOne(id);
    }

    @Override
    public Equipment getEquipment(Long id) {
        return equipmentRepository.findOne(id);
    }

    @Override
    public Transport getTransport(Long id) {
        return transportRepository.findOne(id);
    }

    @Override
    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectRepository.delete(subject.getId());
    }
}
