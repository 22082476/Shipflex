 class Company {
    private String name;
    private String street;
    private String postcode;
    private String city;
    private int housenumber;

    Company(String name, String street, String postcode, String city, int housenumber){
        this.name = name;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.housenumber = housenumber;
    }

     public void setName(String name) {
         this.name = name;
     }

     public void setStreet(String street) {
         this.street = street;
     }

     public void setPostcode(String postcode) {
         this.postcode = postcode;
     }

     public void setCity(String city) {
         this.city = city;
     }

     public void setHousenumber(int housenumber) {
         this.housenumber = housenumber;
     }

     public String getName() {
         return this.name;
     }

     public String getStreet() {
         return this.street;
     }

     public String getPostcode() {
         return this.postcode;
     }

     public String getCity() {
         return this.city;
     }

     public int getHousenumber() {
         return this.housenumber;
     }
 }
