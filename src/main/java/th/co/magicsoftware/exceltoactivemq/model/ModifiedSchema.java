package th.co.magicsoftware.exceltoactivemq.model;

public class ModifiedSchema {
    private String field;
    private String oldValue;
    private String newValue;
    private String entity;
    private String entityId;

    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getOldValue() {
        return oldValue;
    }
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }
    public String getNewValue() {
        return newValue;
    }
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
    public String getEntity() {
        return entity;
    }
    public void setEntity(String entity) {
        this.entity = entity;
    }
    public String getEntityId() {
        return entityId;
    }
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
