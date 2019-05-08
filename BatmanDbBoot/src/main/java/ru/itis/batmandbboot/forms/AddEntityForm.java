package ru.itis.batmandbboot.forms;

import lombok.Data;

@Data
public class AddEntityForm {
    private String entity_id;
    private String table_name;
    private String[] entity;
}
