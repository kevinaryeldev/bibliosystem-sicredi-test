package br.com.kevinaryedev.bibliosystem.data.changeless;

public class LoanData {
    private static final String SERVICE = "/emprestimo";
    public static final String SERVICE_CREATE = String.format("%s/emprestar", SERVICE);
    public static final String SERVICE_UPDATE = String.format("%s/devolver", SERVICE);
    public static final String SERVICE_FIND_ALL_ACTIVE = String.format("%s/listar-ativos", SERVICE);
    public static final String SERVICE_FIND_BY_ID = String.format("%s/listar-por-id-cliente", SERVICE);

}
