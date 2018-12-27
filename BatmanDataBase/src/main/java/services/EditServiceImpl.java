package services;

import repositories.*;

public class EditServiceImpl implements EditService {
    private SubjectRepository subjectRepository;
    private WeaponRepository weaponRepository;
    private AmmoRepository ammoRepository;
    private EquipmentRepository equipmentRepository;
    private TransportRepository transportRepository;
    private ExpensesRepository expensesRepository;

    public EditServiceImpl(SubjectRepository subjectRepository, WeaponRepository weaponRepository, AmmoRepository ammoRepository,
                           EquipmentRepository equipmentRepository, TransportRepository transportRepository,
                           ExpensesRepository expensesRepository) {
        this.subjectRepository = subjectRepository;
        this.weaponRepository = weaponRepository;
        this.ammoRepository = ammoRepository;
        this.equipmentRepository = equipmentRepository;
        this.transportRepository = transportRepository;
        this.expensesRepository = expensesRepository;
    }

    @Override
    public boolean deleteEntity(String table, Long id) {
        switch (table) {
            case "subject":
                return subjectRepository.delete(id);
            case "equipment":
                return equipmentRepository.delete(id);
            case "weapon":
                return weaponRepository.delete(id);
            case "transport":
                return transportRepository.delete(id);
            case "expense":
                return expensesRepository.delete(id);
        }
        return false;
    }
}
