package ru.itis.batmandbboot.forms;

import lombok.Data;

@Data
public class EntityForm {
    private String entity_id;
    private String table_name;
    private String action;
}
