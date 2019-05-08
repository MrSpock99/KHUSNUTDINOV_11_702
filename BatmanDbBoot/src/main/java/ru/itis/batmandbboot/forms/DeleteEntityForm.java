package ru.itis.batmandbboot.forms;

import lombok.Data;

@Data
public class DeleteEntityForm {
    private String entity_id;
    private String table_name;
}
