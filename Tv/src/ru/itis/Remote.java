package ru.itis;

public class Remote {
    private TV tv;
    private String name;
    private int serialNum;
    private String firmName;
    private String manufacturer;
    private String lifeTime;

    public Remote(Builder builder) {
        this.name = builder.name;
        this.tv = builder.tv;
        this.serialNum = builder.serialNum;
        this.firmName = builder.firmName;
        this.manufacturer = builder.manufacturer;
        this.lifeTime = builder.lifeTime;

    }





    public TV getTv() {
        return tv;
    }

    public String getName() {
        return name;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public String getFirmName() {
        return firmName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getLifeTime() {
        return lifeTime;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private TV tv;
        private String name;
        private int serialNum;
        private String firmName;
        private String manufacturer;
        private String lifeTime;

        public Builder tv(TV tv){
            this.tv = tv;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder serialNum(int serialNun){
            this.serialNum = serialNum;
            return this;
        }

        public Builder firmName(String firmName){
            this.firmName = firmName;
            return this;
        }

        public Builder manufacturer(String manufacturer){
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder lifeTime(String lifeTime){
            this.lifeTime = lifeTime;
            return this;
        }


        //????????????????
        public Remote build(){
            return new Remote(this);
        }

        public void switchToChannel(String name){
            tv.switchChannel(name);
        }
    }




}
