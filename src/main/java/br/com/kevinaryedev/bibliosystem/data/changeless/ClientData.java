package br.com.kevinaryedev.bibliosystem.data.changeless;

public class ClientData {
    public static final String SERVICE = "/cliente";
    public static final String SERVICE_CREATE = String.format("%s/cadastrar", SERVICE);
    public static final String SERVICE_UPDATE = String.format("%s/editar", SERVICE);
    public static final String SERVICE_DELETE = String.format("%s/deletar", SERVICE);
    public static final String SERVICE_FIND_ALL = String.format("%s/listar", SERVICE);
    public static final String SERVICE_FIND_BY_ID = String.format("%s/busca-por-id", SERVICE);
}
