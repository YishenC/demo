package com.example.neotest.Entity;

import java.util.List;


public class ContractEntity {
    private String script;
    private List<?> parameters;
    private boolean deployed;

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public List<?> getParameters() {
        return parameters;
    }

    public void setParameters(List<?> parameters) {
        this.parameters = parameters;
    }

    public boolean isDeployed() {
        return deployed;
    }

    public void setDeployed(boolean deployed) {
        this.deployed = deployed;
    }
}
