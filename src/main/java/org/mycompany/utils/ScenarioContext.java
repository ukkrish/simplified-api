package org.mycompany.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ScenarioContext {

    private int statusCode;

    private HashMap<String, Object> context =new HashMap<>();

    public Object getContext(String key) {
        return context.get(key);
    }

    public void setContext(String key, Object value) {
        if (this.context.containsKey(key))
            this.context.remove(key);
        this.context.put(key, value);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


}
