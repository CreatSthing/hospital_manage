package edu.xhu.pojo;

import lombok.Data;

@Data
public class Appartus {

    private Integer appartus_id;
    private String  appartus_no;
    private String  appartus_name;
    private float   appartus_price;
    private Integer appartus_quantity;
    private String  appartus_ren;

    public Appartus() {
    }

    public Appartus(String appartus_no, String appartus_name, float appartus_price, Integer appartus_quantity, String appartus_ren) {
        this.appartus_no = appartus_no;
        this.appartus_name = appartus_name;
        this.appartus_price = appartus_price;
        this.appartus_quantity = appartus_quantity;
        this.appartus_ren = appartus_ren;
    }

    public Appartus(Integer appartus_id, String appartus_no, String appartus_name, float appartus_price, Integer appartus_quantity, String appartus_ren) {
        this.appartus_id = appartus_id;
        this.appartus_no = appartus_no;
        this.appartus_name = appartus_name;
        this.appartus_price = appartus_price;
        this.appartus_quantity = appartus_quantity;
        this.appartus_ren = appartus_ren;
    }
}