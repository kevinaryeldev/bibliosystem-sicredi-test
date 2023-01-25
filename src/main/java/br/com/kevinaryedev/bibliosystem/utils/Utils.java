package br.com.kevinaryedev.bibliosystem.utils;

import br.com.kevinaryedev.bibliosystem.adapter.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class Utils {
    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
            .create();
    public static Faker faker = new Faker(new Locale("pt-BR"));
    public static String converterParaJson(Object object) {
        return gson.toJson(object);
    }
}
