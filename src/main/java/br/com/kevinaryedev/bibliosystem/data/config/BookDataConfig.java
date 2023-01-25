package br.com.kevinaryedev.bibliosystem.data.config;

import br.com.kevinaryedev.bibliosystem.utils.Utils;

public class BookDataConfig {
    public static String validTitle(){
        return "TesteQa "+ Utils.faker.book().title();
    }
    public static String validCode(){
        return Utils.faker.number().digits(13);
    }
    public static String invalidCode(){
        return Utils.faker.number().digits(7);
    }
    public static String validSubtitle(){
        return Utils.faker.book().title();
    }
    public static String validPublisher(){
        return Utils.faker.book().publisher().replaceAll("[^a-zA-ZÀ-ȕ ']", "");
    }
    public static String invalidPublisher(){
        return Utils.faker.expression("#{bothify '?#?#?#?#'}");
    }
    public static String validAuthor(){
        return Utils.faker.book().author().replaceAll("[^a-zA-ZÀ-ȕ ']", "");
    }
    public static String invalidAuthor(){
        return Utils.faker.name().firstName()+"123";
    }
    public static String validCdd(){
        return Utils.faker.number().digits(3);
    }
    public static String invalidCdd(){
        return Utils.faker.number().digits(5)+"A";
    }
}
