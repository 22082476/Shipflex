 class Company {
    private String name;
    private String street;
    private String postcode;
    private String city;
    private String housenumber;

    Company(String name, String street, String postcode, String city, String housenumber){
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

     public void setHousenumber(String housenumber) {
         this.housenumber = housenumber;
     }

     public String getName() {
         return name;
     }

     public String getStreet() {
         return street;
     }

     public String getPostcode() {
         return postcode;
     }

     public String getCity() {
         return city;
     }

     public String getHousenumber() {
         return housenumber;
     }
 }
