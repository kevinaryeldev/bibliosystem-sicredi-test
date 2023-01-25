package br.com.kevinaryedev.bibliosystem.data.config;

import br.com.kevinaryedev.bibliosystem.data.factory.ClientCreateRequestFactory;
import br.com.kevinaryedev.bibliosystem.utils.Utils;

import java.time.LocalDate;

public class ClientDataConfig {

    private static enum GenderOptions{
        M,F,O
    }

    public static  String validName(){
      return "TesteQa "+Utils.faker.name().firstName().replaceAll("[^a-zA-Z]", "");
    }
    public static String invalidName(){
        return "TesteQa " + Utils.faker.number().digits(2);
    }
    public static String validEmail(){
        return Utils.faker.internet().emailAddress();
    }
    public static String invalidEmail(){
        return Utils.faker.number().digits(5)+".com";
    }
    public static String validDocument(){
        return Utils.faker.number().digits(11);
    }
    public static String invalidDocument(){
        return Utils.faker.number().digits(8)+"A";
    }
    public static Character validGender(){
        return ClientDataConfig.GenderOptions.values()[Utils.faker.number().numberBetween(0,2)].toString().charAt(0);
    }
    public static Character invalidGender(){
        return Utils.faker.expression("#{letterify '?'}").toLowerCase().charAt(0);
    }
    public static LocalDate validBirthDate(){
        return LocalDate.now().minusYears(Utils.faker.number().numberBetween(18,55));
    }

}
