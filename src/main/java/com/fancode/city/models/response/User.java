package com.fancode.city.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Address {
        public String street;
        public String suite;
        public String city;
        public String zipcode;
        public Geo geo;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static class Geo {
            public String lat;
            public String lng;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Company {
        public String name;
        public String catchPhrase;
        public String bs;
    }
}
