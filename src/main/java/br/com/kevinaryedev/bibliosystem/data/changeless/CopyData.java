package br.com.kevinaryedev.bibliosystem.data.changeless;

public class CopyData {
    public static final String SERVICE = "/bibliosystem/exemplar";
    public static final String SERVICE_CREATE = String.format("%s/cadastrar", SERVICE);
    public static final String SERVICE_DELETE = String.format("%s/deletar", SERVICE);
    public static final String SERVICE_FIND_BY_BOOK_ID = String.format("%s/listar", SERVICE);
}
