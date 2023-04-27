package com.example.neotest.Entity;

import java.util.List;


public class NEP6Entity {
    private Object name;
    private String version;
    private ScryptBean scrypt;
    private List<AccountsBean> accounts;
    private Object extra;
    public static class ScryptBean {
        private int n;
        private int r;
        private int p;
    }
    public static class AccountsBean {
        private String address;
        private Object label;
        private boolean isdefault;
        private boolean lock;
        private String key;
        private ContractBean contract;
        private Object extra;
        public static class ContractBean {
            private String script;
            private List<ParametersBean> parameters;
            private boolean deployed;
            public static class ParametersBean {
                private String name;
                private String type;
            }
        }
    }
}
