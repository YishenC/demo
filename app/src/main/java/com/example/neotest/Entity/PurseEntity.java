package com.example.neotest.Entity;

import java.util.List;



public class PurseEntity {

    private String name;
    private String version;
    private ScryptBean scrypt;
    private List<?> accounts;
    private Object extra;
    public static class ScryptBean {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ScryptBean getScrypt() {
        return scrypt;
    }

    public void setScrypt(ScryptBean scrypt) {
        this.scrypt = scrypt;
    }

    public List<?> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<?> accounts) {
        this.accounts = accounts;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
