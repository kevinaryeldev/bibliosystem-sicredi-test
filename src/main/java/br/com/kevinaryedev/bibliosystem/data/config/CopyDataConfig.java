package br.com.kevinaryedev.bibliosystem.data.config;

import br.com.kevinaryedev.bibliosystem.utils.Utils;

public class CopyDataConfig {
    public static String validYear(){
        return String.valueOf(Utils.faker.number().numberBetween(1900, 2020));
    }
    public static String invalidYear(){
        return Utils.faker.expression("#{bothify '?###?'}");
    }
    public static String validPropertyCode(){
        return Utils.faker.number().digits(13);
    }
    public static String validEdition(){
        return Utils.faker.number().digits(2);
    }
    public static String invalidEdition(){
        return Utils.faker.expression("#{bothify '?###?'}");
    }
}