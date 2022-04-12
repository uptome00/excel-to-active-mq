package th.co.magicsoftware.exceltoactivemq.model;

import java.util.List;
import java.util.Map;

public class AddressSchema {
    private AddressTypeSchema type;
    private String addressNumber;
    private String villageApartmentCondo;
    private String moo;
    private String soi;
    private String road;
    private SubDistrictSchema subDistrict;
    private DistrictSchema district;
    private ProvinceSchema province;
    private String zip;

    public AddressTypeSchema getType() {
        return type;
    }
    public void setType(AddressTypeSchema type) {
        this.type = type;
    }
    public String getAddressNumber() {
        return addressNumber;
    }
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
    public String getVillageApartmentCondo() {
        return villageApartmentCondo;
    }
    public void setVillageApartmentCondo(String villageApartmentCondo) {
        this.villageApartmentCondo = villageApartmentCondo;
    }
    public String getMoo() {
        return moo;
    }
    public void setMoo(String moo) {
        this.moo = moo;
    }
    public String getSoi() {
        return soi;
    }
    public void setSoi(String soi) {
        this.soi = soi;
    }
    public String getRoad() {
        return road;
    }
    public void setRoad(String road) {
        this.road = road;
    }
    public SubDistrictSchema getSubDistrict() {
        return subDistrict;
    }
    public void setSubDistrict(SubDistrictSchema subDistrict) {
        this.subDistrict = subDistrict;
    }
    public DistrictSchema getDistrict() {
        return district;
    }
    public void setDistrict(DistrictSchema district) {
        this.district = district;
    }
    public ProvinceSchema getProvince() {
        return province;
    }
    public void setProvince(ProvinceSchema province) {
        this.province = province;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<String> validate(List<String> message, String parentfield, Map<String,String> validateProperties){

        if(this.type == null) {
            message.add("Error: Invalid field "+parentfield+"type");
        }else {
            message = this.type.validate(message, parentfield, validateProperties);
        }

        return message;
    }

    @Override
    public String toString() {
        return "AddressSchema [type=" + type + ", addressNumber=" + addressNumber + ", villageApartmentCondo="
                + villageApartmentCondo + ", moo=" + moo + ", soi=" + soi + ", road=" + road + ", subDistrict="
                + subDistrict + ", district=" + district + ", province=" + province + ", zip=" + zip + "]";
    }

}
