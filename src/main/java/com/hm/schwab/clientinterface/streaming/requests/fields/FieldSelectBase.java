package com.hm.schwab.clientinterface.streaming.requests.fields;

import java.util.Set;
import java.util.TreeSet;

public class FieldSelectBase {
    public Set<String> selectedfields;
    
    public FieldSelectBase() {
        this.selectedfields = new TreeSet<String>();
    }
    
    public void addFields(String fields) {
        if (fields != null && !fields.isEmpty()) {
            String[] fieldArray = fields.split(",");
            for (String field : fieldArray) {
                selectedfields.add(field.trim());
            }
        }
    }
    
    public String getFieldsString() {
        return String.join(",", selectedfields);
    }
}