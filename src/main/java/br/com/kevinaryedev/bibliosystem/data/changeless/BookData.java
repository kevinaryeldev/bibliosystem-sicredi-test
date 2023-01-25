package br.com.kevinaryedev.bibliosystem.data.changeless;

public class BookData {
    public static final String SERVICE = "/livro";
    public static final String SERVICE_CREATE = String.format("%s/cadastrar", SERVICE);
    public static final String SERVICE_DELETE = String.format("%s/deletar", SERVICE);
    public static final String SERVICE_FIND_ALL = String.format("%s/listar", SERVICE);
    public static final String SERVICE_FIND_BY_ID = String.format("%s/busca-por-id", SERVICE);

}
